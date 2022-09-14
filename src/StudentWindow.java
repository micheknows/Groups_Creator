import com.sun.tools.javac.Main;

import java.awt.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentWindow extends JFrame{

    public StudentWindow() {
        super("Groups");
        this.setMinimumSize(new Dimension(800,800));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuBar menubar = new MainMenuBar();
        this.setJMenuBar(menubar);

        JPanel westside = new JPanel();
        westside.setLayout(new BoxLayout(westside, BoxLayout.PAGE_AXIS));
        JLabel presentStudents = new JLabel("Present Students");
        westside.add(presentStudents);

        JPanel presentpanel = new JPanel();
        presentpanel.setLayout(new FlowLayout());
        StudentListArea sla = new StudentListArea();
        JScrollPane scrollPane1 = new JScrollPane(sla);
        presentpanel.add(scrollPane1);
        westside.add(presentpanel);
        this.add(westside, BorderLayout.WEST);
        JLabel absentStudents = new JLabel("Absent Students");
        westside.add(absentStudents);

        this.pack();
        this.setVisible(true);
    }

}
