package Object;

import Constant.Constants;
import Constant.Rank;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person implements Serializable {
    private String studentId;
    private String school;
    private Integer yearStart;
    private Float gpa;
    private Rank rank;

    public Student(){super();}
    public String getStudentId() {
        return studentId;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Student(Integer id, String name, String address, Float height, Float weight, LocalDate birthday, String studentId, String school, Integer yearStart, Float gpa, Rank rank) {
        super(id, name, address, height, weight, birthday);
        this.studentId = studentId;
        this.school = school;
        this.yearStart = yearStart;
        this.gpa = gpa;
        this.rank = rank;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void checkRank(){
        if(getGpa()< Constants.GPA_WEAK){
            this.rank = Rank.POOR;
        }else if (getGpa()<Constants.GPA_AVERAGE){
            this.rank= Rank.WEAK;
        }else if (getGpa()<Constants.GPA_GOOD){
            this.rank= Rank.AVERAGE;
        } else if (getGpa()<Constants.GPA_VERY_GOOD) {
            this.rank= Rank.GOOD;
        } else if (getGpa()<Constants.GPA_EXCELLENT) {
            this.rank= Rank.VERY_GOOD;
        } else {
            this.rank= Rank.EXCELLENT;
        }
    }
    @Override
    public String toString(){
        return String.format("%-15s%-12s|%-15s|%-10d|%-10.2f|%s",super.toString(),
                studentId,school,yearStart,gpa,rank);

    }
}
