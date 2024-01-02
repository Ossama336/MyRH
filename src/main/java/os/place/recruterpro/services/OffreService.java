package os.place.recruterpro.services;

import org.springframework.data.domain.Page;
import os.place.recruterpro.dtos.OffreDTO;
import os.place.recruterpro.dtos.offre.request.RequestOffre;
import os.place.recruterpro.dtos.offre.request.RequestSearchOffreDTO;
import os.place.recruterpro.dtos.offre.request.RequestValidationDTO;
import os.place.recruterpro.entities.Offre;

import java.util.List;
import java.util.Map;

public interface OffreService {
    OffreDTO createOffre(OffreDTO offreDTO);
    OffreDTO storeOffre(RequestOffre requestOffre);
    OffreDTO validationOffre(RequestValidationDTO validationDTO);
    Page<Offre> listOffrePageable(Map<String, Integer> query);
    OffreDTO getOffre(Long id);
    List<OffreDTO >getOffres();

    List<OffreDTO> searchOffre(RequestSearchOffreDTO requestSearchOffreDTO);
}
