import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
//w  ww .  ja v  a  2  s . c o m
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;

public class Main {
  public static void main(String[] args) {
    SplashScreen splashScreen = new SplashScreen();
  }
}
class SplashScreen extends JWindow {
  static JProgressBar progressBar = new JProgressBar();
  static int count = 1, TIMER_PAUSE = 25, PROGBAR_MAX = 100;
  static Timer progressBarTimer;
  ActionListener al = new ActionListener() {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
      progressBar.setValue(count);
      if (PROGBAR_MAX == count) {
        progressBarTimer.stop();
        SplashScreen.this.setVisible(false);
        createAndShowFrame();
      }
      count++;
    }
  };

  public SplashScreen() {
    Container container = getContentPane();

    JPanel panel = new JPanel();
    panel.setBorder(new EtchedBorder());
    panel.setSize(500,500);
    container.add(panel, BorderLayout.CENTER);

    JLabel label = new JLabel("Hello World!");
    label.setFont(new Font("Verdana", Font.BOLD, 14));
    panel.add(label);

    progressBar.setMaximum(PROGBAR_MAX);
    container.add(progressBar, BorderLayout.SOUTH);
    pack();
    setVisible(true);
    startProgressBar();
  }
  private void startProgressBar() {
    progressBarTimer = new Timer(TIMER_PAUSE, al);
    progressBarTimer.start();
  }
  private void createAndShowFrame() {
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}