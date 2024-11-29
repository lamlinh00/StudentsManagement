package Utils;
import Constant.Rank;
import Object.*;
import Manager.StudentArray;
import Manager.StudentArrayList;

import static Manager.StudentArrayList.SynchronizeData;
import static Utils.CheckInputUtil.*;
import static Utils.PrintUtil.*;

public class SwitchUtil {
    static StudentArray array = new StudentArray();
    static Student[] students = null;

    public static void updateInfo(Student student){
        updateItem();
        int n = Integer.parseInt(sc.nextLine());
        try {
            switch (n) {
                case 1 -> student.setName(name());
                case 2 -> student.setBirthday(birthday(student.getYearStart()));
                case 3 -> student.setAddress(address());
                case 4 -> student.setWeight(weight());
                case 5 -> student.setHeight(height());
                case 6 -> student.setSchool(school());
                case 7 -> student.setYearStart(yearStart());
                case 8 -> {student.setGpa(gpa());student.checkRank();}
            }}catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
    public static void arrayStudent(){
        boolean check = true;
        while (check){
        menuStudentArray();
        int n = Integer.parseInt(sc.nextLine());
        switch (n){
            case 1 ->{
                students = array.arrStudent();
                array.showArr(students);
            }
            case 2 ->
                    array.showArr(students);
            case 3 ->
                    array.searchId(students);
            case 4 ->
                    array.updateId(students);
            case 5 ->{
                    if(checkNull(students)){
                    Student[] student = new Student[students.length-1];
                    if(array.deleteId(students,student)){
                        students=student;
                    }
                }
            }
            case 6 ->
                    SynchronizeData(students);
            case 0 ->
                    check = false;
            default ->
                    System.out.println("Reselect !!!");

        }}
    }
    public static void arrayListStudent(){
        boolean check = true;
        while (check){
        menuStudentArrayList();
        int n = Integer.parseInt(sc.nextLine());
        switch (n){
            case 1->
                    StudentArrayList.inputList();
            case 2->
                    StudentArrayList.showList();
            case 3->
                    StudentArrayList.searchIdList();
            case 4->
                    StudentArrayList.updateIdList();
            case 5 ->
                    StudentArrayList.deleteIdList();
            case 6 ->
                    StudentArrayList.percentRank();
            case 7 ->
                    StudentArrayList.percentMedianScore();
            case 8 ->
                    StudentArrayList.showListRank();
            case 9 ->
                    StudentArrayList.readFromFile();
            case 10 ->
                    StudentArrayList.writeToFile();
            case 0 ->
                    check=false;
            default ->
                    System.out.println("Reselect !!!");
        }}
    }
    public static void listRank(int n, Student student){
        switch (n) {
            case 1 -> {
                if (student.getRank() == Rank.POOR) {
                    System.out.println(student);
                }
            }
            case 2 -> {
                if (student.getRank() == Rank.WEAK) {
                    System.out.println(student);
                }
            }
            case 3 -> {
                if (student.getRank() == Rank.AVERAGE) {
                    System.out.println(student);
                }
            }
            case 4 -> {
                if (student.getRank() == Rank.GOOD) {
                    System.out.println(student);
                }
            }
            case 5 -> {
                if (student.getRank() == Rank.VERY_GOOD) {
                    System.out.println(student);
                }
            }
            case 6 -> {
                if (student.getRank() == Rank.EXCELLENT) {
                    System.out.println(student);
                }
            }
            default -> System.out.println("Error !!!");
        }
    }
}
