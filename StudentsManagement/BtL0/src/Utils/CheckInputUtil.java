package Utils;

import Constant.Constants;
import Object.Student;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class CheckInputUtil {
    static Scanner sc = new Scanner(System.in);
    public static String studentID() {
        do {
            System.out.println("-------------------- ");
            System.out.print("\nStudent id: ");
            String studentID = sc.nextLine();
            if (studentID != null && studentID.length() == Constants.MAX_LENGTH_STUDENTID ) {
                return studentID;
            }
            else {
                System.out.println("Student has "+Constants.MAX_LENGTH_STUDENTID+" characters ");
            }
        }
        while (true);
    }
    public static String name(){
        do{
            System.out.print("\nName: ");
            String name= sc.nextLine();
            if(!name.isEmpty() && name.length()< Constants.MAX_LENGTH_NAME){
                return name;
            }else {
                System.out.println("Max name is "+Constants.MAX_LENGTH_NAME+" characters");
            }
        }
        while (true);
    }
    public static String address(){
        do {
            System.out.print("\nAddress: ");
            String address = sc.nextLine();
            if(!address.isEmpty() && address.length()< Constants.MAX_LENGTH_ADDRESS){
                return address;
            }else {
                System.out.println("Max address is "+Constants.MAX_LENGTH_ADDRESS+" characters");
            }
        }while (true);
    }

    public static Float height(){
        do {
            try{
                System.out.print("\nHeight(cm): ");
                float height = Float.parseFloat(sc.nextLine());
                if(height>= Constants.MIN_HEIGHT && height<= Constants.MAX_HEIGHT ){
                    return height;
                }else {
                    System.out.println("Height: "+Constants.MIN_HEIGHT+" - "+Constants.MAX_HEIGHT);
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
    public static Float weight(){
        do {
            try{
                System.out.print("\nWeight(kg): ");
                float weight = Float.parseFloat(sc.nextLine());
                if(weight>= Constants.MIN_WEIGHT&& weight<= Constants.MAX_WEIGHT){
                    return weight;
                }else {
                    System.out.println("Weight: "+Constants.MIN_WEIGHT+" - "+Constants.MAX_WEIGHT);
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
    public static String school(){
        do{
            System.out.print("\nUniversity: ");
            String school = sc.nextLine();
            if(!school.isEmpty() && school.length()< Constants.MAX_LENGTH_SCHOOL){
                return school;
            }else {
                System.out.println("Max University = "+Constants.MAX_LENGTH_SCHOOL+" characters");
            }
        }while (true);
    }
    public static int yearStart(){
        do {
            try{
                System.out.print("\nYear Start: ");
                int yearStart = Integer.parseInt(sc.nextLine());
                if((yearStart >= Constants.MIN_YEAR) && (yearStart <= Constants.MAX_YEAR) ){
                    return yearStart;
                }else {
                    System.out.print("Year Start: "+Constants.MIN_YEAR+"- "+Constants.MAX_YEAR+" !!!");
                }}catch (NumberFormatException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (true);
    }
    public static Float gpa(){
        do {
            try {
                System.out.print("\nGPA: ");
                float gpa = Float.parseFloat(sc.nextLine());
                if(gpa>= Constants.MIN_GPA && gpa<= Constants.MAX_GPA){
                    return gpa;
                }else {
                    System.out.println("GPA: "+Constants.MIN_GPA+" - "+Constants.MAX_GPA);
                }
            }catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
        }while (true);
    }
    public static LocalDate birthday(int year){
        do{
            try{
                System.out.print("\nBirthday(yyyy-LL-dd): ");
                String date = sc.nextLine();
                LocalDate birthday = LocalDate.parse(date);
                if(birthday.getYear()>= Constants.MIN_YEAR&&birthday.getYear()<= Constants.MAX_YEAR && year > birthday.getYear()){
                    return birthday;
                }else {
                    System.out.println("Year birthday: "+Constants.MIN_YEAR+" - "+Constants.MAX_YEAR +" and < Year Start: "+year);
                }
            }catch (DateTimeParseException e){
                System.out.println("Error: "+e.getMessage());
            }
        }while (true);
    }
    public static boolean checkNull(Student[] students){
        if(students == null){
            System.out.println("List student: null! ");
            return false;
        }
        return true;
    }
    public static boolean checkArrayListNull(List<Student> list){
        if(list.size()==0){
            System.out.println("List student: null! ");
            return false;
        }
        return true;
    }
    public static boolean checkFound(int id,Student[] students){
        for(Student student: students){
            if (student.getId().equals(id)) {
                return true;
            }
        }
        System.out.println("Not Found! ");
        return false;
    }
    public static boolean checkFoundStudent(int id,List<Student> list){
        for(Student student: list){
            if (student.getId().equals(id)) {
                return true;
            }
        }
        System.out.println("Not Found! ");
        return false;
    }
    public static boolean checkDuplicateData(List<Student> list) {
        for(int i=0;i< list.size();i++){
            for (int j=i+1;j< list.size();j++){
                if(list.get(i).getStudentId().equals(list.get(j).getStudentId())){
                    list.remove(list.get(j));
                    j--;
                }
            }
        }
        return true;
    }

    public static boolean checkDuplicateStudentID(List<Student> list){
        for(int i=0;i< list.size();i++){
            for (int j=i+1;j< list.size();j++){
                if(list.get(i).getStudentId().equals(list.get(j).getStudentId())){
                    System.out.println("Duplicate studentID!");
                    return false;
                }
            }
        }
        return true;
    }

    public static Float randomGPA(){
        return (float) (Math.random()*(Constants.MAX_GPA));
    }
    public static Float randomHeight(){
        return (float) (Math.random()*(Constants.MAX_HEIGHT- Constants.MIN_HEIGHT+1)+ Constants.MIN_HEIGHT);
    }
    public static Float randomWeight(){
        return (float) (Math.random()*(Constants.MAX_WEIGHT- Constants.MIN_WEIGHT+1)+ Constants.MIN_WEIGHT);
    }
    public static Integer randomYearStart(){
        return (int) (Math.random() * (Constants.MAX_YEAR - Constants.MIN_YEAR + 1) + Constants.MIN_YEAR);
    }
    public static LocalDate randomBirthday(){
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        int randomDay = ThreadLocalRandom.current().nextInt(0,randomYearStart());
        return startDate.plusDays(randomDay);
    }

}
