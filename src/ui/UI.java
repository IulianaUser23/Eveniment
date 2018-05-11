package ui;

import domain.Event;
import service.Service;

import java.util.Scanner;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by User on 11.05.2018.
 */
public class UI {
    private Service service;
    private Scanner in = new Scanner(System.in);

    public UI(Service s)
    {
        this.service = s;
    }

    public void printMenu()
    {
        System.out.println("1. Adaugare eveniment.");
        System.out.println("2. Afisare evenimente.");
        System.out.println("0. Exit.");
    }

    public void adauga()
    {
        try
        {
            System.out.print("Introduceti titlul: ");
            String titlu = this.in.next();

            System.out.print("Introduceti locatia: ");
            String locatie = this.in.next();

            System.out.print("Introduceti data: ");
            String data = this.in.next();

            System.out.print("Introduceti numarul de persoane: ");
            int nrPersoane = this.in.nextInt();

            System.out.print("Introduceti link: ");
            String link = this.in.next();

            service.adaugaEveniment(titlu, locatie, data, nrPersoane, link);
        }
        catch(ParseException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void afiseaza()
    {
        for (Event e: this.service.getAll())
            System.out.println(e.toString());
    }

    public void run()
    {
        while (true)
        {
            this.printMenu();
            System.out.println("Introduceti comanda: ");
            int cmd = this.in.nextInt();

            if (cmd == 0)
                break;

            switch (cmd)
            {
                case 1:
                    this.adauga();
                    break;
                case 2:
                    this.afiseaza();
                    break;
                default:
                    System.out.println("Eroare");
                    break;
            }
        }
    }
}
