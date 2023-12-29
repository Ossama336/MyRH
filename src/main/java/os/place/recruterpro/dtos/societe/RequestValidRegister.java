package os.place.recruterpro.dtos.societe;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequestValidRegister {
    private String email;
    private String verificationKey;
}
