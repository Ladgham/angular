package tn.esprit.springproject.Service;


import tn.esprit.springproject.Entity.Bloc;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IBlocService  {
    public Bloc addBloc(Bloc bloc);
    public Bloc getBlocById(long idBloc);
    public List<Bloc> getAllBloc();
    public Bloc updateBloc(Bloc bloc);
    public void deleteBlocById(long idBloc);
    public List<Bloc> getBlocByCapacite(long capaciteBloc,String nomBloc);
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;

    public Set<Bloc> getBlocsByUniversytyId(long universityId);
}
