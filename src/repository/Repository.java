package repository;

import domain.Event;

import java.util.ArrayList;

/**
 * Created by User on 11.05.2018.
 */
public class Repository {
    private ArrayList<Event> evenimente = new ArrayList<>();

    /*
     * Adauga un eveniment in lista de evenimente, daca acesta nu mai exista deja.
     * Input: e - Eveniment
     * Output: Evenimentul e va fi adaugat in lista de evenimente.
     */
    public void adaugaEveniment(Event e) throws Exception
    {
        int pos = this.find(e);
        if (pos == -1) // e nu a mai fost gasit in lista
            this.evenimente.add(e);
        else	// e mai exista in lista
            throw new Exception("Evenimentul mai exista in lista!");
    }

    /*
     * Cauta un eveniment in lista si returneaza pozitia acestuia.
     * Input: e - Eveniment
     * Output: pozitia pe care se afla e, daca e este gasit
     *         -1, daca e nu este gasit in lista
     */
    public int find(Event e)
    {
        for (int i = 0; i < this.evenimente.size(); i++)
            if (this.evenimente.get(i).equals(e))
                return i;
        return -1;
    }

    public ArrayList<Event> getAll()
    {
        return this.evenimente;
    }
}

