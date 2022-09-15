import javax.swing.*;
import java.awt.*;

public class Container extends JPanel {

    public Container(LayoutManager layout){
        super();
        this.setLayout(layout);
        this.setBackground(Color.WHITE);
    }

    public Container(){
        super();
        this.setBackground(Color.WHITE);
    }
}
