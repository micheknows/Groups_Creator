import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainMenuBar extends JMenuBar implements ActionListener {
    JMenu menu;

    public MainMenuBar(){
        menu = new JMenu("Students");
        menu.setMnemonic(KeyEvent.VK_S);
        this.add(menu);
        JMenuItem menuitem = new JMenuItem("Add Students",KeyEvent.VK_A);
        menuitem.addActionListener(this);
        menu.add(menuitem);
        menuitem = new JMenuItem("Delete Student",KeyEvent.VK_D);
        menuitem.addActionListener(this);
        menu.add(menuitem);
        menuitem = new JMenuItem("Save Students",KeyEvent.VK_V);
        menuitem.addActionListener(this);
        menu.add(menuitem);

    }

    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "Add Students":
                System.out.println("YAY  YOU CLIKCKED ADD STUDENTS!!!");
                break;
            case "Delete Student":
                System.out.println("YAY  YOU CLIKCKED DELETE STUDENTS!!!");
                break;
            case "Save Students":
                Students students = new Students();
                students.saveStudents();
                break;
        }
    }
}
