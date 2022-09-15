import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class StudentLists extends JList{

    public StudentLists(ArrayList<String> snames) {
        super();
        this.setFixedCellWidth(150);
        this.setPreferredSize(new Dimension(150,400));
        this.setListData(snames.toArray());
    }


}
