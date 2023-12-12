package tn.esprit.springproject.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Foyer;

import java.util.List;

@Repository
public interface IFoyerRepository extends CrudRepository<Foyer, Long> {
    public List<Foyer> findByNomFoyerContainingOrderByCapaciteFoyer(String nomFoyer);
}
