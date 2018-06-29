package ui;

import domain.Event;
import domain.Participare;
import domain.Persoana;
import service.ServiceGeneral;

import java.text.ParseException;
import java.util.Scanner;

public class UI {
    private ServiceGeneral service;
    private Scanner in = new Scanner(System.in);

    //constructorul
    public UI(ServiceGeneral s) {
        this.service = s;
    }

    public void printMenu() {
        System.out.println("1.Adauga Eveniment.");
        System.out.println("2.Afiseaza Lista de evenimente.");
        System.out.println("3.Sterge Eveniment");
        System.out.println("4.Sorteaza Eveniment");
        System.out.println("5.Actualizeaza Eveniment");
        System.out.println("6.Adauga Persoana");
        System.out.println("7.Afiseaza Persoane");
        System.out.println("8.Sterge Persoana");
        System.out.println("9.Adauga Participare");
        System.out.println("10.Afiseaza Participare");
        System.out.println("11.Sterge Participare");
        System.out.println("12.Undo");
        System.out.println("13.Redo");
        System.out.println("14.Afiseaza Persoane la eveniment");
        System.out.println("15.Afiseaza evenimentele la care participa o persoana");
        System.out.println("0.Exit");
    }

    public void adaugaEveniment() {
        try {
            System.out.println("Introduceti id-ul: ");
            int id = this.in.nextInt();
            System.out.println("Introduceti titlul: ");
            String titlu = this.in.next();

            System.out.println("Introduceti locatia: ");
            String locatie = this.in.next();

            System.out.println("Introduceti data (MM/dd/yyyy): ");
            String dataStr = this.in.next();

            System.out.println("Introduceti nrPersoane: ");
            int nrPersoane = this.in.nextInt();

            System.out.println("Introduceti link: ");
            String link = this.in.next();

            this.service.adaugaEveniment(id,titlu, locatie, dataStr, nrPersoane, link);

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void adaugarePersoana(){
        try{
            System.out.println("Introduceti id-ul: ");
            int id = this.in.nextInt();
            System.out.println("Introduceti numele: ");
            String nume = this.in.next();
            System.out.println("Introduceti prenumele: ");
            String prenume = this.in.next();
            System.out.println("Introduceti varsta: ");
            int varsta = this.in.nextInt();
            this.service.adaugaPersoana(id, nume, prenume, varsta);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void adaugaParticipare(){
        try{
            System.out.println("Introduceti id-ul: ");
            int id = this.in.nextInt();
            System.out.println("Introduceti id-ul persoanei: ");
            int idPers = this.in.nextInt();
            System.out.println("Introduceti id-ul evenimentului: ");
            int idEveniment = this.in.nextInt();
            this.service.adaugaParticipare(id, idPers,idEveniment);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void afisareEvenimente(){
        for(Event e: this.service.getEvenimente()){
            System.out.println(e.toString());
        }
    }

    public void afiseazaPersoane(){
        for(Persoana p : this.service.getPersoana()){
            System.out.println(p.toString());
        }
    }

    public void afiseazaParticipari(){
        for (Participare part : this.service.getParticipare()) {
            System.out.println(part.toString());
        }
    }

    public void afiseazaPersLaEveniment(){
        try {
            System.out.println("Introduceti id-ul evenimentului: ");
            int id = this.in.nextInt();
            for (Persoana pers : this.service.PersLaEveniment(id)){
                System.out.println(pers.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void afiseazaEvenimentePtPersoana(){
        try{
            System.out.println("Introduceti id-ul persoanei: ");
            int id = this.in.nextInt();
            for(Event e : this.service.evenimentePtPersoana(id, "","",0)){
                System.out.println(e.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void stergeParticipare(){
        try{
            System.out.println("Introduceti id-ul participarii:");
            int id = this.in.nextInt();
            this.service.stergeParticipare(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void stergeEveniment() {
        int id = this.in.nextInt();
        try {
            System.out.println("Introduceti id-ul evenimentului:");
            service.stergeEveniment(id);
        } catch (Exception e) {
            System.out.println("Evenimentul nu exista in lista!");
        }
    }
    private void stergePersoana() {

        System.out.println("Introduceti id-ul");
        int id = this.in.nextInt();

        try {
            this.service.stergePersoana(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void undo() {
        try {
            this.service.undo();
            System.out.println("Undo s-a facut cu succes!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void redo() {
        try {
            this.service.redo();
            System.out.println("Redo s-a facut cu succes!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //    public void sorteazaEveniment() {
//        try {
//            System.out.println("Introduceti data (MM/dd/yy):");
//            String d = this.in.next();
//            List<Eveniment> e = this.service.ordonare();
//            for (Eveniment e : service.ordonare(d)) {
//                System.out.println(e.toString());
//            }
//        } catch (ParseException p) {
//            System.out.println(p.getMessage());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    private void updateEveniment() throws Exception {

        System.out.println("Introduceti id-ul evenimentului");
        int id = this.in.nextInt();

        System.out.println("Introduceti noul titlu");
        String titlu = this.in.next();

        System.out.println("Introduceti noua locatie");
        String locatie = this.in.next();

        System.out.println("Introduceti noua data");
        String data = this.in.next();

        System.out.println("Introduceti noul nr de persoane");
        int nrPersoane = this.in.nextInt();

        System.out.println("Introduceti noul link");
        String link = this.in.next();

        try {
            this.service.updateEveniment(id, titlu, locatie, data, nrPersoane, link);
            System.out.println("Evenimentul s-a modificat.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() throws Exception {
        while (true) {
            this.printMenu();
            System.out.println("Introduceti comanda: ");
            int cmd = this.in.nextInt();

            if (cmd == 0)
                break;
            switch (cmd) {
                case 1:
                    this.adaugaEveniment();
                    break;
                case 2:
                    this.afisareEvenimente();
                    break;
                case 3:
                    this.stergeEveniment();
                    break;
//                case 4:
//                    this.sorteazaEveniment();
//                    break;
                case 5:
                    this.updateEveniment();
                    break;
                case 6:
                    this.adaugarePersoana();
                    break;
                case 7:
                    this.afiseazaPersoane();
                    break;
                case 8:
                    this.stergePersoana();
                    break;
                case 9:
                    this.adaugaParticipare();
                    break;
                case 10:
                    this.afiseazaParticipari();
                    break;
                case 11:
                    this.stergeParticipare();
                    break;
                case 12:
                    this.undo();
                    break;
                case 13:
                    this.redo();
                    break;
                case 14:
                    this.afiseazaPersLaEveniment();
                    break;
                case 15:
                    this.afiseazaEvenimentePtPersoana();
                    break;

            }
        }
    }
}
