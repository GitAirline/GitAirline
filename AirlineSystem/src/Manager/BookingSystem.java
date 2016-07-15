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
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiPredicate;

/**
 *
 * @author User
 */
public class BookingSystem {
    protected ArrayList<Aeroplane> aeroplanes = new ArrayList<>();
    protected String flightPrefix = "GA";
    protected int flightSuffix = 1;
    
    ExecutorService pool = Executors.newFixedThreadPool(10);
    
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
        return flightPrefix + flightSuffix++;
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
    
    private BiPredicate<Aeroplane, String> isFlight = (aeroplane, flightNo) -> {
        return aeroplane.getFlightNo().equals(flightNo);
    };
    
    public boolean removeAeroplane(String flightNo)
    {
        if(aeroplanes != null)
        {
            Aeroplane removable = null;
            for(Aeroplane a : aeroplanes)
            {
                if(isFlight.test(a, flightNo))
                {
                    removable = a;
                    break;
                }
            }
            
            if(removable != null)
                return aeroplanes.remove(removable);
        }
        return false;
    }
    
    public List<? extends AeroplaneInterface> getFlights()
    {
        return aeroplanes;
    }
    
    public boolean reserveFlight(String flightNo, String seatNo, Person person, ArrayList<FoodItem> food)
    {
        // For selected flight call reserveSeat
        // if minimum criteria to fly is true, fly the flight
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(isFlight.test(aeroplane, flightNo))                
            {                
                aeroplane.reserveSeat(seatNo, person, food);                
                logProfit();
                return true;
            }
        }
        return false;
    }
    
    public boolean isFlightReady(String flightNo)
    {
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(isFlight.test(aeroplane, flightNo))
            {
                return aeroplane.isReady();
            }
        }
        return false;
    }
    
    public Menus getMenu(String flightNo)
    {
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(isFlight.test(aeroplane, flightNo))
            {
                return aeroplane.getMenu();
            }
        }
        return null;
    }
    
    public boolean changeMenu(String flightNo, Menus menu)
    {
        for(Aeroplane aeroplane : aeroplanes)
        {
            if(isFlight.test(aeroplane, flightNo))
            {
                aeroplane.setMenu(menu);
                return true;
            }
        }
        return false;
    }
    
    public void changeFlightStatus(String flightNo, FlightStatus status)
    {
        // change flight status for selected flight
        synchronized(this)
        {
            for(Aeroplane aeroplane : aeroplanes)
            {
                if(isFlight.test(aeroplane, flightNo))
                {
                    aeroplane.changeStatus(status);
                }
            }
        }
    }
    
    public void flyFlight(String flightNo)
    {
        // change the status and fly the flight
        // here will start new thread
        
    }
    
    private double getFleetProfit(){
        double totalprofit=0;
        for(Aeroplane flyg: aeroplanes){
            totalprofit+=flyg.getPrice();
        }
        return totalprofit*.3;
    }
    
    File logFile = new File("C:\\Users\\User\\Documents\\NetBeansProjects\\AirlineSystem\\AirlineSystem\\FleetProfit.txt");
    private void logProfit() {
        try {
            BufferedWriter bufferwriter = new BufferedWriter(new FileWriter(logFile, false));//"false" argument means create new file
            PrintWriter thePrinter = new PrintWriter(bufferwriter);
            String outstring;
            double fleet_vinst = 0;
            for (Aeroplane flyg : aeroplanes) {
                fleet_vinst += flyg.getPrice();
                outstring = flyg.getPrice() + " " + flyg.getFlightNo();
                thePrinter.println(outstring);
            }
            thePrinter.println(fleet_vinst + " " +"The total profit of GitAirline");
            thePrinter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    
}
