package service;

import domain.Persoana;
import repository.GenericRepo;

import java.util.ArrayList;

public class ServicePers {
    private GenericRepo<Persoana> repository;

    public ServicePers(GenericRepo<Persoana> repository) {
        this.repository = repository;
    }

    public void adaugarePersoana(int id, String nume, String prenume, int varsta) throws Exception{
        Persoana pers = new Persoana(id, nume, prenume, varsta);
        this.repository.add(pers);
    }

    public Persoana stergePersoana(int id)throws Exception{
        Persoana pers = new Persoana(id,"","",0);
        return this.repository.sterge(pers);

    }

    public ArrayList<Persoana> getAllPers(){
        return new ArrayList<>(this.repository.getAll());
    }
    public Persoana findId(int id){
        return this.repository.findId(id);
    }
    public GenericRepo<Persoana> getRepo() {
        return this.repository;
    }
}
