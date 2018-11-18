package pl.coderslab.Controller.Employees;

import pl.coderslab.Dao.EmployeesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeesDeleteController", urlPatterns = "/employees/delete")
public class EmployeesDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delEmployees = new ArrayList<>();
        for (String tmp : request.getParameterValues("employee_id")) {
            delEmployees.add(Integer.parseInt(tmp));
        }

        EmployeesDao employeesDao = new EmployeesDao();
        int count = employeesDao.deleteEmployee(delEmployees);

        response.sendRedirect("/employees/list?countDel=" + count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delEmployees = new ArrayList<>();
        delEmployees.add(Integer.parseInt(request.getParameter("employee_id")));

        EmployeesDao employeesDao = new EmployeesDao();
        int count = employeesDao.deleteEmployee(delEmployees);

        response.sendRedirect("/employees/list?countDel=" + count);
    }
}
