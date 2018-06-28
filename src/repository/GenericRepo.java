package repository;

import domain.Entitate;
import service.Action;

import java.util.ArrayList;
import java.util.List;


public class GenericRepo<T extends Entitate> implements Action {
    protected List<T> elemente = new ArrayList<>();

    public T findId (int id)
    {
        T elem = this.elemente.stream()
                .filter((el) -> el.getId()== id)
                .findFirst()
                .orElse(null);
        return elem;
    }
    private int find (T elem){


        for(int i=0; i < this.elemente.size(); i++){
            T object = this.elemente.get(i);
            if (object.equals(elem)){
                return i;
            }
        }
        return -1;
    }

    public void add(T elem) throws Exception
    {
        T e = this.findId(elem.getId());
        if (e != null)
            throw new Exception("Elementul exista deja!");

        this.elemente.add(elem);
    }


    public List<T> getAll() {

        return this.elemente;
    }


    public T sterge(T elem) throws Exception {
        int pozitie = this.find(elem);
        if (pozitie == -1) {
            throw new Exception("Nu exista elementul");

        }this.elemente.remove(pozitie);
        return elem;
    }


    public T update(T elem) throws Exception {
        T el = findId(elem.getId());  //el va fi elementul vechi

        if (el == null) {
            throw new Exception("Nu exista elementul");
        }
        elemente.add(elem);
        return el;
    }


    @Override
    public void executeDo() throws Exception {

    }

    @Override
    public void executeUndo() throws Exception {

    }

    @Override
    public void executeRedo() throws Exception {

    }
}
