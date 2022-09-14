import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class StudentListArea extends JList {

    private ArrayList<String> students;
    private Students s;


    public StudentListArea(){
        this.s = new Students();
        this.getStudentList();
        this.setFixedCellWidth(200);
        this.setMaximumSize(new Dimension(200,400));
        this.setListData(this.s.getnames(s.getPresent()).toArray());
    }

    public void  getStudentList(){
        this.students = this.s.loadStudents();
    }
}
