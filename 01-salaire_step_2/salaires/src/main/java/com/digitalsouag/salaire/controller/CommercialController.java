package com.digitalsouag.salaire.controller;

import com.digitalsouag.salaire.entity.Commercial;
import com.digitalsouag.salaire.repository.CommercialRepository;
import com.digitalsouag.salaire.service.CommercialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employes/commercial")
public class CommercialController {

    private final CommercialService commercialService;
    private final CommercialRepository commercialRepository;

    public CommercialController(CommercialService commercialService, CommercialRepository commercialRepository) {
        this.commercialService = commercialService;
        this.commercialRepository = commercialRepository;
    }

    @GetMapping()
    public ResponseEntity<List<Commercial>> findAllCommercial() {
        List<Commercial> list = commercialService.findAllCommercial();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Commercial>> findCommercialById(@PathVariable Long id) {
        Commercial findedCommercial = commercialService.findCommercialById(id);
        if (findedCommercial != null)
            return new ResponseEntity(findedCommercial, HttpStatus.OK);
        return new ResponseEntity("Désolé commercial avec ID : " + id + "introuvable", HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<List<Commercial>> createCommercial(@RequestBody Commercial commercial) {
        if (commercial != null) {
            commercialService.createCommercial(commercial);
            return new ResponseEntity(commercial, HttpStatus.OK);
        }
        return new ResponseEntity("Attention, mauvaise requête", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Commercial>> updateCommercial(@PathVariable Long id, @RequestBody Commercial commercial) {
        Optional<Commercial> findedCommercial = commercialRepository.findById(id);
        if (findedCommercial.isPresent()) {
            commercialService.updateCommercial(commercial);
            return new ResponseEntity(findedCommercial, HttpStatus.OK);
        }
        return new ResponseEntity("Désolé commercial avec ID : " + id + "introuvable", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Commercial>> deleteCommercialById(@PathVariable Long id) {
        Commercial findedCommercial = commercialService.findCommercialById(id);
        if (findedCommercial != null)
            commercialService.deleteCommercial(id);
        if (findedCommercial == null)
            return new ResponseEntity("Désolé commercial avec ID : " + id + " introuvable", HttpStatus.NOT_FOUND);
        return null;
    }
}
