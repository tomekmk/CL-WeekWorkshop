package pl.coderslab.Controller.Orders;

import pl.coderslab.Dao.OrdersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrdersDeleteController", urlPatterns = "/orders/delete")
public class OrdersDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delOrders = new ArrayList<Integer>();
        for (String tmp : request.getParameterValues("order_id")) {
            delOrders.add(Integer.parseInt(tmp));
        }

        OrdersDao clientsDao = new OrdersDao();
        int count = clientsDao.deleteOrder(delOrders);

        response.sendRedirect("/orders/list?countDel=" + count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delOrders = new ArrayList<>();
        delOrders.add(Integer.parseInt(request.getParameter("order_id")));

        OrdersDao ordersDao = new OrdersDao();
        int count = ordersDao.deleteOrder(delOrders);

        response.sendRedirect("/orders/list?countDel=" + count);
    }
}
