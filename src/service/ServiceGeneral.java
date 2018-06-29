package service;

import domain.Entitate;
import domain.Event;
import domain.Participare;
import domain.Persoana;
import repository.GenericRepo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 28.06.2018.
 */
public class ServiceGeneral {
    private ServiceEv serviceEvenimente;
    private ServicePers servicePersoana;
    private ServiceParticipare serviceParticipare;

    private GenericRepo genericRepository;

    private ArrayList<Action> undoActions;
    private ArrayList<Action> redoActions;

    public ServiceGeneral(ServiceEv serviceEvenimente, ServicePers servicePersoana, ServiceParticipare serviceParticipare) {
        this.serviceEvenimente = serviceEvenimente;
        this.servicePersoana = servicePersoana;
        this.serviceParticipare = serviceParticipare;
        this.undoActions = new ArrayList<>();
        this.redoActions = new ArrayList<>();
    }

    // EVENIMENT~

    public void adaugaEveniment(int id, String titlu, String locatie, String data, int nrPers, String link) throws Exception {
                this.serviceEvenimente.adaugareEveniment(id, titlu, locatie, data, nrPers, link);
    }

    public void stergeEveniment(int id) throws Exception {
        List<Participare> participari = this.serviceParticipare.stergeDupaEveniment(id);

        Event e = this.serviceEvenimente.stergeEveniment(id);


    }

    public void updateEveniment(int id, String titlu, String locatia, String data, int nrPers, String link) throws Exception {
        this.serviceEvenimente.updateEveniment(id, titlu, locatia, data, nrPers, link);
    }

    public void undo() throws Exception {
        //nu mai am in lista nimic de facut
        if (this.undoActions.size() == 0) {
            throw new Exception("Nu se mai poate face undo!");
        }
        int size = this.undoActions.size();
        // ultima actiune
        Action a = this.undoActions.get(size - 1);
        //  undo pe obiectul actiune a
        a.executeUndo();
        // elimin din lista, actiunea pt care s-a facut undo
        this.undoActions.remove(size - 1);
        this.redoActions.add(a);
    }

    public void redo() throws Exception {
        if (this.redoActions.size() == 0) {
            throw new Exception("Nu se mai poate face redo!");
        }
        int size = this.redoActions.size();
        Action a = this.redoActions.get(size - 1);
        a.executeRedo();
        this.redoActions.remove(size - 1);
        this.undoActions.add(a);
    }



    public ArrayList<Event> getAllEvenimente() {
        return this.serviceEvenimente.getAll();
    }


    //~PERSOANA~

    public void adaugaPersoana(int id, String nume, String prenume, int varsta) throws Exception {
        this.servicePersoana.adaugarePersoana(id, nume, prenume, varsta);
    }

    public void stergePersoana(int id) throws Exception {
        List<Participare> participari = this.serviceParticipare.stergeDupaPersoana(id);
        Persoana p = this.servicePersoana.stergePersoana(id);

    }

    public ArrayList<Persoana> getAllPersoane() {
        return this.servicePersoana.getAllPers();
    }


    // ~PARTICIPARE~

    public void adaugaParticipare(int id, int idPersoana, int idEveniment) throws Exception {
        this.serviceParticipare.adaugareParticipare(id, idPersoana, idEveniment);
    }

    public void stergeParticipare(int id) throws Exception {
        this.serviceParticipare.stergeParticipare(id);
    }

    public ArrayList<Participare> getAll() {
        return this.serviceParticipare.getAll();
    }


    public Entitate find(int id) {
        if (this.genericRepository.findId(id) != null)
            return this.genericRepository.findId(id);
        return null;
    }

    public ArrayList getEvenimentePtPersoana(int id) {
        ArrayList<Event> listEv = new ArrayList<>();
        return listEv;
    }

    public ArrayList<Event> getEvenimente() {
        return this.serviceEvenimente.getAll();
    }

    public ArrayList<Persoana> getPersoana() {
        return this.servicePersoana.getAllPers();
    }

    public ArrayList<Participare> getParticipare() {
        return this.serviceParticipare.getAll();
    }

    //Tema:
//1.Pentru un eveniment dat, să se afișeze toate persoanele care participă
    public ArrayList<Persoana> PersLaEveniment(int idEv) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");
        Event e = new Event(0 ,"", "", f.parse("00/00/00"), 0, "");
        ArrayList<Persoana> persEv = new ArrayList<>();
        for (Participare pa : this.getParticipare()) {
            if (pa.getIdEveniment() == idEv) {
                persEv.add(this.servicePersoana.findId(pa.getIdPers()));
            }
        }
        return persEv;
//        Participare pa = this.getParticipare().stream()
//                .filter((ev) -> ev.getIdEveniment() == e.getId())
//                .findFirst()
//                .orElse(null);
//        return persEv;
    }

    //2.Pentru o persoană dată, să se afișeze toate evenimentele la care aceasta participă.
    public ArrayList<Event> evenimentePtPersoana(int id, String nume, String prenume, int varsta) {
        Persoana p = new Persoana(id, "", "", 0);
        ArrayList<Event> ev = new ArrayList<>();
        for (Participare pa : this.getParticipare()) {
            if (id == pa.getIdPers()) {
                ev.add(this.serviceEvenimente.findId(pa.getIdEveniment()));
            }
        }
        return ev;
//        Participare pa = this.getParticipare().stream()
//                .filter((e) -> id == e.getId())
//                .findFirst()
//                .orElse(null);
//        return ev;
    }
}
