import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser{
  //... imports class definition...
    

  
    // Inside class:
    // private Integer id; // employee id not neccsary we are inhereting id from user
    private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();
    
     // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role) {
      super(id);
      this.role = role;
      //TODO Auto-generated constructor stub
    }

    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

        // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public boolean assignPin(int pin) {
      // TODO Auto-generated method stub
      String pinString = Integer.toString(pin); // int is data type // Integer is a class
      if(pinString.length()== 6){
        return true;
      } else { return false; }
    }
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
      // TODO Auto-generated method stub
      int id = (confirmedAuthID);
      if(id == this.id) {
      return true; 
    } else { 
      authIncident();
      return false; }
    }
    @Override
    public ArrayList<String> reportSecurityIncidents() {
      // TODO Auto-generated method stub
      return this.securityIncidents;
      
    }
    
    // TO DO: Setters & Getters
}
