
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StudentWindow extends JFrame{

    StudentListArea slaabsent;
    StudentListArea sla;
    JPanel center;
    JLabel presentStudents;
    JLabel absentStudents;



    public StudentWindow() {
        super("Groups");
        this.setMinimumSize(new Dimension(800,800));
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenuBar menubar = new MainMenuBar();
        this.setJMenuBar(menubar);

        JPanel northside = new JPanel();
        northside.setLayout(new FlowLayout());
        northside.setBackground(Color.white);



        // button for popsicle sticks
        JButton pop;
        try {
            pop = new JButton(new ImageIcon("pop2.jpg"));
            pop.setPreferredSize(new Dimension(100,75));


            northside.add(pop);
        } catch (Exception IOException){
            pop = new JButton("Popsicle Sticks");
        }
        pop.setToolTipText("Click to pull the next popsicle stick.");
        pop.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students students = new Students();
                String name = students.getNextPopsicle();
                showPop(name);
            }
        }));


        // button for clear middle
        JButton clear;
        try {
            clear = new JButton( new ImageIcon("clear.jpg"));
            clear.setPreferredSize(new Dimension(100,75));


            northside.add(clear);
        } catch (Exception IOException){
            clear = new JButton("Clear Middle");
        }
        clear.setToolTipText("Click to clear the space below.");
        clear.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showClear();
            }
        }));



        this.add(northside, BorderLayout.NORTH);

        JPanel westside = new JPanel();
        westside.setLayout(new BoxLayout(westside, BoxLayout.PAGE_AXIS));
        presentStudents = new JLabel("Present Students");
        westside.add(presentStudents);

        JPanel presentpanel = new JPanel();
        presentpanel.setLayout(new FlowLayout());
        sla = new StudentListArea(true);
        JScrollPane scrollPane1 = new JScrollPane(sla);

        scrollPane1.setPreferredSize(new Dimension(100,370));
        presentpanel.add(scrollPane1);
        westside.add(presentpanel);
        // mark all absent button
        JButton maabsentBtn = new JButton("Mark All Absent");
        slaabsent = new StudentListArea(false);
        westside.add(maabsentBtn);
        // mark selected absent
        JButton msabsentBtn = new JButton("Mark Selected Absent");

        westside.add(msabsentBtn);
        maabsentBtn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students students = new Students();
                students.setALl(false);
                setbothlists();
                setPresentAbsentLabels();
            }
        }));
        msabsentBtn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String)sla.getSelectedValue();
                Students students = new Students();
                students.setPresentByWholeName(name, false);
                setbothlists();
                setPresentAbsentLabels();
            }
        }));
        absentStudents = new JLabel("Absent Students");

        absentStudents.setBorder(new EmptyBorder(50, 10, 0, 10));

        westside.add(absentStudents);
        JPanel absentpanel = new JPanel();
        absentpanel.setLayout(new FlowLayout());
        JScrollPane scrollPane2 = new JScrollPane(slaabsent);
        scrollPane2.setPreferredSize(new Dimension(100,70));
        absentpanel.add(scrollPane2);
        westside.add(absentpanel);

        absentpanel.setBackground(Color.white);

        presentpanel.setBackground(Color.white);

        presentpanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        absentpanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        setPresentAbsentLabels();
        // mark all present button
        JButton mapresentBtn = new JButton("Mark All Present");
        westside.add(mapresentBtn);

        // mark selected present
        JButton mspresentBtn = new JButton("Mark Selected Present");
        westside.add(mspresentBtn);
        mapresentBtn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Students students = new Students();
                students.setALl(true);
                setbothlists();
                setPresentAbsentLabels();
            }
        }));

        mspresentBtn.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = (String) slaabsent.getSelectedValue();
                Students students = new Students();
                students.setPresentByWholeName(name, true);
                setbothlists();
                setPresentAbsentLabels();
            }
        }));

        westside.setBackground(Color.white);

        westside.setBorder(new EmptyBorder(10, 10, 100, 10));


        this.add(westside, BorderLayout.WEST);

        center = new JPanel();

        JLabel popname = new JLabel();
        center.add(popname);

        center.setBackground(Color.white);
        this.add(center, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }



    private void setbothlists(){
        sla.setStudentList();
        slaabsent.setStudentList();
    }

    private void showPop(String name) {
        center.removeAll();
        JLabel popname = new JLabel(name);
        popname.setFont(new Font("Serif", Font.BOLD, 100));
        popname.setForeground(Color.blue);
        center.add(popname);
        this.validate();
        this.repaint();
    }

    private void showClear() {
        center.removeAll();
        this.validate();
        this.repaint();
    }

    private void setPresentAbsentLabels(){
        Students s = new Students();
        int numpresent = s.getNumPresent();
        int numabsent = s.getNumAbsent();
        this.presentStudents.setText("Present Students:  " + Integer.toString(numpresent));
        this.absentStudents.setText("Absent Students:  " + Integer.toString(numabsent));
    }

}
