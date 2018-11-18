package pl.coderslab.Controller.OtherPages;

import pl.coderslab.Dao.MainPageDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainPage", urlPatterns = "/index")
public class MainPage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MainPageDao mainPageDao = new MainPageDao();
        request.setAttribute("clients", mainPageDao.count("Clients"));
        request.setAttribute("employees", mainPageDao.count("Employees"));
        request.setAttribute("orders", mainPageDao.count("Orders"));
        request.setAttribute("vehicles", mainPageDao.count("Vehicles"));

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
