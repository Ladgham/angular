package tn.esprit.springproject.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Entity.Reservation;
import tn.esprit.springproject.Repository.IChambreRepository;
import tn.esprit.springproject.Repository.IEtudiantRepository;
import tn.esprit.springproject.Repository.IReservationRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class IReservationServiceImpl implements IReservationService{
    @Autowired
    private IReservationRepository reservationRepository;
    private IEtudiantRepository iEtudiantRepository;
    private IChambreRepository iChambreRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getReservationById(String idReservation) {
        return reservationRepository.findById(idReservation).get();
    }

    @Override
    public List<Reservation> getAllReservation() {
        Iterable<Reservation> iterable = reservationRepository.findAll();
        List<Reservation> reservationList = new ArrayList<>();
        iterable.forEach(reservationList::add);
        return reservationList;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    @Override
    public void deleteReservationById(String idReservation) {reservationRepository.deleteById(idReservation);}

    @Override
    public List<Reservation> getReservationValide() {
        return reservationRepository.findByEstValideTrueOrderByEtudiantsCin();
    }

    @Override
    public Reservation addReservationAffecterChambreEtEtudient(Reservation reservation, long etudientId, long chambreID) {
        Etudiant etudiant = iEtudiantRepository.findById(etudientId).orElse(null);


        Set<Etudiant> etudiantsList=new HashSet<>();
        etudiantsList.add(etudiant);
        reservation.setEtudiants(etudiantsList);

       return reservationRepository.save(reservation);
     /*   Reservation reservationCreated =

     Chambre chambre = iChambreRepository.findById(chambreID).orElse(null);
     Set<Reservation> reservationList = new HashSet<>();
     reservationList.add(reservationCreated);
     chambre.setReservations(reservationList);

     iChambreRepository.save(chambre);

     return reservationCreated;*/


    }
}
