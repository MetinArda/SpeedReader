import java.awt.*;
import javax.swing.*;

public class FastReaderscreen extends JFrame{
    private int width = 1000;
	private int height = 800;

	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel mainPanel = new JPanel(new GridLayout(5, 4, 0, 0));
	private JLabel label = new JLabel("",SwingConstants.CENTER);

	private Font fnt = new Font("Courier", Font.PLAIN, 60);

    public FastReaderscreen(){
        setLayout(new BorderLayout());

        add(topPanel, BorderLayout.CENTER);
		add(mainPanel, BorderLayout.SOUTH);

		// Label that contains the paragraph
		label.setFont(fnt);
		//label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        topPanel.add(label);

		// Buttons
        mainPanel.add(new JSwitchButton("Start", label));
		mainPanel.add(new JSwitchButton("Stop", label));
		mainPanel.add(new JSwitchButton("Faster", label));
		mainPanel.add(new JSwitchButton("Slower", label));

        setSize(width,height);

        
    }
    

}
