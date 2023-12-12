package tn.esprit.springproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Bloc;


import java.util.List;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc, Long> {
    //keyword
    //générer methodes spécifiques
    List<Bloc> findByCapaciteBlocGreaterThanEqualAndNomBlocContainingOrderByChambresIdChambre(long capaciteBloc,String x);



}
