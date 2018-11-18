package pl.coderslab.Controller.Vehicles;

import pl.coderslab.Dao.VehiclesDao;
import pl.coderslab.Entity.Vehicles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "VehiclesListController", urlPatterns = "/vehicles/list")
public class VehiclesListController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VehiclesDao vehiclesDao= new VehiclesDao();
        List<Vehicles> vehicles = vehiclesDao.findAll();

        request.setAttribute("countDel", request.getParameter("countDel"));        //a count of deleted clients
        request.setAttribute("pageName", "Lista samochodów");
        request.setAttribute("edited", request.getParameter("edited"));

        if (vehicles != null) {
            request.setAttribute("vehicles", vehicles);
        } else
            request.setAttribute("emptyTable", true);

        getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/list.jsp").forward(request, response);

    }
}
