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
        
        bsm.reserveFlight("GA1", "E1", person, null);
        bsm.reserveFlight("GA1", "E2", person, null);
        bsm.reserveFlight("GA1", "E3", person, null);
        bsm.reserveFlight("GA1", "B1", person, null);
        bsm.reserveFlight("GA1", "B2", person, null);
        
        bsm.reserveFlight("GA2", "E1", person, null);
        bsm.reserveFlight("GA2", "E2", person, null);
        bsm.reserveFlight("GA2", "E3", person, null);
        bsm.reserveFlight("GA2", "B1", person, null);
        bsm.reserveFlight("GA2", "B2", person, null);
        
        eseats = bsm.getEconomySeats("GA1");
        for(SeatInterface si : eseats)
        {
            System.out.println(si.getSeatNo() + " " + si.getStatus() /*+ " " + si.getPessanger().getFirstName()*/);
        }
        
        double price = bsm.getFlights().get(0).getPrice();
        System.out.println(price);
        
        /*System.out.println(bsm.removeAeroplane("GA2"));
        flights = bsm.getReadyFlights();
        flights.forEach(s -> System.out.println(s));*/
        
        if(bsm.isFlightReady("GA1")) {
            bsm.flyFlight("GA1");
        }
        
        bsm.getFlights().stream().filter(a -> bsm.isFlightReady(a.getFlightNo())).forEach(a -> bsm.flyFlight(a.getFlightNo()));
    }
}
