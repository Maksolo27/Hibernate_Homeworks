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
 * Created by Asus on 29.01.2018.
 */public class ArifmeticServlet extends HttpServlet{

    private Calculator calculator = new Calculator();
    private List<String> operations = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        proccessRequest(req, resp);
    }

    private void proccessRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        try {
            String operation = req.getParameter("operation");
            System.out.println(operation);
            double value1 = Double.valueOf(req.getParameter("FristPar"));
            System.out.println(value1);
            double value2 = Double.valueOf(req.getParameter("SecondPar"));
            System.out.println(value2);

            switch (operation) {
                case "add": operations.add(value1 + " + " + value2 + " = " + calculator.calc(value1, value2, operation.charAt(0)));
                    break;
                case "sub": operations.add(value1 + " - " + value2 + " = " + calculator.calc(value1, value2, operation.charAt(0)));
                    break;
                case "mult": operations.add(value1 + " * " + value2 + " = " + calculator.calc(value1, value2, operation.charAt(0)));
                    break;
                case "div": operations.add(value1 + " / " + value2 + " = " + calculator.calc(value1, value2, operation.charAt(0)));
                    break;
                default: throw new Exception();
            }


            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Arifmetic multithreading</title>");
            writer.println("</head>");
            writer.println("<body>");

            for (String result : operations) {
                writer.print("<p>" + result + "</p>");
            }

        }  catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            e.printStackTrace();
        } finally {
            writer.println("</body");
            writer.println("</html>");
            writer.close();
        }

    }


}
