package tn.esprit.springproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.TypeChambre;
import tn.esprit.springproject.Service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/chambres")
public class ChambreController {

    @Autowired
    private IChambreService chambreService;

    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable long id) {
        return chambreService.getChambreById(id);
    }

    @GetMapping
    public List<Chambre> getAllChambre() {
        return chambreService.getAllChambre();
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambreById(@PathVariable long id) {
        chambreService.deleteChambreById(id);
    }

    @GetMapping("/getChambreByNumero")
    public List<Chambre> getChambreByNumero(long numeroChambre,String nomBloc){
        return chambreService.getChambreByNumero(numeroChambre, nomBloc);
    }

    @GetMapping("/ByNomUniversite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc ,@PathVariable TypeChambre typeC){
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }

}
