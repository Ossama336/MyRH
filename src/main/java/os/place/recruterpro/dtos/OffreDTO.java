package os.place.recruterpro.dtos;

import lombok.Getter;
import lombok.Setter;
import os.place.recruterpro.Enum.NiveauEtude;

@Getter @Setter
public class OffreDTO {
    private Long id;
    private String titre;
    private String description;
    private String profile;
    private float salaire;
    private NiveauEtude niveau_etude;
}
