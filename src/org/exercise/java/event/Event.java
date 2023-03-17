package org.exercise.java.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Event implements Comparable<Event>{

    //ATTRIBUTES
    private String title;
    private LocalDate dateEvent;
    private int capacityLocation;
    private int booking;

    //CONSTRUCTORS
    public Event(String title, LocalDate dateEvent, int capacityLocation) throws IllegalArgumentException{
        this.title = title;

        if(isValidDate(dateEvent)){
            this.dateEvent = dateEvent;
        }

        if(capacityLocation <= 0){
            throw new RuntimeException();
        }else{
            this.capacityLocation = capacityLocation;
        }
        this.booking = 0;
    }

    //GETTER & SETTER
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateEvent() {
        return dateEvent;
    }

    public String getFormattedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateEvent.format(formatter);
    }

    public void setDateEvent(LocalDate dateEvent) {
        this.dateEvent = dateEvent;
    }

    public int getCapacityLocation() {
        return capacityLocation;
    }

    public int getBooking() {
        return booking;
    }

    //METHODS
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", dateEvent=" +  getFormattedDate() +
                '}';
    }

    public void bookEvent() throws IllegalArgumentException{
        if(!isValidDate(dateEvent) || !thereIsSpace()){
            throw new IllegalArgumentException("Sorry, this event is no more avaiable");
        } else{
            booking ++;
        }
    }

    public void cancellationEvent() throws IllegalArgumentException{
        if(!isValidDate(dateEvent) || booking == 0){
            throw new IllegalArgumentException("There is no booking yet or the date is past");
        } else{
            booking --;
        }
    }

    private boolean isValidDate(LocalDate dateEvent) throws IllegalArgumentException{
        if (dateEvent.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Impossible, the event is past");
        } else {
            return true;
        }
    }

    private boolean thereIsSpace() throws IllegalArgumentException{
        if (capacityLocation - booking <= 0){
            throw new IllegalArgumentException("Sorry, the event is Sold out");
        }else{
            return true;
        }
    }

    public int getAvaiable(){
        int avaiableTickets = getCapacityLocation() - getBooking();
        return avaiableTickets;
    }


}
