package ui;

import domain.Event;
import service.Service;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;

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
        System.out.println("3. Sterge evenimente.");
        System.out.println("4. Afiseaza evenimentele cronologic.");
        System.out.println("5. Afiseaza evenimentele dupa locatie.");
        System.out.println("6. Undo.");
        System.out.println("6. Redo.");
        System.out.println("0. Exit.");
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
                case 3:
                    this.stergeEveniment();
                    break;
                case 4:
                    this.sorteazaDupaData();
                    break;
                case 5:
                    this.sorteazaDupaLocatie();
                    break;
              //  case 6:
               //     this.undo();
               //     break;
                case 7:
                    this.redo();
                    break;
                default:
                    System.out.println("Eroare");
                    break;
            }
        }
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
            this.service.adaugaEveniment(titlu, locatie, data, nrPersoane, link);
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

 /**   private void undo() {
        try
        {
            this.service.undo();
            System.out.println("Undo s-a facut cu succes.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
*/

    private void redo() {
    }

    // Afișarea tuturor evenimentelor dintr-o lună, ordonate cronologic
    private void sorteazaDupaData() {

    }

    private void sorteazaDupaLocatie() {
        System.out.print("Introduceti locatia: ");
        String locatie = this.in.next();
        System.out.println("Lista dupa locatie" + service.sorteazaDupaLocatie(locatie));
    }


    //Ștergerea unui eveniment. Dacă evenimentul care se dorește a fi șters nu există, se va afișa un
    // mesaj.
    private void stergeEveniment () {
        try{
        System.out.print("Introduceti titlul evenimentului pe care il stergeti: ");
        String titlu = this.in.next();
        System.out.print("Introduceti locatia: ");
        String locatie = this.in.next();
        System.out.print("Introduceti data: ");
        String data = this.in.next();
        System.out.print("Introduceti numarul de persoane: ");
        int nrPersoane = this.in.nextInt();
        System.out.print("Introduceti link: ");
        String link = this.in.next();
        service.stergeEveniment(titlu, locatie, data, nrPersoane, link) ;
        } catch (java.lang.Exception jle){

        }
    }
}
//SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//format.parse(data);