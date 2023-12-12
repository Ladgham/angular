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
public class IUniversiteServiceImpl implements IUniversiteService {
    @Autowired
    private IUniversiteRepository universiteRepository;
    private IFoyerRepository foyerRepository;

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite getUniversiteById(long idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public List<Universite> getAllUniversite() {
        Iterable<Universite> iterable = universiteRepository.findAll();
        List<Universite> universiteList = new ArrayList<>();
        iterable.forEach(universiteList::add);
        return universiteList;
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversiteById(long idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }

    @Override
    public Universite getByNomUniversite(String nomUniversite) {
        return universiteRepository.findByNomUniversite(nomUniversite);
    }

    @Override
    public Universite getByIdBloc(long idBloc) {
        return universiteRepository.findByidBloc(idBloc);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Universite universite = getByNomUniversite(nomUniversite);

        if (foyer != null && universite != null) {
            universite.setFoyer(foyer);
            foyer.setUniversite(universite);
            universiteRepository.save(universite);
            foyerRepository.save(foyer);
        }

        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        if (universite != null) {
            Foyer foyer = universite.getFoyer();
            foyer.setUniversite(null);
            universite.setFoyer(null);
        }
        return universite;
    }
}
