package model;

import java.util.ArrayList;

public class EmployeeInfo {
    public String usrId;
    public String name;
    public String birthday;
    public String wage;
    public String email;
    public String[] data;

    public EmployeeInfo(String[] data) {
        this.usrId = data[0];
        this.name = data[1];
        this.birthday = data[2];
        this.wage = data[3];
        this.email = data[4];
    }

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