import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 


//---------------------------------------------------- 
//  GUI
//----------------------------------------------------   
  
public class GUI extends JFrame {
    
// Declaring Components ------------------------------      
    
    JLabel AccountID;
    JTextField AccountID_Inp;
    JLabel BillingType; 
    JRadioButton ServicesRB; 
    JRadioButton SuppliesRB;
    JLabel Question1;
    JTextField ServAnswer1;
    JTextField SuppAnswer1;   
    JLabel Question2;
    JTextField ServAnswer2;
    JTextField SuppAnswer2;
    JLabel AccountBill;   
    JButton CalculateB; 
    ButtonGroup G1;
    JOptionPane OutstandingBill;
    int AccID;
    int ServAns1;
    double ServAns2;
    int SuppAns1;
    double SuppAns2; 
    boolean accSubmit;
    boolean servSubmit;
    boolean suppSubmit;


public GUI(){ 
        
// Initializing Components ---------------------------  

    this.setLayout(null); 
    AccountID = new JLabel();
    AccountID_Inp = new JTextField();
       
    ServicesRB = new JRadioButton();
    SuppliesRB = new JRadioButton();
    G1 = new ButtonGroup(); 
       
    Question1 = new JLabel();
    ServAnswer1 = new JTextField("0");
    SuppAnswer1 = new JTextField("0");
    Question2 = new JLabel();
    ServAnswer2 = new JTextField("0");
    SuppAnswer2 = new JTextField("0");
    CalculateB = new JButton("Calculate"); 
        
// Setting Component Text ---------------------------  
        
    AccountID = new JLabel("Account ID: ");
    BillingType = new JLabel("Billing Type: "); 
    ServicesRB.setText("Services");
    SuppliesRB.setText("Supplies");
    
// This ends the program by calling System.exit(0)    
    
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    });

// If there were more components I would have placed them in a pannel/group and turn on the visability for the pannel/group
// I made two different sets of text fields so that both Services and Supplies could be added at the same time for the same Account. 

    
    
    ServicesRB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Question1.setText("Number of Hours: ");   
            Question2.setText("Hourly Rate: ");
            ServAnswer1.setVisible(true);
            ServAnswer2.setVisible(true);
            SuppAnswer1.setVisible(false);
            SuppAnswer2.setVisible(false);
            
        }        
    });
        
    SuppliesRB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Question1.setText("Number of Items: ");   
            Question2.setText("  Item Price: ");
            ServAnswer1.setVisible(false);
            ServAnswer2.setVisible(false);
            SuppAnswer1.setVisible(true);
            SuppAnswer2.setVisible(true);
        }
    });
    
// This insures that everything is visable on app start    
    ServicesRB.doClick();
 
// Magic happens here
// I do a bit of error handling here, basically xxxSubmit allows me to stop the program if an error occurs.
// I didn't want the program to calculate if a bad input happened after an error was thrown.
// Doing it this way allows the computer to stop calculating and waits for the user to fix the error.
// Other than that it isn't too much different than the first program, we feed the relevant data into each initialization.
// Data is pulled out of the array it is stored in like before but now it is displayed in a JOptionPane


    CalculateB.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try{
                AccID = Integer.parseInt(AccountID_Inp.getText());
                accSubmit = true;
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error, Please input an Account Identification number. ");
                accSubmit = false;
            }
            Account[] accountArray = new Account[2];
           
            try{
                ServAns1 = Integer.parseInt(ServAnswer1.getText());
                ServAns2 = Double.parseDouble(ServAnswer2.getText());
                if (ServAns1 < 0 || ServAns2 < 0.0) {
                    JOptionPane.showMessageDialog(null, "Error, Please input a posative number or zero for none. ");
                    servSubmit = false;
                } else {
                Services Services1 = new Services();
                accountArray[0] = Services1;
                Services1.setAccountID(AccID);
                Services1.setNumHours(ServAns1);
                Services1.setHourlyRate(ServAns2);
                servSubmit = true;
                }
            } catch(Exception z) {
                JOptionPane.showMessageDialog(null, "Error, Input all valid information for Services. ");
            }
            
            
            try{
                SuppAns1 = Integer.parseInt(SuppAnswer1.getText());
                SuppAns2 = Double.parseDouble(SuppAnswer2.getText());
                if (SuppAns1 < 0 || SuppAns2 < 0.0) {
                    JOptionPane.showMessageDialog(null, "Error, Please input a posative number or zero for none. ");
                    suppSubmit = false;
                } else {
                Supplies Supplies1 = new Supplies();
                accountArray[1] = Supplies1;
                Supplies1.setAccountID(AccID);
                Supplies1.setNumItems(SuppAns1);
                Supplies1.setItemPrice(SuppAns2);
                suppSubmit = true;
                }
            } catch(Exception y) {
                JOptionPane.showMessageDialog(null, "Error, Input all valid information for Supplies. ");
            }
        
            String AccID_String = accountArray[0].toString2();
            String ServString = accountArray[0].toString();
            String SuppString = accountArray[1].toString();
            String totalServ = String.format("Total Services: $%,.2f",accountArray[0].calculateSales());
            String totalSupp = String.format("Total Supplies: $%,.2f",accountArray[1].calculateSales());
            double salesTax = 1.029;
            String Total = String.format("Total: $%,.2f",((accountArray[0].calculateSales() + accountArray[1].calculateSales())* salesTax));
            
            
            if (accSubmit == true && servSubmit == true && suppSubmit == true){
                JOptionPane.showMessageDialog(null,AccID_String + "\n\n" + ServString + "\n\n" + SuppString + "\n\n" + 
                        totalServ + "\n" + totalSupp + "\n\n" + Total, "Itemized Bill", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    });        
    
                
// Component Position in JFrame ---------------------        
        
    AccountID.setBounds(51,20,80,30);
    AccountID_Inp.setBounds(130,26,190,20);
    BillingType.setBounds(51,65,80,30); 
    ServicesRB.setBounds(125,65,80,30); 
    SuppliesRB.setBounds(225,65,150,30);
    Question1.setBounds(20,110,120,30);
    ServAnswer1.setBounds(130,117,190,20);
    SuppAnswer1.setBounds(130,117,190,20);
    Question2.setBounds(50,155,120,30);
    ServAnswer2.setBounds(130,162,190,20);
    SuppAnswer2.setBounds(130,162,190,20);
    CalculateB.setBounds(230,205,90,20); 
        
// Adding Components to JFrame -----------------------

    this.add(AccountID);
    this.add(AccountID_Inp);
    this.add(BillingType); 
    this.add(ServicesRB); 
    this.add(SuppliesRB);
    this.add(Question1);
    this.add(ServAnswer1);
    this.add(SuppAnswer1);
    this.add(Question2);
    this.add(ServAnswer2);
    this.add(SuppAnswer2);
    this.add(CalculateB); 
        
// Radio Button Group --------------------------------

    G1.add(ServicesRB); 
    G1.add(SuppliesRB); 
        
}  
      
//---------------------------------------------------- 
//  Main 
//----------------------------------------------------  
    
public static void main(String[] args) {
     
// Initalize, Positiong & Titiling JFrame ------------
        
    GUI frame = new GUI(); 
    frame.setBounds(100,300,360,285);  
    frame.setTitle("Account Billing"); 
    frame.setVisible(true); 
        
        
        
    }
}