package os.place.recruterpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import os.place.recruterpro.dtos.SocieteDTO;
import os.place.recruterpro.dtos.societe.RequestCreateSocieteDTO;
import os.place.recruterpro.dtos.societe.RequestValidRegister;
import os.place.recruterpro.services.SocieteService;

import java.io.IOException;

@RestController
@CrossOrigin(value = "*")
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
     public ResponseEntity<String> validationCompteSociete(@RequestBody RequestValidRegister validRegister){

        boolean result = this.societeService.verificationCode(validRegister);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("Validation realized successfully");
        }else return ResponseEntity.status(HttpStatus.CONFLICT).body("Field validation");

    }
}
