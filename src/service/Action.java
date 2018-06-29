package service;

public interface Action {
   public void executeDo() throws Exception;
    public void executeUndo() throws Exception;
    public void executeRedo() throws Exception;
}

