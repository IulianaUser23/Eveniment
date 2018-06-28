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
        ServiceGeneral sv = new ServiceGeneral(serviceEvenimente, servicePersoana, serviceParticipare);
        UI ui = new UI(sv);

        try {
            sv.adaugaEveniment(1, "Circ", "Cluj", "05/06/18", 150, "https://www.circus.ro");
            sv.adaugaEveniment(2, "Teatru", "Cluj", "06/19/18", 200, "www.teatrucluj.ro");
            sv.adaugaEveniment(3, "Opera", "Cluj", "07/20/18", 100, "www.operacluj.ro");
            sv.adaugaEveniment(4, "ConcertAerLiber", "PiataUnirii", "06/15/18", 300, "www.clujevents.ro");
            sv.adaugaEveniment(5, "ZileleClujului", "PiataUnirii", "05/17/18", 600, "www.clujlife.ro");
            sv.adaugaEveniment(6, "Untold", "ParculCentral", "08/03/18", 30000, "www.untold.ro");

            sv.adaugaPersoana(1, "A", "C1", 45);
            sv.adaugaPersoana(2, "B", "C2", 34);
            sv.adaugaPersoana(3, "C", "C3", 32);
            sv.adaugaPersoana(4, "D", "C4", 25);
            sv.adaugaPersoana(5, "E", "C5", 38);
            sv.adaugaPersoana(6, "F", "C6", 30);

            sv.adaugaParticipare(10, 5, 5);
            sv.adaugaParticipare(11, 1, 5);
            sv.adaugaParticipare(12, 1, 6);
            sv.adaugaParticipare(13, 6, 1);
            sv.adaugaParticipare(14, 3, 6);
            sv.adaugaParticipare(15, 3, 2);
        } catch (Exception e) {
            System.out.println("Eroare la adaugare");
        }
        ui.run();
//        IRepository repo = new Repository1();
//        //        repository.Repository1 repository1 = new repository.Repository1();
//        ServiceEv serviceEv = new ServiceEv(repo);
//        //        repository.Repository2 repository2 =new repository.Repository2("evenimente.txt");
//        //        serviceEv.ServiceEv serviceEv = new serviceEv.ServiceEv(repository2);
//        serviceEv.adaugaEveniment("Circ","Cluj","05/06/18",150,"https://www.circus.ro");
//        serviceEv.adaugaEveniment("Teatru","Cluj","06/19/18",200,"www.teatrucluj.ro");
//        serviceEv.adaugaEveniment("Opera", "Cluj","07/20/18",100,"www.operacluj.ro");
//        serviceEv.adaugaEveniment("ConcertAerLiber","PiataUnirii","06/15/18",300,"www.clujevents.ro");
//        serviceEv.adaugaEveniment("ZileleClujului","PiataUnirii","05/17/18",600,"www.clujlife.ro");
//        serviceEv.adaugaEveniment("Untold","ParculCentral","08/03/18",30000,"www.untold.ro");
//        UI ui = new UI(serviceEv);
//        ui.run();
//    }
    }
}
