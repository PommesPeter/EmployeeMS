package model;

public class EmployeeInfo {
    private String usrId;
    private String name;
    private String birthday;
    private String wage;
    private String email;
    //雇员信息类构造方法：根据data数组赋值
    public EmployeeInfo(String[] data) {
        this.usrId = data[0];
        this.name = data[1];
        this.birthday = data[2];
        this.wage = data[3];
        this.email = data[4];
    }
    //雇员信息类构造方法：根据各项数据赋值
    public EmployeeInfo(String usrId, String name, String birthday, String wage, String email) {
        this.usrId = usrId;
        this.name = name;
        this.birthday = birthday;
        this.wage = wage;
        this.email = email;
    }
    //各种get方法
    public String getUsrId() {
        return usrId;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getWage() {
        return wage;
    }

    public String getEmail() {
        return email;
    }
}
