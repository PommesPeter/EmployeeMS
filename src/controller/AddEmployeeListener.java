package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Employee;
import view.AddEmployeeWindow;

public class AddEmployeeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			AddEmployeeWindow window = new AddEmployeeWindow();



//			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception exp2) {
			exp2.printStackTrace();
		}
		
	}
}
