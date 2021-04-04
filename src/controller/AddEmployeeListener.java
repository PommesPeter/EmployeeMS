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
/*if (!Employee.isVaildEmail(window.getEmailInput())) {
				new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "邮箱格式错误, 请重试....");
				window.setEmailInput("");
			}
			if (!Employee.isNumberic(window.getNumInput())) {
				new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工号格式错误, 请重试....");
				window.setNumInput("");
			}
			if (!Employee.isDoubleNumber(window.getWageInput())) {
				new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "基本工薪格式错误, 请重试....");
				window.setWageInput("");
			}
			if (Employee.isVaildString(window.getName())) {
				new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "名字中包含数字, 请重试....");
				window.setNameInput("");
			}
			if (Employee.isVaildBirthday(window.getYearInput(), window.getMonthInput())) {
				new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "出生年月中格式错误, 请重试....");
				window.setBirthInput("", "");
			}*/