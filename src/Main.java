import repository.Repository;
import service.Service;
import ui.UI;

public class Main {

    public static void main(String[] args) {

        Repository repo = new Repository();
        Service service = new Service(repo);
        UI ui = new UI(service);
        ui.run();
    }
}
