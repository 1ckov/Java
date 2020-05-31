import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class ButtonLambda3 extends JFrame {
    JButton button;

    ButtonLambda3(final String title) {
	super(title);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	this.button = new JButton("Klick");
	this.button.addActionListener(e -> {
	    System.out.println("geklickt");
	});
	add(this.button);
    }

    public static void main(final String[] args) {
	final ButtonLambda3 frm = new ButtonLambda3("Demo");
	frm.setSize(150, 75);
	frm.setVisible(true);
    }
}