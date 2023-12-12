package tn.esprit.springproject.Service;



import tn.esprit.springproject.Entity.Chambre;
import tn.esprit.springproject.Entity.TypeChambre;

import java.util.List;

public interface IChambreService {
    public Chambre addChambre(Chambre chambre);
    public Chambre getChambreById(long idChambre);
    public List<Chambre> getAllChambre();
    public Chambre updateChambre(Chambre chambre);
    public void deleteChambreById(long idChambre);
    public List<Chambre> getChambreByNumero(long numeroChambre,String nomBloc);
    public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;
    List<Chambre> getChambresParBlocEtType(long idBloc , TypeChambre typeC);

}
