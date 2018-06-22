package main;

import repository.IRepository;
import repository.Repository1;
import repository.Repository2;
import service.Service;
import ui.GUI;
import ui.UI;

import javax.swing.*;
/*
Implementați o aplicație software care să vă ajute să va gestionați viața după serviciu/cursuri și să fiți
mereu informați despre evenimentele interesante din orașul dumneavoastră. Aplicația va memora toate
evenimentele într-un Repository1. Fiecare eveniment are un titlu, o locație, o dată, un număr de oameni
care merg la acel eveniment și un link către resursa online. Aplicația va oferi următoarele opțiuni:
- Adăugarea unui eveniment. Dacă un alt eveniment cu aceeași locație și aceeași oră există deja,
aplicația va afișa un mesaj și evenimentul nu va fi adăugat.
- Afișarea tuturor evenimentelor.
- Afișarea tuturor evenimentelor dintr-o lună, ordonate cronologic
- Ștergerea unui eveniment. Dacă evenimentul care se dorește a fi șters nu există, se va afișa un
mesaj.
 */

public class Main {

    public static void main(String[] args) throws Exception {


       // IRepository repo = new Repository2("file.csv");
        IRepository repo = new Repository1();
        Service service = new Service(repo);


        service.adaugaEveniment( "Joaca", "Cluj", "10/05/2018", 0, "www.joaca.ro");
        service.adaugaEveniment( "Concert", "Braila", "05/12/2018", 0, "www.concert.ro");

     //   UI ui = new UI(service);
     //   ui.run();
     //pentru a stiliza putin fereastra
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        GUI gui = new GUI(service);
        gui.initializareGUI();
    }
}
