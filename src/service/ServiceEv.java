package service;

import domain.Event;
import repository.GenericRepo;
import repository.IRepository;
//import repository.Repository1;
//import repository.Repository2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ServiceEv {
    private GenericRepo<Event> repository;


    private GenericRepo<Event> repo;
    private ArrayList<Action> undoActions = new ArrayList<>();
    private ArrayList<Action> redoActions = new ArrayList<>();
//    obiectele adaugate sterse sunt stocate si in doua liste(pe langa repo) astfel incat in cazul in care se doreste
//    executia de undo sau redo, obiectele pot fi luate din aceste liste

    public ServiceEv (GenericRepo repository){
        this.repository = repository;
    }

    public void adaugareEveniment(int id, String titlu, String locatie, String data, int nrPersoane, String link) throws Exception {
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");
        Event e = new Event(id, titlu, locatie, f.parse(data), nrPersoane, link);
        this.repository.add(e);
        //retinem ce actiune s-a facut ca sa putem sa-i inversam efectul
        //Action a = new ActionAdd(e, this.irepo); //va lucra cu functiile din clasa ActionAdd
        // undoActions.add(a); //se pune elementul adaugat in repo in lista pentru a putea fi sters in caz de undo
    }
    public Event stergeEveniment(int id) throws Exception{
        Event e =this.repository.findId(id);
        if (e == null) {
            throw new Exception("Evenimentul nu exista!");
        }
        this.repository.sterge(e);

        return e;
    }
    public void updateEveniment(int id, String titlu, String locatie, String data, int nrPersoane, String link) throws Exception {

        Event evenimentExistent = this.repository.findId(id);
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");
        Event evenimentNou = new Event(id, titlu, locatie, f.parse(data), nrPersoane, link);

        this.repository.update(evenimentNou);
    }

    public Event findId(int id) {
        if (this.repository.findId(id) != null) {
            return this.repository.findId(id);
        }
        return null;
    }
    public GenericRepo<Event> getRepository(){
        return this.repository;
    }

    public Date stringToDate(String date) throws ParseException {     //transforma stringul date in Date
        SimpleDateFormat d = new SimpleDateFormat("MM/dd/yy");
        return d.parse(date);
    }
    public int getMonth(Date date) {
        SimpleDateFormat d = new SimpleDateFormat("MM");
        int month = Integer.parseInt(d.format(date));    //transforma Date in int
        return month;
    }
    public void ordonare(List<Event> e){
        e.sort(Comparator.comparing(d -> d.getDate()));
    }
    public ArrayList<Event> getAll() {
        return new ArrayList<>(this.repository.getAll());
    }

}
