import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private String details;

    public Student(String name, int rollNumber, String grade, String details) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getDetails() {
        return details;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                break;
            }
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("Roll Number: " + student.getRollNumber());
            System.out.println("Grade: " + student.getGrade());
            System.out.println("Details: " + student.getDetails());
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) { 
        StudentManagementSystem smanage = new StudentManagementSystem();
        Scanner sc=new Scanner(System.in);

        //Some students data
        Student student1 = new Student("Dharshith", 1, "A", "Some details about Dharshith");
        Student student2 = new Student("Suresh", 2, "Z", "Some details about Suresh");
        Student student3 = new Student("Prashanth", 3, "A", "Some details about Prashanth");
        smanage.addStudent(student1);
        smanage.addStudent(student2);
        smanage.addStudent(student3);
        System.out.println("Student Management System\nA : For Adding a Student\nB : For Viewing all the Students\nC : For Removing a Student\nD : For Searching a Student\nE : Exit");
        char var;
        do {
           System.out.println("************************************");
           System.out.println("Enter your Option");
           System.out.println("************************************");
           var = sc.next().charAt(0);
           switch (var) {
              case 'A':
                 System.out.println("------------------------------------");
                 System.out.print("How many Students you want to enter:");int num=sc.nextInt();
                 sc.nextLine();
                 for(int i=0;i<num;i++){
                 System.out.println("For adding a student enter the below details");
                 System.out.print("Enter the name:");String name=sc.nextLine();
                 System.out.print("Occupied roll numbers are:");
                 for(int j=1;j<=10;j++){
                   Student student = smanage.searchStudent(j);
                 if (student != null) {
                    System.out.print(student.getRollNumber()+" ");
                 }}                      
                 System.out.print("\nEnter the Rollnumber:");int roll_number=sc.nextInt(); 
                 System.out.print("Enter the grade:");String grade=sc.next();
                 sc.nextLine();
                 System.out.print("Enter the other details of the student:");String details=sc.nextLine();     
                 smanage.addStudent(new Student(name,roll_number,grade,details));
                 }
                 System.out.println("------------------------------------");
                 System.out.println("\n");
                 break;
              case 'B':
                 System.out.println("------------------------------------");
                 System.out.println("Displaying all the students");
                 smanage.displayAllStudents();
                 System.out.println("------------------------------------");
                 System.out.println("\n");
                 break;
              case 'C':
                 System.out.println("------------------------------------");
                 System.out.println("For removing a student enter the respective roll number:");
                 int rn=sc.nextInt();
                 smanage.removeStudent(rn);
                 System.out.println("------------------------------------");
                 System.out.println("\n");
                 break;
              case 'D':
                 System.out.println("------------------------------------");
                 System.out.println("For searching a student enter the respective roll number:");
                 int s=sc.nextInt();
                 Student student = smanage.searchStudent(s);
                 if (student != null) {
                    System.out.println("Student found");
                    System.out.println("Name: " + student.getName());
                    System.out.println("Roll Number: " + student.getRollNumber());
                    System.out.println("Grade: " + student.getGrade());
                    System.out.println("Details: " + student.getDetails());
                } else {
                    System.out.println("Student not found.");
                }
                 System.out.println("--------------------------------------");
                 System.out.println("\n");
                 break;
              default:
                 System.out.println("Invalid option!! please enter one of the valid options: A,B,C,D,E");
                 break;
              case 'E':
                 System.out.println("Preparing to exit...");
           }
        } while(var != 'E');
    }
}