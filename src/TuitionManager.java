import java.util.Scanner;

/**
 Class to handle the I/O for the project and manage the functionalities and flow of the other
 classes. Will issue add/remove and print commands to be carried out by other classes. Will
 create the objects, based on input, that tasks will be carried out on.
 */
public class TuitionManager {
    private StudentList students;
    Scanner stdin;


    /**
     method that will be called to run the project.
     */
    public void run(){
        //initiate scanner and studentlist objects
        students = new StudentList();
        stdin = new Scanner(System.in);

        //loop to accept inputs and do appropriate procedures
        boolean loop = true;
        String command;
        String[] inputLine;
        while(loop == true){
            inputLine = stdin.nextLine().split(" ",1);
            command = inputLine[0];
            if(command.length()!=1){
                handleBadCommands();
            }
            switch (command.charAt(0)){
                //cases based on required inputs:
                case 'I': addNewStudent('I',inputLine[1]);
                break;
                case 'O': addNewStudent('O',inputLine[1]);
                break;
                case 'N': addNewStudent('N',inputLine[1]);
                break;
                case 'R': removeStudent(inputLine[1]);
                break;
                case 'P': printCommand();
                break;
                case 'Q': System.out.println("Program Terminated");
                          loop = false;
                break;
                default : handleBadCommands();
            }
        }

    }


    /**
     Adds new student to the running list in this class.

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    private void addNewStudent(char studentType, String studentInfo){
        //obtain student information, verify its proper for type of student
        String[] studentDetails = studentInfo.split(" ");
        Student newStudent = createNewStudentObject(studentType,studentDetails);
        if(newStudent == null){
            handleBadCommands();
            return;
        }

        //add student to list
        if(!(students.contains(newStudent))){
            students.add(newStudent);
        }
        else{
            System.out.println("Cannot Add Student Because Student already registered");
        }
    }

    private Student createNewStudentObject(char studentType, String[] studentDetails){
        Student newStudent;
        switch (studentType){
            case 'I' : newStudent = new Instate(studentDetails[0],studentDetails[1],Integer.parseInt(studentDetails[2]),Integer.parseInt(studentDetails[3]));
                break;
            case 'O' : newStudent = new Outstate(studentDetails[0],studentDetails[1],Integer.parseInt(studentDetails[2]),Boolean.parseBoolean(studentDetails[3]));
                break;
            case 'N' : newStudent = new International(studentDetails[0],studentDetails[1],Integer.parseInt(studentDetails[2]),Boolean.parseBoolean(studentDetails[3]));
                break;
            default: newStudent = null;
        }
        return newStudent;
    }


    /**
     Removes given student from the running list in this class

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    private void removeStudent(String studentInfo){

    }


    /**
     Handles bad commands inputted into the command line.
     */
    private void handleBadCommands(){

    }


    /**
     * Prints a list of Students and the tuition amount due for each
     */
    private void printCommand(){

    }
}
