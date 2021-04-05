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

	//属性设计为私有避免外部访问修改类中的值，只使用set，get方法修改和获取
	private Integer usrId;
	private String gusrId;
	private String name;
	private Date birthday;
	private String wage;
	private String email;
	private static int count = 0;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

	//以下均为对各个属性的set、get方法
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

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public String getEmail() { return email; }

	public void setEmail(String email) {
		this.email = email;
	}
	//雇员类构造方法：手动输入序号并根据序号生成符合格式的职工序号
	public Employee(String Id, String name, String date, String wage, String email) {
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
	//雇员类构造方法：自动排序ID
	public Employee(String name, String date, String wage, String email) {
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
	//自动生成职工序号
	private String generateUsrId() {
		Calendar calendar = Calendar.getInstance();
		DecimalFormat df = new DecimalFormat("00");
		Integer year = calendar.get(Calendar.YEAR);
		Integer month = calendar.get(Calendar.MONTH);
		return year.toString() + df.format(month) + df.format(this.getUsrId());
	}
	//生成一条职工记录
	public String generateRecord() {

		StringBuilder usrInfo = new StringBuilder();
		usrInfo.append(this.getGusrId() + ",");
		usrInfo.append(this.getName() + ",");
		usrInfo.append(this.getBirthdayOriginal() + ",");
		usrInfo.append(this.getWage() + ",");
		usrInfo.append(this.getEmail());
		return usrInfo.toString();
	}
	//判断是否是有效的邮箱
	public static boolean isVaildEmail(String email) {
		String pattern = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
//		String pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(email);
		return matcher.matches();
	}
	//判断是否是数字
	public static boolean isNumberic (String num) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(num).matches();
	}
	//判断是否为有效字符串
	public static boolean isValidString(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//判断是否为double数字
	public static boolean isDoubleNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	//判断生日格式是否正确
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
