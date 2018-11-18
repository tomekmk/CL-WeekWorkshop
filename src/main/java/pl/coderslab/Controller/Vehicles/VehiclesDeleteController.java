package pl.coderslab.Controller.Vehicles;

import pl.coderslab.Dao.VehiclesDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "VehiclesDeleteController", urlPatterns = "/vehicles/delete")
public class VehiclesDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delVehicles = new ArrayList<>();
        for (String tmp : request.getParameterValues("vehicle_id")) {
            delVehicles.add(Integer.parseInt(tmp));
        }

        VehiclesDao vehiclesDao = new VehiclesDao();
        int count = vehiclesDao.deleteVehicle(delVehicles);

        response.sendRedirect("/vehicles/list?countDel=" + count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Integer> delVehicles = new ArrayList<>();
        delVehicles.add(Integer.parseInt(request.getParameter("vehicle_id")));

        VehiclesDao vehiclesDao = new VehiclesDao();
        int count = vehiclesDao.deleteVehicle(delVehicles);

        response.sendRedirect("/vehicles/list?countDel=" + count);
    }
}
