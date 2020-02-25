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


    private void addNewStudent(char studentType, String studentDetails){
        String[] studentInfo = studentDetails.split(" ");
        boolean successfulAdd = false;
        switch (studentType){
            case 'I': successfulAdd = addNewInstateStudent(studentInfo);
            break;
            case 'O': successfulAdd = addNewOutstateStudent(studentInfo);
            break;
            case 'N': successfulAdd = addNewInternationalStudent(studentInfo);
            break;
        }
        if(successfulAdd == false){
            System.out.println("Could not add student.");
        }
    }


    private boolean addNewInstateStudent(String[] studentInfo){
        if(studentInfo.length != 4){
            return false;
        }

        String firstName = studentInfo[0];
        String lastName = studentInfo[1];
        int credits;
        int funds;
        try {
            credits = Integer.parseInt(studentInfo[2]);
            funds = Integer.parseInt(studentInfo[3]);
        }catch (NumberFormatException e){
            return false;
        }

        Student newInstateStudent = new Instate(firstName,lastName,credits,funds);
        if(!(students.contains(newInstateStudent))){
            students.add(newInstateStudent);
        }

        System.out.print("Student already in students list. ");
        return true;
    }


    private boolean addNewOutstateStudent(String[] studentInfo){
        if(studentInfo.length != 4){
            return false;
        }

        String firstName = studentInfo[0];
        String lastName = studentInfo[1];
        int credits;
        boolean tristate;

        try {
            credits = Integer.parseInt(studentInfo[2]);
        }catch (NumberFormatException e){
            return false;
        }

        switch (getBooleanValue(studentInfo[3])){
            case 1: tristate = true;
            break;
            case 0: tristate = false;
            break;
            default: System.out.println("Bad Input: Value for tristate should be \"T\" or \"F\"");
                     return false;
        }

        Student newOutstateStudent = new Outstate(firstName,lastName,credits,tristate);
        if(!(students.contains(newOutstateStudent))){
            students.add(newOutstateStudent);
            return true;
        }

        System.out.print("Student already in students list. ");
        return false;
    }

    private boolean addNewInternationalStudent(String[] studentInfo){
        if(studentInfo.length != 4){
            return false;
        }

        String firstName = studentInfo[0];
        String lastName = studentInfo[1];
        int credits;
        boolean exchange;

        try {
            credits = Integer.parseInt(studentInfo[2]);
            if(credits<9){
                System.out.println("Not enough credits for an International Student");
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }

        switch (getBooleanValue(studentInfo[3])){
            case 1: exchange = true;
                break;
            case 0: exchange = false;
                break;
            default: System.out.println("Bad Input: Value for exchange should be \"T\" or \"F\"");
                return false;
        }

        Student newInternationalStudent = new International(firstName,lastName,credits,exchange);
        if(!(students.contains(newInternationalStudent))){
            students.add(newInternationalStudent);
            return true;
        }

        System.out.print("Student already in students list. ");
        return false;
    }


    private int getBooleanValue(String boolString){
        if(boolString.equals("T")){
            return 1;
        }

        if(boolString.equals("F")){
            return 0;
        }

        return -1;
    }

    /**
     Removes given student from the running list in this class

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    private void removeStudent(String studentInfo){
        String[] studentDetails = studentInfo.split(" ");
        if(studentDetails.length != 2){
            System.out.println("Wrong number of inputs, should be: R firstname lastname");
            return;
        }

        String firstName = studentDetails[0];
        String lastName = studentDetails[1];
        Student studentToBeRemoved = new Instate(firstName,lastName,0,0);
        boolean successfulRemoval = students.remove(studentToBeRemoved);
        if(successfulRemoval == false){
            System.out.println("Failed to remove Student");
        }
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
