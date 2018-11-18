package pl.coderslab.Controller.Clients;

import pl.coderslab.Dao.ClientsDao;
import pl.coderslab.Entity.Clients;
import pl.coderslab.Service.ParamsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ClientsUpdateController", urlPatterns = "/clients/update")
public class ClientsUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);

        try {
            ClientsDao clientsDao = new ClientsDao();
            Clients client = clientsDao.createClient(params);
            clientsDao.updateClient(client);
            response.sendRedirect("/clients/list?edited=y");
        } catch (Exception e) {
            response.sendRedirect("/clients/list?edited=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClientsDao clientsDao = new ClientsDao();
        int id = Integer.parseInt(request.getParameter("client_id"));
        Clients client = clientsDao.getClient(id);

        request.setAttribute("edited", request.getParameter("edited"));
        request.setAttribute("client", client);
        request.setAttribute("pageName", "Edycja klienta: " + client.getName() + " " + client.getSurname());

        getServletContext().getRequestDispatcher("/WEB-INF/views/clients/update.jsp").forward(request, response);
    }
}
