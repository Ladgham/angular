package tn.esprit.springproject.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springproject.Entity.Reservation;
import tn.esprit.springproject.Service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;

    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }
    @PostMapping("/addReservationById")
    public Reservation addReservationbyChambreByEtudiant(@RequestBody Reservation reservation,@RequestParam long etudiantID,@RequestParam long chambreID) {
        return reservationService.addReservationAffecterChambreEtEtudient(reservation,etudiantID,chambreID);
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") String id) {
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservation();
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable("id") String id) {
        reservationService.deleteReservationById(id);
    }

    @GetMapping("/getValidReservations")
    public List<Reservation> getValidReservations() {
        return reservationService.getReservationValide();
    }
}
