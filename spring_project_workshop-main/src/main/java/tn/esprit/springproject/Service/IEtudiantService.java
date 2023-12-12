package tn.esprit.springproject.Service;



import tn.esprit.springproject.Entity.Etudiant;

import java.util.Date;
import java.util.List;

public interface IEtudiantService {

    public Etudiant addEtudiant(Etudiant etudiant);
    public Etudiant getEtudiantById(long idEtudiant);
    public List<Etudiant> getAllEtudiant();
    public Etudiant updateEtudiant(Etudiant etudiant);
    public void deleteEtudiantById(long idEtudiant);
    public List<Etudiant> getEtudiantByDateNaissance(Date dateNaissance);
    public List<Etudiant> getAllByChambre(long idChambre);

}
