package tn.esprit.springproject.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springproject.Entity.Reservation;

import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation, String> {
    public List<Reservation> findByEstValideTrueOrderByEtudiantsCin();

    @Query("select r from Reservation r join Chambre c on r member c.reservations where c.bloc.idBloc = :idBloc")
    public List<Reservation> findAllByIdBloc(@Param("idBloc") long idBloc);
}
