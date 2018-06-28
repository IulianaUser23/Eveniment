package domain;

public class Participare extends Entitate {
    private int idPers;
    private int idEveniment;

    public Participare(int idEnt, int idPers, int idEveniment) {
        super(idEnt);
        this.idPers = idPers;
        this.idEveniment = idEveniment;
    }

    public int getIdPers() {
        return idPers;
    }

    public int getIdEveniment() {
        return idEveniment;
    }

    @Override
    public boolean equals(Object obj){
        Participare part = (Participare) obj;
        if(part.getId()== this.getId()){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Participare{" +
                "id=" + getId() +
                " idPers=" + idPers +
                ", idEveniment=" + idEveniment +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
