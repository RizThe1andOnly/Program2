/**
 Class for an Instate student, extends the Student class. Represents a student that
 lives in the same state as the school. Instate students have funds that they receive from
 the state/school.

 @author Rizwan Chowdhury
 @author Tin Fung
 */
public class Instate extends Student {

    private int funds;

    //constants
    private int IN_STATE_TUITION = 433;
    private int FULL_TIME_FEE = 1441;
    private int PART_TIME = 846;
    private int OVER_FIFTEEN_CREDITS = 15;
    private int FULL_TIME_THRESHOLD = 12;

    /**
     Constructor for the Instate class. Creates a Instate object by creating an
     instance of the super Student class.
     @param fname Student's First name, of type String
     @param lname Student's Last name, of type String
     @param credit How many credits the Student is taking/has, of type int
     @param funds  Amound of funding student is receiving, type int

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public Instate(String fname, String lname, int credit, int funds){

        //create instance of the super class and this class
        super(fname,lname,credit);

        //set funds property
        this.funds = funds;
    }


    /**
     Calculates the tuition that an instate student has to pay. Calculated based
     on student's credit hours and status as instate student.

     @return int, The amount of tuition the student has to pay.

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public int tuitionDue(){

    	if(this.credit>=OVER_FIFTEEN_CREDITS) {
    		return OVER_FIFTEEN_CREDITS*IN_STATE_TUITION+FULL_TIME_FEE-this.funds;

    	}else if(this.credit>=FULL_TIME_THRESHOLD) {
    		return this.credit*IN_STATE_TUITION+FULL_TIME_FEE-this.funds;
    	}else {
    		return this.credit*IN_STATE_TUITION+PART_TIME;
    	}
    }


    /**
     Creates and returns the string representation of an Instate student.
     Will be in the form:
        FirstName LastName Credit:(value for credit)
        Instate Funds:(value for funds)
        Tuition Due: (value for tuitionDue)

     @return A String containing the information regarding the instate student

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    @Override
    public String toString(){
    	return super.toString()+"\nInstate Funds: "+this.funds+"\nTuition Due: "+this.tuitionDue();
    }


    /**
     Testbed main to test the Instate class with different test cases.
     @param args arguments passed into the testbed main class
     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public static void main(String[] args){ 
    	
    	Instate test=new Instate ("John","white",12,1000);
    	test.tuitionDue();
    	System.out.println(test.toString());


    }
}
