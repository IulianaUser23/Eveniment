package domain;

import java.util.Objects;

public class Persoana extends Entitate{
    private int varsta;
    private String nume;
    private String prenume;

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }


    public Persoana(int id, String nume, String prenume, int varsta) {
        super(id);
        this.nume=nume;
        this.prenume=prenume;
        this.varsta=varsta;
    }


    @Override
    public String toString() {
        return "Persoana{" +
                "id='" + getId() + '\'' +
                "varsta=" + varsta +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object obj){
        Persoana p = (Persoana) obj;    //compararea se va face doar in functie de data si locatie
        if(p.getId()== this.getId()){
            return true;
        }
        return false;
    }



    @Override
    public int hashCode() {

        return Objects.hash(varsta, nume);
    }

}
