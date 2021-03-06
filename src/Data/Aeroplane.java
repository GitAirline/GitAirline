package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 * @author User
 */
public class Aeroplane implements AeroplaneInterface{
    private int noEconomySeats = 5;
    private int noFirstClassSeats = 5;
    
    private ArrayList<Seat> economySeats = new ArrayList<>(noEconomySeats);
    private ArrayList<Seat> firstClassSeats = new ArrayList<>(noFirstClassSeats);
    private Menus menu;
    private FlightStatus flightStatus;
    private String flightNo;
    
    public Aeroplane(String flightNo, Menus menu)
    {
        this(flightNo, menu, 5, 5);
    }
    
    public Aeroplane(String flightNo, Menus menu, int noEconomySeats, int noFirstClassSeats)
    {
        this.flightNo = flightNo;
        this.noEconomySeats = noEconomySeats;
        this.noFirstClassSeats = noFirstClassSeats;
        this.menu = menu;
        this.flightStatus = FlightStatus.READY;
        createSeats();
        
    }
    
    public FlightStatus getFilghtStatus()
    {
        return this.flightStatus;
    }   
    
    public String getFlightNo()
    {
        return flightNo;
    }
    
    public Menus getMenu()
    {
        return menu;
    }
    
    // This will create seat arraylist with seatNos and price only. 
    // For booking these seat nos will be listed and as per selected seat 
    // pessanger and food item is selected and added through reserveSeat
    protected void createSeats()
    {
        Seat seat;
        String eNo = "E";
        for(int i = 1; i <= noEconomySeats; ++ i)
        {
            seat = new Seat(eNo+i, 5000);
            economySeats.add(seat);
        }
        
        String bNo = "B";
        for(int i = 1; i <= noFirstClassSeats; ++ i)
        {
            seat = new Seat(bNo+i, 15000);
            firstClassSeats.add(seat);
        }
    }
    
    public boolean reserveSeat(String seatNo, Person person, ArrayList<FoodItem> food)
    {
        BiFunction<Seat, String, Boolean> reserve = (original, another) -> {
            boolean res = false;
            if(original.getSeatNo().equals(another))
            {
                original.setPessanger(person);
                original.setSelectedFood(food);
                original.setStatus(SeatStatus.OCCUPIED);
                res = true;
            }
            return res;
        };
        
        for(Seat original : economySeats)
        {
            if(reserve.apply(original, seatNo))
            {
                return true;
            }
        }
        
        for(Seat original : firstClassSeats)
        {
            if(reserve.apply(original, seatNo))
            {
                return true;
            }
        }
        
        return false;
    }
    
    private Function<Seat, Double> getPrice = (seat) -> {
        
        if(seat.isFree())
            return 0.0;
        
        double price = seat.getPrice();
        if(seat.getSelectedFood() != null) {
            for(FoodItem food : seat.getSelectedFood())
            {
                price += food.getPrice();
            }
        }
        return price;
    };
    
    public double getPrice(String seatNo)
    {
        for(Seat seat : economySeats)
        {
            if(seat.getSeatNo().equals(seatNo)) {
                return getPrice.apply(seat);
            }
        }
        for(Seat seat : firstClassSeats)
        {
            if(seat.getSeatNo().equals(seatNo)) {
                return getPrice.apply(seat);
            }
        }
        
        return 0;
    }
    
    public double getPrice()
    {
        // go through all seats and return collected rpice
        double price = 0.0;
        for(Seat seat : economySeats)
        {
            price += getPrice.apply(seat);
        }
        for(Seat seat : firstClassSeats)
        {
            price += getPrice.apply(seat);
        }
        return price*0.3;
    }
    
    public ArrayList<Seat> getEconomySeats()
    {
        ArrayList<Seat> ecoseat=new ArrayList<>();
        for(Seat st: economySeats){
            if(st.getStatus()==SeatStatus.FREE){
                ecoseat.add(st);
            }
        }
        //return economySeats;
        return ecoseat;
    }
    
//    public List<? extends SeatInterface> getEconomySeats()
//    {
//        return economySeats;
//    }
    
    
    public ArrayList<Seat> getFirstClassSeats()
    {
        ArrayList<Seat> busyseats=new ArrayList<>();
        for(Seat st: firstClassSeats){
            if(st.getStatus()==SeatStatus.FREE){
                busyseats.add(st);
            }
        }        
        return busyseats;
    }
    
//    public List<? extends SeatInterface> getFirstClassSeats()
//    {
//        return firstClassSeats;
//    }
    
    public void changeStatus(FlightStatus newStatus)
    {
        this.flightStatus = newStatus;
    }
    
    public boolean checkThresholdToFly()
    {
        // check minimum no of seats to fill to fly the flight
        if(economySeats.size() >= 3 && firstClassSeats.size() >= 2)
            return true;
        return false;
    }
    
    public boolean isReady()
    {
        return flightStatus == FlightStatus.READY;
    }
}