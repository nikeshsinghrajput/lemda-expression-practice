package nikesh;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MyWindow {

	public static void main(String[] args) {
		 
		JFrame jframe= new JFrame();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(400,400);
		jframe.setLayout(new FlowLayout());
		jframe.setVisible(true);
		JButton button=new JButton("click me");
		button.addActionListener( (e)->{System.out.println("button clicked");
		 JOptionPane.showMessageDialog(button, "hey! button clicked");});
		jframe.add(button);
	}

}
