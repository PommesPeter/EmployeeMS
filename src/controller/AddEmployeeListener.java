package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import model.Employee;
import model.MessageDialog;
import view.AddEmployeeWindow;

public class AddEmployeeListener implements ActionListener {

    private final static String filePath = "/run/media/pommespeter/File/schoolFile/学习/面向对象编程/Experinment/Experinment03/EmployeeMS/src/data/data.csv";
    AddEmployeeWindow am;
    JFrame frame;

    public AddEmployeeListener(AddEmployeeWindow am, JFrame frame) {
        this.am = am;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.am.getNumInput().equals("")) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工号不能为空, 请重试....").show();
        } else if (this.am.getNameInput().equals("")) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "姓名不能为空, 请重试....").show();
        } else if (this.am.getYearInput().equals("") || this.am.getMonthInput().equals("")) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "出生年月不能为空, 请重试....").show();
        } else if (this.am.getWageInput().equals("")) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "基本工薪不能为空, 请重试....").show();
        } else if (this.am.getEmailInput().equals("")) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "邮箱不能为空, 请重试....").show();
        } else if (!Employee.isNumberic(this.am.getNumInput())) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工号格式错误, 请重试....").show();
            this.am.setNumInput("");
        } else if (Employee.isValidString(this.am.getNameInput())) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "名字中包含非字符, 请重试....").show();
            System.out.println(this.am.getNameInput());
            this.am.setNameInput("");
        } else if (!Employee.isVaildBirthday(this.am.getYearInput(), this.am.getMonthInput())) {
            System.out.println(this.am.getYearInput());
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "出生年月中格式错误, 请重试....").show();
            this.am.setBirthInput("", "");
        } else if (!Employee.isDoubleNumber(this.am.getWageInput())) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "基本工薪格式错误, 请重试....").show();
            this.am.setWageInput("");
        } else if (!Employee.isVaildEmail(this.am.getEmailInput())) {
            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "邮箱格式错误, 请重试....").show();
            this.am.setEmailInput("");
        }

        Employee employee = new Employee(am.getNumInput(), am.getNameInput(), am.getYearInput() + am.getMonthInput(), am.getWageInput(), am.getEmailInput());
//        am.getNumInput() + "," + am.getNumInput() + "," + am.getYearInput() + am.getMonthInput() + "," + am.getWageInput() + "," + am.getEmailInput()

        String usrInfo = employee.generateRecord();
        try {
            FileWriter w = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(usrInfo);
            bw.newLine();

            bw.close();
            w.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("add a employee");
        frame.dispose();
    }
}
/**/