import java.util.ArrayList;
import java.text.DecimalFormat;

public class TransitCalculator{
    double numOfDays;
    double numOfRides;

    double singleRide;
    double sevenRide;
    double thirtyRide; 
  
    int messNum;

    // Constructor that creates objects and initialize these variables
  public TransitCalculator(int days, int rides){
      numOfDays = days;
      numOfRides = rides;
      singleRide = 2.75;
      sevenRide = 33.00;
      thirtyRide = 127.00; 

      
  }

  public double unlimited7Price(){
      double numOfWeeks = Math.ceil(numOfDays / 7);
      double price = (numOfWeeks * sevenRide) / numOfRides;
      return Math.round(price * 100.00) /100.00;

  }

  public double unlimited30Price(){
      double numOfWeeks = Math.ceil(numOfDays / 30);
      double price = (numOfWeeks * thirtyRide) / numOfRides;
      return Math.round(price * 100.00) /100.00;
  }

  public double singlePrice(){
    return singleRide;
  }

  // get price method 
  public ArrayList<Double> getRidePrices(){
    ArrayList<Double> prices = new ArrayList<>();
    prices.add(singlePrice());
    prices.add(unlimited7Price());
    prices.add(unlimited30Price());

    return prices;
  }

  // return lowest number in the array called "prices"

  public double getLowest(){
    double lowPrice =100;
    ArrayList<Double> thePrices = new ArrayList<>();
    thePrices = this.getRidePrices();
    // System.out.println(thePrices); //for testing
    for (double price : thePrices){
      if (lowPrice>price){
        lowPrice = price;
        this.messNum = thePrices.indexOf(price);
      }
    }
    return lowPrice;
  }

  public void message(){
    String[] numbers = {"Pay-per-ride", "Seven-day", "Thirty-day"};
   
    System.out.println("You should get the "+ numbers[this.messNum] +" Unlimited option at " +this.getLowest()+" per ride.");
  }
    //Main method
    public static void main(String[] args){
      TransitCalculator thisPerson = new TransitCalculator(Integer.parseInt(args[1]), Integer.parseInt(args[0]));
      System.out.println(thisPerson.getRidePrices());
      double lowest = thisPerson.getLowest(); // This needs to run for message method to run properly
      thisPerson.message();
    }
  
  }