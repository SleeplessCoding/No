/**
 * Introduction to Java Programming I(IT151)
 * Professor Dr. Mazen Alkhatib
 * Individual Project 4
 */

/**
 * @author Nicholas Weinold
 * 5/1/2016
 */

import javax.swing.JOptionPane; 

class car {  //class containing getter, setters, constructor from week 2 START
    
    String color;  
    int seats;
    double liters;
  
     String colorGet()
     { 
         return color;
     }
     
     int seatsGet()
     {   
         return seats;
     }
     
     double litersGet()
     {   
         return liters;
     }
     
     car(String colorInit, int seatsInit, double litersInit)
     {
         color = colorInit;
         seats = seatsInit;
         liters = litersInit;        
     } // week 2 getter, setter, constructor class END
     
}

public class IndividualProject4 { //IndividualProject4 class START
    
    // week 4 method creation computeAverageSales(), computeShippingCost() START
    
    static double computeAverageSales(){ //we create the computeAverageSales method START
        double totalPrice = 0;           //we declare our variables for the method
        double itemPrice;
        double averageSales;
        int itemCount = 0;
        int priceConfirm = 0;
        
        while(priceConfirm == JOptionPane.YES_OPTION){ // I decided to practice with YES_NO JOption windows for this assignment here we create a loop to test if the user select yes or no
            itemPrice = Double.parseDouble(JOptionPane.showInputDialog("What is the item price?")); // we must parse the int into double and we ask for the first item price
            totalPrice = itemPrice + totalPrice; // we update the item total
            itemCount++; // we update the item counter for the average calculation
            priceConfirm = JOptionPane.showConfirmDialog(null,"Current Total = $"+totalPrice+"\n\nDo you want to add another item price?","Item Price Total",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); //displaying current total and asking if user wants second item price
        } // end of while loop if they say yes loops back to top to get second item cost, this will happen until NO is selected
        averageSales = totalPrice / itemCount; // average sales calculation for the return when the method is used in main
        
        return averageSales; // this is what the method will return
    } //first method END
    
     static double computeShippingExpense(){ // second method computeShippingExpense is created START
        double totalShippingExpense = 0.0;  // we declare our variables
        double itemShippingExpense = 0.0;
        int shippingExpenseConfirm = 0;
        
        while(shippingExpenseConfirm == JOptionPane.YES_OPTION) { // again we use the YES_NO JOption window for our while loop test condition if the user selects yes or no
            itemShippingExpense = Double.parseDouble(JOptionPane.showInputDialog("Please enter the item shipping cost?")); // we parse the int into double again and we ask for user to input shipping cost for the item
            totalShippingExpense = totalShippingExpense + itemShippingExpense; // shipping cost is calculated and updated
            shippingExpenseConfirm = JOptionPane.showConfirmDialog(null,"Current Shipping Total = $"+totalShippingExpense+"\n\nWould you like to enter another item price?","Shipping Total",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);//displaying current shipping total and asking if user wants second shipping price
        }// end of while loop if they say yes loops back to top to get second item cost, this will happen until NO is selected
        return totalShippingExpense; // this method will return the total of the shipping cost
     } //second method END
    // week 4 method creation computeAveSales(), computeShippingCost()
   
    public static void main(String[] args) { // week 1/2/3 declared main START
        
        //week 1/2 variables declared START
        String colorInit = ""; 
        int seatsInit = 0;
        int litersInit = 0;
        // week 1/2 variables declared END
        
        // week 3 variables declared START
        String seatssInit;
        String literssInit;
        // week 3 variables declared END
        
        //week 4 variables declared START
        double averageSales;
        double totalShippingExpense;
        //week 4 variables declared END
        
       
        // week 1/2/3 user prompts and input checks START
        while(colorInit.isEmpty()) {     
             colorInit = JOptionPane.showInputDialog("Please select one of the following colors. \n - Red \n - Blue \n - Grey \n - Black \n - White"); 
        } 
            
        while((seatsInit<=1)||(seatsInit>5)||(seatsInit==3)) {
            seatssInit=JOptionPane.showInputDialog("How many seats would you like? \n - 2   (Two-seater) (coupe) \n - 4  " + " (4 seat sedan)  \n - 5   (added middle seat sedan)");
            if(seatssInit.matches("\\d+")) {                  
                seatsInit = Integer.parseInt(seatssInit);    
            }                                            
        }   
                    
        while((litersInit<=1)||(litersInit>4)) {         
            literssInit = JOptionPane.showInputDialog("Please select a liter option? \n 2  (liters) \n 3  (liters) \n 4  (liters)"); 
            if(literssInit.matches("\\d+")) { 
                litersInit = Integer.parseInt(literssInit);
            }                                                                     
        }
        // week 1/2/3 user prompts and input checks END
        
        car car1 = new car(colorInit, seatsInit, litersInit);// week 2 calling constructor for system out START/END
        
        //week 1/2/3 system out display user stored data START
        System.out.println("Car color = "+ car1.colorGet()); 
        System.out.println("Car Seats = "+ car1.seatsGet());
        System.out.println("Car Liters = "+ car1.litersGet());
        //week 1/2/3 system out display user stored data END
        
        // week 4 calling our methods START
        averageSales = computeAverageSales(); // we use our averageSales variable to hold the value of our computeAverageSales method
        
        JOptionPane.showMessageDialog(null, "Average Sales Total: $"+ averageSales); // we use joption to display the avaerage sales total
        if(averageSales>200){ // we set if conditional to see if our averag total is above 200
            JOptionPane.showMessageDialog(null, "Significant profits were attained!", "Congratulations",1); // if the total is above 200 we display a message
        } // if END
            
        totalShippingExpense = computeShippingExpense(); // we use our totalShippingExpense to hold the value of our computeShippingExpense method
        JOptionPane.showMessageDialog(null, "Total Shipping Expense: $" + totalShippingExpense); //we use joption to display the total shipping expenses
        // week 4 calling our methods END
        
    } // week 1/2/3 declared main END
    
} // IndividualProject4 class END