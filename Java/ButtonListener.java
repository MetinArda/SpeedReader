import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class ButtonListener implements ActionListener {

	String[] data;
	private JLabel label = new JLabel();

	private static volatile int c = 0;
	public static volatile boolean stop;
	private static long timeToSleep = 400;
	private TimeUnit time = TimeUnit.SECONDS;

	public ButtonListener(JLabel label) {
		stop = false;
		this.setLabel(label);
		paragraphGetter pg = new paragraphGetter();
		data = pg.getData();
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (button.getText().equals("Start")) {
			this.stop = false;
			System.out.println("Start button pressed");
			Thread thread = new Thread(() -> {
				while (!this.stop && c < data.length - 1) {
					getLabel().setText(data[c]);
					c++;
					System.out.println("Going to sleep for " + timeToSleep + " seconds");
					// Using sleep() method
					try {
						Thread.sleep(timeToSleep); // Multiply by 1000 to convert seconds to milliseconds
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					System.out.println("Slept for " + timeToSleep + " seconds");
					System.out.println(stop);
				}
			});

			thread.start();
		}
		if (button.getText().equals("Stop")) {
			System.out.println("Stop button pressed");
			this.stop = true;

			// The program must stop.+
		}
		// The text in label changes to next
		if (button.getText().equals("Faster")) {
			System.out.println("Faster button pressed ");
			if (this.timeToSleep!=0 ) {
				timeToSleep-=100;
			}

		}
		if (button.getText().equals("Slower")) {
			System.out.println("Slower button pressed");
			timeToSleep+=100;
		}
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
}