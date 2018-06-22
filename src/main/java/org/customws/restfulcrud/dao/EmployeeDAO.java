package org.customws.restfulcrud.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.customws.restfulcrud.model.Computer;
import org.customws.restfulcrud.model.Department;
import org.customws.restfulcrud.model.Employee;

public class EmployeeDAO {

//    public static final EmployeeDAO DAO_INSTANCE = new EmployeeDAO();

    private static final Map<String, Employee> empMap = new HashMap<String, Employee>();

    static {
        initEmps();
    }

    private EmployeeDAO() {}

    private File getFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("source.json").getFile());
        return file;
    }

    private static void initEmps() {

       /* try {

            DAO_INSTANCE.employeeList = new Gson().fromJson(new JsonReader(
                    new FileReader(DAO_INSTANCE.getFile())), EmployeeDAO.class);

            for (Employee empl : DAO_INSTANCE.employeeList) {
                empMap.put(empl.getEmployeeID(), empl);
            }
        }
        catch(IOException ioe) {
            ioe.getStackTrace();
        }*/

        Employee emp1 = new Employee("E_0001", "Tijuana",	"Mccann", "HR Manager");
        Employee emp2 = new Employee("E_0002", "Marg", "Rousseau", "Salesman");
        Employee emp3 = new Employee("E_0003", "Carlos", "Clay", "Auditor");
        Employee emp4 = new Employee("E_0004", "Dino", "Hooker", new Department("ACBP", "Accounting / Payroll"),
        "Account Service Manager", new Computer("HP", "Windows10"));

        empMap.put(emp1.getEmployeeID(), emp1);
        empMap.put(emp2.getEmployeeID(), emp2);
        empMap.put(emp3.getEmployeeID(), emp3);
        empMap.put(emp4.getEmployeeID(), emp4);
    }

    public static Employee getEmployee(String empNo) {
        return empMap.get(empNo);
    }

    public static List<Employee> addEmployee(List<Employee> employees) {
        for (Employee emp: employees
                ) {
            empMap.put(emp.getEmployeeID(), emp);
        }
        return getAllEmployees();
    }

    public static Employee updateEmployee(Employee emp) {
        empMap.put(emp.getEmployeeID(), emp);
        return emp;
    }

    public static void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }

    public static List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }

    List<Employee> list;

}