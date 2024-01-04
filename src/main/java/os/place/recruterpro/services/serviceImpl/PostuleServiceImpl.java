package os.place.recruterpro.services.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import os.place.recruterpro.Enum.StatusOffre;
import os.place.recruterpro.dtos.PostuleDto;
import os.place.recruterpro.dtos.offre.request.RequestPostuleOffre;
import os.place.recruterpro.entities.Offre;
import os.place.recruterpro.entities.Postule;
import os.place.recruterpro.exceptions.exception.AccessOffreException;
import os.place.recruterpro.exceptions.exception.OffreCreateException;
import os.place.recruterpro.mappers.PostuleMapper;
import os.place.recruterpro.repositories.OffreRepository;
import os.place.recruterpro.repositories.PostuleRepository;
import os.place.recruterpro.services.PostuleService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class PostuleServiceImpl implements PostuleService {
    private PostuleRepository postuleRepository;
    private OffreRepository offreRepository;
    private final PostuleMapper postuleMapper;
    @Value("${UPLOAD_DIR.Cv}")
    private String pathCv;
    @Autowired
    public PostuleServiceImpl(PostuleRepository postuleRepository, OffreRepository offreRepository) {
        this.postuleRepository = postuleRepository;
        this.offreRepository = offreRepository;
        this.postuleMapper = PostuleMapper.INSTANCE;
    }

    @Override
    public PostuleDto potuleOffre(RequestPostuleOffre requestPostuleOffre) {
        Long id = requestPostuleOffre.getOffreId();
        Offre offre = offreRepository.findById(id).orElseThrow(OffreCreateException::new);
        Postule postule = Postule.builder()
                .tel(requestPostuleOffre.getTel())
                .nom_complet(requestPostuleOffre.getNom_complet())
                .build();
        if(offre.getStatus().equals(StatusOffre.ACCEPTED)){

             postule.setOffre(offre);
                 MultipartFile fileCv = requestPostuleOffre.getCv();
                 if (fileCv != null && !fileCv.isEmpty()) {
                     try {
                         byte[] bytes = fileCv.getBytes();
                         Path path = Paths.get("src/main/resources/cv/" + UUID.randomUUID().toString() + fileCv.getOriginalFilename());
                         Files.write(path, bytes);
                         postule.setCv(path.toString());
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
                 MultipartFile fileMotivation = requestPostuleOffre.getMotivation();
                if (fileMotivation != null && !fileMotivation.isEmpty()) {
                    try {
                        byte[] bytes = fileMotivation.getBytes();
                        Path path = Paths.get("src/main/resources/motivation/" + UUID.randomUUID().toString() + fileMotivation.getOriginalFilename());
                        Files.write(path, bytes);
                        postule.setMotivation(path.toString());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
             postule = postuleRepository.save(postule);
             return postuleMapper.toDto(postule);
        }else throw new AccessOffreException("the offre don't by accessed");
    }
}
