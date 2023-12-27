package os.place.recruterpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import os.place.recruterpro.dtos.SocieteDTO;
import os.place.recruterpro.dtos.societe.RequestCreateSocieteDTO;
import os.place.recruterpro.services.SocieteService;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/societes")
public class SocieteController {
    private SocieteService societeService;

    @Autowired
    public SocieteController(SocieteService societeService) {
        this.societeService = societeService;
    }

    @PostMapping("/register")
    public ResponseEntity<SocieteDTO> createNewSociete(RequestCreateSocieteDTO societeDTO) throws IOException {
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.societeService.createSociete(societeDTO));
    }
    @PostMapping("/login")
    public ResponseEntity<SocieteDTO> loginSociete(SocieteDTO societeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.societeService.loginSociete(societeDTO));
    }
    @PostMapping("/validation")
     public ResponseEntity<String> validationCompteSociete(@RequestBody String code){
        boolean result = this.societeService.verificationCode(code);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("Validation realized successfully");
        }else return ResponseEntity.status(HttpStatus.CONFLICT).body("Field validation");

    }
}
