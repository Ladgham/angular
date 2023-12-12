package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Universite;

import java.util.List;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite, Long> {
    public Universite findByNomUniversite(String nomUniversite);

    @Query("SELECT u FROM Universite u JOIN u.foyer f JOIN f.blocs b WHERE b.idBloc = :idBloc")
    public Universite findByidBloc(@Param("idBloc") long idBloc);
}
