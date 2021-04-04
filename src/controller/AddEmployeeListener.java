package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Employee;
import model.MessageDialog;
import view.AddEmployeeWindow;

public class AddEmployeeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			AddEmployeeWindow window = new AddEmployeeWindow();
		} catch (Exception exp2) {
			exp2.printStackTrace();
		}
	}
}
