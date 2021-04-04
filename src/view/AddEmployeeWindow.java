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

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField numInput;
	private JTextField nameInput;
	private JTextField wageInput;
	private JTextField emailInput;
	private JTextField yearInput;
	private JTextField monthInput;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AddEmployeeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		frame.setTitle("\u6DFB\u52A0\u4FE1\u606F");
		frame.setBounds(100, 100, 383, 374);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setLocationRelativeTo(frame);
		frame.setVisible(true);
		
		JLabel addTitleLabel = new JLabel("\u6DFB\u52A0\u804C\u5DE5\u4FE1\u606F");
		addTitleLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		addTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(addTitleLabel, BorderLayout.NORTH);
		
		JPanel infoPanel = new JPanel();
		frame.getContentPane().add(infoPanel, BorderLayout.CENTER);
		infoPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel numLabel = new JLabel("\u804C\u5DE5\u5E8F\u53F7");
		numLabel.setHorizontalAlignment(SwingConstants.LEFT);
		infoPanel.add(numLabel);
		
		numInput = new JTextField();
		infoPanel.add(numInput);
		numInput.setColumns(10);
		
		JLabel nameLabel = new JLabel("\u59D3\u540D");
		infoPanel.add(nameLabel);
		
		nameInput = new JTextField();
		infoPanel.add(nameInput);
		nameInput.setColumns(10);
		
		JLabel birthLabel = new JLabel("\u51FA\u751F\u5E74\u6708");
		infoPanel.add(birthLabel);
		
		JPanel birthPanel = new JPanel();
		infoPanel.add(birthPanel);
		
		yearInput = new JTextField();
		birthPanel.add(yearInput);
		yearInput.setColumns(10);
		
		JLabel yearLabel = new JLabel("\u5E74");
		birthPanel.add(yearLabel);
		
		monthInput = new JTextField();
		birthPanel.add(monthInput);
		monthInput.setColumns(10);
		
		JLabel monthLabel = new JLabel("\u6708");
		birthPanel.add(monthLabel);
		
		JLabel wageLabel = new JLabel("\u57FA\u672C\u5DE5\u85AA");
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
		
		JButton confirmButton = new JButton("\u786E\u5B9A");
		confirmButton.addActionListener(new AddEmployeeListener());
		button.add(confirmButton);
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
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
		return monthInput.getText();
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
