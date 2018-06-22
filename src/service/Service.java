package service;

import domain.Event;
import repository.IRepository;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Service {
    private IRepository repo;

    public Service(IRepository repo) {
        this.repo = repo;
    }

    public List<Event> getAll() {
        return this.repo.getAll();
    }

    public void adaugaEveniment(String titlu, String locatia, String data, int nrOameni, String link) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Event e = new Event(titlu, locatia, f.parse(data), nrOameni, link);
        this.repo.addEveniment(e);

    }

    public void stergeEveniment(String titlu, String locatia, String data, int nrOameni, String link) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Event e = new Event(titlu, locatia, f.parse(data), nrOameni, link);
        repo.deleteEveniment(e);
    }

    public List<Event> sorteazaDupaLocatie(String locatia) {
        List<Event> ev = repo.getAll();
        Collections.sort(ev, (o1, o2) -> o1.getLocation().compareToIgnoreCase(o2.getLocation()));
        return ev;
    }

    public List<Event> sorteazaDupaLuna (){
        return null;
    }
}
