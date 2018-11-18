package pl.coderslab.Controller.Employees;

import pl.coderslab.Dao.EmployeesDao;
import pl.coderslab.Entity.Employees;
import pl.coderslab.Service.ParamsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "EmployeesCreateController", urlPatterns = "/employees/create")
public class EmployeesCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);
        params.put("employee_id", "0");

        try {
            EmployeesDao employeesDao = new EmployeesDao();
            Employees employee = employeesDao.createEmployee(params);
            if (employeesDao.addEmployee(employee))
                response.sendRedirect("/employees/create?add=y");
            else
                response.sendRedirect("/employees/create?add=n");
        } catch (Exception e) {
            response.sendRedirect("/employees/create?add=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("add", request.getParameter("add"));
        request.setAttribute("pageName", "Dodawanie pracownika");

        getServletContext().getRequestDispatcher("/WEB-INF/views/employees/create.jsp").forward(request, response);
    }
}
