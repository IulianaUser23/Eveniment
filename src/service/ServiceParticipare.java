package service;

import domain.Participare;
import repository.GenericRepo;

import java.util.ArrayList;
import java.util.List;

public class ServiceParticipare {
    private GenericRepo repository;
//    private GenericRepository<Persoana> repoPersoana;
//    private GenericRepository<Eveniment> repoEveniment;

    public ServiceParticipare(GenericRepo repository) {
        this.repository = repository;
    }

    public void adaugareParticipare(int id, int idPers, int idEveniment) throws Exception{

        Participare part = new Participare(id, idPers,idEveniment);
        this.repository.add(part);

    }

    public void stergeParticipare(int id) throws Exception {

        Participare part = new Participare(id,0,0);

        this.repository.sterge(part);
    }


    public List<Participare> stergeDupaEveniment(int idEvenimet) throws Exception {

        List<Participare> participari = new ArrayList<>();

        for (Participare part : this.getAll()) {
            if (part.getIdEveniment() == idEvenimet) {
                participari.add(part);

                this.repository.sterge(part);
            }
        }
        return participari;
    }

    public List<Participare>stergeDupaPersoana(int idPers) throws Exception {

        List<Participare> participari = new ArrayList<>();

        for (Participare part: this.getAll()) {
            if (part.getIdPers() == idPers) {
                participari.add(part);

                this.repository.sterge(part);
            }
        }

        return participari;
    }
    public ArrayList<Participare> getAll() {
        return new ArrayList<>(this.repository.getAll());
    }
    public GenericRepo<Participare> getRepo() {
        return this.repository;
    }
}
