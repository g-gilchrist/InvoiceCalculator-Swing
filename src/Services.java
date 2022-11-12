// Create a Services Class that extends the Account Class
// Assign a private variable to numberOfHours and ratePerHour
// Create getter and setter for numberOfHours and ratePerHour variables
// Create an method to calculateSales that overides the other calculateSales methods in other class methods
// Create a toString to return the data that overrides the other toString methods in other class methods

public class Services extends Account{
        private int numberOfHours;
        private double ratePerHour;
    
    public int getNumHours() {
        return numberOfHours;
    }
    
    public double getHourlyRate() {
        return ratePerHour;
    }

    public void setNumHours(int NumHours) {
        this.numberOfHours = NumHours;  
    }

    public void setHourlyRate(double HourlyRate) {
        this.ratePerHour = HourlyRate;
    }
        
        @Override
    public double calculateSales() {
        return numberOfHours*ratePerHour;
    }

        @Override
    public String toString() {
        return String.format("Number of Hours: " + numberOfHours + "\n" + "Hourly Rate $%,.2f ", ratePerHour); 
    }
}