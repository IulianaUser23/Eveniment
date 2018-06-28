package service;

import domain.Event;
import repository.IRepository;

/**
 * Created by User on 28.06.2018.
 */
public class aAdd implements iAction {
    private Event e;
    private IRepository repository;


    public aAdd(Event e, IRepository repository){
        this.e = e;
        this.repository = repository;
    }

    @Override
    public void executeDo() throws Exception {
        this.repository.addEveniment(this.e);
    }

    @Override
    public void executeUndo() throws Exception {
        this.repository.deleteEveniment(e.getLocation(),e.getDate());
    }
}
