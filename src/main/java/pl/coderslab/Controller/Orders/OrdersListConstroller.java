package pl.coderslab.Controller.Orders;

import pl.coderslab.Dao.OrdersDao;
import pl.coderslab.Entity.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersListConstroller", urlPatterns = "/orders/list")
public class OrdersListConstroller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdersDao ordersDao = new OrdersDao();
        List<Orders> orders = ordersDao.findAll();

        request.setAttribute("countDel", request.getParameter("countDel"));        //a count of deleted clients
        request.setAttribute("pageName", "Lista zleceń");
        request.setAttribute("edited", request.getParameter("edited"));

        if (orders != null) {
            request.setAttribute("orders", orders);
        } else
            request.setAttribute("emptyTable", true);

        getServletContext().getRequestDispatcher("/WEB-INF/views/orders/list.jsp").forward(request, response);

    }
}
