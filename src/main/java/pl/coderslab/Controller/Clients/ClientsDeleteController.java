package pl.coderslab.Controller.Clients;

import pl.coderslab.Dao.ClientsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClientsDeleteController", urlPatterns = "/clients/delete")
public class ClientsDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delClients = new ArrayList<>();
        for (String tmp : request.getParameterValues("client_id")) {
            delClients.add(Integer.parseInt(tmp));
        }

        ClientsDao clientsDao = new ClientsDao();
        int count = clientsDao.deleteClient(delClients);

        response.sendRedirect("/clients/list?countDel=" + count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delClients = new ArrayList<>();
        delClients.add(Integer.parseInt(request.getParameter("client_id")));

        ClientsDao clientsDao = new ClientsDao();
        int count = clientsDao.deleteClient(delClients);

        response.sendRedirect("/clients/list?countDel=" + count);
    }
}