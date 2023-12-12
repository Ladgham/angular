package tn.esprit.springproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.Service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@RequestMapping("/api/universites")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversiteController {
    @Autowired
    private IUniversiteService universiteService;

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversite();
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable("id") long id) {
        return universiteService.getUniversiteById(id);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable("id") long id) {
        universiteService.deleteUniversiteById(id);
    }

    @GetMapping("/getUniversiteByNom")
    public Universite getUniversiteByNom(@RequestParam String nomUniversite) {
        return universiteService.getByNomUniversite(nomUniversite);
    }

    @GetMapping("/getUniversiteByIdBloc")
    public Universite getUniversiteByIdBloc(@RequestParam long idBloc) {
        return universiteService.getByIdBloc(idBloc);
    }


    @PostMapping("/add-Foyer-to-University/{idFoyer}/{nom}")
    public Universite ajouterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer ,@PathVariable("nom") String nomUniversite) {
        return universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
    }

    @PutMapping("/delete-Foyer-from-University/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("idUniversite")long idUniversite){
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }


}
