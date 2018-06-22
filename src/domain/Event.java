package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (!getLocation().equals(event.getLocation())) return false;
        return getDate().equals(event.getDate());
    }

    @Override
    public int hashCode() {
        int result = getLocation().hashCode();
        result = 31 * result + getDate().hashCode();
        return result;
    }
}
