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

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JFrame frame;
    ArrayList<EmployeeInfo> tableDataList;
    public MainWindow() {
        initialize();
        //窗口启动之后先初始化窗口和数据，加快程序效率
        this.tableDataList = new ArrayList<>();
        FileReader r = null;
        try {
            //读取data.csv文件
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
    //初始化窗口
    private void initialize() {
        frame = new JFrame();
        frame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        frame.setTitle("职工信息管理系统 开发者:谢浚霖(1900301236) 指导老师:郭标");
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
        JButton addButton = new JButton("添加");
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
        JLabel opLabel = new JLabel("操作");
        opLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        operatorPanel.add(opLabel);
        JLabel addLabel = new JLabel("添加职工信息");
        operatorPanel.add(addLabel);
        operatorPanel.add(addButton);
        JLabel modifyLabel = new JLabel("修改职工信息");
        operatorPanel.add(modifyLabel);
        JButton modifyButton = new JButton("修改");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //处理修改员工信息的逻辑
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
                updateCsv(tableDataList);
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "操作", "工号序号为:" + usrIdInput + "的职工信息已更新....");
            }
        });
        operatorPanel.add(modifyButton);
        JLabel showLabel = new JLabel("显示职工信息");
        operatorPanel.add(showLabel);
        JButton showButton = new JButton("显示");
        showButton.addActionListener(new ShowEmployeeListener());
        operatorPanel.add(showButton);
        JLabel delLabel = new JLabel("删除职工信息");
        operatorPanel.add(delLabel);
        JButton delButton = new JButton("删除");
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //处理删除员工信息的逻辑
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
                updateCsv(tableDataList);
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "操作", "工号序号为:" + MessageDialog.inputValue + "的职工信息删除成功....");
            }
        });
        operatorPanel.add(delButton);
        JPanel staticsPanel = new JPanel();
        frame.getContentPane().add(staticsPanel, BorderLayout.EAST);
        staticsPanel.setLayout(new GridLayout(9, 1, 0, 0));
        JLabel staticsLabel = new JLabel("统计");
        staticsLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
        staticsPanel.add(staticsLabel);
        JLabel numLabel = new JLabel("显示职工人数");
        staticsPanel.add(numLabel);
        JButton numButton = new JButton("职工人数");
        numButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //显示职工人数
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "查询结果", "目前共有" + tableDataList.size() + "名员工").show();
            }
        });
        staticsPanel.add(numButton);
        JLabel avgLabel = new JLabel("显示平均薪资");
        staticsPanel.add(avgLabel);
        JButton avgButton = new JButton("平均薪资");
        avgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //显示平均薪资
                Double sum = 0.0;
                DecimalFormat df = new DecimalFormat("#.000");
                for (EmployeeInfo employeeInfo : tableDataList) {
                    sum += Double.parseDouble(employeeInfo.getWage());
                }
                new MessageDialog("message", JOptionPane.PLAIN_MESSAGE, "查询结果", "目前所有职工的平均基本工薪为: " + df.format(sum / tableDataList.size()) + "元").show();
            }
        });
        staticsPanel.add(avgButton);
        JLabel maxLabel = new JLabel("显示最高薪资");
        staticsPanel.add(maxLabel);
        JButton maxButton = new JButton("最高薪资");
        maxButton.addActionListener(new ActionListener() {
            //显示最高薪资
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
        JLabel minLabel = new JLabel("显示最低薪资");
        staticsPanel.add(minLabel);
        JButton minButton = new JButton("最低薪资");
        minButton.addActionListener(new ActionListener() {
            //显示最低薪资
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
        JMenu otherMenu = new JMenu("其他(O)...");
        menuBar.add(otherMenu);
        JMenuItem aboutItem = new JMenuItem("关于我");
        otherMenu.add(aboutItem);
    }
    //更新csv文件
    public void updateCsv(ArrayList<EmployeeInfo> l) {
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