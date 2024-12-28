import java.util.*;

import static java.util.Arrays.asList;

public class Main {
    private static Catalog catalog = new Catalog();
    private static Map<Integer, Student> students = new HashMap<>();
    private static Map<Integer, Professor> professors = new HashMap<>();
    private static List<Complaint> complaints = new ArrayList<>();
    private static Admin admin;

    // Sample courses
    private static Courses course1 = new Courses("Introduction to Computer Science", "CS101", 4, 1, null, "MWF 10:00-11:00 AM", "Basic", new ArrayList<>(), 30, "A");
    private static Courses course2 = new Courses("Data Structures and Algorithms", "CS202", 4, 2, null, "TR 1:00-2:30 PM", "Study", new ArrayList<>(), 25, "D");
    private static Courses course3 = new Courses("Computer Organisation", "CS303", 4, 2, null, "MW 2:00-3:30 PM", "Introduction", new ArrayList<>(), 20, "C");
    private static Courses course4 = new Courses("Discrete Maths", "C4304", 4, 1, null, "MW 2:00-3:30 PM", "Introduction", new ArrayList<>(), 20, "C");
    private static Courses course5 = new Courses("Basic Electronics ", "CS505", 1, 4, null, "MW 2:00-3:30 PM", "Introduction", new ArrayList<>(), 20, "C");
    private static Courses course6 = new Courses("Database Systems", "CS606", 1, 4, null, "MW 2:00-3:30 PM", "Introduction", new ArrayList<>(), 20, "C");
    private static Courses course7 = new Courses("DSA", "CS707", 4, 2, null, "MW 2:00-3:30 PM", "Introduction", new ArrayList<>(), 20, "C");

    public static void main(String[] args) {
        // Initialize data
        Professor prof1 = new Professor(3021, "prof1@gmail.com", "Mike", new ArrayList<>(), "9-11 MW");
        Professor prof2 = new Professor(2023, "prof2@gmail.com", "Hu", new ArrayList<>(), "11-7 WED-THUR");
        professors.put(prof1.getID(), prof1);
        professors.put(prof2.getID(), prof2);

        Student john1 = new Student(2023566, "203@123", "John", 4, new ArrayList<>(), new ArrayList<>());
        Student amy1 = new Student(2023567, "204@123", "Amy", 4, new ArrayList<>(), new ArrayList<>());
        students.put(john1.getID(), john1);
        students.put(amy1.getID(), amy1);

        admin = new Admin(301, "admin@yahoo.com", "Hu", catalog, students, professors, complaints);

        catalog.addSubject(course1);
        catalog.addSubject(course2);
        catalog.addSubject(course3);
        catalog.addSubject(course4);
        catalog.addSubject(course5);
        catalog.addSubject(course6);
        catalog.addSubject(course7);


//        admin.addcourse(course2);
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to the University Course Registration System");
            System.out.println("1. Signup as a Student");
            System.out.println("2. Signup as a Professor");
            System.out.println("3. Login as Student");
            System.out.println("4. Login as Professor");
            System.out.println("5. Login as Administrator");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(input);
                    break;
                case 2:
                    addProfessor(input);
                    break;
                case 3:
                    handleStudentLogin(input);
                    break;
                case 4:
                    handleProfessorLogin(input);
                    break;
                case 5:
                    handleAdminLogin(input);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        input.close();

    }

    private static void handleStudentLogin(Scanner input) {
        System.out.print("Enter student ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();



        Student student = students.get(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found.");
        }
        else{
            studentmenu(input,student);
        }
    }

    private static void studentmenu(Scanner input, Student student) {
        boolean studentrunning = true;
        while (studentrunning) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View All Courses");
            System.out.println("2. View Registered Courses");
            System.out.println("3. Register for a Course");
            System.out.println("4. View Schedule");
            System.out.println("5. Drop a Course");
            System.out.println("6. View CGPA ");
            System.out.println("7. View SGPA");
            System.out.println("8. View Grades");
            System.out.println("9. Register for a Complaint");
            System.out.println("10. View Complaint Status");
            System.out.println("11. Log out");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    student.View_Course(catalog);
                case 2:
                    List<Courses> registeredCourses = student.getRegistered_Courses();
                    if (registeredCourses.isEmpty()) {
                        System.out.println("No registered courses.");
                    } else {
                        System.out.println("Registered Courses:");
                        for (Courses course : registeredCourses) {
                            System.out.println("Course Code: " + course.getCourseCode() + " | Course Name: " + course.getCourseName());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Course Code to Register: ");
                    String courseCode = input.nextLine();
                    Courses course = catalog.findCourseByCode(courseCode);
                    if (course != null) {
                        List<Courses> availableCourses = catalog.getSubjects();
                        student.RegisterCourse(course, availableCourses);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    student.View_Schedule();
                    break;
                case 5:
                    System.out.print("Enter Course Code to Drop: ");
                    String dropCode = input.nextLine();

                    Courses dropCourse = catalog.findCourseByCode(dropCode);
                    if (dropCourse != null) {
                        student.Drop_Course(dropCourse);
                        System.out.println("Course Dropped.");
                    }else{
                        System.out.println("Course not found.");
                    }
                    break;
                case 6:
                    double CGPA = student.CGPA();
                    System.out.println("YOUR CGPA FOR "+student.getSemester()+" is "+CGPA);

                case 7:
                    double SGPA = student.SGPA();
                    System.out.println("YOUR SGPA FOR "+student.getSemester()+" is "+SGPA);
                    break;
                case 8:
                    student.ViewGrades();
                    break;
                case 9:
                    System.out.print("Enter Complaint Description ");
                    String description = input.nextLine();

                    Complaint complaint= new Complaint(description,student);
                    complaints.add(complaint);

                    System.out.println("Complaint filed with ID: " + complaint.getComplaintID());
                    break;
                case 10:
                    List<Complaint> studentComplaints = new ArrayList<>();

                    for (Complaint comp : complaints) {
                        if(comp.getStudent().equals(student)){
                            studentComplaints.add(comp);
                        }
                    }
                    if (studentComplaints.isEmpty()) {
                        System.out.println("You have not submitted any complaints.");
                    }
                    else {
                        System.out.println("Your Complaints:");
                        for (Complaint comp : studentComplaints) {
                            System.out.println("Complaint ID: " + comp.getComplaintID() +
                                    ", Description: " + comp.getDescription() +
                                    ", Status: " + comp.getStatus() +
                                    ", Resolution: " + comp.getResoloutionDetails());
                        }


                    }
                case 11:
                    studentrunning=false;
                    break;


            }
        }
    }

    private static void handleAdminLogin(Scanner input) {
        System.out.print("Enter admin ID: ");
        int id = input.nextInt();
        input.nextLine();


        System.out.print("Enter password: ");
        String password=input.nextLine();

        String fixedpassword="admin123";

        if(id==admin.getID()){
            adminMenu(input,admin);
            System.out.println("Admin logged in.");
        }
        else{
            System.out.println("Invalid Credentials. Please try again.");
        }
    }

    private static void adminMenu(Scanner input,Admin admin) {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("Administrator Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Professor");
            System.out.println("3. View Course");
            System.out.println("4. Add Course");
            System.out.println("5. Update Student Record");
            System.out.println("6. Update Student Marks");
            System.out.println("7. Assign Prof");
            System.out.println("8  All Complaints  ");
            System.out.println("9. Filter Complaints by Status");
            System.out.println("10. Filter Complaints by Date");
            System.out.println("11. Update Complaint Resolution");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(input);
                    break;
                case 2:
                    addProfessor(input);
                    break;
                case 3:
                    admin.viewallcourses();
                    break;
                case 4:
                    admin.addcourse(input);
                case 5:
                    admin.updateStudentRecord(input);
                    break;
                case 6:
                    admin.updateStudentMarks(input);
                    break;
                case 7:
                    admin.assignprof(input);
                    break;
                case 8:
                    admin.AllComplaints();
                    break;
                case 9:
                    admin.FilterByStatus(input);
                    break;
                case 10:
                    admin.FilterByDate(input);
                    break;
                case 11:
                    admin.updateComplaintResolution(input);
                    break;
                case 12:
                    adminRunning=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }


    private static void handleProfessorLogin(Scanner input) {
        System.out.print("Enter professor ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter professor password");
        String password=input.nextLine();



        Professor professor = professors.get(id);

        if(professor!=null){
            profmenu(input,professor);
        }
        else{
            System.out.println("Invalid Professor ID. Please try again. Or Register a prof with the admin");
        }
    }

    private static void profmenu(Scanner input,Professor prof) {
        boolean professorRunning = true;

        while (professorRunning) {
            System.out.println("\n--- Professor Menu ---");
            System.out.println("1. View Assigned Courses");
            System.out.println("2. View Students in a Course");
            System.out.println("3. Update Course Details");
            System.out.println("4. Log out");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    prof.AllteachingCourses();
                    break;
                case 2:
                    viewStudents(input,prof);
                    break;
                case 3:
                    updateCourseDetails(input,prof);
                    break;
                case 4:
                    professorRunning = false;
                    System.out.println("Logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner input) {
        System.out.print("Enter student ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter Student Password");
        String password = input.nextLine();

        System.out.print("Enter student email: ");
        String email = input.nextLine();

        System.out.print("Enter your current semester: ");
        int semester = input.nextInt();
        input.nextLine();

        List<Courses> registeredcourses = new ArrayList<>();
        List<Courses> completedcourses = new ArrayList<>();

        Student student = new Student(id,email,name,semester,registeredcourses,completedcourses);
        students.put(id, student);
        System.out.println("Student added "+student.getID());
    }

    private static void addProfessor(Scanner input) {
        System.out.print("Enter professor ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter professor name: ");
        String name = input.nextLine();

        System.out.print("Enter Professor Password");
        String password = input.nextLine();

        System.out.print("Enter professor email: ");
        String email = input.nextLine();

        System.out.print("Enter Professors Office Hours: ");
        String officeHours = input.nextLine();

        List<Courses> TeachingCourses = new ArrayList<>();

        Professor professor = new Professor(id,email,name,TeachingCourses,officeHours);
        professors.put(id,professor);
        System.out.println("Proffessor added successfully "+professor.getID());

    }

    private static void viewStudents(Scanner input,Professor prof){
        System.out.println("Enter Course Code: ");
        String courseCode = input.nextLine();

        Courses course = prof.findCourseByCode(courseCode);
        if(course!=null){
            prof.ViewStudents(course);
        }
        else{
            System.out.println("Invalid Course Code. Please try again. OR no students found ");
        }
    }

    private static void updateCourseDetails(Scanner input, Professor professor) {
        System.out.print("Enter Course Code: ");
        String courseCode = input.nextLine();

        Courses course = professor.findCourseByCode(courseCode);
        if (course != null) {
            System.out.print("Enter new syllabus: ");
            String syllabus = input.nextLine();

            System.out.print("Enter new credits: ");
            int credits = input.nextInt();
            input.nextLine(); // Consume newline

            System.out.print("Enter new enrollment limit: ");
            int limit = input.nextInt();
            input.nextLine(); // Consume newline

            System.out.print("Enter prerequisites (comma-separated): ");
            List<String> prerequisites = Arrays.asList(input.nextLine().split(","));

            professor.UpdateDetails(course, syllabus, credits, prerequisites, limit, professor.getOffice_Hours());
            System.out.println("Course details updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }}




