package os.place.recruterpro.dtos.offre.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import os.place.recruterpro.dtos.PostuleDto;

@Getter @Setter
@Builder
public class RequestPostuleOffre {
    private Long offreId;
    private String nom_complet;
    private int tel;
    private MultipartFile cv;
    private MultipartFile motivation;
}
