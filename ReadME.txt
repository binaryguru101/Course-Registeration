
Overview

This is a terminal-based University Course Registration System that allows students, professors, and administrators to interact with the system. Students can register for courses, view registered courses, drop courses, and check grades. Professors can view enrolled students, and administrators can manage the catalog, assign professors, update records, and handle complaints.

Features:

Student Functionalities:

View available courses
Register and drop courses
View schedule and grades
File and track complaints
Professor Functionalities:

View students enrolled in their courses
Admin Functionalities:

Manage courses (add/remove)
Assign professors to courses
Handle complaints from students
How to Run the Program
Compile the program preferably in an IDE and run 



Class Descriptions

Main.java
The entry point of the system. It presents the main menu where users can log in as a student, professor, or administrator, and interact with the respective functionalities.

Student.java
Represents a student user. Handles course registration, dropping courses, viewing schedules, grades, and managing complaints.

Professor.java
Represents a professor user. Professors can view the students enrolled in the courses they are teaching.

Admin.java
Represents the admin user responsible for managing the course catalog, assigning professors to courses, and handling student complaints.

Courses.java
Defines the structure of a course, including course code, title, prerequisites, enrolled students, and assigned professor.

Complaint.java
Handles the creation and tracking of student complaints, storing complaint descriptions, statuses, resolution details, and associated students.

Catalog.java
Maintains a list of courses available in the system. Handles adding, removing, and finding courses by their course codes.

Complaints.java (Interface)
Defines the contract for handling complaints with methods to get and set the description, status, and resolution details.

OOP Concepts Used
1. Encapsulation:
Each class encapsulates its own data and exposes necessary functionalities through public methods. For example, the Student class holds information about registered courses and complaints, providing methods to modify these attributes.

2. Inheritance:
The Student, Professor, and Admin classes inherit from a common User class, reusing common attributes such as name, ID, and email.

3. Polymorphism:
Polymorphism is used in handling complaints, where different types of complaints can be managed uniformly through the Complaints interface.

4. Abstraction:
The Complaints interface abstracts the common functionalities of complaints, making the system flexible for handling different types of complaints.

(---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------)



When you run the program, you’ll be greeted with a main menu that allows you to:

Login as a Student
Login as a Professor
Login as an Admin
Exit the program
Student Menu


View All Courses: Lists all available courses.

View Registered Courses: Displays all the courses you are currently registered for.

Register for a Course: Register for a course by entering the course code.

Drop a Course: Drop a registered course.

View Schedule: Shows your weekly schedule based on registered courses.

View Grades: Displays your grades for completed courses.

Add Complaint: Submit a new complaint to the admin.

View Complaint Status: Check the status of your submitted complaints.

Log out: Exit the student menu and return to the main menu.


Professor Menu
View Students: View students enrolled in a specific course you are teaching.

Update Grades: Update the grades of students in your course.

Log out: Exit the professor menu and return to the main menu.





Admin Menu
View Courses: View all available courses and manage them (add or remove courses).

Assign Professors: Assign a professor to a course.

Update Student Records: Update student marks and semester.

View Complaints: View all submitted complaints and resolve them.

Log out: Exit the admin menu and return to the main menu.



