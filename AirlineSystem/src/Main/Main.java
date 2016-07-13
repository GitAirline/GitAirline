/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Data.EnumTitle;
import Data.Person;
import Data.Seat;
import Data.SeatInterface;
import Manager.BookingSystemManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args) {
        BookingSystemManager bsm = new BookingSystemManager();
        bsm.addAeroplane();
        bsm.addAeroplane();
        
        ArrayList<String> flights = bsm.getReadyFlights();
        flights.forEach(s -> System.out.println(s));
        
        List<? extends SeatInterface> eseats = bsm.getEconomySeats("GA1");
        for(SeatInterface si : eseats)
        {
            System.out.println(si.getSeatNo() + " " + si.getStatus());
        }
        
        Person person = new Person(EnumTitle.MS, "abc", "def", "");
        
        bsm.reserveFlight("GA1", "E2", person, null);
        eseats = bsm.getEconomySeats("GA1");
        for(SeatInterface si : eseats)
        {
            System.out.println(si.getSeatNo() + " " + si.getStatus() /*+ " " + si.getPessanger().getFirstName()*/);
        }
    }
}
