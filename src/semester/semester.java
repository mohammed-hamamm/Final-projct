/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semester;

/**
 *
 * @author Extreme
 */
public class semester {

    private String ID;
    private String semester;
    private String year;
    private String lecturer_id;

    public semester() {
    }

    @Override
    public String toString() {
        return "semester{" + "id=" + ID + ", semester=" + semester + ", year=" + year + ", lecturer_id=" + lecturer_id + '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(String lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

}
