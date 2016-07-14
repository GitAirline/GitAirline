/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.AeroplaneInterface;
import Data.Aeroplane;
import Data.FoodItem;
import Data.Menus;
import Data.Person;
import Data.Seat;
import Data.SeatInterface;
import Data.SeatStatus;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public ArrayList<Seat> getFirstClassSeats(String flightNo){
    //public List<? extends SeatInterface> getFirstClassSeats(String flightNo) {
       ArrayList<Aeroplane> list = bookingSystem.getFlights();
       for(Aeroplane ai : list)
        {
            if(ai.getFlightNo().equals(flightNo)) {
                return ai.getFirstClassSeats();
            }
        }
       // should throw exception
       return null;
    }

    @Override
    public ArrayList<Seat> getEconomyClassSeats(String flightNo) {
        //public List<? extends SeatInterface> getEconomySeats(String flightNo) {
        ArrayList<Aeroplane> list = bookingSystem.getFlights();
//List<? extends AeroplaneInterface> list = bookingSystem.getFlights();

        for (Aeroplane ai : list) {
            if (ai.getFlightNo().equals(flightNo)) {
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
    
    public LinkedHashMap<String, Double> readProfitLog() throws IOException {
        LinkedHashMap<String,Double> mymap= new LinkedHashMap<>();
        String entity;
        double profit;
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("C:\\Users\\Win10 Sucks\\Documents\\GA-Profit-Logger.txt"));
            StringBuilder sb = new StringBuilder();
            String output=readFile.readLine();
            while (output!= null){
                
                int i=output.indexOf(" ");                
                profit=Double.parseDouble(output.substring(0,i));                
               
                entity=output.substring(i+1,output.length());
                
                mymap.put(entity, profit);
                output=readFile.readLine();          
            }            
        } catch (FileNotFoundException ex) {} 
        catch (IOException ex) { }  
        return mymap;        
    }
    
}
