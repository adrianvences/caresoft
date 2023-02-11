import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
  //... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
      super(id); // super calls the parent constructor
    }

	

    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }


 // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
      // TODO Auto-generated method stub
      String pinString = Integer.toString(pin); // int is data type // Integer is a class
      if(pinString.length()== 4){
        return true;
      } else { return false; }

      
    }



    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
      // TODO Auto-generated method stub
      int id = (confirmedAuthID);
      if(id == this.id) {
      return true; 
    } else { return false; }
	
    // TO DO: Setters & Getters
}
}
