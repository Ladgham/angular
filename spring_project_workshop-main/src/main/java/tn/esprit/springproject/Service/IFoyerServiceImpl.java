package tn.esprit.springproject.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Foyer;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.Repository.IFoyerRepository;
import tn.esprit.springproject.Repository.IUniversiteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class IFoyerServiceImpl implements IFoyerService {
    @Autowired
    private IFoyerRepository foyerRepository;
    private IUniversiteRepository universiteRepository;

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer getFoyerById(long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public List<Foyer> getAllFoyer() {
        Iterable<Foyer> iterable = foyerRepository.findAll();
        List<Foyer> foyerList = new ArrayList<>();
        iterable.forEach(foyerList::add);
        return foyerList;    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyerById(long idFoyer) {foyerRepository.deleteById(idFoyer);}

    @Override
    public List<Foyer> getFoyerByNomFoyer(String nomFoyer) {
        return foyerRepository.findByNomFoyerContainingOrderByCapaciteFoyer(nomFoyer);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
       Universite universite = universiteRepository.findById(idUniversite).orElse(null);
       if (universite!= null){
           foyer.setUniversite(universite);
           universite.setFoyer(foyer);
           foyerRepository.save(foyer);
       }
        return foyer;
    }
}
