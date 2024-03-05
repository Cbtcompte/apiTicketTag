package jpa.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.builders.ProjetBuilder;
import jpa.dtos.ProjetDto;
import jpa.services.ProjetService;
import jpa.utils.Formatter;

@WebServlet(name = "ProjetController", urlPatterns = { "/projet" })
public class ProjetController extends HttpServlet {
    private ProjetService projetService;

    public ProjetController() {
        super();
        projetService = new ProjetService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter p = new PrintWriter(resp.getOutputStream());        
        p.print(projetService.getAllProjet());
        p.flush();
        // System.err.println("hello");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter pin = new PrintWriter(resp.getOutputStream());        
        ProjetDto p;
        try {
            p = new ProjetBuilder()
                    .setTheme(req.getParameter("theme"))
                    .setDescription(req.getParameter("description"))
                    .setEndProjet(Formatter.getFormatterInstance()
                            .parse(req.getParameter("endProjet")))
                    .setStartProjet(Formatter.getFormatterInstance()
                            .parse(req.getParameter("startProjet")))
                    .buildDto();
            ProjetDto pr = projetService.addProjet(p);
            pin.print(pr);
            pin.flush();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
