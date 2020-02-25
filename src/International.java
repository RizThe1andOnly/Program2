/**
 Class for International students, extends the Student class and inherits the
 properties. International students are students who are not from the country
 where the school exists.

 @author Rizwan Chowdhury
 @author Tin Fung
 */
public class International extends Student {

    private boolean exchange;

    /**
     Constructor for the International class, instantiates the object by calling the
     Student super class' constructor.
     @param fname Student's First Name, type String
     @param lname Student's Las Name, type String
     @param credit Number of credits student is taking/has, type int
     @param exchange Whether or not the student is an exchange student, type boolean
     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public International(String fname, String lname, int credit, boolean exchange){
        //creates the object by call super's constructor
        super(fname,lname,credit);

        //sets exchange property
        this.exchange = exchange;
    }


    /**
     Calculates the tuition that the International student has to pay, based on their
     status as an International student and how many credits they are taking.

     @return int, amount of tuition that the student has to pay

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    @Override
    public int tuitionDue() {

    	int InternationalTuition=945;
    	int Internationalfee=350;
    	int full_time=1441;
    	int part_time=846;
    	int over_15=15;

    	if(this.exchange) {
    		return full_time+Internationalfee;
    	}else {
    		if(this.credit>=over_15) {
        		return over_15*InternationalTuition+full_time;
        	}else   if(this.credit>=12) {
    		return this.credit*InternationalTuition+full_time+Internationalfee;
    	}else {
    		return this.credit*InternationalTuition+part_time+Internationalfee;
    	}
    	}
    
    }


    /**
     Creates the string representation for the International student.
     In the form:
        FirstName LastName Credit: (value of credit)
        International  Exchange: (Yes/No)
        Tuition Due: the value of tuition
     @return String representation of the International student

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    @Override
    public String toString(){
    	if(this.exchange) {
        	return super.toString()+"\nInternational  Exchange: Yes\nTuition Due: "+this.tuitionDue();

    	}else {
        	return super.toString()+"\nInternational  Exchange: No\nTuition Due: "+this.tuitionDue();

    	}

    }


    /**
     Testbed main to test the International class with different test cases.
     @param args arguments passed into the testbed main class
     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public static void main(String[] args){
    	International test=new International ("Joe","Kim",12,true);
    	test.tuitionDue();
    	System.out.println(test.toString());
    	
    	International test2=new International ("David","Lee",12,false);
    	test2.tuitionDue();
    	System.out.println(test2.toString());


    }
}
