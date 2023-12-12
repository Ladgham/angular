package tn.esprit.springproject.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.TypeChambre;
import tn.esprit.springproject.Entity.Universite;
import tn.esprit.springproject.Repository.IChambreRepository;
import tn.esprit.springproject.Repository.IUniversiteRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class IChambreServiceImpl implements IChambreService {
    @Autowired
    private IChambreRepository chambreRepository;
    @Autowired
    private IUniversiteRepository universiteRepository;

    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambreById(long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public List<Chambre> getAllChambre() {
        Iterable<Chambre> iterable = chambreRepository.findAll();
        List<Chambre> chambreList = new ArrayList<>();
        iterable.forEach(chambreList::add);
        return chambreList;
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambreById(long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getChambreByNumero(long numeroChambre,String nomBloc){
        return chambreRepository.findByNumeroChambreAndBlocNomBlocContainingOrderByNumeroChambre(numeroChambre, nomBloc);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);

        if (universite != null) {
            Set<Bloc> blocs = universite.getFoyer().getBlocs();
            List<Chambre> chambres = new ArrayList<>();

            for (Bloc bloc : blocs) {
                chambres.addAll(bloc.getChambres());
            }

            return chambres;
        }

        return Collections.emptyList();
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        return chambreRepository.findChambresByBloc_IdBlocAndTypeC(idBloc, typeC);
    }


}
