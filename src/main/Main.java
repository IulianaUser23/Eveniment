package main;

import repository.IRepository;
import repository.Repository1;
import service.Service;
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

        IRepository repo = new Repository1();
        //        repository.Repository1 repository1 = new repository.Repository1();
        Service service = new Service(repo);
        //        repository.Repository2 repository2 =new repository.Repository2("evenimente.txt");
        //        service.Service service = new service.Service(repository2);
        service.adaugaEveniment("Circ","Cluj","05/06/18",150,"https://www.circus.ro");
        service.adaugaEveniment("Teatru","Cluj","06/19/18",200,"www.teatrucluj.ro");
        service.adaugaEveniment("Opera", "Cluj","07/20/18",100,"www.operacluj.ro");
        service.adaugaEveniment("ConcertAerLiber","PiataUnirii","06/15/18",300,"www.clujevents.ro");
        service.adaugaEveniment("ZileleClujului","PiataUnirii","05/17/18",600,"www.clujlife.ro");
        service.adaugaEveniment("Untold","ParculCentral","08/03/18",30000,"www.untold.ro");
        UI ui = new UI(service);
        ui.run();
    }
}
