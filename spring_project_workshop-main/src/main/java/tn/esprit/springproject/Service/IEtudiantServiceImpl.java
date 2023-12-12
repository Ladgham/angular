package tn.esprit.springproject.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Etudiant;
import tn.esprit.springproject.Repository.IEtudiantRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class IEtudiantServiceImpl implements IEtudiantService{
    @Autowired
    private IEtudiantRepository etudiantRepository;

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant getEtudiantById(long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        Iterable<Etudiant> iterable = etudiantRepository.findAll();
        List<Etudiant> etudiantList = new ArrayList<>();
        iterable.forEach(etudiantList::add);
        return etudiantList;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiantById(long idEtudiant) {etudiantRepository.deleteById(idEtudiant);}

    @Override
    public List<Etudiant> getEtudiantByDateNaissance(Date dateNaissance) {
        return etudiantRepository.findByDateNaissanceGreaterThan(dateNaissance);
    }

    @Override
    public List<Etudiant> getAllByChambre(long idChambre) {
        return etudiantRepository.findAllByIdChambre(idChambre);
    }


}
