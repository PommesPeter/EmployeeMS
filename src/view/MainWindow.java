package view;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import controller.ShowEmployeeListener;
import model.Config;
import model.Employee;
import model.EmployeeInfo;
import model.MessageDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
            String tmp;
            while ((tmp = br.readLine()) != null) {
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
        ImageIcon titleIc = new ImageIcon(Config.IMAGETITLEPATH);
        JLabel title = new JLabel(titleIc, JLabel.CENTER);
        title.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 35));
        frame.getContentPane().add(title, BorderLayout.NORTH);

        JLabel footer = new JLabel("Copyright@PommesPeter(1900301236谢浚霖)", JLabel.LEFT);
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
        opLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        operatorPanel.add(opLabel);

        JLabel addLabel = new JLabel("\u6DFB\u52A0\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(addLabel);
        operatorPanel.add(addButton);

        JLabel modifyLabel = new JLabel("\u4FEE\u6539\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(modifyLabel);


        JButton modifyButton = new JButton("\u4FEE\u6539");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String usrIdInput = JOptionPane.showInputDialog(null, "请输入要更新的职工的职工序号...", "更新职工信息", JOptionPane.PLAIN_MESSAGE);
                try {
                    if (!Employee.isNumberic(usrIdInput)) {
                        new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工序号格式错误, 请重试....").show();
                        return;
                    }
                } catch (Exception e) {
                    new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工序号为空, 请重试....").show();
                    return;
                }

                for (int i = 0; i < tableDataList.size(); i++) {
                    if (usrIdInput.equals(tableDataList.get(i).getUsrId())) {
                        String usrId = usrIdInput;
                        String nameInput = JOptionPane.showInputDialog(null, "请输入更改后的姓名...(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        if (nameInput.equals("")) {
                            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "姓名为空, 请重试...").show();
                            nameInput = JOptionPane.showInputDialog(null, "请输入更改后的姓名...(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        } else if (nameInput.equals("n") || nameInput.equals("N")) {
                            nameInput = tableDataList.get(i).getName();
                        }
                        String birthInput = JOptionPane.showInputDialog(null, "请输入更改后的生日...(格式:yyyyMM)(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        if (birthInput.equals("")) {
                            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "生日为空, 请重试...").show();
                            birthInput = JOptionPane.showInputDialog(null, "请输入更改后的生日...(格式:yyyyMM)(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        } else if (birthInput.equals("N") || birthInput.equals("n")) {
                            birthInput = tableDataList.get(i).getBirthday();
                        }
                        String wageInput = JOptionPane.showInputDialog(null, "请输入更改后的基本工薪...(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        if (wageInput.equals("")) {
                            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "基本工薪为空, 请重试...").show();
                            wageInput = JOptionPane.showInputDialog(null, "请输入更改后的基本工薪...(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        } else if (wageInput.equals("N") || wageInput.equals("n")) {
                            wageInput = tableDataList.get(i).getWage();
                        }
                        String emailInput = JOptionPane.showInputDialog(null, "请输入更改后的Email...(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        if (emailInput.equals("")) {
                            new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "Email为空, 请重试...").show();
                            emailInput = JOptionPane.showInputDialog(null, "请输入更改后的Email...(输入N为不修改)", "修改信息", JOptionPane.PLAIN_MESSAGE);
                        } else if (emailInput.equals("N") || emailInput.equals("n")) {
                            emailInput = tableDataList.get(i).getEmail();
                        }
                        EmployeeInfo e = new EmployeeInfo(usrId, nameInput, birthInput, wageInput, emailInput);
                        tableDataList.set(i, e);
                        break;
                    }
                }
                updateTxt(tableDataList);
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "操作", "工号序号为:" + usrIdInput + "的职工信息已更新....");

            }
        });
        operatorPanel.add(modifyButton);

        JLabel showLabel = new JLabel("\u663E\u793A\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(showLabel);

        JButton showButton = new JButton("\u5C55\u793A");
        showButton.addActionListener(new ShowEmployeeListener());
        operatorPanel.add(showButton);

        JLabel delLabel = new JLabel("\u5220\u9664\u804C\u5DE5\u4FE1\u606F");
        operatorPanel.add(delLabel);

        JButton delButton = new JButton("\u5220\u9664");
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MessageDialog("input", JOptionPane.PLAIN_MESSAGE, "删除职工信息", "请输入要删除的职工的职工序号...").show();
                try {
                    if (!Employee.isNumberic(MessageDialog.inputValue)) {
                        new MessageDialog("message", JOptionPane.ERROR_MESSAGE, "输入错误", "职工序号格式错误, 请重试....").show();
                        new MessageDialog("input", JOptionPane.PLAIN_MESSAGE, "删除工号", "请输入要删除的职工的职工序号...").show();
                    }
                } catch (Exception e) {
                    new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "输入错误", "职工序号为空, 请重试....").show();
                    return;
                }

                for (int i = 0; i < tableDataList.size(); i++) {
                    if (MessageDialog.inputValue.equals(tableDataList.get(i).getUsrId())) {
                        tableDataList.remove(i);
                        break;
                    }
                }
                updateTxt(tableDataList);
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "操作", "工号序号为:" + MessageDialog.inputValue + "的职工信息删除成功....");
            }
        });
        operatorPanel.add(delButton);

        JPanel staticsPanel = new JPanel();
        frame.getContentPane().add(staticsPanel, BorderLayout.EAST);
        staticsPanel.setLayout(new GridLayout(9, 1, 0, 0));

        JLabel staticsLabel = new JLabel("\u7EDF\u8BA1");
        staticsLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
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

        ImageIcon ic = new ImageIcon(Config.IMAGEBANNERPATH);
        JLabel image = new JLabel(ic);
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

    public void updateTxt(ArrayList<EmployeeInfo> l) {
        try {
            FileWriter w = new FileWriter(Config.DATAFILEPATH);
            BufferedWriter bw = new BufferedWriter(w);
            for (EmployeeInfo employeeInfo : l) {
                StringBuilder rowLine = new StringBuilder();
                rowLine.append(employeeInfo.getUsrId()).append(",");
                rowLine.append(employeeInfo.getName()).append(",");
                rowLine.append(employeeInfo.getBirthday()).append(",");
                rowLine.append(employeeInfo.getWage()).append(",");
                rowLine.append(employeeInfo.getEmail());
                bw.write(rowLine.toString());
                bw.newLine();
            }
            bw.close();
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}