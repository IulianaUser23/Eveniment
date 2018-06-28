package main;

import domain.Event;
import domain.Participare;
import domain.Persoana;
import repository.GenericRepo;
import service.ServiceEv;
import service.ServiceGeneral;
import service.ServiceParticipare;
import service.ServicePers;
import ui.UI;

//import ui.GUI;
//import ui.UI;
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

        GenericRepo<Event> repoEveniment = new GenericRepo<>();

        GenericRepo<Participare> repoParticipari = new GenericRepo<>();

        GenericRepo<Persoana> repoPersoana = new GenericRepo<>();

        ServiceEv serviceEvenimente = new ServiceEv(repoEveniment);

        ServiceParticipare serviceParticipare = new ServiceParticipare(repoParticipari);

        ServicePers servicePersoana = new ServicePers(repoPersoana);

        ServiceGeneral serviceGeneral = new ServiceGeneral(serviceEvenimente, servicePersoana, serviceParticipare);
        UI ui = new UI(serviceGeneral);

        //GUI gui = new GUI(serviceGeneral);

        try {
            serviceGeneral.adaugaEveniment(1, "Circ", "Cluj", "05/06/18", 150, "https://www.circus.ro");
            serviceGeneral.adaugaEveniment(2, "Teatru", "Cluj", "06/19/18", 200, "www.teatrucluj.ro");
            serviceGeneral.adaugaEveniment(3, "Opera", "Cluj", "07/20/18", 100, "www.operacluj.ro");


            serviceGeneral.adaugaPersoana(1, "A", "C1", 45);
            serviceGeneral.adaugaPersoana(2, "B", "C2", 34);
            serviceGeneral.adaugaPersoana(3, "C", "C3", 32);


            serviceGeneral.adaugaParticipare(10, 5, 5);
            serviceGeneral.adaugaParticipare(11, 1, 5);
            serviceGeneral.adaugaParticipare(12, 1, 6);

        } catch (Exception e) {
            System.out.println("Eroare la adaugare");
        }
        ui.run();
        //  gui.initializareGUI();

//        IRepository repo = new Repository1();
//        ServiceGeneral serviceGen = new ServiceGeneral(repo);
//
//        serviceGen.adaugaEveniment(1,"Circ","Cluj","05/06/18",150,"https://www.circus.ro");
//        serviceGen.adaugaEveniment(2,"Teatru","Cluj","06/19/18",200,"www.teatrucluj.ro");
//        serviceGen.adaugaEveniment(3,"Opera", "Cluj","07/20/18",100,"www.operacluj.ro");
//


//    }
    }
}
