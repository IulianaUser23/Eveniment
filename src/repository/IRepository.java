package repository;

import domain.Event;

import java.util.Date;
import java.util.List;

public interface IRepository {

    List<Event> getAll();
    Event findEveniment(String location, Date date);
    void addEveniment(Event ev) throws Exception;
    void deleteEveniment(String location, Date date) throws Exception;
}
