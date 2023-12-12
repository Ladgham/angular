package tn.esprit.springproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@RequestMapping("/api/foyers")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoyerController {
    @Autowired
    private IFoyerService foyerService;

    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyer();
    }

    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable("id") long id) {
        return foyerService.getFoyerById(id);
    }

    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable("id") long id) {
        foyerService.deleteFoyerById(id);
    }

    @GetMapping("/getFoyersByNomFoyer")
    public List<Foyer> getFoyersByNomFoyer(@RequestParam String nomFoyer) {
        return foyerService.getFoyerByNomFoyer(nomFoyer);
    }
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite (@RequestBody Foyer foyer,@PathVariable long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }

}
