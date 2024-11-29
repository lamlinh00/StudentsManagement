package Manager;

import Object.*;
import java.util.Scanner;
import static Utils.CheckInputUtil.*;
import static Utils.PrintUtil.showTitle;
import static Utils.SwitchUtil.updateInfo;

public class StudentArray {
    static Scanner sc = new Scanner(System.in);
    public static Student input(){
        Student student = new Student();
        student.setId(Person.count);
        student.setStudentId(studentID());
        student.setName(name());
        student.setWeight(weight());
        student.setHeight(height());
        student.setYearStart(yearStart());
        student.setAddress(address());
        student.setBirthday(birthday(student.getYearStart()));
        student.setSchool(school());
        student.setGpa(gpa());
        student.checkRank();
        return student;
    }
    public Student[] arrStudent(){
        System.out.print("The number of student: ");
        int n = Integer.parseInt(sc.nextLine());
        Student[] arrStudent= new Student[n];
        System.out.println("1.Automatic\t2.Hand input");
        System.out.print("Choose: ");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1 -> studentData(arrStudent);
            case 2 -> {
                for (int i = 0; i < n; i++) {
                    System.out.println("-------------------- ");
                    System.out.println("Student " + (i + 1) + ": ");
                    arrStudent[i] = input();
                    if(i>0 && arrStudent[i].getStudentId().equals(arrStudent[i-1].getStudentId())){
                        System.out.println("Duplicate StudentID ");
                        arrStudent[i].setStudentId(studentID());
                    }
                }
            }
        }
        System.out.println("Add successful <3");
        System.out.println("-----------------");
        return arrStudent;
    }
    public void studentData(Student[] students) throws RuntimeException {
        for (int i=0;i<students.length;i++){
            Student student = new Student();
            student.setName("0"+(i+1));
            student.setGpa(randomGPA());
            student.setAddress("0"+i);
            student.setSchool("0"+i);
            student.setBirthday(randomBirthday());
            student.setYearStart(randomYearStart());
            student.setHeight(randomHeight());
            student.setWeight(randomWeight());
            student.setStudentId("00"+randomBirthday().getYear()+randomYearStart());
            student.checkRank();
            students[i] = student;
        }
    }
    public void showArr(Student[] students){
        if(checkNull(students)){
            System.out.println("List Student: ");
            showTitle();
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void searchId(Student[] students){
        if(checkNull(students)){
            System.out.print("\nID search: ");
            try{
                int id= Integer.parseInt(sc.nextLine());
                if(checkFound(id,students)){
                    showTitle();
                    for (Student student : students) {
                        if (student.getId() == id) {
                            System.out.println(student);
                        }
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    public void updateId(Student[] students){
        if(checkNull(students)){
            System.out.print("\nUpdate ID: ");
            try {
                int id= Integer.parseInt(sc.nextLine());
                if(checkFound(id,students)){
                    for (Student student : students) {
                        if (student.getId() == id) {
                            updateInfo(student);
                        }
                    }
                    showArr(students);
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean deleteId(Student[] students, Student[] newStudent) {
        boolean check= false;
        System.out.print("\nDelete ID: ");
        try {
            int id = Integer.parseInt(sc.nextLine());
            if(checkFound(id,students)) {
                int pos=0;
                for (Student student : students) {
                    if (student.getId() != id) {
                        newStudent[pos] = student;
                        pos++;
                        check = true;
                    }
                }
                students=newStudent;
                showArr(students);
                System.out.println("--------------------");
            }
        }catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return check;
    }
}
