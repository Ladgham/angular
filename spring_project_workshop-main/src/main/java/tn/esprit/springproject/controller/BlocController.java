package tn.esprit.springproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Service.IBlocService;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/blocs")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Gestion Bloc")
public class BlocController {
    @Autowired
    private IBlocService blocService;

    @PostMapping("/addBloc")
    @Operation(summary = "add",description = "permet d'ajouter un bloc")
    public Bloc addEtudiant(@RequestBody Bloc b){
        return blocService.addBloc(b);
    }

    @GetMapping("/getall")
    @Operation(summary = "get",description = "permet d'afficher la liste des blocs")
    public List<Bloc> getAllBlocs(){
        return blocService.getAllBloc();
    }

    @GetMapping("/getbyid/{id}")
    @Operation(summary = "get",description = "permet d'afficher un bloc")
    public Bloc getBlocById(@PathVariable long id){
        return blocService.getBlocById(id);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "put",description = "permet de modifer un bloc")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete",description = "permet de supprimer un bloc")
    public void deleteBlocById(@PathVariable long id) {
        blocService.deleteBlocById(id);
    }

    @GetMapping("/getByCapacite")
    @Operation(summary = "get",description = "permet d'afficher la liste des blocs par capacite")
    public List<Bloc> getBlocByCapacite(@RequestParam long capaciteBloc,@RequestParam String nomBloc){
        return blocService.getBlocByCapacite(capaciteBloc, nomBloc);
    }

    @GetMapping("/getByUniversityId")
    @Operation(summary = "get",description = "permet d'afficher la liste des blocs par unversity id")
    public Set<Bloc> getBlocByUnversityId(@RequestParam long unirvsityId){
        return blocService.getBlocsByUniversytyId(unirvsityId);
    }

    @Scheduled(cron = "*/30 * * * * *" )
    public void cronMethod() {
        log.info(blocService.getAllBloc().toString());
    }


    @PutMapping("/add-chambres-to-bloc/{numChambre}/{idBloc}")
    public Bloc affecterChambresABloc(@PathVariable List<Long> numChambre,@PathVariable long idBloc){
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }
}
