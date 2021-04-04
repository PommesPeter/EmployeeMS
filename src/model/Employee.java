package model;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Employee {
	
	private Integer usrId;
	private String gusrId;
	private String name;
	private Date birthday;
	private Double wage;
	private String email;
	private static int count = 0;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	public Integer getUsrId() {
		return usrId;
	}

	public void setGusrId(String usrId) {
		this.gusrId = usrId;
	}
	
	public String getGusrId() {
		return gusrId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public String getBirthdayOriginal() {
		return sdf.format(this.birthday);
	}

	public void setBirthday(String birthday) {
		try {
			this.birthday = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(String Id, String name, String date, double wage, String email) {
		try {
			this.usrId = Integer.parseInt(Id);
			this.name = name;
			this.birthday = this.sdf.parse(date);
			this.wage = wage;
			this.email = email;
			this.gusrId = generateUsrId();
			++count;
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public Employee(String name, String date, double wage, String email) {
		try {
			this.name = name;
			this.birthday = sdf.parse(date);
			this.wage = wage;
			this.email = email;
			this.usrId = ++count;
			this.gusrId = generateUsrId();
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private String generateUsrId() {
		Calendar calendar = Calendar.getInstance();
		DecimalFormat df = new DecimalFormat("00");
		Integer year = calendar.get(Calendar.YEAR);
		Integer month = calendar.get(Calendar.MONTH);
		return year.toString() + df.format(month) + df.format(this.getUsrId());
	}

	public static boolean isVaildEmail(String email) {
		String pattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
//		String pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}

	public static boolean isNumberic (String num) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(num).matches();
	}

	public static boolean isValidString(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isDoubleNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isVaildBirthday(String year, String month) {
		Calendar calendar = Calendar.getInstance();
		Integer nowYear = calendar.get(Calendar.YEAR);
		Integer yearNum = Integer.parseInt(year);
		Integer monthNum = Integer.parseInt(month);
		if (isNumberic(year) && isNumberic(month)) {
			if (monthNum >= 1 && monthNum <= 12 && yearNum <= nowYear) {
				return true;
			} else return false;
		} else return false;
	}

}
