package org.exercise.java.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Event {

    //ATTRIBUTES
    private String title;
    private LocalDate dateEvent;
    private int capacityLocation;
    private int booking;

    //CONSTRUCTORS

    public Event(String title, LocalDate dateEvent, int capacityLocation) {
        this.title = title;

        if(isValidDate()){
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

    public void bookEvent(){
        if(!isValidDate() || !thereIsSpace()){
            throw new RuntimeException();
        } else{
            booking += 1;
        }
    }

    public void cancellationEvent(){
        if(!isValidDate() || booking == 0){
            throw new RuntimeException();
        } else{
            booking -= 1;
        }
    }

    private boolean isValidDate(){
        LocalDate today = LocalDate.now();
        if (dateEvent.isBefore(today) || today.isAfter(dateEvent)){
            throw new RuntimeException();
        } else {
            return true;
        }
    }

    private boolean thereIsSpace(){
        if (capacityLocation - booking <= 0){
            throw new RuntimeException();
        }else{
            return true;
        }
    }

}
