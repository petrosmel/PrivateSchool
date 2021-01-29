package privateschool;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivateSchoolMain {

    static List<Course> listOfCourses = new ArrayList<>(); // create a new list with all courses input by the user
    static List<Trainer> listOfTrainers = new ArrayList<>(); // create a new list with all trainers input by the user
    static List<Student> listOfStudents = new ArrayList<>(); // create a new list with all students input by the user
    static List<Assigment> listOfAssigments = new ArrayList<>(); // create a new list with all assigments input by the user
    static Scanner sc = new Scanner(System.in);
    static List<CourseCombinationClass> ccList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Greetings user! Choose from followiung menu:"); // Greeting text
        mainMenu();
    }

//============================         ============================//
//=========================    METHODS    =========================//
//============================         ============================//
    public static void mainMenu() {
        //Main Menu.

        System.out.println("==================================================================================");
        System.out.println("1. Add data");  // Add data or use synthetic data.
        System.out.println("2. Edit data");  // Edit existing data.
        System.out.println("3. Combine data");  // Combine existing data.
        System.out.println("4. Export data."); // Export data from application
        System.out.println("5. Exit."); // Exit application
        System.out.println("==================================================================================");
        System.out.print("\n" + "Choose from 1 to 5: ");
        String menuInput = sc.next();
        switch (menuInput) {
            case ("1"):
                inputMenu();
                break;
            case ("2"):
                editMenu();
                break;
            case ("3"):
                assignMenu();
                break;
            case ("4"):
                outputMenu();
                break;
            case ("5"):
                System.out.println("Goodbye. See you soon!");
                System.exit(0);
                break;
            default:
                System.out.println("!!!!!  " + menuInput + " is not a valid entry. Please try again.  !!!!!");
                mainMenu();

        }
    }

//============================MANUAL INPUTS============================
    public static void inputMenu() {

        System.out.println("==================================================================================");
        System.out.println("1. Add new course manually.");
        System.out.println("2. Add new student manually.");
        System.out.println("3. Add new assigment manually.");
        System.out.println("4. Add new trainer manually.");
        System.out.println("5. Add synthetic data automatically.");
        System.out.println("6. Back to main menu.");
        System.out.println("==================================================================================");
        System.out.print("\n" + "Choose from 1 to 6: ");

        String menuInput = sc.next();// Bellow are cases depending to user input
        switch (menuInput) {
            case ("1"): // input course
                inputCourse();
                break;
            case ("2"): // input student
                inputStudent();
                break;
            case ("3"): // input assigment
                inputAssigment();
                break;
            case ("4"): // input trainer
                inputTrainer();
                break;
            case ("5"): // import synthetic data
                importSyntheticData();
                break;
            case ("6")://return to main menu
                mainMenu();
                break;

            default:
                System.out.println("!!!!!  " + menuInput + " is not a valid entry. Please try again.  !!!!!");
                inputMenu();
        }
    }

    public static void inputCourse() {

        String localTitle = null;// variables declaration and initialization
        String localStream = null;
        String localType = null;
        String localStartDate = null;
        String localEndDate = null;
        String temp = null;

        do {
            System.out.println("Type NEW to create a new course or type BACK and press enter to return to main menu.");
            temp = sc.next();
            switch (temp) {// end input if the user wants to exit input routine and return to main menu.

                case ("Back"):// 3 alternative answers for the user
                case ("back"):
                case ("BACK"):
                    System.out.println("");
                    System.out.println("!!! You have returned to main menu !!!");
                    System.out.println("");
                    mainMenu();
                    break;
                default: // routine for the user to input data to tables
                    System.out.print("Please enter course title: ");
                    localTitle = sc.next();
                    System.out.print("Please enter course stream: ");
                    localStream = sc.nextLine();
                    System.out.print("Please enter course type: ");
                    localType = sc.nextLine();
                    System.out.print("Please enter course starting date(DD/MM/YYYY): ");
                    localStartDate = sc.nextLine();
                    System.out.print("Please enter course ending date(DD/MM/YYYY): ");
                    localEndDate = sc.nextLine();

            }
            Course courseInput = new Course(localTitle, localStream, localType, localStartDate, localEndDate); // creating new course object
            listOfCourses.add(courseInput); // adding new course to list

        } while (!(temp.equals("back") || temp.equals("Back") || temp.equals("BACK")));

    }

    public static void inputTrainer() {

        String localFIrstName = null;// variables declaration and initialization
        String localLastName = null;
        String localSubject = null;
        String temp = null;

        do {
            System.out.println("Type NEW to create a new trainer or type BACK and press enter to return to main menu.");
            temp = sc.next();
            switch (temp) {// end input if the user wants to exit input routine and return to main menu.

                case ("Back"):// 3 alternative answers for the user
                case ("back"):
                case ("BACK"):
                    System.out.println("");
                    System.out.println("!!! You have returned to main menu !!!");
                    System.out.println("");
                    mainMenu();

                    break;
                default: // routine for the user to input data to tables
                    System.out.print("Please enter trainer first name: ");
                    localFIrstName = sc.next();
                    System.out.print("Please enter trainer last name: ");
                    localLastName = sc.nextLine();
                    System.out.print("Please enter trainer subject: ");
                    localSubject = sc.nextLine();

            }
            Trainer trainerInput = new Trainer(localFIrstName, localLastName, localSubject); // creating new course object
            listOfTrainers.add(trainerInput); // adding new course to list

        } while (!(temp.equals("back") || temp.equals("Back") || temp.equals("BACK")));

    }

    public static void inputStudent() {

        String localFIrstName = null;// variables declaration and initialization
        String localLastName = null;
        String localDateOfBirth = null;
        float localTuitionFees = 0;
        String temp = null;

        do {
            System.out.println("Type NEW to create a new student or type BACK and press enter to return to main menu.");
            temp = sc.next();
            switch (temp) {// end input if the user wants to exit input routine and return to main menu.

                case ("Back"):// 3 alternative answers for the user
                case ("back"):
                case ("BACK"):
                    System.out.println("");
                    System.out.println("!!! You have returned to main menu !!!");
                    System.out.println("");
                    mainMenu();

                    break;
                default: // routine for the user to input data to tables
                    System.out.print("Please enter student first name: ");
                    localFIrstName = sc.next();
                    System.out.print("Please enter student last name: ");
                    localLastName = sc.nextLine();
                    System.out.print("Please enter student date of birth: ");
                    localDateOfBirth = sc.nextLine();
                    System.out.print("Please enter student Tuition Fees: ");
                    localTuitionFees = sc.nextFloat();

            }
            Student studentInput = new Student(localFIrstName, localLastName, localDateOfBirth, localTuitionFees); // creating new course object
            listOfStudents.add(studentInput); // adding new course to list

        } while (!(temp.equals("back") || temp.equals("Back") || temp.equals("BACK")));

    }

    public static void inputAssigment() {

        String localTitle = null;// variables declaration and initialization
        String localDescription = null;
        String localSubDateTime = null;
        int localOralMark = 0;
        int localTotalMark = 0;
        String temp = null;

        do {
            System.out.println("Type NEW to create a new student or type BACK and press enter to return to main menu.");
            temp = sc.next();
            switch (temp) {// end input if the user wants to exit input routine and return to main menu.

                case ("Back"):// 3 alternative answers for the user
                case ("back"):
                case ("BACK"):
                    System.out.println("");
                    System.out.println("!!! You have returned to main menu !!!");
                    System.out.println("");
                    mainMenu();

                    break;
                default: // routine for the user to input data to tables
                    System.out.print("Please enter assigment title: ");
                    localTitle = sc.next();
                    System.out.print("Please enter assigment description: ");
                    localDescription = sc.nextLine();
                    System.out.print("Please enter assigment submission date: ");
                    localSubDateTime = sc.nextLine();
                    System.out.print("Please enter assigment oral mark: ");
                    localOralMark = sc.nextInt();
                    System.out.print("Please enter assigment total mark: ");
                    localTotalMark = sc.nextInt();

            }
            Assigment assigmentInput = new Assigment(localTitle, localDescription, localSubDateTime, localOralMark, localTotalMark); // creating new course object
            listOfAssigments.add(assigmentInput); // adding new course to list

        } while (!(temp.equals("back") || temp.equals("Back") || temp.equals("BACK")));

    }

//============================SYNTHETIC DATA============================
    public static void importSyntheticData() {
//import Students
        Student s1 = new Student("Peter", "Papas", "04/10/1980", 1500);
        Student s2 = new Student("John", "Bixton", "07/04/1985", 1000);
        Student s3 = new Student("Mary", "Poppins", "11/05/1998", 1500);
        Student s4 = new Student("Jenny", "Tapas", "14/08/2000", 1300);

        listOfStudents.add(s1);
        listOfStudents.add(s2);
        listOfStudents.add(s3);
        listOfStudents.add(s4);

//import trainers
        Trainer t1 = new Trainer("Jason", "Red", "Java");
        Trainer t2 = new Trainer("Niki", "Black", "Python");
        Trainer t3 = new Trainer("Carol", "English", "HTML");
        listOfTrainers.add(t1);
        listOfTrainers.add(t2);
        listOfTrainers.add(t3);

//import assigments
        Assigment a1 = new Assigment("Individual project CB2020", "Java", "10/01/2021", 100, 200);
        Assigment a2 = new Assigment("Team project CB2020B", "Java", "20/05/2021", 100, 200);
        Assigment a3 = new Assigment("Individual project CB2019A", "Python", "05/01/2020", 100, 200);
        Assigment a4 = new Assigment("Team project CB2019B", "Html", "18/06/2020", 100, 200);
        listOfAssigments.add(a1);
        listOfAssigments.add(a2);
        listOfAssigments.add(a3);
        listOfAssigments.add(a4);
//import courses
        Course c1 = new Course("CB2020", "Java", "Full time", "20/11/2020", "30/06/2021");
        Course c2 = new Course("CB2020", "Java", "Part time", "20/11/2020", "30/12/2021");
        Course c3 = new Course("CB2019", "Python", "Full time", "17/10/2019", "30/06/2020");
        Course c4 = new Course("CB2019", "Python", "Part time", "17/10/2019", "30/12/2020");

        listOfCourses.add(c1);
        listOfCourses.add(c2);
        listOfCourses.add(c3);
        listOfCourses.add(c4);
// import combined data

//        ccc1.setCourse(c1);
        List<Student> ls1 = new ArrayList<>();
        ls1.add(s1);
        ls1.add(s2);

        List<Trainer> tr1 = new ArrayList<>();
        tr1.add(t3);

        List<Assigment> la1 = new ArrayList<>();
        la1.add(a4);
        la1.add(a2);

        CourseCombinationClass ccc1 = new CourseCombinationClass(c1, tr1, la1, ls1);

        //setting ccc2 synthetic data
        List<Student> ls2 = new ArrayList<>();
        ls2.add(s1);
        ls2.add(s2);
        ls2.add(s3);

        List<Trainer> tr2 = new ArrayList<>();
        tr2.add(t3);
        tr2.add(t1);
        tr2.add(t2);

        List<Assigment> la2 = new ArrayList<>();
        la2.add(a4);
        la2.add(a2);
        la2.add(a1);

        CourseCombinationClass ccc2 = new CourseCombinationClass(c2, tr2, la2, ls2);

        //setting ccc3 synthetic data
        List<Student> ls3 = new ArrayList<>();
        ls3.add(s2);
        ls3.add(s4);

        List<Trainer> tr3 = new ArrayList<>();
        tr3.add(t1);
        tr3.add(t2);

        List<Assigment> la3 = new ArrayList<>();
        la3.add(a3);
        la3.add(a2);
        la3.add(a1);

        CourseCombinationClass ccc3 = new CourseCombinationClass(c3, tr3, la3, ls3);

        //setting ccc4 synthetic data
        CourseCombinationClass ccc4 = new CourseCombinationClass(c4, tr2, la1, ls3);

// adding combined courses to course list
        ccList.add(ccc1);
        ccList.add(ccc2);
        ccList.add(ccc3);
        ccList.add(ccc4);

        System.out.println("You have sucsesfully added synthetic data to your application!");

        mainMenu();

    }

//============================OUTPUTS============================
    public static void outputMenu() {
        System.out.println("==================================================================================");
        System.out.println("1. Export list of all students.");                     //done
        System.out.println("2. Export list of all trainers.");                     //done
        System.out.println("3. Export list of all assigments.");                   //done
        System.out.println("4. Export list of all courses.");                      //done
        System.out.println("5. Export all the students per course.");              //done
        System.out.println("6. Export all the trainers per course.");              //done
        System.out.println("7. Export all the assignments per course.");           //done
        System.out.println("8. Export all the assignments per student.");
        System.out.println("9. Export all students that belong to more than one courses.");
        System.out.println("10. Export list of students who need to submit more than one projects by given date.");
        System.out.println("11. Back to main menu.");
        System.out.println("==================================================================================");
        System.out.print("\n" + "Choose from 1 to 11: ");

        String menuInput = sc.next();
        switch (menuInput) {
            case ("1"): // Export list of all students
                printAllStudents();
                outputMenu();
                break;
            case ("2"): // Export list of all trainers
                printAllTrainers();
                outputMenu();
                break;
            case ("3"): // Export list of all assigments
                printAllAssigments();
                outputMenu();
                break;
            case ("4"): // Export list of all courses
                printAllCourses();
                outputMenu();
                break;
            case ("5"): // Export all the students per course
                quickPrintCombinedCourse();
                int input = sc.nextInt();

                if ((input < 0) || (input > ccList.size())) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                    outputMenu();

                } else {
                    printStudentsPerCourse(input);
                    outputMenu();

                }
                break;
            case ("6"): // Export all the trainers per course
                quickPrintCombinedCourse();
                input = sc.nextInt();

                if ((input < 0) || (input > ccList.size())) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                    outputMenu();
                } else {
                    printTrainersPerCourse(input);
                    outputMenu();
                }
                break;
            case ("7"): // Export all the assignments per course
                quickPrintCombinedCourse();
                input = sc.nextInt();
                String t = String.valueOf(input);

                if ((input < 0) || (input > ccList.size())) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("WRONG INPUT PLEASE TRY AGAIN");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
                    outputMenu();
                } else {
                    printAssigmentsPerCourse(input);
                    outputMenu();
                }
                break;
            case ("8"): // Export all the assignments per student
                printAssigmentsPerStudent();
                outputMenu();
                break;
            case ("9"): // Export all students that belong to more than one courses
                printStudentsPlusOneCourse();
                outputMenu();
                break;
            case ("10"): // Export list of students who need to submit projects by given date
                submitAssigmentsGivenDate();
                outputMenu();
                break;
            case ("11"):// return to main menu
                mainMenu();
                break;
            default:
                System.out.println("!!!!!  " + menuInput + " is not a valid entry. Please try again.  !!!!!");
                outputMenu();

        }

    }

    public static void printAllStudents() {
        int i = 1;
        for (Student temp : listOfStudents) {
            System.out.println("Student " + i + " " + temp);
            i++;
        }

    }

    public static void printAllTrainers() {
        int i = 1;
        for (Trainer temp : listOfTrainers) {
            System.out.println("Trainer " + i + " " + temp);
            i++;
        }
    }

    public static void printAllCourses() {
        int i = 1;
        for (Course temp : listOfCourses) {
            System.out.println("Course " + i + " " + temp);
            i++;
        }
    }

    public static void printAllAssigments() {
        int i = 1;
        for (Assigment temp : listOfAssigments) {
            System.out.println("Assigment " + i + " " + temp);
            i++;
        }

    }

    public static void printStudentsPerCourse(int i) {
        i = (i - 1);
        System.out.println("\n" + "All assigned students to course " + ccList.get(i).getCourse().getTitle() + " " + ccList.get(i).getCourse().getStream() + " " + ccList.get(i).getCourse().getType() + " are:");
        for (int j = 0; j < ccList.get(i).getStudents().size(); j++) {
            System.out.println(ccList.get(i).getStudents().get(j).getFirstName() + " " + ccList.get(i).getStudents().get(j).getLastName());
        }
    }

    public static void printTrainersPerCourse(int i) {
        i = (i - 1);// fixed index 
        System.out.println("\n" + "All assigned trainers to course " + ccList.get(i).getCourse().getTitle() + " " + ccList.get(i).getCourse().getStream() + " " + ccList.get(i).getCourse().getType() + " are:");
        for (int j = 0; j < ccList.get(i).getTrainers().size(); j++) {
            System.out.println(ccList.get(i).getTrainers().get(j).getFirstName() + " " + ccList.get(i).getTrainers().get(j).getLastName());
        }
    }

    public static void printAssigmentsPerCourse(int i) {
        i = (i - 1);//fixed index
        System.out.println("\n" + "All assigned assigments to course " + ccList.get(i).getCourse().getTitle() + " " + ccList.get(i).getCourse().getStream() + " " + ccList.get(i).getCourse().getType() + " are:");
        for (int j = 0; j < ccList.get(i).getAssigment().size(); j++) {
            System.out.println(ccList.get(i).getAssigment().get(j).getTitle());
        }
    }

    public static void printAssigmentsPerStudent() {
        System.out.println("\n" + "All available students.");
        quickAllStudents();
        System.out.print("\n" + "Choose from 1 to " + listOfStudents.size() + ": ");
        int i = sc.nextInt() - 1;

        if ((i < 0) || (i > listOfStudents.size())) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("WRONG INPUT PLEASE TRY AGAIN");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!");
            outputMenu();
        } else {
            String fn = listOfStudents.get(i).getFirstName();
            String ln = listOfStudents.get(i).getLastName();
            System.out.println("Student " + fn + " " + ln + " is assigned to:");
            for (int j = 0; j < ccList.size(); j++) {
                for (int z = 0; z < ccList.get(j).getStudents().size(); z++) {
                    if (ccList.get(j).getStudents().get(z).getFirstName().equals(fn) && ccList.get(j).getStudents().get(z).getLastName().equals(ln)) {
                        System.out.println(ccList.get(j).getAssigment().get(z).getTitle() + " (" + ccList.get(j).getCourse().getTitle() + " " + ccList.get(j).getCourse().getStream() + " " + ccList.get(j).getCourse().getType() + ").");
                    } else {
                        System.out.println("0 courses.");
                    }
                }
            }

        }
        outputMenu();
    }

    public static void printStudentsPlusOneCourse() {

        List<String> studentsPlusOneCourse = new ArrayList<>();

        for (int i = 0; i < listOfStudents.size(); i++) {// list of students i for every specific student
            String fn = listOfStudents.get(i).getFirstName();
            String ln = listOfStudents.get(i).getLastName();
            int counter = 0; // counter returns to zero for every new student
            String asTitles = "";
            for (int j = 0; j < ccList.size(); j++) {// list of combined courses j for evey specific combined course

                for (int z = 0; z < ccList.get(j).getStudents().size(); z++) { // list of students within a combined course
                    if (ccList.get(j).getStudents().get(z).getFirstName().equals(fn) && ccList.get(j).getStudents().get(z).getLastName().equals(ln)) {

                        counter += 1;// counter is increasing by one for every fullname and last name match
                        asTitles = asTitles + " [" + ccList.get(j).getCourse().getTitle() + " " + ccList.get(j).getCourse().getStream() + " " + ccList.get(j).getCourse().getType() + "] " + ccList.get(j).getAssigment().get(z).getTitle();

                    }
                }

            }
            if (counter > 1) {
                studentsPlusOneCourse.add(fn + " " + ln + " (" + asTitles + " ).");//adds student to a new list for +1 courses
            }
        }

        int x = 1;//prints list with students who have +1 courses
        for (String temp : studentsPlusOneCourse) {
            System.out.println(temp);
            x++;
        }
    }

    public static void submitAssigmentsGivenDate() {
        System.out.print("Please enter a date(DD/MM/YYYY) you want to examine: ");
        String userInput = sc.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");// given format for input
        LocalDate givenDate = LocalDate.parse(userInput, formatter);//converts string to specific format for later compiration
        String temp = givenDate.getDayOfWeek().name();//getting the name of the week
        LocalDate startOfWeek;
        LocalDate endOfWeek;

        switch (temp) {// creating the baggining and the end of the given week to search later for assigments
            case ("MONDAY"):
                startOfWeek = givenDate;
                endOfWeek = (givenDate.plusDays(6));
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;
            case ("TUESDAY"):
                startOfWeek = givenDate.minusDays(1);
                endOfWeek = (givenDate.plusDays(5));
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;
            case ("WEDNESDAY"):
                startOfWeek = givenDate.minusDays(2);
                endOfWeek = (givenDate.plusDays(4));
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;
            case ("THURSDAY"):
                startOfWeek = givenDate.minusDays(3);
                endOfWeek = (givenDate.plusDays(3));
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;
            case ("FRIDAY"):
                startOfWeek = givenDate.minusDays(4);
                endOfWeek = (givenDate.plusDays(2));
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;
            case ("SATURDAY"):
                startOfWeek = givenDate.minusDays(5);
                endOfWeek = (givenDate.plusDays(1));
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;
            case ("SUNDAY"):
                startOfWeek = givenDate.minusDays(6);
                endOfWeek = givenDate;
                search(startOfWeek, endOfWeek);
                outputMenu();
                break;

        }

    }

    public static void search(LocalDate startOfWeek, LocalDate endOfWeek) {
        List<Student> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");// given format for input

        for (int i = 0; i < ccList.size(); i++) {// for each course
            for (int j = 0; j < ccList.get(i).getAssigment().size(); j++) { // for each assigment to prechossen course from previous loop
                LocalDate dateFromData = LocalDate.parse(ccList.get(i).getAssigment().get(j).getSubDateTime(), formatter);
                LocalDate start = startOfWeek.minusDays(1);
                LocalDate end = endOfWeek.plusDays(1);
                int s = dateFromData.compareTo(start);
                int e = dateFromData.compareTo(end);

                if (s > 0 && e < 0) {

                    list.addAll(ccList.get(i).getStudents());
                
                }
            }

        }
        int x = 1;
        for (Student temp : list) {
            System.out.println("Student " + x + " " + temp.getFirstName()+" "+temp.getLastName());
            x++;
        }
    }
    //============================EDIT EXISTING DATA============================

    public static void editMenu() {

        System.out.println("==================================================================================");
        System.out.println("1. Edit existing course.");
        System.out.println("2. Edit existing student.");
        System.out.println("3. Edit existing assigment.");
        System.out.println("4. Edit existing trainer.");
        System.out.println("5. Back to main menu.");
        System.out.println("==================================================================================");
        System.out.print("\n" + "Choose from 1 to 5: ");

        String menuInput = sc.next();
        switch (menuInput) {
            case ("1"):
                editCourse();
                break;
            case ("2"):
                editStudent();
                break;
            case ("3"):
                editAssigment();
                break;
            case ("4"):
                editTrainer();
                break;
            case ("5"):
                mainMenu();
                break;
            default:
                System.out.println("!!!!!  " + menuInput + " is not a valid entry. Please try again.  !!!!!");
                editMenu();

        }
    }

    public static void editCourse() {

        if (listOfCourses.isEmpty()) { // Checking if list is empty.
            System.out.println("Courses list is empty please add courses from add menu.");
            inputMenu();
        }

        System.out.println("ALL AVAILABLE COURSES");
        quickAllCourses(); // Outputs all available courses. 

        System.out.println("Please choose a course you want to edit from 1 to " + listOfCourses.size() + " as mentioned above.");
        int temp = sc.nextInt() - 1;
        if ((temp < 0) || (temp >= listOfCourses.size())) { //
            System.out.println("Invalid input please try again.");
            editMenu();

        } else {
            System.out.println("==================================================================================");
            System.out.println("1. Edit course title.");
            System.out.println("2. Edit course stream.");
            System.out.println("3. Edit course type.");
            System.out.println("4. Edit course start date.");
            System.out.println("5. Edit course end date.");
            System.out.println("6. Back to edit menu.");
            System.out.println("==================================================================================");
            String menuInput = sc.next();// Bellow are cases depending to user input

            switch (menuInput) {
                case ("1"):
                    System.out.print("Change current title " + listOfCourses.get(temp).getTitle() + " with: ");
                    listOfCourses.get(temp).setTitle(sc.next());
                    System.out.println("New title is " + listOfCourses.get(temp).getTitle() + ".");
                    editCourse();
                    break;
                case ("2"):
                    System.out.print("Change current stream " + listOfCourses.get(temp).getStream() + " with: ");
                    listOfCourses.get(temp).setStream(sc.next());
                    System.out.println("New stream is " + listOfCourses.get(temp).getStream() + ".");
                    editCourse();

                    break;
                case ("3"):
                    System.out.print("Change current type " + listOfCourses.get(temp).getType() + " with: ");
                    listOfCourses.get(temp).setTitle(sc.next());
                    System.out.println("New type is " + listOfCourses.get(temp).getType() + ".");
                    editCourse();

                    break;
                case ("4"):
                    System.out.print("Change current start date " + listOfCourses.get(temp).getStartDate() + " with (DD/MM/YYYY): ");
                    listOfCourses.get(temp).setStartDate(sc.next());
                    System.out.println("New start date is " + listOfCourses.get(temp).getStartDate() + ".");
                    editCourse();

                    break;
                case ("5"):

                    System.out.print("Change current END date " + listOfCourses.get(temp).getEndDate() + " with (DD/MM/YYYY): ");
                    listOfCourses.get(temp).setEndDate(sc.next());
                    System.out.println("New end date is " + listOfCourses.get(temp).getEndDate() + ".");
                    editCourse();

                    break;
                case ("6"):
                    editMenu();
                    break;

            }

        }

    }

    public static void editTrainer() {
        if (listOfTrainers.isEmpty()) { // Checking if list is empty.
            System.out.println("Trainers list is empty please add courses from add menu.");
            inputMenu();
        }

        System.out.println("ALL AVAILABLE TRAINERS");
        quickAllTrainers(); // Outputs all available courses. 

        System.out.println("Please choose a trainer you want to edit from 1 to " + listOfTrainers.size() + " as mentioned above.");
        int temp = sc.nextInt() - 1;
        if ((temp < 0) || (temp >= listOfTrainers.size())) { //
            System.out.println("Invalid input please try again.");
            editMenu();

        } else {
            System.out.println("==================================================================================");
            System.out.println("1. Edit trainer first name.");
            System.out.println("2. Edit trainer last name.");
            System.out.println("3. Edit trainer subject.");
            System.out.println("4. Back to edit menu.");
            System.out.println("==================================================================================");
            String menuInput = sc.next();// Bellow are cases depending to user input

            switch (menuInput) {
                case ("1"):
                    System.out.print("Change current first name " + listOfTrainers.get(temp).getFirstName() + " with: ");
                    listOfTrainers.get(temp).setFirstName(sc.next());
                    System.out.println("New first name is " + listOfTrainers.get(temp).getFirstName() + ".");
                    editTrainer();
                    break;
                case ("2"):
                    System.out.print("Change current last name " + listOfTrainers.get(temp).getLastName() + " with: ");
                    listOfTrainers.get(temp).setLastName(sc.next());
                    System.out.println("New last name is " + listOfTrainers.get(temp).getLastName() + ".");
                    editTrainer();
                    break;
                case ("3"):
                    System.out.print("Change current subject " + listOfTrainers.get(temp).getSubject() + " with: ");
                    listOfTrainers.get(temp).setSubject(sc.next());
                    System.out.println("New subject is " + listOfTrainers.get(temp).getSubject() + ".");
                    editTrainer();
                    break;
                case ("4"):
                    editMenu();
                    break;

            }

        }
    }

    public static void editStudent() {
        if (listOfStudents.isEmpty()) { // Checking if list is empty.
            System.out.println("Students list is empty please add courses from add menu.");
            inputMenu();
        }

        System.out.println("ALL AVAILABLE STUDENTS");
        quickAllStudents(); // Outputs all available students. 

        System.out.println("Please choose a student you want to edit from 1 to " + listOfStudents.size() + " as mentioned above.");
        int temp = sc.nextInt() - 1;
        if ((temp < 0) || (temp >= listOfStudents.size())) { //
            System.out.println("Invalid input please try again.");
            editMenu();

        } else {
            System.out.println("==================================================================================");
            System.out.println("1. Edit student first name.");
            System.out.println("2. Edit student last name.");
            System.out.println("3. Edit student date of birth.");
            System.out.println("4. Edit student tuition fees.");
            System.out.println("5. Back to edit menu.");
            System.out.println("==================================================================================");
            String menuInput = sc.next();// Bellow are cases depending to user input

            switch (menuInput) {
                case ("1"):
                    System.out.print("Change current first name " + listOfStudents.get(temp).getFirstName() + " with: ");
                    listOfStudents.get(temp).setFirstName(sc.next());
                    System.out.println("New first name is " + listOfStudents.get(temp).getFirstName() + ".");
                    editStudent();
                    break;
                case ("2"):
                    System.out.print("Change current last name " + listOfStudents.get(temp).getLastName() + " with: ");
                    listOfStudents.get(temp).setLastName(sc.next());
                    System.out.println("New last name is " + listOfStudents.get(temp).getLastName() + ".");
                    editStudent();
                    break;
                case ("3"):
                    System.out.print("Change current date of birth " + listOfStudents.get(temp).getDateOfBirth() + " with(DD/MM/YYYY): ");
                    listOfStudents.get(temp).setDateOfBirth(sc.next());
                    System.out.println("New date of birth is " + listOfStudents.get(temp).getDateOfBirth() + ".");
                    editStudent();
                    break;
                case ("4"):
                    System.out.print("Change current feesh " + listOfStudents.get(temp).getTuitionFees() + " with: ");
                    listOfStudents.get(temp).setTuitionFees(sc.nextFloat());
                    System.out.println("New tuition fees are: " + listOfStudents.get(temp).getTuitionFees() + ".");
                    editStudent();
                    break;
                case ("5"):
                    editMenu();
                    break;

            }

        }
    }

    public static void editAssigment() {
        if (listOfAssigments.isEmpty()) { // Checking if list is empty.
            System.out.println("Assigment list is empty please add courses from add menu.");
            inputMenu();
        }

        System.out.println("ALL AVAILABLE ASSIGMENTS");
        quickAllAssigments(); // Outputs all available assigments. 

        System.out.println("Please choose an assigment you want to edit from 1 to " + listOfAssigments.size() + " as mentioned above.");
        int temp = sc.nextInt() - 1;
        if ((temp < 0) || (temp >= listOfAssigments.size())) { //
            System.out.println("Invalid input please try again.");
            editMenu();

        } else {
            System.out.println("==================================================================================");
            System.out.println("1. Edit assigment title.");
            System.out.println("2. Edit assigment description.");
            System.out.println("3. Edit assigment submition date.");
            System.out.println("4. Edit assigment oral mark.");
            System.out.println("5. Edit assigment total mark.");
            System.out.println("6. Back to edit menu.");
            System.out.println("==================================================================================");
            String menuInput = sc.next();// Bellow are cases depending to user input

            switch (menuInput) {
                case ("1"):
                    System.out.print("Change current title " + listOfAssigments.get(temp).getTitle() + " with: ");
                    listOfAssigments.get(temp).setTitle(sc.next());
                    System.out.println("New title is " + listOfAssigments.get(temp).getTitle() + ".");
                    editAssigment();
                    break;
                case ("2"):
                    System.out.print("Change current description " + listOfAssigments.get(temp).getDescription() + " with: ");
                    listOfAssigments.get(temp).setDescription(sc.next());
                    System.out.println("New description is " + listOfAssigments.get(temp).getDescription() + ".");
                    editAssigment();

                    break;
                case ("3"):
                    System.out.print("Change current submition date " + listOfAssigments.get(temp).getSubDateTime() + " with: ");
                    listOfAssigments.get(temp).setSubDateTime(sc.next());
                    System.out.println("New submition date is " + listOfAssigments.get(temp).getSubDateTime() + ".");
                    editAssigment();

                    break;
                case ("4"):
                    System.out.print("Change current oral mark " + listOfAssigments.get(temp).getOralMark() + " with (DD/MM/YYYY): ");
                    listOfAssigments.get(temp).setOralMark(sc.nextInt());
                    System.out.println("New oral mark is " + listOfAssigments.get(temp).getOralMark() + ".");
                    editAssigment();

                    break;
                case ("5"):

                    System.out.print("Change current total mark  " + listOfAssigments.get(temp).getTotalMark() + " with (DD/MM/YYYY): ");
                    listOfAssigments.get(temp).setTotalMark(sc.nextInt());
                    System.out.println("New total mark is " + listOfAssigments.get(temp).getTotalMark() + ".");
                    editAssigment();
                    break;
                case ("6"):
                    editMenu();
                    break;

            }

        }
    }

//============================ASSIGN DATA============================
    public static void assignMenu() {
        /*the idea behind the following design plan is that there are 
        courses with specific trainers, assigments and student. */

        //COURSES IF EMPTY
        if (listOfCourses.isEmpty()) { // Checking if list is empty.
            System.out.println("Courses list is empty please add courses from add menu.");
            inputMenu();
        }

        System.out.println("==================================================================================");
        System.out.println("1. Assign trainers, students and assigments to selected course.");
        System.out.println("2. Back to main menu.");
        System.out.println("==================================================================================");
        System.out.print("\n" + "Choose from 1 to 2: ");

        int menuInput = sc.nextInt();
        switch (menuInput) {
            case (1):
                System.out.println("ALL AVAILABLE COURSES");
                quickAllCourses();
                System.out.println("Please choose a course you want to use from 1 to " + listOfCourses.size() + " as mentioned above.");
                int courseIndex = sc.nextInt() - 1; // input for course index -1 to gain the right possistion of the list
                if ((courseIndex < 0) || (courseIndex >= listOfCourses.size())) { //
                    System.out.println("Invalid input please try again.");
                    assignMenu();

                }
                Course tempCourse = listOfCourses.get(courseIndex);//the chosen course of the user input for later usage

                CourseCombinationClass ccc = new CourseCombinationClass(tempCourse, combineCourseTrainer(), combineCourseAssignment(), combineCourseStudent());
                ccList.add(ccc);
                assignMenu();
                break;
            case (2):
                mainMenu();
                break;
        }

    }

    public static List<Student> combineCourseStudent() {
        String menuInput;
        List<Student> studentsList = new ArrayList<>();
        do {
            System.out.println("Type ADD to assign a new student to selected course or type NEXT and press enter to continue.");
            menuInput = sc.next();
            switch (menuInput) {// end input if the user wants to exit input routine and return to main menu.

                case ("next"):// 3 alternative answers for the user
                case ("NEXT"):
                case ("Next"):
                    break;
                case ("add"): // routine for the user to select trainer
                case ("Add"): // routine for the user to select trainer
                case ("ADD"): // routine for the user to select trainer
                    System.out.println("Please choose a student you want to assign to selected course");
                    quickAllStudents();
                    System.out.print("\n" + "Choose from 1 to " + (listOfStudents.size()) + ": ");
                    int tempIndex = sc.nextInt() - 1;
                    studentsList.add(listOfStudents.get(tempIndex));
                    break;
            }

        } while (!(menuInput.equals("next") || menuInput.equals("Next") || menuInput.equals("NEXT")));

        return studentsList;

    }

    public static List<Trainer> combineCourseTrainer() {
        String menuInput;
        List<Trainer> trainersList = new ArrayList<>();
        do {
            System.out.println("Type ADD to assign a new trainer to selected course or type NEXT and press enter to continue.");
            menuInput = sc.next();
            switch (menuInput) {// end input if the user wants to exit input routine and return to main menu.

                case ("next"):// 3 alternative answers for the user
                case ("NEXT"):
                case ("Next"):
                    break;
                case ("add"): // routine for the user to select trainer
                case ("Add"): // routine for the user to select trainer
                case ("ADD"): // routine for the user to select trainer
                    System.out.println("Please choose a trainer you want to assign to selected course");
                    quickAllTrainers();
                    System.out.print("\n" + "Choose from 1 to " + (listOfTrainers.size()) + ": ");
                    int tempIndex = sc.nextInt() - 1;
                    trainersList.add(listOfTrainers.get(tempIndex));
                    break;
            }

        } while (!(menuInput.equals("next") || menuInput.equals("Next") || menuInput.equals("NEXT")));

        return trainersList;
    }

    public static List<Assigment> combineCourseAssignment() {
        String menuInput;
        List<Assigment> assigmentsList = new ArrayList<>();
        do {
            System.out.println("Type ADD to assign a new assigment to selected course or type NEXT and press enter to continue.");
            menuInput = sc.next();
            switch (menuInput) {// end input if the user wants to exit input routine and return to main menu.

                case ("next"):// 3 alternative answers for the user
                case ("NEXT"):
                case ("Next"):
                    break;
                case ("add"): // routine for the user to select trainer
                case ("Add"): // routine for the user to select trainer
                case ("ADD"): // routine for the user to select trainer
                    System.out.println("Please choose an assigment you want to assign to selected course");
                    quickAllAssigments();
                    System.out.print("\n" + "Choose from 1 to " + (listOfAssigments.size()) + ": ");
                    int tempIndex = sc.nextInt() - 1;
                    assigmentsList.add(listOfAssigments.get(tempIndex));
                    break;
            }

        } while (!(menuInput.equals("next") || menuInput.equals("Next") || menuInput.equals("NEXT")));

        return assigmentsList;

    }

//============================QUICK PRINTS============================
//here we use methods to print a summery of the data lists
    public static void quickAllStudents() {
        for (int i = 0; i < listOfStudents.size(); i++) {
            System.out.println((i + 1) + ". " + listOfStudents.get(i).getFirstName() + " " + listOfStudents.get(i).getLastName());

        }
    }

    public static void quickAllTrainers() {
        for (int i = 0; i < listOfTrainers.size(); i++) {
            System.out.println((i + 1) + ". " + listOfTrainers.get(i).getFirstName() + " " + listOfTrainers.get(i).getLastName());

        }
    }

    public static void quickAllCourses() {
        for (int i = 0; i < listOfCourses.size(); i++) {
            System.out.println((i + 1) + ". " + listOfCourses.get(i).getTitle() + " " + listOfCourses.get(i).getType() + " " + listOfCourses.get(i).getStream());

        }
    }

    public static void quickAllAssigments() {
        for (int i = 0; i < listOfAssigments.size(); i++) {
            System.out.println((i + 1) + ". " + listOfAssigments.get(i).getTitle() + " " + listOfAssigments.get(i).getDescription());

        }
    }

    public static void quickPrintCombinedCourse() {
        System.out.println("\n" + "All available combined courses.");
        System.out.println("===============================");
        for (int i = 0; i < ccList.size(); i++) {
            System.out.println((i + 1) + ". " + ccList.get(i).getCourse().getTitle() + " " + ccList.get(i).getCourse().getStream() + " " + ccList.get(i).getCourse().getType());
        }
        System.out.println("===============================");
        System.out.print("\n" + "Choose from 1 to " + ccList.size() + ": ");

    }
}
