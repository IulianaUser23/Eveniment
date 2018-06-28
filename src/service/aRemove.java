package service;

import domain.Event;
import repository.IRepository;

/**
 * Created by User on 28.06.2018.
 */
public class aRemove implements iAction {
    private Event ev;
    private IRepository repository;


    public aRemove (Event ev, IRepository repository){
        this.ev = ev;
        this.repository = repository;

    }

    @Override
    public void executeDo() throws Exception {
        this.repository.deleteEveniment(ev.getLocation(),ev.getDate());
    }

    @Override
    public void executeUndo() throws Exception {
        this.repository.addEveniment(this.ev);

    }
}
