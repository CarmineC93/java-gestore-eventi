package org.exercise.java.event;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event{

    //ATTRIBUTES
    private LocalTime time;
    private BigDecimal price;

    //CONSTRUCTORS
    public Concert(String title, LocalDate dateEvent, int capacityLocation, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, dateEvent, capacityLocation);
        this.time = time;
        this.price = price;
    }

    //GETTER & SETTER
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //METHODS
    public String dataFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.of(getDateEvent(), getTime()).format(formatter);
    }

    public String priceFormatter(){
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(price) + "€";
    }

    @Override
    public String toString() {
        return "Concert{" +
                "data and time=" + dataFormatter() +
                ", price=" + priceFormatter() +
                '}';
    }


    @Override
    public int compareTo(Event e) {
        return getDateEvent().compareTo(e.getDateEvent());
    }

}
