package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import view.ShowEmployeeWindow;

public class ShowEmployeeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

//			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
	
	

}
