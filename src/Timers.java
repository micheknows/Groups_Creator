import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Timers extends JPanel implements ActionListener {

    boolean isALarm;
    int minutes;
    int seconds;
    JTextField timerEntryMinutes;
    JTextField timerEntrySeconds;
    JButton startBtn;
    public Timer timer;

    public Timers(StudentWindow studentWindow) {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.add(createTimerLabel());
        this.add(crateTimerEntry());
        this.add(createStartBtn());
    }

    private JPanel createStartBtn(){
        JPanel jp  = new JPanel();
        jp.setBackground(Color.WHITE);
        jp.setSize(100, 100);
        jp.setPreferredSize(new Dimension(100, 100));
        jp.setMaximumSize(new Dimension(100, 100));
        jp.setBorder(new EmptyBorder(30, 10, 10, 10));
        startBtn = new JButton("Start Timers");
        startBtn.addActionListener(this);
        jp.add(startBtn);

        return jp;
    }

    public void actionPerformed(ActionEvent e){
        switch(e.getActionCommand()){
            case "Start Timers":
                runTimer();
                startBtn.setText("Stop Timers");
                break;
            case "Stop Timers":
                stopTimer();
                break;
        }
    }



    private JPanel crateTimerEntry(){
        JPanel jp  = new JPanel();
        jp.setBackground(Color.WHITE);
        jp.setSize(400, 60);
        jp.setPreferredSize(new Dimension(400, 60));
        jp.setMaximumSize(new Dimension(400, 60));

        timerEntryMinutes = new JTextField("2", 3);
        timerEntryMinutes.setPreferredSize(new Dimension(150,60));
        timerEntryMinutes.setFont(new Font("Serif", Font.BOLD, 45));
        timerEntryMinutes.setForeground(Color.RED);
        timerEntryMinutes.setHorizontalAlignment(SwingConstants.RIGHT);
        timerEntryMinutes.setSize(150,60);
        jp.add(timerEntryMinutes);

        JLabel colonlabel = new JLabel(":");
        colonlabel.setFont(new Font("Serif", Font.BOLD, 45));
        colonlabel.setForeground(Color.RED);
        colonlabel.setBackground(Color.white);
        jp.add(colonlabel);


        timerEntrySeconds = new JTextField("00", 2);
        timerEntrySeconds.setPreferredSize(new Dimension(150,60));
        timerEntrySeconds.setFont(new Font("Serif", Font.BOLD, 45));
        timerEntrySeconds.setForeground(Color.RED);
        timerEntrySeconds.setHorizontalAlignment(SwingConstants.LEFT);
        timerEntrySeconds.setSize(150,60);
        jp.add(timerEntrySeconds);


        return jp;
    }

    private JLabel createTimerLabel(){
        JLabel timerLabel = new JLabel("Timers",JLabel.CENTER);
        timerLabel.setHorizontalTextPosition(JLabel.CENTER);
        timerLabel.setBorder(new EmptyBorder(10, 10, 10, 10));
        timerLabel.setBackground(Color.WHITE);
        timerLabel.setFont(new Font("Serif", Font.BOLD, 45));
        timerLabel.setVerticalTextPosition(JLabel.CENTER);
        return timerLabel;
    }

    private void runTimer() {

// And From your main() method or any other method
        timer = new Timer(true);
        timer.schedule(new RunClock(this), 0,1000);
    }

    public void stopTimer() {
        startBtn.setText("Start Timers");
        timer.cancel();
    }

}


class RunClock extends TimerTask {

    Timers t;
    public RunClock(Timers t){
        this.t = t;
    }
    public void run() {
        int seconds = Integer.parseInt(t.timerEntrySeconds.getText());
        int minutes = Integer.parseInt(t.timerEntryMinutes.getText());
        if(seconds>0){
            seconds = seconds - 1;
        } else {
            if(minutes>0){
                seconds = 59;
                minutes = minutes -1;
            } else {
                minutes = 2;
                seconds = 0;
                t.stopTimer();
            }
        }
        if(seconds<10){
            t.timerEntrySeconds.setText("0" + Integer.toString(seconds));
        } else {
            t.timerEntrySeconds.setText(Integer.toString(seconds));
        }
        t.timerEntryMinutes.setText(Integer.toString(minutes));
    }
}