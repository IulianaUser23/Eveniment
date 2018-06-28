package service;

import domain.Event;
import repository.IRepository;
import repository.Repository1;
import repository.Repository2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServiceEv {
    private Repository1 repo;
    private Repository2 rep;
    private IRepository irepo;
    private ArrayList<Action>undoActions=new ArrayList<>();
    private ArrayList<Action>redoActions = new ArrayList<>();



    //Constructor pentru service care primeste un repository
    public ServiceEv(Repository1 r1){
        this.repo = r1;
    }
    public ServiceEv(Repository2 repository2){
        this.rep = repository2;
    }
    public ServiceEv(IRepository repository){
        this.irepo = repository;
    }


    public void adaugaEveniment(String titlu, String locatia, String date, int nrOameni, String link) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");
        Event ev = new Event(titlu,locatia,f.parse(date),nrOameni,link);
        this.irepo.addEveniment(ev);

        //retinem ce actiune s-a facut ca sa ii putem face inversul
        Action a = new ActionAdd(ev,irepo);
        this.undoActions.add(a);

    }

    public List<Event> getAll(){
        return this.irepo.getAll();
    }

    public void undo() throws Exception {
        //daca nu mai sunt actiuni in lista, aruncam o exceptie
        if(this.undoActions.size() == 0) {
            throw new Exception("Nu se mai poate face undo!");
        }

        int size = this.undoActions.size();
        //luam actiunea de pe ultima pozitie
        Action a = this.undoActions.get(size - 1);
        //executam undo pe obiectul aciune a
        a.executeUndo();
        //eliminam din lista de actiuni, actiunea pt care s-a facut undo
        this.redoActions.add(a);
        this.undoActions.remove(size-1);

    }
    public void redo() throws Exception{
        if(this.redoActions.size() == 0) {
            throw new Exception("Nu se mai poate face redo!");
        }
        int size = this.redoActions.size();
        Action a = this.redoActions.get(size - 1);
        a.executeDo();
        this.undoActions.add(a);
        this.redoActions.remove(size - 1);
    }

    public void stergeEveniment (String location, String date) throws Exception {

        SimpleDateFormat dt = new SimpleDateFormat("MM/dd/yy");
        Event ev = this.irepo.findEveniment(location,dt.parse(date));
        irepo.deleteEveniment(location, dt.parse(date));

        Action a = new ActionDelete<>(ev, irepo);
        this.undoActions.add(a);
    }


    public Date stringToDate(String date) throws ParseException{
        SimpleDateFormat d = new SimpleDateFormat("MM/dd/yy");
        return d.parse(date);
    }

    public static int getMonth(Date date) {
        SimpleDateFormat d = new SimpleDateFormat("MM");
        int month = Integer.parseInt(d.format(date));
        return month;
    }
    public void ordonare(List<Event> e){

        e.sort(Comparator.comparing(d -> d.getDate()));
    }

    public ArrayList<Event> evenimenteOrdonate(String data) throws ParseException{
        ArrayList<Event> listaEvenimente = new ArrayList<>();
        int luna = getMonth(stringToDate(data));
        for(int i = 0; i < irepo.getAll().size(); i++){
            Date d = irepo.getAll().get(i).getDate();
            if(getMonth(d) == luna){
                listaEvenimente.add(irepo.getAll().get(i));
            }
        }
        ordonare(listaEvenimente);
        return listaEvenimente;
    }

}
