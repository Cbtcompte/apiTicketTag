package jpa.resources.Projets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.dtos.ProjetDto;
import jpa.services.ProjetService;

@WebServlet(name = "ProjetResources", urlPatterns = { "/projets/all" })
public class ProjetResources extends HttpServlet {
    private ProjetService projetService;

    public ProjetResources() {
        super();
        projetService = new ProjetService();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProjetDto> pr = projetService.getAllProjet();
        PrintWriter out = resp.getWriter();
            out.println("<html>\n<head>\r\n" + //
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + //
                                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n" + //
                                "        integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\r\n" + //
                                "    <title>Document</title>\r\n" + //
                                "</head><body>\n" +"    <div class='container mt-5'>\r\n" + //
                                "<div class='text-center mb-3'><h1>Liste des projets</h1></div>\n"+
                                "<div class='text-center mb-3'>"+
                                "<a href='/projet.html'><button class='btn btn-primary'>Créer un projet</button></a>"+
                                "</div>"+
                                "<div class='card mx-auto p-2' style='width: 900px;'>\n" +
                                "<div class='card-body'>\n"+"<div class='table-responsive'>\n"+
                                "<table class='table table-striped'>\n"+
                                "<thead>\n"+
                                "<th>#</th>\n"+
                                "<th>Thème</th>\n"+
                                "<th>Démarrage du projet</th>\n"+
                                "<th>Fin du projet</th>\n"+
                                "<th>Description</th>\n"+
                                "<th></th>\n"+
                                "</thead>\n"+
                                "<tbody>\n");
                                
            for (ProjetDto projetDto : pr) {
                out.println(
                    "<tr>\n"+
                    "<td>"+projetDto.getId()+"</td>\n"+
                    "<td>"+projetDto.getTheme()+"</td>\n"+
                    "<td>"+projetDto.getStartProjet()+"</td>\n"+
                    "<td>"+projetDto.getEndProjet()+"</td>\n"+
                    "<td>"+projetDto.getDescription()+"</td>\n"+
                    "<td>\n"+
                        "<div> \n"+
                            "<a href='/projet/"+projetDto.getId()+"'><button class='btn btn-primary'>Consulter</button></a>"+
                        "</div>\n"+
                    "</td>\n"+
                    "</tr>"
                );		
            }
                out.println("</tbody></table></div></div></div></div><script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n" + //
                                        "        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\r\n" + //
                                        "        crossorigin=\"anonymous\"></script></body></html>");
    }
}
