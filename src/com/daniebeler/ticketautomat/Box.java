package com.daniebeler.ticketautomat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Box {

    private List<Ticket> ticketList = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);
    private Ticket insertedTicket;

    public Box(){

    }

    public Ticket getNewTicket(){
        Ticket ticket = new Ticket();
        ticketList.add(ticket);
        return ticket;
    }

    public void insertTicket(Ticket ticket){
        insertedTicket = ticket;
    }

    public Ticket getInsertedTicket() {
        return insertedTicket;
    }

    public void payTicket(){
        float priceToPay = getPrice();
        System.out.println("Price to pay: " + priceToPay + "€");
        System.out.println("Please insert money:");
        float insertedMoney = scanner.nextFloat();
        scanner.nextLine();

        while (priceToPay > insertedMoney){
            System.out.println("Please insert more Money!");
            System.out.println("Money left: " + (priceToPay - insertedMoney));
            insertedMoney += scanner.nextFloat();
        }

        System.out.println("Your ticket was successfully paid!");
        float change = insertedMoney - priceToPay;
        System.out.println("You got " + change + "€ back.");

        insertedTicket.setTimestampEnd(new Date().getTime());

        System.out.println("\nTicket information:");
        System.out.println("ID: " + insertedTicket.getId());
        System.out.println("Starttime: " + insertedTicket.getTimestampStart());
        System.out.println("Endtime: " + insertedTicket.getTimestampEnd());
    }

    public float getPrice(){
        return calculatePrice(insertedTicket.getTimestampStart());
    }

    public float calculatePrice(long start){
        float price = new Date().getTime() - start;
        return price / 1000f;
    }
}
