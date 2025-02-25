package com.example.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name="employeeDetails")
public class EmpsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int emp_id;
        private String emp_name;
        private String emp_dept;
        private String emp_job;
        private long emp_salary;
        private String emp_email;

    public EmpsModel() {

    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_dept() {
        return emp_dept;
    }

    public void setEmp_dept(String emp_dept) {
        this.emp_dept = emp_dept;
    }

    public String getEmp_job() {
        return emp_job;
    }

    public void setEmp_job(String emp_job) {
        this.emp_job = emp_job;
    }

    public long getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(long emp_salary) {
        this.emp_salary = emp_salary;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public EmpsModel(int emp_id, String emp_name, String emp_dept, String emp_job, long emp_salary, String emp_email) {
            this.emp_id = emp_id;
            this.emp_name = emp_name;
            this.emp_dept = emp_dept;
            this.emp_job = emp_job;
            this.emp_salary = emp_salary;
            this.emp_email = emp_email;
        }



    }


