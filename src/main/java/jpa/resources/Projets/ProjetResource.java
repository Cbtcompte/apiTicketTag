package jpa.resources.Projets;

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

@WebServlet(name = "ProjetResource", urlPatterns = { "/projet/*" })
public class ProjetResource extends HttpServlet {
    private ProjetService projetService;

    public ProjetResource() {
        super();
        projetService = new ProjetService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getPathInfo().split("/")[1];
        ProjetDto projetDto = projetService.getProjet(Long.parseLong(id));
        PrintWriter out = resp.getWriter();
            out.println("<html>\n<head>\r\n" + //
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n" + //
                                "        integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n" + //
                                "    <title>Document</title>\r\n" + //
                                "</head><body>\n" +"    <div class='container mt-5'>\r\n" + //
                                "<div class='text-center'><h1>Liste des projets</h1></div>\n"+
                                "<div class='text-center mb-3'>"+
                                "<a href='/projets/all'><button class='btn btn-primary'>Voir le liste des projets</button></a>"+
                                "</div>"+
                               "<div class='card mx-auto p-2' style='width: 800px;'>\n" +
                                "<div class='card-body'>\n");
                out.println(		
                            "<ul><li><strong>Thème: </strong> "
                            + projetDto.getTheme() + "\n" +
                            " <li><strong>Démarrage du projet: </strong>"
                            + projetDto.getStartProjet() + "\n" +
                            " <li><strong>Fin du projet: </strong>"
                            + projetDto.getEndProjet() + "\n" +
                            " <li><strong>Description: </strong>"
                            + projetDto.getDescription() + "\n" +
                            "</ul>\n");			
                out.println("</div></div></div><script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n" + //
                                        "        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n" + //
                                        "        crossorigin=\"anonymous\"></script></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
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
            PrintWriter out = resp.getWriter();
            out.println("<html>\n<head>\r\n" + //
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
            "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n" + //
            "        integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n" + //
            "    <title>Document</title>\r\n" + //
            "</head><body>\n" +"    <div class='container mt-5'>\r\n" + //
            "<div class='text-center'><h4>Détail du projet : <span style='color : red'>"+pr.getTheme()+" </span></h4></div>\n<div class='card mx-auto p-2' style='width: 800px;'>\n" +
            "<div class='card-body'>\n"+
                        "<ul>\n" +			
                        " <ul><li><strong>Thème: </strong> "
                        + pr.getTheme() + "\n" +
                        " <li><strong>Démarrage du projet: </strong>"
                        + pr.getStartProjet() + "\n" +
                        " <li><strong>Fin du projet: </strong>"
                        + pr.getEndProjet() + "\n" +
                        " <li><strong>Description: </strong>"
                        + pr.getDescription() + "\n" +
                        "</ul>\n" +				
                "</div></div></div><script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n" + //
                                        "        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n" + //
                                        "        crossorigin=\"anonymous\"></script></body></html>");

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
