/**
 Class for an Outstate student, a student that lives in a different state than the
 one the school is located in. Extends the Student class and inherits the properties.
 Outstate students have the property whether they are in the tri-state area.

 @author Rizwan Chowdhury
 @author Tin Fung
 */
public class Outstate extends Student {

    private boolean tristate;

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
    	int OutStateTuition=756;
    	int full_time=1441;
    	int part_time=846;
    	int tristateDiscount=200;
    	int over_15=15;

    	 	if(this.credit>=12) {
        	if(this.tristate) {
        		if(this.credit>=over_15) {
    	    		return over_15*(OutStateTuition-tristateDiscount)+full_time;}
        		return this.credit*(OutStateTuition-tristateDiscount)+full_time;

        	}else {
        		if(this.credit>=over_15) {
    	    		return over_15*OutStateTuition+full_time;}
        		return this.credit*OutStateTuition+full_time;

        	}
    	}else {
    		return this.credit*OutStateTuition+part_time;
    	}

    
    }


    /**
     Creates the string representation for the Outstate student object.
     In the form:
        FirstName LastName Credit: value of credit
        Oustate TristateArea: (Yes/No)
        Tuition Due: value of tuitionDue()
     @return String representation of an Outstate class
     @author Rizwan Chowdhury
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
     @author Rizwan Chowdhury
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
