package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim on 19.04.2021.
 */
public class SecretDocument extends HttpServlet {

    List<String> names = new ArrayList<>();
    List<String> numbers = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procces(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        procces(req, resp);
    }

    private void procces(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        try {
            String name = req.getParameter("name");
            names.add(name);
            System.out.println(name);
            String telefonNumber = req.getParameter("number");
            numbers.add(telefonNumber);
            System.out.println(telefonNumber);

            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>");
            writer.println("SecretDocument");
            writer.println("</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border='1'>");
            writer.println("<caption>");
            writer.println("Секретная таблица");
            writer.println("</caption>");
            writer.println("<tr>");
            writer.println("<th>");
            writer.println("Имя");
            writer.println("</th>");
            writer.println("<th>");
            writer.println("Телефон");
            writer.println("</th>");
            writer.println("</tr>");
            for (int i = 0; i < names.size(); i++) {
                writer.println("<tr>");
                writer.println("<td>" + names.get(i) + "</td>");
                writer.println("<td>" + numbers.get(i) + "</td>");
                writer.println("</tr>");
            }
            writer.println("</table");
        }catch (Exception e){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        }finally {
            writer.println("<body>");
            writer.println("</html");
            writer.close();
        }


    }
}
