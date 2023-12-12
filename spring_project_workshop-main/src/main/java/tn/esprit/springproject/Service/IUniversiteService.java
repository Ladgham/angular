package tn.esprit.springproject.Service;

import tn.esprit.springproject.Entity.Universite;

import java.util.List;

public interface IUniversiteService {

    public Universite addUniversite(Universite universite);
    public Universite getUniversiteById(long idUniversite);
    public List<Universite> getAllUniversite();
    public Universite updateUniversite(Universite universite);
    public void deleteUniversiteById(long idUniversite);
    public Universite getByNomUniversite(String nomUniversite);
    public Universite getByIdBloc(long idBloc);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;


}
