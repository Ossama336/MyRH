package os.place.recruterpro.services.serviceImpl;

import org.apache.logging.log4j.CloseableThreadContext;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import os.place.recruterpro.Util.EmailSender;
import os.place.recruterpro.dtos.SocieteDTO;
import os.place.recruterpro.dtos.societe.RequestCreateSocieteDTO;
import os.place.recruterpro.entities.Offre;
import os.place.recruterpro.entities.Societe;
import os.place.recruterpro.exceptions.exception.LoginSocieteException;
import os.place.recruterpro.exceptions.exception.NotExist;
import os.place.recruterpro.mappers.SocieteMapper;
import os.place.recruterpro.repositories.SocieteRepository;
import os.place.recruterpro.services.SocieteService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.UUID;

@Service
public class SocieteServiceImpl implements SocieteService {
    private SocieteRepository societeRepository;
    private SocieteMapper societeMapper;
    @Value("${UPLOAD_DIR.Images}")
    private static final String UPLOAD_DIR = "src/main/resources/images/";
    private final EmailSender emailSender;
    @Autowired
    public SocieteServiceImpl(SocieteRepository societeRepository, EmailSender emailSender) {
        this.societeRepository = societeRepository;
        this.emailSender = emailSender;
        this.societeMapper = SocieteMapper.INSTANCE;
    }


    @Override
    public SocieteDTO createSociete(RequestCreateSocieteDTO createSocieteDTO) throws IOException {
        Societe societe = Societe.builder()
                .email(createSocieteDTO.getEmail())
                .password(createSocieteDTO.getPassword())
                .adresse(createSocieteDTO.getAdresse())
                .build();
        String hashPassword = BCrypt.hashpw(societe.getPassword(), BCrypt.gensalt());
        if (!hashPassword.isEmpty()) {
                MultipartFile file = createSocieteDTO.getImageFile();
            if (file != null && !file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get("src/main/resources/images/" + UUID.randomUUID().toString()+file.getOriginalFilename());
                    Files.write(path, bytes);
                    societe.setImage(path.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String Code = UUID.randomUUID().toString();
            societe.setCode(Code);
            societe = societeRepository.save(societe);
            emailSender.sendEmail("hay.anas.336@gmail.com","code verification", Code);
            return societeMapper.toDto(societe);
        } else {
            throw new LoginSocieteException("the societe field to create");
        }
    }

    @Override
    public SocieteDTO loginSociete(SocieteDTO societeDTO) {

        Societe societe = societeMapper.toEntity(societeDTO);
        Optional<Societe> societeOpt = societeRepository.findByEmail(societe.getEmail());
        if (societeOpt.isPresent()){
            if(BCrypt.checkpw(societe.getPassword(), societeOpt.get().getPassword())){
                societe = societeOpt.get();
            }else{
                throw  new LoginSocieteException("the password is not correct");
            }
            return societeMapper.toDto(societe);
        }else {
            throw  new LoginSocieteException("the login operation is field");
        }

    }

    @Override
    public Boolean verificationCode(String code) {
        boolean result;
        Optional<Societe> societeOpt = this.societeRepository.findByCode(code);
        if (societeOpt.isPresent()){
            result = true;
        }else throw new NotExist("the societe not exist");
        return result;
    }
}
