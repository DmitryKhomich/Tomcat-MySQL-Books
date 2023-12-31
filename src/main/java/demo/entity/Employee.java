package demo.entity;

public class Employee {

    Integer id;
    String name;
    String position;
    String phone;

    public Employee(Integer id){
        this.id = id;
    }

    public Employee(String name, String position, String phone){
        this.name = name;
        this.position = position;
        this.phone = phone;
    }

    public Employee(Integer id, String name, String position, String phone) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
