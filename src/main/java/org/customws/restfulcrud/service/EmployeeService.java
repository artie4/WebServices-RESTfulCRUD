package org.customws.restfulcrud.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.customws.restfulcrud.dao.EmployeeDAO;
import org.customws.restfulcrud.model.Employee;

@Path("/employees")
public class EmployeeService {

    // URI:
    // /contextPath/servletPath/employees
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Employee> getEmployees_JSON() {
        List<Employee> listOfCountries = EmployeeDAO.getAllEmployees();
        return listOfCountries;
    }

    // URI:
    // /contextPath/servletPath/employees/{empNo}
    @GET
    @Path("/{employeeID}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee getEmployee(@PathParam("employeeID") String employeeID) {
        return EmployeeDAO.getEmployee(employeeID);
    }

    // URI:
    // /contextPath/servletPath/employees
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Employee> addEmployee(List<Employee> employees) {
        return EmployeeDAO.addEmployee(employees);
    }

    // URI:
    // /contextPath/servletPath/employees
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Employee updateEmployee(Employee emp) {
        return EmployeeDAO.updateEmployee(emp);
    }

    @DELETE
    @Path("/{employeeID}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteEmployee(@PathParam("employeeID") String employeeID) {
        EmployeeDAO.deleteEmployee(employeeID);
    }

}