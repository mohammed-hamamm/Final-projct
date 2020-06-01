/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course;

/**
 *
 * @author Extreme
 */
public class course {
    private String id;
    private  String name;
    private String hours;
    private String grade;

    public course() {
        
    }

    public course(String id, String name, String hours, String grade) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10s %8.2f", id,name,hours,grade);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
    
    
    
}
