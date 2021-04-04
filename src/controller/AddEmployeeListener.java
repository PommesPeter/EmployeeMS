package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Employee;
import model.MessageDialog;
import view.AddEmployeeWindow;

public class AddEmployeeListener implements ActionListener {

    AddEmployeeWindow am;

    public AddEmployeeListener(AddEmployeeWindow am) {
        this.am = am;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!Employee.isVaildEmail(this.am.getEmailInput())) {
            if (this.am.getEmailInput().equals("")) {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "邮箱不能为空, 请重试....").show();
            } else {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "邮箱格式错误, 请重试....").show();
                this.am.setEmailInput("");
            }
        } else if (!Employee.isNumberic(this.am.getNumInput())) {
            if (this.am.getNumInput().equals("")) {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工号不能为空, 请重试....").show();
            } else {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工号格式错误, 请重试....").show();
                this.am.setNumInput("");
            }
        } else if (!Employee.isDoubleNumber(this.am.getWageInput())) {
            if (this.am.getWageInput().equals("")) {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "工薪不能为空, 请重试....").show();
            } else {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "基本工薪格式错误, 请重试....").show();
                this.am.setWageInput("");
            }
        } else if (Employee.isVaildString(this.am.getName())) {
            if (this.am.getNameInput().equals("")) {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "姓名不能为空, 请重试....").show();
            } else {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "名字中包含非字符, 请重试....").show();
                this.am.setNameInput("");
            }
        } else if (Employee.isVaildBirthday(this.am.getYearInput(), this.am.getMonthInput())) {
            if (this.am.getYearInput().equals("") || this.am.getMonthInput().equals("")) {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "出生年月不能为空, 请重试....").show();
            } else {
                new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "出生年月中格式错误, 请重试....").show();
                this.am.setBirthInput("", "");
            }
        }
    }
}
/**/