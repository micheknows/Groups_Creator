import javax.swing.*;

public class Buttons extends JButton {

    public Buttons(){
        super();
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
}
