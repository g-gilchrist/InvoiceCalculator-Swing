// Create an Abstract Account Class that is inherited by the Services and Supplies Classes.
// Assign a private variable to accountID
// Create getter and setter for accountID
// Create an abstract method to calculateSales
// Create a toString to return the data

abstract class Account {
    private int accountID;
    
    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int AccountID) {
        this.accountID = AccountID;
    }

    public abstract double calculateSales();
    
    public abstract String toString();

    public String toString2() {
        return "Account ID: " + this.accountID;
    }    
    
    


}
