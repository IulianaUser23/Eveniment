package service;

import domain.Entitate;
import domain.Participare;
import domain.Persoana;
import repository.GenericRepo;

import java.util.List;

/**
 * Created by User on 28.06.2018.
 */
public class ActionDeleteCascade <TMain extends Entitate, TDependent extends Entitate> extends ActionDelete<TMain> {
    private List<TDependent> dependencies;
    private GenericRepo<TDependent> dependetRepository;

    public ActionDeleteCascade(TMain mainObj, List<TDependent> dependencies, GenericRepo<TMain> mainRepository,
                               GenericRepo<TDependent> dependentRepo)
    {
        super(mainObj, mainRepository);
        this.dependencies = dependencies;
        this.dependetRepository= dependentRepo;
    }


    @Override
    public void executeDo() throws Exception {
        super.executeDo();

        for (TDependent dependency : this.dependencies){
            this.dependetRepository.sterge(dependency);
        }
    }

    @Override
    public void executeUndo() throws Exception {
        super.executeUndo();

        for(TDependent dependency : this.dependencies){
            this.dependetRepository.add(dependency);
        }
    }

    @Override
    public void executeRedo() throws Exception {
        super.executeRedo();

        for(TDependent dependency : this.dependencies){
            this.dependetRepository.sterge(dependency);
        }

    }
}
