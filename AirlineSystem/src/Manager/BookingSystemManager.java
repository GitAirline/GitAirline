/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.AeroplaneInterface;
import Data.FlightStatus;
import Data.FoodItem;
import Data.Menus;
import Data.Person;
import Data.Seat;
import Data.SeatInterface;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 *
 * @author User
 */
public class BookingSystemManager implements ManagerInterface {

    BookingSystem bookingSystem = new BookingSystem();
    @Override
    public ArrayList<String> getReadyFlights() {
        List<? extends AeroplaneInterface> list = bookingSystem.getFlights();
        ArrayList<String> readyFlights = new ArrayList<>();
        for(AeroplaneInterface ai : list)
        {
            if(ai.isReady()) {
                readyFlights.add(ai.getFlightNo());
            }
        }
        return readyFlights;
    }

    @Override
    public boolean removeAeroplane(String flightNo) {
        return bookingSystem.removeAeroplane(flightNo);
    }

    @Override
    public void addAeroplane() {
        bookingSystem.addAeroplane();
    }

    @Override
    public void addAeroplane(Menus menu) {
        bookingSystem.addAeroplane(menu);
    }

    @Override
    public List<? extends SeatInterface> getFirstClassSeats(String flightNo) {
       List<? extends AeroplaneInterface> list = bookingSystem.getFlights();
       for(AeroplaneInterface ai : list)
        {
            if(ai.getFlightNo().equals(flightNo)) {
                return ai.getFirstClassSeats();
            }
        }
       // should throw exception
       return null;
    }

    @Override
    public List<? extends SeatInterface> getEconomySeats(String flightNo) {
       List<? extends AeroplaneInterface> list = bookingSystem.getFlights();
       for(AeroplaneInterface ai : list)
        {
            if(ai.getFlightNo().equals(flightNo)) {
                return ai.getEconomySeats();
            }
        }
       // should throw exception
       return null;
    }

    @Override
    public boolean reserveFlight(String flightNo, String seatNo, Person person, ArrayList<FoodItem> food) {
        return bookingSystem.reserveFlight(flightNo, seatNo, person, food);
    }

    @Override
    public boolean isFlightReady(String flightNo) {
        return bookingSystem.isFlightReady(flightNo);
    }

    @Override
    public List<? extends AeroplaneInterface> getFlights() {
        return bookingSystem.getFlights();
    }

    @Override
    public void flyFlight(String flightNo) {
        FlyFlight fly = new FlyFlight(bookingSystem, flightNo);
        
        Thread flying = new Thread(fly);
        flying.start();
       
    }

    @Override
    public boolean changeMenu(String flightNo, Menus menu) {
        return bookingSystem.changeMenu(flightNo, menu);
    }
    
    @Override
    public Menus getMenu(String flightNo) {
        return bookingSystem.getMenu(flightNo);
    }   

    
    public LinkedHashMap<String, Double> readProfitLog() throws IOException {
        LinkedHashMap<String,Double> mymap= new LinkedHashMap<>();
        String entity;
        double profit;
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("C:\\Users\\User\\Documents\\NetBeansProjects\\AirlineSystem\\FleetProfit.txt"));
            StringBuilder sb = new StringBuilder();
            String output=readFile.readLine();
            while (output!= null){
                
                int i=output.indexOf(" ");                
                profit=Double.parseDouble(output.substring(0,i));                
               
                entity=output.substring(i+1,output.length());
                
                mymap.put(entity, profit);
                output=readFile.readLine();  
                System.out.println("Booked seat gives profit: "+entity+" "+profit);
            }            
        } catch (FileNotFoundException ex) {} 
        catch (IOException ex) { }  
        return mymap;        
    }
    
    
    
}
