import java.util.Scanner;

/**
 Class to handle the I/O for the project and manage the functionalities and flow of the other
 classes. Will issue add/remove and print commands to be carried out by other classes. Will
 create the objects, based on input, that tasks will be carried out on.
 */
public class TuitionManager {
    private StudentList students;
    private Scanner stdin;

    /**
     method that will be called to run the project.

     @author Rizwan Chowdhury
     */
    public void run() {
        //initiate scanner and studentlist objects
        students = new StudentList();
        stdin = new Scanner(System.in);

        //message that program started:
        System.out.println("Welcome, please enter inputs below in proper format.");

        //loop to accept inputs and do appropriate procedures
        boolean loop = true;
        String command;
        String[] inputLine;
        while(loop == true){
            inputLine = stdin.nextLine().split(" ",2);
            command = inputLine[0];
            if(command.length()!=1){
                handleBadCommands("Input does not match format");
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
                default : handleBadCommands("\'"+command.charAt(0)+"\'"+" is not a proper command");
            }
        }

    }


    /**
     Adds a new student to the running list within this class.
     @param studentType Type of student to add (I)nstate, (O)utstate, I(N)ternational
     @param studentDetails String that contains details inputted as part of command

     @author Rizwan Chowdhury
     @author Tin Fung
     */
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


    /**
     Helper method to specifically add an Instate student to the list
     @param studentInfo String array that contains student details as tokens
     @return true if add was successful or false if unsuccessful

     @author Rizwan Chowdhury
     @author Tin Fung
     */
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
            return true;
        }

        System.out.print("Student already in students list. ");
        return false;
    }


    /**
     Helper method to specifically add an Outstate student to the list
     @param studentInfo String array that contains student details as tokens
     @return true if add was successful or false if unsuccessful

     @author Rizwan Chowdhury
     @author Tin Fung
     */
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


    /**
     Helper method to specifically add an International student to the list
     @param studentInfo String array that contains student details as tokens
     @return true if add was successful or false if unsuccessful

     @author Rizwan Chowdhury
     @author Tin Fung
     */
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


    /**
     * Helper method to parse string containing type-specific-data for booleans from input
     * to determine which (if any) boolean value is being provided as input.
     * @param boolString String containing the boolean input, either "T" or "F"
     * @return int: 1 if true, 0 if false, -1 if not proper input format
     *
     * @author Rizwan Chowdhury
     */
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

     @author Rizwan Chowdhury
     @author Tin Fung
     */
    private void handleBadCommands(String command){
        System.out.println("Bad input: " + command);
    }


    /**
     * Prints a list of Students and the tuition amount due for each
     *
     * @author Rizwan Chowdhury
     * @author Tin Fung
     */
    private void printCommand(){
        students.print();
        System.out.println("--End of List--");
    }
}
