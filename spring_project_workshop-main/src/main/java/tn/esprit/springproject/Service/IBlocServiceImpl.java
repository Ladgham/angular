package tn.esprit.springproject.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.*;
import tn.esprit.springproject.Repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class IBlocServiceImpl implements IBlocService{
    @Autowired
    private IBlocRepository blocRepository;
    private IChambreRepository chambreRepository;
    private IEtudiantRepository etudiantRepository;
    private IReservationRepository reservationRepository;
    private IUniversiteRepository universiteRepository;
    private IFoyerRepository iFoyerRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBlocById(long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public List<Bloc> getAllBloc() {
        Iterable<Bloc> iterable = blocRepository.findAll();
        List<Bloc> blocList = new ArrayList<>();
        iterable.forEach(blocList::add);
        return blocList;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBlocById(long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public List<Bloc> getBlocByCapacite(long capaciteBloc,String nomBloc){
        return blocRepository.findByCapaciteBlocGreaterThanEqualAndNomBlocContainingOrderByChambresIdChambre(capaciteBloc,nomBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if(bloc!= null){
            for (long i : numChambre) {
                Chambre chambre = chambreRepository.findByNumeroChambre(i);
                bloc.getChambres().add(chambre);
                chambre.setBloc(bloc);
            }
            blocRepository.save(bloc);
        }

        return bloc;
    }

    @Override
    public Set<Bloc> getBlocsByUniversytyId(long universityId){
        Universite universite = this.universiteRepository.findById(universityId).orElse(null);
        long foyerId = universite.getFoyer().getIdFoyer();
        Foyer foyer =  this.iFoyerRepository.findById(foyerId).orElse(null);
        return foyer.getBlocs();
    }

}
