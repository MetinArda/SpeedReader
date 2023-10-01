import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class JSwitchButton extends JButton {
    Font fnt = new Font("Courier", Font.PLAIN, 20);
	private JLabel label = new JLabel();


	public JSwitchButton(String a, JLabel label) {
		this.label=label;
		setText(a);
		setFont(fnt);
		setBackground(Color.white);
		ButtonListener b= new ButtonListener(label);
		addActionListener(b);
	}
}
