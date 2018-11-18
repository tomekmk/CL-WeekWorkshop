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

@WebServlet(name = "OrdersUpdateController", urlPatterns = "/orders/update")
public class OrdersUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);

        try {
            OrdersDao ordersDao = new OrdersDao();
            Orders order = ordersDao.createOrder(params);
            ordersDao.updateOrder(order);
            response.sendRedirect("/orders/list?edited=y");
        } catch (Exception e) {
            response.sendRedirect("/orders/list?edited=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OrdersDao ordersDao = new OrdersDao();
        int id = Integer.parseInt(request.getParameter("order_id"));
        Orders order = ordersDao.getOrder(id);

        EmployeesDao employeesDao = new EmployeesDao();
        List<Employees> employees = employeesDao.findAll();
        request.setAttribute("employees", employees);

        VehiclesDao vehiclesDao = new VehiclesDao();
        List<Vehicles> vehicles = vehiclesDao.findAll();
        request.setAttribute("vehicles", vehicles);

        request.setAttribute("edited", request.getParameter("edited"));
        request.setAttribute("order", order);
        request.setAttribute("pageName", "Edycja zlecenia: " + order.getVehicle().getMark() + " "
                + order.getVehicle().getModel() + " " + order.getVehicle().getRegistNumber());

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders/update.jsp").forward(request, response);
    }
}
