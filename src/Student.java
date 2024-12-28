import java.util.List;

public class Student extends User {
    private int semester;
    private List<Courses> Registered_Courses;
    private List<Courses>Completed_Courses;

    public Student(int ID, String email, String name, int semester,
                   List<Courses> registered_Courses, List<Courses> completed_Courses) {
        super(ID, email, name);
        this.semester = semester;
        this.Registered_Courses = registered_Courses;
        this.Completed_Courses = completed_Courses;
    }

    public void View_Course(Catalog sub){
        System.out.println("Offered Courses are: ");
        sub.viewallsubjects();
    }

    public void Add_Course(Courses Course){
        if(!Registered_Courses.contains(Course)){
            Registered_Courses.add(Course);
            System.out.println("Added Course: " + Course);
        }else{
            System.out.println("Course already registered");
        }
    }

    public void Drop_Course(Courses Course){
        if(Registered_Courses.contains(Course)){
            Registered_Courses.remove(Course);
            System.out.println("Removed Course: " + Course);
        }else{
            System.out.println("Course not registered");
        }
    }

    public void View_Schedule(){
        for(Courses C : Registered_Courses){
            System.out.println(C.getTiming()+"\n");
        }
    }

    public void ViewGrades(){
        if(Registered_Courses.isEmpty()){
            System.out.println("No courses registered");
            return;
        }
        for(Courses C : Registered_Courses){
            System.out.println(conversion(C.getGrade())+" -->"+C.getCourseCode());
        }

    }

    private double conversion(String G){
        return switch (G) {
            case "A+" -> 10.00;
            case "A" -> 9.00;
            case "B" -> 8.00;
            case "C" -> 5.00;
            case "D" -> 4.00;
            default -> 0.00;
        };
    }
    //fix
    public double SGPA(){
        double totalpoints=0.0;
        double totalcredit=0.0;
        int totalCourses=Registered_Courses.size();
        if (totalCourses==0){
            System.out.println("No Courses Registered");
        }
        for(Courses C : Registered_Courses){
            if(C.getGrade()==null){
                System.out.println("Course "+C.getCourseCode()+"  not Graded");
                return -1;
            }
            totalpoints+=conversion(C.getGrade());
            totalcredit+=C.getCredit();
        }
        return totalcredit==0 ? 0 : totalpoints/totalcredit;

    }


    public double CGPA(){
        double totalpoints=0.0;
        double totalcredit=0.0;
        int totalCourses=Completed_Courses.size();
        if (totalCourses==0){
            System.out.println("No Courses Registered");
        }
        for(Courses C : Completed_Courses){
            if(C.getGrade()==null){
                System.out.println("Course "+C.getCourseCode()+"  not Graded");
                return -1;
            }
            totalpoints+=conversion(C.getGrade());
            totalcredit+=C.getCredit();
        }
        return totalcredit==0 ? 0 : totalpoints/totalcredit;

    }

    private boolean AllGraded(){
        for(Courses C : Registered_Courses){
            if(C.getGrade()==null){
                System.out.println("Course "+C.getCourseCode()+"  not Graded");
                return false;
            }
        }
        return true;
    }
    private  double totalCred(){
        double totalCredit=0;
        for(Courses C : Registered_Courses){
            totalCredit+=C.getCredit();
        }
        return totalCredit;
    }

    public boolean RegisterCourse(Courses Subject,List<Courses> AvailiableCourses) {
        if (!AvailiableCourses.contains(Subject)) {
            System.out.println("Course " + Subject.getCourseCode() + " not Registered");
            return false;
        }
        for (String prerequisite : Subject.getPreReq()) {
            boolean completed = Completed_Courses.stream().anyMatch(x -> x.getCourseCode().equals(prerequisite));
            if (!completed) {
                System.out.println("Course " + Subject.getCourseCode() + " has unfulfilled prerequisites");
                return false;
            }

        }
        if (!AllGraded()) {
            System.out.println("Course " + Subject.getCourseCode() + " not Graded");
            return false;
        }

        if (totalCred() > 20) {
            System.out.println("Cred CAP reached");
        }
        if (Subject.enrollstudent(this)) {
            Registered_Courses.add(Subject);
            System.out.println("Course " + Subject.getCourseCode() + " registered");

        }
        return true;
    }




    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<Courses> getRegistered_Courses() {
        return Registered_Courses;
    }

    public void setRegistered_Courses(List<Courses> registered_Courses) {
        Registered_Courses = registered_Courses;
    }

    public List<Courses> getCompleted_Courses() {
        return Completed_Courses;
    }

    public void setCompleted_Courses(List<Courses> completed_Courses) {
        Completed_Courses = completed_Courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "semester=" + semester +
                ", Registered_Courses=" + Registered_Courses +
                ", Completed_Courses=" + Completed_Courses +
                "} " + super.toString();
    }
}
