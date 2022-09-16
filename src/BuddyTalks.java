import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class BuddyTalks {

    private Students students;
    private StudentWindow sw;

    private String col1Icon = "pb.png";

    private String col2Icon = "jelly.png";

    private String col1Name = "Peanut Butter";
    private String col2Name = "Jelly";

    private JTable text;

    public BuddyTalks(Students students, StudentWindow sw) {
        this.students = students;
        this.sw = sw;
    }

    public void doBuddyTalk(){
        this.clear();
        sw.centerside.add(createBTwindow());
        this.repack();

    }

    public void setPairs(String pairs){
        switch(pairs){
            case "fry":
                this.col1Icon = "frybread.png";
                this.col2Icon = "stew.png";
                this.col1Name = "Frybread";
                this.col2Name = "Stew";
                this.SetBothIcons();
                this.repack();
                break;
            case "pbj":
                this.col1Icon = "pb.png";
                this.col2Icon = "jelly.png";
                this.col1Name = "Peanut Butter";
                this.col2Name = "Jelly";
                this.SetBothIcons();
                this.repack();
                break;
            case "bacon":
                this.col1Icon = "bacon.png";
                this.col2Icon = "eggs.png";
                this.col1Name = "Bacon";
                this.col2Name = "Eggs";
                this.SetBothIcons();
                this.repack();
                break;
            case "salsa":
                this.col1Icon = "chips.png";
                this.col2Icon = "salsa.png";
                this.col1Name = "Chips";
                this.col2Name = "Salsa";
                this.SetBothIcons();
                this.repack();
                break;
        }
    }

    private JPanel createBTwindow() {
        JPanel c = new JPanel(new BorderLayout());
        text = new JTable(this.getBuddyTalks(), new String[]{"Peanut Butter", "Jelly"}){
            public Component prepareRenderer
                    (TableCellRenderer renderer,int Index_row, int Index_col) {
                Component comp = super.prepareRenderer(renderer, Index_row, Index_col);
                //even index, selected or not selected
                if (Index_row % 2 == 0 && !isCellSelected(Index_row, Index_col)) {
                    comp.setBackground(Color.lightGray);
                }
                else {
                    comp.setBackground(Color.white);
                }
                return comp;
            }
        };
        text.setPreferredSize(new Dimension(760,700));
        text.setRowHeight(35);
        text.setRowMargin(10);
        text.setFont(new Font("Serif", Font.BOLD, 20));
        this.SetBothIcons();
        c.add(text, BorderLayout.CENTER);
        c.add(text.getTableHeader(), BorderLayout.NORTH);
        return c;
    }

    public void SetBothIcons(){
        SetIcon(text,0,new ImageIcon(this.col1Icon), this.col1Name);
        SetIcon(text,1,new ImageIcon(this.col2Icon), this.col2Name);
    }

    public void SetIcon(JTable table, int col_index, ImageIcon icon,String name){
        table.getTableHeader().getColumnModel().getColumn(col_index).setHeaderRenderer
                (new iconRenderer());
        table.getColumnModel().getColumn(col_index).setHeaderValue(new txtIcon(name, icon));
    }
    public class iconRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent(JTable table,
                                                       Object obj,boolean isSelected, boolean hasFocus, int row,
                                                       int column) {
            txtIcon i = (txtIcon)obj;
            if (obj == i) {
                setIcon(i.imageIcon);
                setText(i.txt);
            }
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            setHorizontalAlignment(JLabel.CENTER);
            return this;
        }
    }

    public class txtIcon {
        String txt;
        ImageIcon imageIcon;
        txtIcon(String text, ImageIcon icon) {
            txt = text;
            imageIcon = icon;
        }
    }


    private String[][] getBuddyTalks(){
        // create array of all students who are present
        ArrayList<String> available = this.students.getWholeNameFromStudents(this.students.getPresentStudents());
        // shuffle the list
        Collections.shuffle(available);
        Boolean isOdd = available.size()%2>0;
        Integer numRows = available.size()/2;
        Integer listCounter = 0;
        // create multidimensional string array
        String[][] data = new String[numRows][2];
        for(int i=0; i<numRows; i++){
            data[i][0] = available.get(listCounter);
            data[i][1] = available.get(listCounter+1);
            listCounter = listCounter + 2;
        }
        if(isOdd){
            data[numRows-1][1] = data[numRows-1][1] +  " AND " +  available.get(listCounter);
        }
        return data;
    }

    private void repack() {
        this.sw.centerside.validate();
        this.sw.centerside.repaint();
    }


    public void clear() {
        try {
            sw.centerside.removeAll();
        } catch (Exception e) {
            System.out.print("");
        }
        try {
            sw.centerside.validate();
        } catch (Exception e) {
            System.out.print("");
        }
        try {
            sw.centerside.repaint();
        } catch (Exception e) {
            System.out.print("");
        }
    }
}
