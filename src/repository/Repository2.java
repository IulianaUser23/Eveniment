package repository;

import domain.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository2 implements IRepository {

    private Map<String, Event> evenimente = new HashMap<>();
    private String filename;
    private DateFormat d = new SimpleDateFormat("MM/dd/yy");

    public Repository2 (String filename){
        this.filename = filename;
    }
    private String getKey(String locatie, Date date){
        return locatie + "_" + date;
    }

    private void loadFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null){
                String[] params = line.split(",");
                String titlu = params[0];
                String locatie = params[1];
                Date date = d.parse(params[2]);
                int nrPersoane = Integer.parseInt(params[3]);
                String link = params[4];

                Event ev = new Event(titlu,locatie, date, nrPersoane, link);
                String keyMap = getKey(locatie, date);

                evenimente.put(keyMap, ev);
            }
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + filename);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename))) {

            for (Event ev : evenimente.values()) {
                w.write(String.format("%s,%s,%tD,%d,%s\n",
                        ev.getTitle(),
                        ev.getLocation(),
                        ev.getDate(),
                        ev.getNrPeople(),
                        ev.getLink()));
            }

        } catch (IOException ioe) {
            System.out.println("IO Exception: " + filename);
        }
    }
//    public domain.Eveniment find(String locatie, Date date) {
//
//        String keyMap = getKey(locatie, date);
//        return evenimente.get(keyMap);
//    }

    public Event findEveniment(String location, Date date) {

        String keyMap = location+ "" + date.toString();
        return evenimente.get(keyMap);
    }
    @Override
    public void addEveniment(Event ev) throws Exception {
        loadFile();
        String keyMap = ev.getLocation()+ "" +ev.getDate().toString();
        if (this.findEveniment(ev.getLocation(), ev.getDate()) == null) {
            this.evenimente.put(keyMap, ev);
        } else
            throw new Exception("Exista deja un eveniment cu aceasta locatie si data!");
    }


//    public domain.Eveniment find (domain.Eveniment e){
//        for(int i=0; i < this.evenimente.size(); i++)
//            if (this.evenimente.get(i).equals(e))
//                return e;
//        return null;
//    }

    public ArrayList<Event> getAll() {

        loadFile();
        ArrayList<Event> evenimentList = new ArrayList<>();
        for (Event ev : evenimente.values()) {
            evenimentList.add(ev);
        }

        return evenimentList;
    }

    public void deleteEveniment(String locatie, Date data) throws Exception {
        Event eveniment = new Event("",locatie,data,0,"");
        if (findEveniment(locatie,data) != null){
            this.evenimente.remove(eveniment);
        }else
            throw new Exception();
    }
}
