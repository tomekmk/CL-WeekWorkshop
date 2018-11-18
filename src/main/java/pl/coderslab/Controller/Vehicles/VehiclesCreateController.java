package pl.coderslab.Controller.Vehicles;

import pl.coderslab.Dao.ClientsDao;
import pl.coderslab.Dao.VehiclesDao;
import pl.coderslab.Entity.Clients;
import pl.coderslab.Entity.Vehicles;
import pl.coderslab.Service.ParamsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "VehiclesCreateController", urlPatterns = "/vehicles/create")
public class VehiclesCreateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);
        params.put("vehicle_id", "0");

        try {
            VehiclesDao vehiclesDao = new VehiclesDao();
            Vehicles vehicle = vehiclesDao.createVehicle(params);
            if (vehiclesDao.addVehicle(vehicle))
                response.sendRedirect("/vehicles/create?add=y");
            else
                response.sendRedirect("/vehicles/create?add=n");

        } catch (Exception e) {
            response.sendRedirect("/vehicles/create?add=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("add", request.getParameter("add"));
        request.setAttribute("pageName", "Dodawanie samochodu");

        ClientsDao clientsDao = new ClientsDao();
        List<Clients> clients = clientsDao.findAll();
        request.setAttribute("clients", clients);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/create.jsp").forward(request, response);
    }
}
