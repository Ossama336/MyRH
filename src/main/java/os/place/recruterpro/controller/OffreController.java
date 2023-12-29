package os.place.recruterpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import os.place.recruterpro.dtos.OffreDTO;
import os.place.recruterpro.dtos.PostuleDto;
import os.place.recruterpro.dtos.offre.request.RequestOffre;
import os.place.recruterpro.dtos.offre.request.RequestPostuleOffre;
import os.place.recruterpro.dtos.offre.request.RequestSearchOffreDTO;
import os.place.recruterpro.dtos.offre.request.RequestValidationDTO;
import os.place.recruterpro.entities.Offre;
import os.place.recruterpro.services.OffreService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/offre")
public class OffreController {
    private final OffreService offreService;

    @Autowired
    public OffreController(OffreService offreService) {
        this.offreService = offreService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createOffre(@RequestBody RequestOffre requestOffre) {
        OffreDTO offreDTO= offreService.storeOffre(requestOffre);
        return new ResponseEntity<>("Offer created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/valide")
    public ResponseEntity<String> validationOffre(@RequestBody RequestValidationDTO validationDTO) {
        this.offreService.validationOffre(validationDTO);
        return new ResponseEntity<>("Validation realised successfully", HttpStatus.OK);
    }
    @GetMapping("/list")
    public Page<Offre> listOffre(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size){
        Map<String, Integer> query = new HashMap<>();
        query.put("page", page);
        query.put("size", size);
        return this.offreService.listOffrePageable(query);

    }
    @PostMapping("/search")
    public List<OffreDTO> searchOffre(@RequestBody RequestSearchOffreDTO offreDTO){
        return this.offreService.searchOffre(offreDTO);
    }

    @PostMapping("/postuler")
    public ResponseEntity<String> postuleOffre(@RequestBody RequestPostuleOffre requestPostuleOffre){
//        PostuleDto postuleDto = this.offreService.potuleOffre(requestPostuleOffre);
        return new ResponseEntity<>("the postule was add successfully " , HttpStatus.CREATED);
    }
}
