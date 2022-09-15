import javax.swing.*;
import java.awt.*;

public class Buttons extends JButton {

    public Buttons(){
        super();
    }

    // tool buttons with image
    public Buttons(Icon icon, String cmd, Students students, StudentWindow sw){
        super(icon);
        switch (cmd){
            case "popsicle":
                this.addActionListener(e -> this.popsicle(students, sw));
                break;
            case "clear":
                this.addActionListener(e -> this.clear(students, sw));
                break;
        }
    }

    public void popsicle(Students students, StudentWindow sw) {
        System.out.println("popsicle");
    }
    public void clear(Students students, StudentWindow sw) {
        System.out.println("clear");
    }

    // attendance buttons with text
    public Buttons(String text, String cmd, Students students, StudentWindow sw){
        super(text);
        switch (cmd){
            case "allAbsent":
                this.addActionListener(e -> this.allAbsent(students, sw.presentStudents, sw.absentStudents));
                break;
            case "allPresent":
                this.addActionListener(e -> this.allPresent(students, sw.presentStudents, sw.absentStudents));
                break;
            case "selectedAbsent":
                this.addActionListener(e -> this.selectedAbsent(students, sw.presentStudents, sw.absentStudents));
                break;
            case "selectedPresent":
                this.addActionListener(e -> this.selectedPresent(students, sw.presentStudents, sw.absentStudents));
                break;
        }
    }



    private void allAbsent(Students students, ScrollingList mypresentlist,  ScrollingList myabsentlist){
        students.markALlAbsent();
        mypresentlist.resetList(students);
        myabsentlist.resetList(students);
    }
    private void selectedAbsent(Students students, ScrollingList mypresentlist,  ScrollingList myabsentlist){
        students.markAbsent((String)mypresentlist.slist.getSelectedValue());
        mypresentlist.resetList(students);
        myabsentlist.resetList(students);
    }

    private void allPresent(Students students, ScrollingList mypresentlist, ScrollingList myabsentlist){
        students.markAllPresent();
        mypresentlist.resetList(students);
        myabsentlist.resetList(students);
    }
    private void selectedPresent(Students students, ScrollingList mypresentlist,  ScrollingList myabsentlist){
        students.markPresent((String)myabsentlist.slist.getSelectedValue());
        mypresentlist.resetList(students);
        myabsentlist.resetList(students);
    }
}
