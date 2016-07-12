/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Data.Aeroplane;
import Data.AeroplaneInterface;
import Data.FlightStatus;
import Data.FoodItem;
import Data.Menus;
import Data.Person;
import Data.Seat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BookingSystem {
    protected ArrayList<Aeroplane> aeroplanes = new ArrayList<>();
    protected String flightSuffix = "GA";
    protected int flightPrefix = 1;
    
    public void addAeroplane()
    {
        Menus menu = createMenu();
        String flightNo = generateFlightNo();
        
        aeroplanes.add(new Aeroplane(flightNo, menu));
    }
    
    public void addAeroplane(Menus menu)
    {
        aeroplanes.add(new Aeroplane(generateFlightNo(), menu));
    }
    
    public String generateFlightNo()
    {
        return flightSuffix + flightPrefix++;
    }
    
    protected Menus createMenu()
    {
        
        FoodItem eat = new FoodItem("Nuts", "", "", 25, FoodItem.MENUCLASS.ECONOMI);
        FoodItem drink = new FoodItem("Soft Drink", "", "", 25, FoodItem.MENUCLASS.ECONOMI);
        ArrayList<FoodItem> eMenu = new ArrayList<>();
        eMenu.add(eat);
        eMenu.add(drink);
        
        eat = new FoodItem("Nuts", "", "", 50, FoodItem.MENUCLASS.FIRST);
        drink = new FoodItem("Soft Drink", "", "", 75, FoodItem.MENUCLASS.FIRST);
        
        ArrayList<FoodItem> bMenu = new ArrayList<>();
        bMenu.add(eat);
        bMenu.add(drink);
        
        Menus menu = new Menus(bMenu, eMenu);
        
        return menu;
    }
    
    public boolean removeAeroplane(String flightNo)
    {
        return false;
    }
    
    public List<? extends AeroplaneInterface> getFlights()
    {
        return aeroplanes;
    }
    
    public boolean reserveFlight(String flightNo, String seatNo, Person person, ArrayList<FoodItem> food)
    {
        boolean status = false;
        // For selected flight call reserveSeat
        // if minimum criteria to fly is true, fly the flight
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(aeroplane.getFlightNo().equals(flightNo))
            {
                status = aeroplane.reserveSeat(seatNo, person, food);
                break;
            }
        }
        return false;
    }
    
    public Menus getMenu(String flightNo)
    {
        Menus menu = null;
        // return menu for selected flight
        return menu;
    }
    
    public void changeFlightStatus(String flightNo, FlightStatus status)
    {
        // change flight status for selected flight
    }
    
    public void flyFlight(String flightNo)
    {
        // change the status and fly the flight
        // here will start new thread
    }
    
    public double getFleetProfit(){
        double totalprofit=0;
        for(Aeroplane flyg: aeroplanes){
            totalprofit+=flyg.getPrice();
        }
        return totalprofit*.3;
    }
        
    private void profitlogger(){
        Double vinst=getFleetProfit();       
        try {            
            File createFile = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\AirlineSystem\\GitAirline\\AirlineSystem\\src\\Manager\\FleetProfit.txt");
            FileOutputStream streamFile = new FileOutputStream(createFile);
            OutputStreamWriter Skrivare = new OutputStreamWriter(streamFile);    
            Writer Skrivut = new BufferedWriter(Skrivare);
            Skrivut.write("Total profit for entire fleet is: "+vinst.toString());                        
            Skrivut.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }   
    
}
