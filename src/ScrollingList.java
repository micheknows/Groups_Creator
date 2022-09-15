import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ScrollingList extends JPanel {

    ArrayList<Student> students;
    StudentLists slist;

    String status;

    JLabel topLabel;

    public ScrollingList(ArrayList<Student> studs, String status, int num){
        super();
        this.students = studs;
        this.status = status;
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Label at top
        this.createLabel(status, num);

        slist = new StudentLists(Students.getWholeNameFromStudents(this.students));
        JScrollPane scrollableTextArea = new JScrollPane(slist);
        this.setBorder(new EmptyBorder(new Insets(10, 20, 30, 50)));
        this.add(scrollableTextArea);

        // now add the two buttons in a new panel

    }

    public void resetList(Students myStudents){
        ArrayList<Student> presentStudents = myStudents.getPresentStudents();
        ArrayList<Student> absentStudents = myStudents.getAbsentStudents();
        if(this.status.equals("Present")){
            this.slist.setListData(Students.getWholeNameFromStudents(presentStudents).toArray());
            this.updateLabel("Present", presentStudents.size());
        } else {
            this.students = absentStudents;
            this.slist.setListData(Students.getWholeNameFromStudents(absentStudents).toArray());
            this.updateLabel("Absent", absentStudents.size());
        }

        this.validate();
        this.repaint();
    }


    public void createLabel(String status, int num){
        topLabel = new JLabel(status + " Students :  " + Integer.toString(num));
        this.add(topLabel);
    }

    public void updateLabel(String status, int num){
        topLabel.setText(status + " Students : " + Integer.toString(num));
        this.validate();
        this.repaint();
    }
}
