package view;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import controller.AddEmployeeListener;
import controller.ShowEmployeeListener;
import model.Config;
import model.EmployeeInfo;
import model.MessageDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainWindow extends JFrame {


    private static final long serialVersionUID = 1L;
    private JFrame frame;
    ArrayList<EmployeeInfo> tableDataList;

    /**
     * Create the application.
     */
    public MainWindow() {
        initialize();
        this.tableDataList = new ArrayList<>();
        FileReader r = null;
        try {
            r = new FileReader(Config.DATAFILEPATH);
            BufferedReader br = new BufferedReader(r);
            while (br.read() != -1) {
                String tmp = br.readLine();
                String[] splitData = tmp.split(",");
                EmployeeInfo e = new EmployeeInfo(splitData);
                this.tableDataList.add(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        frame.setTitle("\u804C\u5DE5\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF  \u5F00\u53D1\u8005:\u8C22\u6D5A\u9716(1900301236) \u6307\u5BFC\u8001\u5E08:\u90ED\u6807");
        frame.setBounds(100, 100, 897, 616);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        frame.setVisible(true);
        frame.setLocationRelativeTo(frame);

        JLabel title = new JLabel("\u804C\u5DE5\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF", JLabel.CENTER);
        title.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
        frame.getContentPane().add(title, BorderLayout.NORTH);

        JLabel footer = new JLabel("New label");
        frame.getContentPane().add(footer, BorderLayout.SOUTH);

        JPanel operatorPanel = new JPanel();
        frame.getContentPane().add(operatorPanel, BorderLayout.WEST);

        JButton addButton = new JButton("\u6DFB\u52A0");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    AddEmployeeWindow window = new AddEmployeeWindow();
                } catch (Exception exp2) {
                    exp2.printStackTrace();
                }
            }
        });

        operatorPanel.setLayout(new GridLayout(9, 1, 0, 0));

        JLabel opLabel = new JLabel("\u64CD\u4F5C");
        operatorPanel.add(opLabel);

        JLabel addLabel = new JLabel("\u6DFB\u52A0\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(addLabel);
        operatorPanel.add(addButton);

        JLabel modifyLabel = new JLabel("\u4FEE\u6539\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(modifyLabel);

        JButton modifyButton = new JButton("\u4FEE\u6539");
        operatorPanel.add(modifyButton);

        JLabel showLabel = new JLabel("\u663E\u793A\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(showLabel);

        JButton showButton = new JButton("\u5C55\u793A");
        showButton.addActionListener(new ShowEmployeeListener());
        operatorPanel.add(showButton);

        JLabel delLabel = new JLabel("\u5220\u9664\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(delLabel);

        JButton delButton = new JButton("\u5220\u9664");
        operatorPanel.add(delButton);

        JPanel staticsPanel = new JPanel();
        frame.getContentPane().add(staticsPanel, BorderLayout.EAST);
        staticsPanel.setLayout(new GridLayout(9, 1, 0, 0));

        JLabel staticsLabel = new JLabel("\u7EDF\u8BA1");
        staticsPanel.add(staticsLabel);

        JLabel numLabel = new JLabel("\u663E\u793A\u804C\u5DE5\u4EBA\u6570");
        staticsPanel.add(numLabel);

        JButton numButton = new JButton("\u4EBA\u6570");
        numButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //number of the employee
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "查询结果", "目前共有" + tableDataList.size() + "名员工").show();
            }
        });
        staticsPanel.add(numButton);

        JLabel avgLabel = new JLabel("\u663E\u793A\u5E73\u5747\u85AA\u8D44");
        staticsPanel.add(avgLabel);

        JButton avgButton = new JButton("\u5E73\u5747\u85AA\u8D44");
        avgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // average of the wage
                Double sum = 0.0;
                DecimalFormat df = new DecimalFormat("#.000");
                for (EmployeeInfo employeeInfo : tableDataList) {
                    sum += Double.parseDouble(employeeInfo.getWage());
                }
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "查询结果", "目前所有职工的平均基本工薪为: " + df.format(sum / tableDataList.size()) + "元").show();
            }
        });
        staticsPanel.add(avgButton);

        JLabel maxLabel = new JLabel("\u663E\u793A\u6700\u9AD8\u85AA\u8D44");
        staticsPanel.add(maxLabel);

        JButton maxButton = new JButton("\u6700\u9AD8\u85AA\u8D44");
        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Double max = 0.0;
                DecimalFormat df = new DecimalFormat("#.000");
                for (EmployeeInfo employeeInfo : tableDataList) {
                    if (Double.parseDouble(employeeInfo.getWage()) > max) {
                        max = Double.parseDouble(employeeInfo.getWage());
                    }
                }
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "查询结果", "目前最高基本工薪为: " + df.format(max) + "元").show();
            }
        });
        staticsPanel.add(maxButton);

        JLabel minLabel = new JLabel("\u663E\u793A\u6700\u4F4E\u85AA\u8D44");
        staticsPanel.add(minLabel);

        JButton minButton = new JButton("\u6700\u4F4E\u85AA\u8D44");
        minButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Double min = 1e6;
                DecimalFormat df = new DecimalFormat("0.000");
                for (EmployeeInfo employeeInfo : tableDataList) {
                    if (Double.parseDouble(employeeInfo.getWage()) < min) {
                        min = Double.parseDouble(employeeInfo.getWage());
                    }
                }
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "查询结果", "目前最低基本工薪为: " + df.format(min) + "元").show();
            }
        });
        staticsPanel.add(minButton);

        JLabel image = new JLabel("Image");
        frame.getContentPane().add(image, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu operatorMenu = new JMenu("\u4FE1\u606F\u64CD\u4F5C(M)");
        menuBar.add(operatorMenu);

        JMenuItem addItem = new JMenuItem("\u6DFB\u52A0\u804C\u5DE5\u4FE1\u606F");
        operatorMenu.add(addItem);

        JMenuItem modifyItem = new JMenuItem("\u4FEE\u6539\u804C\u5DE5\u4FE1\u606F");
        operatorMenu.add(modifyItem);

        JMenuItem showItem = new JMenuItem("\u663E\u793A\u6240\u6709\u804C\u5DE5\u4FE1\u606F");
        operatorMenu.add(showItem);

        JMenuItem delItem = new JMenuItem("\u5220\u9664\u804C\u5DE5\u4FE1\u606F");
        operatorMenu.add(delItem);

        JMenu staticsMenu = new JMenu("\u7EDF\u8BA1\u4FE1\u606F(S)");
        menuBar.add(staticsMenu);

        JMenuItem numItem = new JMenuItem("\u663E\u793A\u804C\u5DE5\u6570\u91CF");
        staticsMenu.add(numItem);

        JMenuItem avgItem = new JMenuItem("\u663E\u793A\u5E73\u5747\u85AA\u8D44");
        staticsMenu.add(avgItem);

        JMenuItem maxItem = new JMenuItem("\u663E\u793A\u6700\u9AD8\u85AA\u8D44");
        staticsMenu.add(maxItem);

        JMenuItem minItem = new JMenuItem("\u663E\u793A\u6700\u4F4E\u85AA\u8D44");
        staticsMenu.add(minItem);

        JMenu otherMenu = new JMenu("\u5176\u4ED6(O)...");
        menuBar.add(otherMenu);

        JMenuItem aboutItem = new JMenuItem("About");
        otherMenu.add(aboutItem);
    }

}
