package pl.coderslab.Controller.Employees;

import pl.coderslab.Dao.EmployeesDao;
import pl.coderslab.Entity.Employees;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeesListController", urlPatterns = "/employees/list")
public class EmployeesListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeesDao employeesDao = new EmployeesDao();
        List<Employees> employees = employeesDao.findAll();

        request.setAttribute("countDel", request.getParameter("countDel"));        //a count of deleted employess
        request.setAttribute("pageName", "Lista pracowników");
        request.setAttribute("edited", request.getParameter("edited"));

        if (employees != null)
            request.setAttribute("employees", employees);
        else
            request.setAttribute("emptyTable", true);

        getServletContext().getRequestDispatcher("/WEB-INF/views/employees/list.jsp").forward(request, response);
    }
}
