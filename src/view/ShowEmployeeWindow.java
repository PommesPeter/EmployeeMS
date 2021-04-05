package view;

import controller.ShowEmployeeListener;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileReader;

public class ShowEmployeeWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTable infoList;

	/**
	 * Launch the application.
	 */
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
	

	/**
	 * Create the application.
	 */
	public ShowEmployeeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		frame.setTitle("\u804C\u5DE5\u4FE1\u606F\u8868");
		frame.setBounds(100, 100, 952, 637);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);

		JPanel title = new JPanel();
		frame.getContentPane().add(title);
		title.setLayout(new BorderLayout(0, 0));
		
		JPanel footer = new JPanel();
		title.add(footer, BorderLayout.SOUTH);
		
		JButton confirmButton = new JButton("\u786E\u5B9A");
		footer.add(confirmButton);
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		footer.add(cancelButton);

		String colName[] = {"职工序号", "姓名", "出生年月", "基本工薪", "Email"};
		infoList = new JTable();
		JScrollPane scrollPane = new JScrollPane(infoList);
		infoList.setFont(new Font("Dialog", Font.BOLD, 12));
		title.add(scrollPane, BorderLayout.CENTER);


		JLabel titleLabel = new JLabel("\u804C\u5DE5\u4FE1\u606F");
		titleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(titleLabel, BorderLayout.NORTH);
	}

	public String[][] getData() {
		String[][] data = new String[3][5];
		FileReader r = new FileReader()
	}

	public void updateTable(JTable table, String[][] content) {

	}
}
