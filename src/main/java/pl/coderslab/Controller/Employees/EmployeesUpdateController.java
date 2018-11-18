package pl.coderslab.Controller.Employees;

import pl.coderslab.Dao.EmployeesDao;
import pl.coderslab.Dao.VehiclesDao;
import pl.coderslab.Entity.Employees;
import pl.coderslab.Entity.Vehicles;
import pl.coderslab.Service.ParamsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EmployeesUpdateController", urlPatterns = "/employees/update")
public class EmployeesUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);

        try {
            EmployeesDao employeesDao = new EmployeesDao();
            Employees employee = employeesDao.createEmployee(params);
            employeesDao.updateEmployee(employee);
            response.sendRedirect("/employees/list?edited=y");
        } catch (Exception e) {
            response.sendRedirect("/employees/list?edited=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeesDao employeesDao = new EmployeesDao();
        int id = Integer.parseInt(request.getParameter("employee_id"));
        Employees employee = employeesDao.getEmployee(id);

        request.setAttribute("edited", request.getParameter("edited"));
        request.setAttribute("employee", employee);
        request.setAttribute("pageName", "Edycja pracownika: " + employee.getName() + " " + employee.getSurname());

        getServletContext().getRequestDispatcher("/WEB-INF/views/employees/update.jsp").forward(request, response);
    }
}
