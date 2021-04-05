package model;
public class testEmployee {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee("Peter", "20200210", "3000.2", "190030126@guet.cn.com");
		
		System.out.println(employee.getGusrId());
		
		Employee employee2 = new Employee("Tee", "20200203", "3000.2", "434596665@qq.com");
		System.out.println(employee2.getGusrId());

		System.out.println(employee.getBirthdayOriginal());
		employee.setBirthday("20000601");
		System.out.println(employee.getBirthdayOriginal());
		System.out.println(Employee.isDoubleNumber(employee.getWage().toString()));
		System.out.println(employee.generateRecord());
		
	}

}
