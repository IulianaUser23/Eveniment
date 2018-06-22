package repository;

import domain.Event;

import java.util.Date;
import java.util.List;

public interface IRepository {

    List<Event> getAll();
    Event findEveniment(String locatie, Date data);
    void addEveniment(Event ev) throws Exception;
    void deleteEveniment(Event ev);
}
