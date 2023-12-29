package os.place.recruterpro.services;

import os.place.recruterpro.dtos.SocieteDTO;
import os.place.recruterpro.dtos.societe.RequestCreateSocieteDTO;
import os.place.recruterpro.dtos.societe.RequestValidRegister;

import java.io.IOException;

public interface SocieteService {
    SocieteDTO createSociete(RequestCreateSocieteDTO societeDTO) throws IOException;
    SocieteDTO loginSociete(SocieteDTO societeDTO);
    Boolean verificationCode(RequestValidRegister validRegister);
}
