package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 11.05.2018.
 */
public class Event {
    private String title;
    private String location;
    private Date date;
    private int nrOfPeople;
    private String link;

    public Event(String title, String location, Date date, int nrOfPeople, String link) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.nrOfPeople = nrOfPeople;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Date getDate() {
        return date;
    }

    public int getNrOfPeople() {
        return nrOfPeople;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "Event{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", date=" + formatter.format(date) +
                ", nrOfPeople=" + nrOfPeople +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        Event e = (Event) obj;
        if (e.getDate().equals(this.getDate()) && e.getLocation().equals(this.getLocation()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((location == null) ? 0 : location.hashCode());
        return result;
    }

}
