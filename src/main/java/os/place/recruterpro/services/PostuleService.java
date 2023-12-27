package os.place.recruterpro.services;

import os.place.recruterpro.dtos.PostuleDto;
import os.place.recruterpro.dtos.offre.request.RequestPostuleOffre;

public interface PostuleService {
    PostuleDto potuleOffre(RequestPostuleOffre requestPostuleOffre);
}
