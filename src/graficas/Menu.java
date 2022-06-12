package graficas;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame{
	
	private JButton btnTest;
	
	public Menu(){
		this.setTitle("FarmaUADE");
		this.setResizable(false);
		Container c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLUE);
		btnTest = new JButton("Testear");
	}
}
