package pl.coderslab.Controller.Clients;

import pl.coderslab.Dao.ClientsDao;
import pl.coderslab.Entity.Clients;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientsListController", urlPatterns = "/clients/list")
public class ClientsListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientsDao clientsDao = new ClientsDao();
        List<Clients> clients = clientsDao.findAll();

        request.setAttribute("countDel", request.getParameter("countDel"));        //a count of deleted clients
        request.setAttribute("pageName", "Lista klientów");
        request.setAttribute("edited", request.getParameter("edited"));

        if (clients != null)
            request.setAttribute("clients", clients);
        else
            request.setAttribute("emptyTable", true);

        getServletContext().getRequestDispatcher("/WEB-INF/views/clients/list.jsp").forward(request, response);
    }
}
