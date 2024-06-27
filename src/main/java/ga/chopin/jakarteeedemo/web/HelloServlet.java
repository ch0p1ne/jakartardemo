package ga.chopin.jakarteeedemo.web;

import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import ga.chopin.jakarteeedemo.dao.implementations.*;
import ga.chopin.jakarteeedemo.dao.interfaces.*;
import ga.chopin.jakarteeedemo.services.entities.User;
import ga.chopin.jakarteeedemo.web.model.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.grammars.hql.HqlParser;

@WebServlet(name = "helloServlet", value = {"/"})
public class HelloServlet extends HttpServlet {
    private IImmeubleDAO immeubleDAO;
    private ILocataireDAO locataireDAO;
    private ILocationUnitDAO locationUnitDAO;
    private IUserDAO userDAO;
    private IPaymentDAO paymentDAO;
    private ILocationsContratDAO locationsContratDAO;
    HttpSession session;

    @Override
    public void init() throws ServletException {
        immeubleDAO = new ImmeubleDAOImpl();
        locataireDAO = new LocataireDAOImpl();
        locationUnitDAO = new LocationUnitDAOImpl();
        userDAO = new UserDAOImpl();
        paymentDAO = new PaymentDAOImpl();
        locationsContratDAO = new LocationsContratDAOImpl();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getServletPath();
        if (path.equals("/accueil")) {
            request.getRequestDispatcher("pages/accueil.jsp").forward(request, response);
        }
        else if (path.equals("/liste-utilisateur")) {
            UserModel model = new UserModel();
            List<User> users = userDAO.findAll();
            model.setUsers(users);
            request.setAttribute("model",model);

            request.getRequestDispatcher("pages/utilisateur/liste-utilisateur.jsp").forward(request, response);
        }
        else if (path.equals("/inscription")) {
            HttpSession session = request.getSession();
            if(session.getAttribute("user") != null) {
                response.sendRedirect("accueil");
            }
            else
            request.getRequestDispatcher("pages/utilisateur/inscription.jsp").forward(request, response);

        }
        else if (path.equals("/connexion")) {
            HttpSession session = request.getSession();
            if(session.getAttribute("user") == null) {
                request.getRequestDispatcher("pages/utilisateur/connexion.jsp").forward(request, response);

            }else
                response.sendRedirect("accueil");


        }
        else if (path.equals("/authentification")  && request.getMethod().equals("POST")) {
            HttpSession session = request.getSession();
            String login = request.getParameter("email");
            String password = request.getParameter("password");
            System.out.println(login);
            System.out.println(password);
            User user = userDAO.authenticate(login, password);
            if(user != null) {
                session.setAttribute("user", user);
                response.sendRedirect("profil");
            }
            else {
                session.setAttribute("error", "Invalid email or password");
                response.sendRedirect("connexion");
            }
        }
        else if (path.equals("/deconnexion")) {
            HttpSession session = request.getSession();
            session.invalidate();
            System.out.println("session invalid ohhh ouiii");
            request.getRequestDispatcher("pages/accueil.jsp").forward(request, response);

        }
        else if ((path.equals("/ajout-utilisateur")) && (request.getMethod().equals("POST"))) {
            User user;
            HttpSession session = request.getSession();
            String nom = request.getParameter("last_name");
            String prenom = request.getParameter("first_name");
            String sexe = request.getParameter("sexe");
            String role = request.getParameter("role");
            String actif = "Y";
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));

            user = new User(null, prenom, nom, role, actif, sexe,email, password, dateNaissance );
            userDAO.save(user);
            session.setAttribute("user",user);

            response.sendRedirect("liste-utilisateur");
        }
        else if (path.equals("/profil")) {
            request.getRequestDispatcher("pages/utilisateur/profil.jsp").forward(request, response);
        } else if (path.equals("/update") && (request.getMethod().equals("POST"))) {
            User user;
            HttpSession session = request.getSession();
            String nom = request.getParameter("last_name");
            String prenom = request.getParameter("first_name");
            String sexe = request.getParameter("sexe");
            String role = request.getParameter("role");
            String actif = "Y";
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));

            user = new User(null, prenom, nom, role, actif, sexe,email, password, dateNaissance );
            userDAO.update(user);
            session.setAttribute("user",user);

            response.sendRedirect("profil");
        } else {
            System.out.println(path);
            response.sendError(response.SC_NOT_FOUND);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    public void destroy() {
    }
}