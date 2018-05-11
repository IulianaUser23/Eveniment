package service;

import domain.Event;
import repository.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by User on 11.05.2018.
 */
public class Service {
    private Repository repo;

    public Service(Repository r)
    {
        this.repo = r;
    }

    public void adaugaEveniment(String title, String location, Date date, int nrOfPeople, String link) throws Exception
    {
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Event e = new Event(title, location, date, nrOfPeople, link);
        this.repo.adaugaEveniment(e);
    }

    public ArrayList<Event> getAll()
    {
        return this.repo.getAll();
    }
}
