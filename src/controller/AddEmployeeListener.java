package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Employee;
import model.MessageDialog;
import view.AddEmployeeWindow;
import view.MainWindow;

public class AddEmployeeListener implements ActionListener {

	AddEmployeeWindow am;

	public AddEmployeeListener(AddEmployeeWindow am) {
		this.am = am;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());

		if (!Employee.isVaildEmail(this.am.getEmailInput())) {
			new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "邮箱格式错误, 请重试....").show();
			this.am.setEmailInput("");
		}
		if (!Employee.isNumberic(this.am.getNumInput())) {
			new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工号格式错误, 请重试....").show();
			this.am.setNumInput("");
		}
		if (!Employee.isDoubleNumber(this.am.getWageInput())) {
			new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "基本工薪格式错误, 请重试....").show();
			this.am.setWageInput("");
		}
		if (Employee.isVaildString(this.am.getName())) {
			new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "名字中包含数字, 请重试....").show();
			this.am.setNameInput("");
		}
		if (Employee.isVaildBirthday(this.am.getYearInput(), this.am.getMonthInput())) {
			new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "出生年月中格式错误, 请重试....").show();
			this.am.setBirthInput("", "");
		}
	}
}
/**/