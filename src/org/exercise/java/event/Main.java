package org.exercise.java.event;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Event concertox = new Concert("ConcertoX", LocalDate.of(2023,05,02), 50, LocalTime.of(19,30), new BigDecimal("200.00"));
        Event concertoy = new Concert("concertoY", LocalDate.of(2023,06,15), 200, LocalTime.of(20,30), new BigDecimal("150.00"));

        Scanner scan = new Scanner(System.in);

        int choise;

        do{
            System.out.println("What do you want about this event? 1)Booking 2)Cancellation 3)bye!");
            choise = scan.nextInt();
            if(choise == 1){
                System.out.println("How many reservations do you want?");
                int reservations = scan.nextInt();

                    try{
                        for (int i = 0; i < reservations; i++) {
                        concertox.bookEvent();
                        }
                    }catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }

                System.out.println("Booked: " + concertox.getBooking() + " " + "Avaiable: " + (concertox.getAvaiable()));
            }


            if(choise == 2){
                System.out.println("How many cancellations do you want?");
                int cancellations = scan.nextInt();
                        try{
                            for (int i = 0; i < cancellations; i++) {
                            concertox.cancellationEvent();
                            }
                        }catch(Exception e){
                            System.out.println("Error: "+ e.getMessage());
                        }
                    System.out.println("Booked: " + concertox.getBooking() + " " + "Avaiable: " + (concertox.getAvaiable()));
                }
            }while(choise != 3);

        System.out.println(concertox);

        //BONUS
        EventsPlan serataAllaScala = new EventsPlan("Notti Magiche");
        serataAllaScala.addEvent(concertox);
        serataAllaScala.addEvent(concertoy);

        //test filtro data
        System.out.println(serataAllaScala.filterEvents(LocalDate.of(2023,05,02)));

        //test tutti gli eventi nel programma
        System.out.println(serataAllaScala.allEvents());

        //test svuoto programma
        serataAllaScala.removeAll();
        System.out.println(serataAllaScala.allEvents());




    }
}