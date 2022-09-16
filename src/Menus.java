import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menus extends JMenuBar implements ActionListener {

    JMenu btmenu;
    JMenu winmenu;
    JMenu displaymenu;

    BuddyTalks bt;
    StudentWindow sw;
    JMenuItem showstudentssubmenu;
    JMenuItem showdisplaysubmenu;

    Boolean studentview;
    Boolean displayview;

    public Menus(BuddyTalks bt, StudentWindow sw){
        this.bt = bt;
        this.sw = sw;

        studentview = true;
        displayview = true;

        // BUddy Talk Menu
        btmenu = new JMenu("Buddy Talk");
        btmenu.setMnemonic(KeyEvent.VK_B);
        this.add(btmenu);

        JMenu headerssubmenu = new JMenu("Change Headers");
        headerssubmenu.setMnemonic(KeyEvent.VK_H);
        btmenu.add(headerssubmenu);


        JMenuItem fryItem= new JMenuItem("Frybread and Stew");
        fryItem.setMnemonic(KeyEvent.VK_F);
        fryItem.addActionListener(this);
        headerssubmenu.add(fryItem);

        JMenuItem pbjItem= new JMenuItem("Peanut Butter and Jelly");
        pbjItem.setMnemonic(KeyEvent.VK_P);
        pbjItem.addActionListener(this);
        headerssubmenu.add(pbjItem);

        JMenuItem baconAndEggs= new JMenuItem("Bacon and Eggs");
        baconAndEggs.setMnemonic(KeyEvent.VK_B);
        baconAndEggs.addActionListener(this);
        headerssubmenu.add(baconAndEggs);

        JMenuItem chipsandsalsa= new JMenuItem("Chips and Salsa");
        chipsandsalsa.setMnemonic(KeyEvent.VK_C);
        chipsandsalsa.addActionListener(this);
        headerssubmenu.add(chipsandsalsa);

        // Windows View Menu

        winmenu = new JMenu("Window View");
        winmenu.setMnemonic(KeyEvent.VK_W);
        this.add(winmenu);

        String text;
        if(studentview){
            text = "Hide Students";
        } else {
            text = "Show Students";
        }

        showstudentssubmenu = new JMenuItem(text);
        showstudentssubmenu.setMnemonic(KeyEvent.VK_S);
        showstudentssubmenu.addActionListener(this);
        winmenu.add(showstudentssubmenu);


        if(displayview){
            text = "Hide Display Area";
        } else {
            text = "Show Display Area";
        }

        showdisplaysubmenu = new JMenuItem(text);
        showdisplaysubmenu.setMnemonic(KeyEvent.VK_S);
        showdisplaysubmenu.addActionListener(this);
        winmenu.add(showdisplaysubmenu);


    }

    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "Frybread and Stew":
                this.bt.setPairs("fry");
                break;
            case "Peanut Butter and Jelly":
                this.bt.setPairs("pbj");
                break;
            case "Bacon and Eggs":
                this.bt.setPairs("bacon");
                break;
            case "Chips and Salsa":
                this.bt.setPairs("salsa");
                break;
            case "Hide Students":
                sw.westside.setVisible(false);
                showstudentssubmenu.setText("Show Students");
                sw.setSize(new Dimension(sw.getWidth()-400,sw.getHeight()));
                sw.validate();
                sw.repaint();
                studentview = false;
                break;
            case "Show Students":
                sw.westside.setVisible(true);
                showstudentssubmenu.setText("Hide Students");
                sw.setSize(new Dimension(sw.getWidth()+400,sw.getHeight()));
                studentview = true;
                sw.validate();
                sw.repaint();
                break;
            case "Hide Display Area":
                sw.centerside.setVisible(false);
                showdisplaysubmenu.setText("Show Display Area");
                sw.setSize(new Dimension(sw.getWidth()-600,sw.getHeight()));
                sw.validate();
                sw.repaint();
                displayview = false;
                break;
            case "Show Display Area":
                sw.centerside.setVisible(true);
                showdisplaysubmenu.setText("Hide Display Area");
                sw.setSize(new Dimension(sw.getWidth()+600,sw.getHeight()));
                displayview = true;
                sw.validate();
                sw.repaint();
                break;
        }
    }
}
