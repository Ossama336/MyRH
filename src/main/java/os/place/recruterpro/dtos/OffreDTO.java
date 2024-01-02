package os.place.recruterpro.dtos;

import lombok.Getter;
import lombok.Setter;
import os.place.recruterpro.Enum.NiveauEtude;
import os.place.recruterpro.Enum.StatusOffre;

@Getter @Setter
public class OffreDTO {
    private Long id;
    private String titre;
    private String description;
    private String profile;
    private float salaire;
    private String status;
    private String ville;
    private NiveauEtude niveau_etude;
}
