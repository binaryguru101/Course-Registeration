import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String courseName;
    private String courseCode;
    private int Credit;
    private int semester;
    private Professor Professor;
    private String Timing;
    private String Syllabus;
    private List<String> PreReq;
    private int limit;
    private String grade;
    private List<Student> Enrolled_Students;

    public Courses(String courseName, String courseCode,int Credit,
                   int semester,Professor professor, String timing,
                   String syllabus, List<String> preReq, int limit
            , String grade) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.Credit = Credit;
        this.semester = semester;
        Professor = null;
        Timing = timing;
        Syllabus = syllabus;
        PreReq = preReq;
        this.limit = limit;
        this.grade = grade;
        this.Enrolled_Students = new ArrayList<>();

    }

    public boolean enrollstudent(Student student){
        if(Enrolled_Students.size()<limit){
            Enrolled_Students.add(student);
            return true;
        }
        else{
            System.out.println("Enrolled Student is Full");
            return false;
        }

    }


    public List<Student> getEnrolled_Students() {
        return Enrolled_Students;
    }

    public void setEnrolled_Students(List<Student> enrolled_Students) {
        Enrolled_Students = enrolled_Students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Professor getProfessor() {
        return Professor;
    }

    public void setProfessor(Professor professor) {
        Professor = professor;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String timing) {
        Timing = timing;
    }

    public String getSyllabus() {
        return Syllabus;
    }

    public void setSyllabus(String syllabus) {
        Syllabus = syllabus;
    }

    public List<String> getPreReq() {
        return PreReq;
    }

    public void setPreReq(List<String> preReq) {
        PreReq = preReq;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", Credit=" + Credit +
                ", semester=" + semester +
                ", Professor=" + Professor +
                ", Syllabus='" + Syllabus + '\'' +
                ", PreReq=" + PreReq +

                '}';
    }
}


