/**
 Container class to hold students registered for school, holds Student and its subclasses
 Uses an array to hold the objects.

 @author Rizwan Chowdhury
 @author Tin Fung
 */
public class StudentList {
    private Student[] studentList;
    private int numberOfStudents;
    private final int GROW_SIZE = 4;
    /**
     Constructor for the StudentList class object. It will instantiate object by
     instantiating the array holding students and the number of students.

     @author Rizwan Chowdhury
     */
    public StudentList(){
        studentList = new Student[0];
        numberOfStudents = 0;
    }



    private int find(Student s) {
    	for(int i=0;i<numberOfStudents;i++) {
    		if(s.compareTo(studentList[i]) == 0) {
    			return i;
    		}
    	}
    	return -1;
    }


    public boolean contains(Student s){
    	for(int i=0;i<this.numberOfStudents;i++){
    		if(this.studentList[i].compareTo(s) == 0){
    			return true;
			}
		}
    	return false;
	}

 	private void grow() {
	 	Student [] temp=new Student[this.numberOfStudents+GROW_SIZE];

	 	for(int i=0;i<this.numberOfStudents;i++) {
	   		temp[i]=this.studentList[i];
	   	}

	 	this.studentList=temp;
 	}
    

    /**
     Adds Student object provided through argument into this container.
     @param s Student object to be added
     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public void add(Student s){
    	if(find(s)==-1) {
    		if(this.numberOfStudents==this.studentList.length) {
    			this.grow();
    		}
    		this.studentList[this.numberOfStudents]=s;
    		this.numberOfStudents++;
    	}
    }


    /**
     Removes the Student given through the argument from the container
     @param s Student object to be removed
     @return true if student successfully removed, false otherwise
     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public boolean remove(Student s){
    	int find=find(s);
    
    	if(find!=-1) {
    		this.studentList[find]=this.studentList[this.numberOfStudents];
    		this.studentList[this.numberOfStudents]=null;
    		this.numberOfStudents--;
    		return true;
    	}
return false;
    }


    /**
     Prints out the contents of this container; all of the Student objects and their
     properties.
     @author Rizwan Chowdhury
     @author Tin Fung
     */
    public void print(){
    	for(int i=0;i<this.numberOfStudents;i++) {
    		System.out.println(this.studentList[i].toString());
    		System.out.println();
    	}
    }
}
