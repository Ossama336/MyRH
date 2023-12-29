package os.place.recruterpro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import os.place.recruterpro.Enum.CompteStatus;

import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Societe {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private String adresse;
    private String image;
    private String code;
    @Enumerated(EnumType.STRING)
    private CompteStatus status;
    @JsonManagedReference
    @OneToMany(mappedBy = "societe", fetch = FetchType.LAZY )
    private List<Offre> offre;

    @PrePersist
    @PreUpdate
    public void checkStatus(){
        if (this.status == null || this.status.describeConstable().isEmpty()){
            this.status = CompteStatus.INVALID;
        }
    }
}
