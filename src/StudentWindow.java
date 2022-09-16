import javax.swing.*;
import java.awt.*;

public class StudentWindow extends JFrame {

    Container northside;
    Container westside;
    Container centerside;
    Container eastside;
    ScrollingList presentStudents;
    ScrollingList absentStudents;
    Buttons popsicleBtn;
    Buttons buddytalkBtn;
    Buttons groupBtn;
    Buttons clearBtn;

    Students myStudents;
    BuddyTalks bt;

    public  StudentWindow() {
        super("Groups Creator");
        this.setPreferredSize(new Dimension(1200,800));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        myStudents = new Students();
        Buttons b = new Buttons(myStudents, this);
        this.bt = b.bt;

        this.setJMenuBar(new Menus(this.bt));

        // NORTHSIDE  holds buttons for pop, buddy talk, groups, etc
        northside = new Container(new FlowLayout());

            // add navigation buttons
                popsicleBtn = new Buttons(new ImageIcon("pop2.jpg"), "popsicle", "Click to pull the next popsicle stick");
                northside.add(popsicleBtn);

                buddytalkBtn = new Buttons(new ImageIcon("pbj.png"), "buddy", "Click to create Buddy Talk pairs");
                northside.add(buddytalkBtn);


                clearBtn = new Buttons(new ImageIcon("clear.jpg"), "clear", "Click to clear the display area");
                northside.add(clearBtn);


        this.add(northside,BorderLayout.NORTH);

        //WESTSIDE holds the lists of present and absent students
        westside = new Container();
        westside.setLayout(new BoxLayout(westside, BoxLayout.Y_AXIS));
            // Create the present students
            presentStudents = new ScrollingList(this.myStudents.getPresentStudents(), "Present", this.myStudents.getPresentStudents().size());
            westside.add(presentStudents);
            Buttons allAbsentBtn = new Buttons("Mark All Absent", "allAbsent");
            westside.add(allAbsentBtn);
            Buttons selectedAbsentBtn = new Buttons("Mark Selected Absent", "selectedAbsent");
            westside.add(selectedAbsentBtn);


            // Create the absent students
            absentStudents = new ScrollingList(this.myStudents.getAbsentStudents(), "Absent", this.myStudents.getAbsentStudents().size());
            westside.add(absentStudents);
            Buttons allPresentBtn = new Buttons("Mark All Present", "allPresent");
            westside.add(allPresentBtn);
            Buttons selectedPresentBtn = new Buttons("Mark Selected Present", "selectedPresent");
            westside.add(selectedPresentBtn);

        this.add(westside,BorderLayout.WEST);

        //CENTERSIDE holds the displayed information about groups, selected, etc
        centerside = new Container(new GridLayout(1,1));
        this.add(centerside,BorderLayout.CENTER);

        // EASTSIDE holds the timer functionality
        eastside = new Container();
        eastside.setLayout(new BoxLayout(eastside, BoxLayout.PAGE_AXIS));
        this.add(eastside, BorderLayout.EAST);

        this.pack();
        this.setVisible(true);
    }

}
