package org.customws.restfulcrud.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    private String employeeID;
    private String firstName;
    private String lastName;
    private Department department;
    private String position;
    private Computer computer;

    // This default constructor is required if there are other constructors.
    public Employee() {}

    public Employee(String employeeID, String firstName, String lastName, String position) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public Employee(String employeeID, String firstName, String lastName, Department department,
                    String position, Computer computer) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.computer = computer;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeID, employee.employeeID) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, firstName, lastName, position);
    }
}