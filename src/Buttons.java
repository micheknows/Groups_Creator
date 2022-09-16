import javax.swing.*;
import java.awt.*;

public class Buttons extends JButton {

    public static BuddyTalks bt;
    private static Students students;
    private static StudentWindow sw;

    public Buttons(Students students, StudentWindow sw){
        super();
        this.students = students;
        this.sw = sw;
        this.bt = new BuddyTalks(students, sw);
    }

    // tool buttons with image
    public Buttons(Icon icon, String cmd, String tooltip){
        super(icon);
        this.setToolTipText(tooltip);
        switch (cmd){
            case "popsicle":
                this.addActionListener(e -> new PopsicleSticks(students, sw));
                break;
            case "buddy":
                this.addActionListener(e -> this.bt.doBuddyTalk());
                break;
            case "clear":
                this.addActionListener(e -> this.clear());
                break;
        }
    }

    public void clear() {
        sw.centerside.removeAll();
        sw.centerside.validate();
        sw.centerside.repaint();
    }

    // attendance buttons with text
    public Buttons(String text, String cmd){
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
