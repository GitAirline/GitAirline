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
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        for(String str : flights)
        {
            System.out.println(str);
        }
        
        List<? extends SeatInterface> eseats = bsm.getEconomyClassSeats("GA1");
        for(SeatInterface si : eseats)
        {
            System.out.println(si.getSeatNo() + " " + si.getStatus());
        }
        
        Person person = new Person(EnumTitle.MS, "ABC", "def", "");
        Person person2 = new Person(EnumTitle.MS, "Karl", "TheGreat", "");
        
        bsm.reserveFlight("GA1", "E2", person, null);
        bsm.reserveFlight("GA2", "B5", person2, null);
        eseats = bsm.getEconomyClassSeats("GA1");
        for(SeatInterface si : eseats)
        {
            System.out.println(si.getSeatNo() + " " + si.getStatus() /*+ " " + si.getPessanger().getFirstName()*/);
        }
        
        //Read from the profitLog file
        try {
            LinkedHashMap<String,Double> profitMap = bsm.readProfitLog();
             for(String key:profitMap.keySet()){
                 System.out.println(key+"    Profit: "+profitMap.get(key));
            
             }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
       
        
    }
}
