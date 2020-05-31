import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class ButtonStatic extends JFrame {
    static class Klicker implements ActionListener {

	@Override
	public void actionPerformed(final ActionEvent arg0) {
	    System.out.println("geklickt");
	}

    }

    JButton button;

    ButtonStatic(final String title) {
	super(title);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	this.button = new JButton("Klick");
	this.button.addActionListener(new Klicker());
	add(this.button);
    }

    public static void main(final String[] args) {
	final ButtonStatic frm = new ButtonStatic("Demo");
	frm.setSize(150, 75);
	frm.setVisible(true);
    }
}