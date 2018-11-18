package pl.coderslab.Controller.Vehicles;

import pl.coderslab.Dao.ClientsDao;
import pl.coderslab.Dao.OrdersDao;
import pl.coderslab.Dao.VehiclesDao;
import pl.coderslab.Entity.Clients;
import pl.coderslab.Entity.Orders;
import pl.coderslab.Entity.Vehicles;
import pl.coderslab.Service.ParamsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "VehiclesUpdateController", urlPatterns = "/vehicles/update")
public class VehiclesUpdateController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> params = ParamsService.getParams(request);

        try {
            VehiclesDao vehiclesDao = new VehiclesDao();
            Vehicles vehicle = vehiclesDao.createVehicle(params);
            vehiclesDao.updateVehicle(vehicle);
            response.sendRedirect("/vehicles/list?edited=y");
        } catch (Exception e) {
            response.sendRedirect("/vehicles/list?edited=n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        VehiclesDao vehiclesDao = new VehiclesDao();
        int id = Integer.parseInt(request.getParameter("vehicle_id"));
        Vehicles vehicle = vehiclesDao.getVehicle(id);

        ClientsDao clientsDao = new ClientsDao();
        List<Clients> clients = clientsDao.findAll();
        request.setAttribute("clients", clients);

        request.setAttribute("edited", request.getParameter("edited"));
        request.setAttribute("vehicle", vehicle);
        request.setAttribute("pageName", "Edycja samochodu: " + vehicle.getMark() + " "
                + vehicle.getModel() + " " + vehicle.getRegistNumber());

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/update.jsp").forward(request, response);
    }
}
