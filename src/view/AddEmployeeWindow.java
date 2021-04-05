package view;

import controller.AddEmployeeListener;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEmployeeWindow extends JFrame {

    private JFrame frame;
    private JTextField numInput;
    private JTextField nameInput;
    private JTextField wageInput;
    private JTextField emailInput;
    private JTextField yearInput;
    private JTextField monthInput;

    public AddEmployeeWindow() {
        initialize();
    }
    /*初始化窗口.*/
    private void initialize() {
        frame = new JFrame();
        frame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        frame.setTitle("添加信息");
        frame.setBounds(100, 100, 383, 374);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
        JLabel addTitleLabel = new JLabel("添加职工信息");
        addTitleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
        addTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(addTitleLabel, BorderLayout.NORTH);
        JPanel infoPanel = new JPanel();
        frame.getContentPane().add(infoPanel, BorderLayout.CENTER);
        infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
        JLabel numLabel = new JLabel("职工序号");
        numLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoPanel.add(numLabel);
        numInput = new JTextField();
        infoPanel.add(numInput);
        numInput.setColumns(10);
        JLabel nameLabel = new JLabel("姓名");
        infoPanel.add(nameLabel);
        nameInput = new JTextField();
        infoPanel.add(nameInput);
        nameInput.setColumns(10);
        JLabel birthLabel = new JLabel("出生年月");
        infoPanel.add(birthLabel);
        JPanel birthPanel = new JPanel();
        infoPanel.add(birthPanel);
        yearInput = new JTextField();
        birthPanel.add(yearInput);
        yearInput.setColumns(10);
        JLabel yearLabel = new JLabel("年");
        birthPanel.add(yearLabel);
        monthInput = new JTextField();
        birthPanel.add(monthInput);
        monthInput.setColumns(10);
        JLabel monthLabel = new JLabel("月");
        birthPanel.add(monthLabel);
        JLabel wageLabel = new JLabel("基本工薪");
        infoPanel.add(wageLabel);
        wageInput = new JTextField();
        infoPanel.add(wageInput);
        wageInput.setColumns(10);
        JLabel emailLabel = new JLabel("Email");
        infoPanel.add(emailLabel);
        emailInput = new JTextField();
        infoPanel.add(emailInput);
        emailInput.setColumns(10);
        JPanel button = new JPanel();
        frame.getContentPane().add(button, BorderLayout.SOUTH);
        JButton confirmButton = new JButton("确定");
        confirmButton.addActionListener(new AddEmployeeListener(this, frame));
        button.add(confirmButton);
        JButton cancelButton = new JButton("取消");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        button.add(cancelButton);
    }
    public String getNumInput() {
        return numInput.getText();
    }

    public String getNameInput() {
        return nameInput.getText();
    }

    public String getWageInput() {
        return wageInput.getText();
    }

    public String getEmailInput() {
        return emailInput.getText();
    }

    public String getYearInput() {
        return yearInput.getText();
    }

    public String getMonthInput() {
        try {
            return String.format("%02d", Integer.parseInt(monthInput.getText()));
        } catch (Exception e) {
            return "";
        }
    }

    public void setNumInput(String content) {
        this.numInput.setText(content);
    }

    public void setNameInput(String content) {
        this.nameInput.setText(content);
    }

    public void setWageInput(String content) {
        this.wageInput.setText(content);
    }

    public void setEmailInput(String content) {
        this.emailInput.setText(content);
    }

    public void setBirthInput(String year, String month) {
        this.yearInput.setText(year);
        this.monthInput.setText(month);
    }

}
