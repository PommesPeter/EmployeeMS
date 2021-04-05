package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ShowEmployeeWindow;

public class ShowEmployeeListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//启动窗口
			ShowEmployeeWindow window = new ShowEmployeeWindow();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}
