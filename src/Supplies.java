// Create a Supples Class that extends the Account Class
// Assign a private variable to numOfItems and ratePerHour
// Create getter and setter for pricePerItem and ratePerHour variables
// Create an method to calculateSales that overides the other calculateSales methods in other class methods
// Create a toString to return the data that overrides the other toString methods in other class methods

public class Supplies extends Account{
        private int numOfItems;
        private double pricePerItem;
    
    public int getNumItems() {
        return numOfItems;
    }
    
    public double getItemPrice() {
        return pricePerItem;
    }

    public void setNumItems(int NumItems) {
        this.numOfItems = NumItems;
    }

    public void setItemPrice(double ItemPrice) {
        this.pricePerItem = ItemPrice;
    }
        
        @Override
    public double calculateSales() {
        return numOfItems*pricePerItem;
    }

        @Override
    public String toString() {
        return String.format("Number of Items: " + numOfItems + "\n" + "Item Price: $%,.2f", pricePerItem);     
    }
         
}
