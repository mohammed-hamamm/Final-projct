/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author Extreme
 */
public class students {

    private String ID;
    private String firstname;
    private String lastname;
    private String age;
    private String address;
    private String dept_name;
    private String email;
    private String GPA;

    public students() {
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + ID + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", address=" + address + ", dept_name=" + dept_name + ", email=" + email + ", GPA=" + GPA + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

   

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
