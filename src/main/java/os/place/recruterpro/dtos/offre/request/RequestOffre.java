package os.place.recruterpro.dtos.offre.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import os.place.recruterpro.dtos.OffreDTO;
@Getter @Setter
public class RequestOffre {
    private Long societeId;
    private OffreDTO offreDTO;
}