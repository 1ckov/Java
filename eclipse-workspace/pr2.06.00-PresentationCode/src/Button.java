import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class Button extends JFrame {
    JButton button;

    Button(final String title) {
	super(title);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	this.button = new JButton("Klick");
	this.button.addActionListener(new Klicker());
	add(this.button);
    }

    public static void main(final String[] args) {
	final Button frm = new Button("Demo");
	frm.setSize(150, 75);
	frm.setVisible(true);
    }
}