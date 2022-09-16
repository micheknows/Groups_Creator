import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PopsicleSticks {

    private static Students students;
    private static StudentWindow sw;
    public PopsicleSticks(Students students, StudentWindow sw) {
        this.students = students;
        this.sw = sw;
        this.clear();
        sw.centerside.add(createPSwindow());
        this.repack();
    }

    private void repack() {
        this.sw.centerside.validate();
        this.sw.centerside.repaint();
    }


    public void clear() {
        sw.centerside.removeAll();
        sw.centerside.validate();
        sw.centerside.repaint();
    }

    private JLabel createPSwindow() {

            JLabel text = new JLabel(this.getNextPopsicleStick());
            text.setIcon(new ImageIcon("onestick.png"));
            text.setFont(new Font("Serif", Font.BOLD, 45));
            text.setHorizontalTextPosition(JLabel.CENTER);
            text.setHorizontalTextPosition(JLabel.CENTER);
            text.setVerticalTextPosition(JLabel.CENTER);
            text.setForeground(Color.BLACK);
        return text;
    }

    private String getNextPopsicleStick() {
        // create array of all students who are present and have not been called
        ArrayList<Student> available = new ArrayList<Student>();
        while((available.size()<1) && (this.students.getPresentStudents().size()>0)) {
            for (Student s : this.students.students) {
                if (s.isPresent) {
                    if (!s.called) {
                        available.add(s);
                    }
                }
            }
            if(available.size()<1){
                this.students.markALlNotCalled();
            }
        }
        // shuffle the list
        ArrayList<String> names = this.students.getWholeNameFromStudents(available);
        Collections.shuffle(names);
        this.students.markCalledByFullName(names.get(0));
        return names.get(0);
    }
}
