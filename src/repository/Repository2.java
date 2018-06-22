package repository;

import domain.Event;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository2 implements IRepository {

    private Map<String, Event> evenimente = new HashMap<>();
    private String filename;

    public Repository2(String filename) {
        this.filename = filename;
        load();
    }

    private void load() {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            // citeste cate o linie cat timp are ce sa citeasca
            while ((line = br.readLine()) != null) {
                String[] componente = line.split(",");
                Event eveniment = new Event(componente[0], componente[1], Date.valueOf(componente[2]),
                        Integer.parseInt(componente[3]), componente[4]);
                evenimente.put(eveniment.getTitle(), eveniment);
            }
        } catch (IOException ioe) {
        }
    }

    public void save() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Event eveniment : evenimente.values()) {
                bw.write(eveniment.getTitle() + "," + eveniment.getLocation() + "," + eveniment.getDate() + "," +
                        eveniment.getNrOfPeople() + "," + eveniment.getLink());
                bw.write(System.lineSeparator());
            }
        } catch (IOException ioe) {

        }
    }

    public List<Event> getAll() {
        return new ArrayList<>(evenimente.values());
    }

    private String getKey(String locatie, java.util.Date data) {
        return locatie + "," + data;
    }

    public Event findEveniment(String locatie, java.util.Date data) {
        String mapKey = getKey(locatie, data);
        return evenimente.get(mapKey);
    }

    public void addEveniment(Event ev) {
        if (findEveniment(ev.getLocation(), ev.getDate()) != null) {
            throw new IllegalArgumentException("Acest eveniment deja exista.");
        }
        String key = getKey(ev.getLocation(), ev.getDate());
        evenimente.put(key, ev);
        save();
    }

    public void deleteEveniment(Event ev) {
        if (findEveniment(ev.getLocation(), ev.getDate()) == null ){
            throw new IllegalArgumentException("Acest eveniment nu exista.");
        }String key = getKey(ev.getLocation(), ev.getDate());
        evenimente.remove(key, ev);
        save();
    }
}
