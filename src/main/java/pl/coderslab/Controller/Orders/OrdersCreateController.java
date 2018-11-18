package pl.coderslab.Controller.Orders;

import pl.coderslab.Dao.EmployeesDao;
import pl.coderslab.Dao.OrdersDao;
import pl.coderslab.Dao.VehiclesDao;
import pl.coderslab.Entity.Employees;
import pl.coderslab.Entity.Orders;
import pl.coderslab.Entity.Vehicles;
import pl.coderslab.Service.ParamsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OrdersCreateController", urlPatterns = "/orders/create")
public class OrdersCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);
        params.put("order_id", "0");

        try {
            OrdersDao ordersDao = new OrdersDao();
            Orders order = ordersDao.createOrder(params);
            if (ordersDao.addOrder(order))
                response.sendRedirect("/orders/create?add=y");
            else
                response.sendRedirect("/orders/create?add=n");

        } catch (Exception e) {
            response.sendRedirect("/orders/create?add=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("add", request.getParameter("add"));
        request.setAttribute("pageName", "Dodawanie zlecenia");

        EmployeesDao employeesDao = new EmployeesDao();
        List<Employees> employees = employeesDao.findAll();
        request.setAttribute("employees", employees);

        VehiclesDao vehiclesDao = new VehiclesDao();
        List<Vehicles> vehicles = vehiclesDao.findAll();
        request.setAttribute("vehicles", vehicles);

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders/create.jsp").forward(request, response);
    }
}
