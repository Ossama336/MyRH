package os.place.recruterpro.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class Postule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String nom_complet;
    private String cv;
    private int tel;
    private String motivation;
    @JsonBackReference
    @ManyToOne
    private Offre offre;
}
