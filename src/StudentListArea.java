import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class StudentListArea extends JList {

    private ArrayList<String> students;
    private Students s;
    private boolean isPresent;


    public StudentListArea(boolean isPresent){
        this.isPresent = isPresent;
        this.s = new Students();
        this.getStudentList();
        this.setFixedCellWidth(100);
        if(this.isPresent){
            this.setListData(this.s.getnames(s.getPresent()).toArray());
        } else {
            this.setListData(this.s.getnames(s.getAbsent()).toArray());
        }
    }

    public void setStudentList(){

        if(this.isPresent){
            this.setListData(this.s.getnames(s.getPresent()).toArray());
        } else {
            this.setListData(this.s.getnames(s.getAbsent()).toArray());
        }
    }

    public void  getStudentList(){
        this.students = this.s.loadStudents();
    }
}
