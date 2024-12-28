import java.util.List;
import java.util.HashMap;

public class Professor extends User {
    private List<Courses> teachingCourses;
    private String Office_Hours;

    public Professor(int ID, String email, String name, List<Courses> teachingCourses, String office_Hours) {
        super(ID, email, name);
        this.teachingCourses = teachingCourses;
        Office_Hours = office_Hours;
    }

    public void ViewStudents(Courses course){
        if(teachingCourses.contains(course)){
            List<Student> enrolledstudents=course.getEnrolled_Students();
            System.out.println("enrolledstudents for " + course.getCourseCode() +" :");
            for(Student student:enrolledstudents){
                System.out.println(student.getName()+" ID "+student.getID());

            }
        }else{
            System.out.println("Not enrolled student for " + course.getCourseCode()+" OR mabye you arent hadling this course");
        }
    }

    public void ViewDetails(Courses course){
        if(!teachingCourses.contains(course)){
            System.out.println("You are NOT teaching this course");
            return;
        }
        System.out.println("Course Details");
        System.out.println("course code" + course.getCourseCode());
        System.out.println("course name" + course.getCourseName());
        System.out.println("timing" + course.getTiming());
        System.out.println("office hours" + Office_Hours);
        System.out.println("Enrollment Limit" + course.getLimit());

    }

    public void UpdateDetails(Courses course,String New_syllabuys,
                              int newCredits, List<String> newPreReq, int newEnrollmentLimit,
                              String newOfficeHours){
        if(teachingCourses.contains(course)){
            System.out.println(course.getCourseCode());

            course.setSyllabus(New_syllabuys);
            course.setCredit(newCredits);
            course.setPreReq(newPreReq);
            course.setLimit(newEnrollmentLimit);
            this.Office_Hours = newOfficeHours;
        }
        else{
            System.out.println("You dont have " + course.getCourseCode());
        }
    }



    public void AllteachingCourses(){
        System.out.println("All teaching courses");
        for(Courses course:teachingCourses){
            System.out.println("Course Code " + course.getCourseCode()+" "+course.getCourseName());
        }
    }

    public Courses findCourseByCode(String courseCode) {
        for (Courses course : teachingCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null; // Return null if the course is not found
    }





    public List<Courses> getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(List<Courses> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    public String getOffice_Hours() {
        return Office_Hours;
    }

    public void setOffice_Hours(String office_Hours) {
        Office_Hours = office_Hours;
    }
}
