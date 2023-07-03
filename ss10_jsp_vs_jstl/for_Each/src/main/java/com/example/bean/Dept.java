package com.example.bean;

import java.util.HashSet;
import java.util.Set;

public class Dept {
    private int depNo;
    private String deptName;
    private String location;

    private Set<Emp> employees;

    public Dept() {
    }

    public Dept(int depNo, String deptName, String location) {
        this.depNo = depNo;
        this.deptName = deptName;
        this.location = location;
    }



    public int getDepNo() {
        return depNo;
    }

    public void setDepNo(int depNo) {
        this.depNo = depNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Emp> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Emp> employees) {
        this.employees = employees;
    }
    public  void addEmployee(Emp employee){
        if(this.employees == null){
            this.employees = new HashSet<>();

        }
        this.employees.add(employee);
    }
}
