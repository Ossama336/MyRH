package os.place.recruterpro.dtos.societe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import os.place.recruterpro.dtos.SocieteDTO;
@Getter @Setter
public class RequestCreateSocieteDTO {
    private MultipartFile imageFile;
    private String email;
    private String password;
    private String adresse;

}
