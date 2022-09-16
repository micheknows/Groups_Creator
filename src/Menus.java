import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menus extends JMenuBar implements ActionListener {

    JMenu btmenu;
    BuddyTalks bt;

    public Menus(BuddyTalks bt){
        this.bt = bt;
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
        }
    }
}
