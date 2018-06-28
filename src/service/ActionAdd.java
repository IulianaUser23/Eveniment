package service;

import domain.Entitate;
import domain.Event;
import repository.GenericRepo;
import repository.IRepository;

public class ActionAdd<T extends Entitate> implements Action {
    private T object ;
    private GenericRepo<T> repository;


    public ActionAdd(T object, GenericRepo<T> repository){
        this.object = object;
        this.repository = repository;
    }

    @Override
    public void executeDo() throws Exception {
        this.repository.add(object);
    }

    @Override
    public void executeUndo() throws Exception {
        this.repository.sterge(this.object);
    }

    @Override
    public void executeRedo() throws Exception {

        this.repository.add(this.object);

    }
}
