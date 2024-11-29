package Manager;
import Constant.Constants;
import Constant.Rank;
import Object.*;

import java.io.*;
import java.util.*;

import static Utils.CheckInputUtil.*;
import static Utils.PrintUtil.rankStudent;
import static Utils.PrintUtil.showTitle;
import static Utils.SwitchUtil.listRank;
import static Utils.SwitchUtil.updateInfo;


public class StudentArrayList {

    static Scanner sc = new Scanner(System.in);
    public static List<Student> list = new ArrayList<>();
    public static void inputList(){
        if(checkDuplicateStudentID(list)){
            list.add(StudentArray.input());
        }
        System.out.println("Add successful <3");
        System.out.println("-------------------");
        showList();
    }
    public static void showList(){
        if(checkArrayListNull(list)){
            showTitle();
            int count = 0;
            for (Student student: list){
                student.setId(++count);
                if(checkDuplicateData(list)) {
                    System.out.println(student);
                }
            }
        }
    }
    public static void readFromFile() {
        try {
            File file = new File(Constants.FILE_URL);
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<Student> students;
            Object object = objectInputStream.readObject();
            if (object != null) {
                students = (List<Student>) object;
                list.addAll(students);
            }
            System.out.println(" Read file students succeed!");
            if(checkDuplicateData(list)){
                showList();
            }
            objectInputStream.close();
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void writeToFile(){
        File file = new File((Constants.FILE_URL));
        try{
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            System.out.println(" Write file students succeed!");
            objectOutputStream.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void SynchronizeData(Student[] students){
        Collections.addAll(list, students);
    }
    public static void searchIdList(){
        if(checkArrayListNull(list)){
            System.out.print("\nID search: ");
            try{
                int id = Integer.parseInt(sc.nextLine());
                if(checkFoundStudent(id,list)) {
                showTitle();
                    for (Student student : list) {
                        if (student.getId().equals(id)) {
                            System.out.print(student);
                        }
                    }
                }
            }catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    public static void updateIdList(){
        if(checkArrayListNull(list)){
            System.out.print("\nUpdate ID: ");
            try{
                int id= Integer.parseInt(sc.nextLine());
                if(checkFoundStudent(id,list)) {
                for (Student student:list) {
                    if (student.getId().equals(id) ) {
                        updateInfo(student);
                    }
                }
                showList();
                }
            }catch (NumberFormatException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    public static void deleteIdList(){
        if(checkArrayListNull(list)){
            System.out.print("\nDelete ID: ");
            try{
                int id = Integer.parseInt(sc.nextLine());
                if(checkFoundStudent(id,list)) {
                    list.removeIf(student -> student.getId().equals(id));
                        System.out.println("ID delete succeed ");
                        showList();
                }
            }catch (NumberFormatException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    public static List<Map.Entry<Rank,Integer>> countRank(){
        Map<Rank,Integer> map = new HashMap<>();
        for(Rank rank: Rank.values()){
            map.put(rank,0);
        }
        for (Student student: list){
            Rank rank = student.getRank();
            int count = map.get(rank);
            map.replace(rank,++count);
        }
        return new ArrayList<>(map.entrySet());
    }
    public static void percentRank(){
        List<Map.Entry<Rank,Integer>> countRank = countRank();
        countRank.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        int size = list.size();
        System.out.println("Show list DESC: ");
        for (Map.Entry<Rank,Integer> entry : countRank){
            int count = entry.getValue();
            Rank rank = entry.getKey();
            float percent = count * 100f/size;
            System.out.printf("%-10s %10s", rank.toString(), percent + " %");
            System.out.println();
        }
    }
    public static List<Map.Entry<Float,Integer>> countGPA(){
        Map<Float,Integer> map = new HashMap<>();
        for(Student student: list){
            float gpa = student.getGpa();
            if(map.containsKey(gpa)){
                int count = map.get(gpa);
                map.put(gpa,++count);
                continue;
            }
            map.put(gpa,1);
        }
        return new ArrayList<>(map.entrySet());
    }
    public static void percentMedianScore(){
        if (checkArrayListNull(list)){
            List<Map.Entry<Float,Integer>> mapList = countGPA();
            mapList.sort(Map.Entry.comparingByValue());
            int size = list.size();
            System.out.println("Show list %MedianScore: ");
            for(Map.Entry<Float,Integer> entry: mapList){
                float gpa = entry.getKey();
                int count = entry.getValue();
                float percent = count*100f/size;
                System.out.printf("%-10s %15s",gpa,percent+" %");
                System.out.println();
            }
        }
    }
    public static void showListRank() {
        if (checkArrayListNull(list)){
            rankStudent();
            int n = Integer.parseInt(sc.nextLine());
            showTitle();
            try{
                for(Student student: list){
                    listRank(n,student);
                }
            }catch (NumberFormatException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
