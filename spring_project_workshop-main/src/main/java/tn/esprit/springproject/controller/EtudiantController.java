package tn.esprit.springproject.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Service.IEtudiantService;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@RequestMapping("api/etudiants")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EtudiantController {
    @Autowired
    private IEtudiantService etudiantService;

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.addEtudiant(e);
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants(){
        return etudiantService.getAllEtudiant();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") long id) {
        return etudiantService.getEtudiantById(id);
    }

    @PutMapping
    public Etudiant updateOneEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable("id") long id) {
        etudiantService.deleteEtudiantById(id);
    }

    @GetMapping("/searchByDate")
    public List<Etudiant> searchByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateNaissance){
        return etudiantService.getEtudiantByDateNaissance(dateNaissance);
    }

}
