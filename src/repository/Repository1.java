package repository;

import domain.Event;

import java.util.ArrayList;
import java.util.Date;

public class Repository1 implements IRepository {
    private ArrayList<Event> evenimente = new ArrayList<>();

    /*
     * Adauga un eveniment in evenimente de evenimente, daca acesta nu mai exista deja.
     * Input: e - Eveniment
     * Output: Evenimentul e va fi adaugat in evenimente de evenimente.
     */
    @Override
    public void addEveniment(Event e) throws Exception {
        int pos = this.find(e);
        if (pos == -1) // e nu a mai fost gasit in evenimente
            this.evenimente.add(e);
        else    // e mai exista in evenimente
            throw new Exception("Evenimentul mai exista in evenimente!");
    }

    /*
     * Cauta un eveniment in evenimente si returneaza pozitia acestuia.
     * Input: e - Eveniment
     * Output: pozitia pe care se afla e, daca e este gasit
     *         -1, daca e nu este gasit in evenimente
     */
    public int find(Event e) {
        for (int i = 0; i < this.evenimente.size(); i++)
            if (this.evenimente.get(i).equals(e))
                return i;
        return -1;
    }

    public void deleteEveniment(Event e) {
        this.evenimente.remove(e);
    }


    public ArrayList<Event> getAll() {
        return this.evenimente;
    }


    public Event findEveniment(String locatie, Date data) {
        for (Event ev : this.evenimente) {
            if (ev.getLocation() == locatie && ev.getDate() == data) {
                return ev;
            }
        }     return null;
    }
}
