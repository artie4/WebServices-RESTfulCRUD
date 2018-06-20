package org.customws.restfulcrud.model;

public class Department {

    private String departmentCode;
    private String departmentName;

    enum department {
        ACAS,
        ACBP,
        ACSC
    }

    public Department(String departmentCode, String departmentName) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
