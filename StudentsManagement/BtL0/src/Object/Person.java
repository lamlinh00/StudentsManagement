package Object;
import Manager.StudentArrayList;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
public class Person implements Serializable {
    private Integer id;
    private String name;
    private String address;
    private Float height;
    private  Float weight;
    private LocalDate birthday;
    public static int count= StudentArrayList.list.size();
    static Set<Integer> useID= new HashSet<>();
    protected Person(){
        while (true) {
            count++;
            if (!useID.contains(count)) {
                this.id = count;
                useID.add(count);
                break;
            }
        }
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public Person(Integer id, String name, String address, Float height, Float weight, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static Integer getCount() {
        return count;
    }

    public static void setCount(Integer count) {
        Person.count = count;
    }
    @Override
    public String toString(){
        return String.format("%-3s|%-15s|%-15s|%-15s|%-9.1f|%-9.1f|", id, name, birthday.toString(), address, height, weight);
    }
}
