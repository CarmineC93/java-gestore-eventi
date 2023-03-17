package org.exercise.java.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventsPlan {

    //ATTRIBUTES
    private String title;
    private List<Event> events;

    //CONSTRUCTORS
    public EventsPlan(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }

    //METHODS

    /*un metodo che aggiunge alla lista un Evento, passato come parametro*/
    public void addEvent(Event event){
        events.add(event);
    }

    /*un metodo che restituisce una lista con tutti gli eventi presenti in una certa data*/
    public List<Event> filterEvents(LocalDate date){
        List<Event> filteredList = new ArrayList<>();
        for (Event singleEvent: events
             ) {
            if (singleEvent.getDateEvent().equals(date)){
                filteredList.add(singleEvent);
            }
        }
        return filteredList;
    }

    /*un metodo che restituisce quanti eventi sono presenti nel programma*/
    public List<Event> allEvents(){
        return this.events;
    }

    /*un metodo che svuota la lista di eventi*/
    public void removeAll(){
        events.removeAll(allEvents());
    }

    /*un metodo che restituisce una stringa che mostra il titolo del programma e tutti gli
    eventi ordinati per data nella forma:
    ○ data1 - titolo1
    ○ data2 - titolo2
    ○ data3 - titolo3 */
    public List<Event> orderByDate(){
        //primo modo con comparable con ordinamento di default
        Collections.sort(events);
        //con un secondo modo, con comparator, possiamo evitare di aggiungere implements comparatore<type> sulla classe da comparare, e possiamo scegliere criteri non di default

        return events;
    }



    @Override
    public String toString() {
        return "EventsPlan{" +
                "title='" + title + '\'' +
                ", events=" + events +
                '}';
    }
}
