package com.daniebeler.ticketautomat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Box box;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Ticket> myOwnTickets = new ArrayList<>();
        box = new Box();


        while (true){
            System.out.println("\n\n");
            System.out.println("What do you want to do?");
            System.out.println("1 get new ticket");
            System.out.println("2 insert ticket");
            System.out.println("3 get the current price of the ticket");
            System.out.println("4 pay the ticket");

            switch (scanner.nextLine()){
                case "1":
                    Ticket newTicket = box.getNewTicket();
                    myOwnTickets.add(newTicket);
                    System.out.println("You just got your new ticket:");
                    System.out.println("\tID: " + newTicket.getId());
                    System.out.println("\tStarttime: " + newTicket.getTimestampStart());
                    break;
                case "2":

                    System.out.println("What is the ID of your ticket?");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean foundTicket = false;
                    for (Ticket ticket : myOwnTickets) {
                        if (ticket.getId() == id) {
                            box.insertTicket(ticket);
                            System.out.println("You just inserted your ticket");
                            foundTicket = true;
                        }
                    }

                    if (!foundTicket){
                        System.out.println("A ticket with this ID doesn't exist!");
                    }

                    break;
                case "3":
                    if (box.getInsertedTicket() == null){
                        System.out.println("Please insert the ticket first!");
                    }
                    else{
                        System.out.println("Current price of the inserted ticket: " + box.getPrice() + "€");
                    }

                    break;
                case "4":
                    if (box.getInsertedTicket() == null){
                        System.out.println("Please insert the ticket first!");
                    }
                    else{
                        box.payTicket();
                    }

                    break;
            }
        }




    }
}
