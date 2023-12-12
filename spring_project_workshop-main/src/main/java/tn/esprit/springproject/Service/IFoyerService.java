package tn.esprit.springproject.Service;


import tn.esprit.springproject.Entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer addFoyer(Foyer foyer);
    public Foyer getFoyerById(long idFoyer);
    public List<Foyer> getAllFoyer();
    public Foyer updateFoyer(Foyer foyer);
    public void deleteFoyerById(long idFoyer);
    public List<Foyer> getFoyerByNomFoyer(String nomFoyer);
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
