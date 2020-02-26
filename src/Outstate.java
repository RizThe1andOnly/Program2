/**
 Class for an Outstate student, a student that lives in a different state than the
 one the school is located in. Extends the Student class and inherits the properties.
 Outstate students have the property whether they are in the tri-state area.

 @author Rizwan Chowdhury
 @author Tin Fung
 */
public class Outstate extends Student {

    private boolean tristate;

    //constants:
	private final int OUT_STATE_TUITION = 756;
	private final int FULL_TIME_FEE = 1441;
	private final int PART_TIME = 846;
	private final int TRISTATE_DISCOUNT = 200;
	private final int OVER_FIFTEEN = 15;
	private final int FULL_TIME_THRESHOLD = 12;

    /**
     Constructor for the Oustate class, instantiate the class by calling the
     super class's constructor.

     @param fname Outstate Student's First Name, type String
     @param lname Outstate Student's Last Name, type String
     @param credit Amount of credits the student is taking/has, type int
     @param tristate Whether the student is from the tristate area or not, type boolean

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public Outstate(String fname, String lname, int credit, boolean tristate){
        //instantiate the object by calling the super's constructor
        super(fname,lname,credit);

        //set tristate property:
        this.tristate = tristate;
    }


    /**
     Calculates the tuition that the Outstate student has to pay. Based on the
     property of being an outstate student as well as how many credits they are
     taking.

     @return int, the amount of tuition the student has to pay

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    @Override
    public int tuitionDue() {

    	if(this.credit>=FULL_TIME_THRESHOLD) {
    		if(this.tristate) {
        		if(this.credit>=OVER_FIFTEEN) {
    	    		return OVER_FIFTEEN*(OUT_STATE_TUITION-TRISTATE_DISCOUNT)+FULL_TIME_FEE;
        		}
        		return this.credit*(OUT_STATE_TUITION-TRISTATE_DISCOUNT)+FULL_TIME_FEE;
        	}
    		else {
        		if(this.credit>=OVER_FIFTEEN) {
    	    		return OVER_FIFTEEN*OUT_STATE_TUITION+FULL_TIME_FEE;
        		}
        		return this.credit*OUT_STATE_TUITION+FULL_TIME_FEE;
        	}
    	}else {
    		return this.credit*OUT_STATE_TUITION+PART_TIME;
    	}

    }


    /**
     Creates the string representation for the Outstate student object.
     In the form:
        FirstName LastName Credit: value of credit
        Oustate TristateArea: (Yes/No)
        Tuition Due: value of tuitionDue()
     @return String representation of an Outstate class

     @author Tin Fung
     */
    @Override
    public String toString(){
    	if(this.tristate) {
        	return super.toString()+"\nOustate TristateArea: Yes\nTuition Due: "+this.tuitionDue();

    	}else {
        	return super.toString()+"\nOustate TristateArea: No\nTuition Due: "+this.tuitionDue();

    	}
    }


    /**
     Testbed main to test the Outstate class with different test cases.
     @param args arguments passed into the testbed main class

     @author Tin Fung
     */
    public static void main(String[] args){
    	Outstate test=new Outstate ("John","White",12,true);
    	test.tuitionDue();
    	System.out.println(test.toString());
    	Outstate test2=new Outstate ("May","Anderson",17,false);
    	test2.tuitionDue();
    	System.out.println(test2.toString());
    	Outstate test3=new Outstate ("John","White",12,true);
    	test.tuitionDue();
    	System.out.println(test.toString());
    	System.out.println(test.compareTo(test3));
    }
}
