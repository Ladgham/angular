package tn.esprit.springproject.Service;

import tn.esprit.springproject.Entity.Reservation;

import java.util.List;

public interface IReservationService {

    public Reservation addReservation(Reservation reservation);
    public Reservation getReservationById(String idReservation);
    public List<Reservation> getAllReservation();
    public Reservation updateReservation(Reservation reservation);
    public void deleteReservationById(String idReservation);
    public List<Reservation> getReservationValide();
    public Reservation addReservationAffecterChambreEtEtudient(Reservation reservation,long etudientId, long chambreID);
}
