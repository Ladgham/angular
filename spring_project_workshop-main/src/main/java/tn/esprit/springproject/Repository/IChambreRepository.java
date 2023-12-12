package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.TypeChambre;


import java.util.List;

@Repository
public interface IChambreRepository extends CrudRepository<Chambre, Long> {
    List<Chambre> findByNumeroChambreAndBlocNomBlocContainingOrderByNumeroChambre(long numeroChambre,String nomBloc);
    Chambre findByNumeroChambre(long numeroChambre);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> getChambresParBlocEtType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    List<Chambre> findChambresByBloc_IdBlocAndTypeC(long idBloc , TypeChambre typeC);
}
