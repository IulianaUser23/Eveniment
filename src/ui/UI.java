package ui;

import domain.Event;
import service.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class UI {
    private Service service;
    private Scanner in = new Scanner(System.in);

    //constructorul
    public UI(Service s) {
        this.service = s;
    }

    public void printMenu() {
        System.out.println("1.Adaugare Eveniment.");
        System.out.println("2.Afisare Evenimente.");
        System.out.println("3.Sterge Eveniment");
        System.out.println("4.Sorteaza Eveniment");
        System.out.println("5.Undo Eveniment");
        System.out.println("6.Redo Eveniment");
        System.out.println("0.Exit");
    }

    public void adauga() {
        try {
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

            this.service.adaugaEveniment(titlu, locatie, dataStr, nrPersoane, link);


        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sterge() {
        System.out.println("Introduceti locatia: ");
        String locatie = this.in.next();
        System.out.println("Introduceti data(MM/dd/yy): ");
        String data = this.in.next();
        try {
            service.stergeEveniment(locatie, data);
        } catch (Exception e) {
            System.out.println("Evenimentul nu exista in lista!");
        }

    }

    //afiseaza toate evenimentele
    public void afiseaza() {
        for (Event e : this.service.getAll()) //getAll imi da o lista si e  va fi fiecare eveniment din lista
            System.out.println(e.toString());
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

    public void sorteaza() {
        try {
            System.out.println("Introduceti data (MM/dd/yy):");
            String d = this.in.next();
            for (Event e : service.evenimenteOrdonate(d)) {
                System.out.println(e.toString());
            }
        } catch (ParseException p) {
            System.out.println(p.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        while (true) {
            this.printMenu();
            System.out.println("Introduceti comanda: ");
            int cmd = this.in.nextInt();

            if (cmd == 0)
                break;
            switch (cmd) {
                case 1:
                    this.adauga();
                    break;
                case 2:
                    this.afiseaza();
                    break;
                case 3:
                    this.sterge();
                    break;
                case 4:
                    this.sorteaza();
                    break;
                case 5:
                    this.undo();
                    break;
                case 6:
                    this.redo();
                    break;
            }
        }
    }
}
