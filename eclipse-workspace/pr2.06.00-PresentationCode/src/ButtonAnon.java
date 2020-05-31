import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
class ButtonAnon extends JFrame {
    JButton button;

    ButtonAnon(final String title) {
	super(title);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setLayout(new FlowLayout());

	this.button = new JButton("Klick");
	this.button.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
		System.out.println("geklickt");
	    }
	});
	add(this.button);
    }

    public static void main(final String[] args) {
	final ButtonAnon frm = new ButtonAnon("Demo");
	frm.setSize(150, 75);
	frm.setVisible(true);
    }
}