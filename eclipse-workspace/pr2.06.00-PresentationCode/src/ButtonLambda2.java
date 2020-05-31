import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class ButtonLambda2 extends JFrame {
    JButton button;

    ButtonLambda2(final String title) {
	super(title);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	this.button = new JButton("Klick");
	this.button.addActionListener((final ActionEvent e) -> System.out.println("geklickt"));
	add(this.button);
    }

    public static void main(final String[] args) {
	final ButtonLambda2 frm = new ButtonLambda2("Demo");
	frm.setSize(150, 75);
	frm.setVisible(true);
    }
}