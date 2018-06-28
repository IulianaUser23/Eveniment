package repository;

import domain.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repository1 implements IRepository {
    private ArrayList<Event> evenimente = new ArrayList<>();

    /*
     * Adauga un eveniment in lista de evenimente, daca acesta nu mai exista deja.
     * Input: e - domain.domain.Eveniment
     * Output: Evenimentul e va fi adaugat in lista de evenimente.
     */
    public void addEveniment(Event e) throws Exception{
        Event ev = this.findEveniment(e.getLocation(),e.getDate());
        if(ev == null)
            this.evenimente.add(e);
        else //e mai exista in lista
            throw new Exception("Evenimentul mai exista in lista!");
    }

    /*
     *Cauta un domain.domain.Eveniment in lista si returneaza pozitia acestuia
     *Input: e-domain.domain.Eveniment
     *Output: pozitia pe care se afla e, daca e este gasit sau -1 daca e nu este gasit in lista
     */
    public Event findEveniment (String location, Date date){
        Event e = new Event("", location, date, 0, "");
        for(int i=0; i < this.evenimente.size(); i++)
            if (this.evenimente.get(i).equals(e))
                return this.evenimente.get(i);
        return null;
    }

    public ArrayList<Event>getAll(){
        return this.evenimente;
    }


    public void deleteEveniment(String locatie, Date data) throws Exception {
        Event eveniment = new Event("",locatie,data,0,"");
        if (findEveniment(locatie,data)!= null){
            this.getAll().remove((eveniment));
        }else
            throw new Exception();
    }
}
