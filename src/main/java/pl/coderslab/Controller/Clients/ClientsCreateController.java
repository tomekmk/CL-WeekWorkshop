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

@WebServlet(name = "ClientsCreateController", urlPatterns = "/clients/create")
public class ClientsCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);
        params.put("client_id", "0");

        try {
            ClientsDao clientsDao = new ClientsDao();
            Clients client = clientsDao.createClient(params);
            if (clientsDao.addClient(client))
                response.sendRedirect("/clients/create?add=y");
            else
                response.sendRedirect("/clients/create?add=n");
        } catch (Exception e) {
            response.sendRedirect("/clients/create?add=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("add", request.getParameter("add"));
        request.setAttribute("pageName", "Dodawanie klienta");

        getServletContext().getRequestDispatcher("/WEB-INF/views/clients/create.jsp").forward(request, response);
    }
}
