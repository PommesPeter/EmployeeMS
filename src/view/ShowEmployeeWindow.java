package view;
import model.Config;
import model.EmployeeInfo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShowEmployeeWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable infoList;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowEmployeeWindow window = new ShowEmployeeWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ShowEmployeeWindow() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		frame.setTitle("职员信息表");
		frame.setBounds(100, 100, 952, 637);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		JPanel title = new JPanel();
		frame.getContentPane().add(title);
		title.setLayout(new BorderLayout(0, 0));
		JPanel footer = new JPanel();
		title.add(footer, BorderLayout.SOUTH);
		JButton confirmButton = new JButton("确定");
		footer.add(confirmButton);
		JButton cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		footer.add(cancelButton);
		ArrayList<EmployeeInfo> tableDataList = null;
		String[][] tableData;
		String colName[] = {"职工序号", "姓名", "出生年月", "基本工薪", "Email"};
		try {
			tableDataList = getDataList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert tableDataList != null;
		tableData = new String[tableDataList.size()][5];
		for (int i = 0; i < tableDataList.size(); i++) {
			tableData[i][0] = tableDataList.get(i).getUsrId();
			tableData[i][1] = tableDataList.get(i).getName();
			tableData[i][2] = tableDataList.get(i).getBirthday();
			tableData[i][3] = tableDataList.get(i).getWage();
			tableData[i][4] = tableDataList.get(i).getEmail();
		}
		infoList = new JTable(tableData, colName);
		JScrollPane scrollPane = new JScrollPane(infoList);
		infoList.setFont(new Font("Dialog", Font.BOLD, 12));
		title.add(scrollPane, BorderLayout.CENTER);
		JLabel titleLabel = new JLabel("职员信息");
		titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(titleLabel, BorderLayout.NORTH);
	}
	public ArrayList<EmployeeInfo> getDataList() throws IOException {
		ArrayList<EmployeeInfo> list = new ArrayList<>();
		FileReader r = new FileReader(Config.DATAFILEPATH);
		BufferedReader br = new BufferedReader(r);
		String tmpString;
		//在使用read或readLine作为判断条件的时候需要注意在判断的时候已经读从文件流中读入一次了，如果循环体中继续写read的方法的话会导致缺失字符。
		while ((tmpString = br.readLine()) != null) {
			String[] splitData = tmpString.split(",");
			EmployeeInfo e = new EmployeeInfo(splitData);
			list.add(e);
		}
		return list;
	}
}
