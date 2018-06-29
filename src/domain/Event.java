package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Event extends Entitate {
    private String title;
    private String location;
    private Date date;
    private int nrPeople;
    private String link;

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public int getNrPeople() {
        return nrPeople;
    }

    public String getLink() {
        return link;
    }

    public Event(int id, String title, String location, Date date, int nrPeople, String link){
        super(id);
        this.title=title;
        this.location = location;
        this.date = date;
        this.nrPeople = nrPeople;
        this.link = link;
    }


    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy"); //pun sa imi arate data cum vreau eu
        return "Eveniment{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", date=" + formatter.format(date) +
                ", nrPeople=" + nrPeople +
                ", link='" + link + '\'' +
                '}';
    }

    //a nu adauga de 2 ori

    @Override
    public boolean equals(Object obj) {
        Event e = (domain.Event) obj;
        if (e.getDate().equals(this.getDate())  && e.getLocation().equals(this.getLocation()) )
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, location);
    }

}
