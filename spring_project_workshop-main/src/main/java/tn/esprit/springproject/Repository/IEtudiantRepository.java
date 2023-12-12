package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Etudiant;


import java.util.Date;
import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant, Long> {
    public List<Etudiant> findByDateNaissanceGreaterThan(Date dateNaissance);

    @Query("select e from Etudiant e join Reservation r on e member r.etudiants " +
            "join Chambre c on r member c.reservations where c.idChambre = :idChambre")
    public List<Etudiant> findAllByIdChambre(@Param("idChambre") long idChambre);
}
