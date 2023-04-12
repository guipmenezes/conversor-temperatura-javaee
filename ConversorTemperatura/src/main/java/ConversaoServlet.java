import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/conversor"})
public class ConversaoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String opcoes1 = request.getParameter("opcoes1");
        String opcoes2 = request.getParameter("opcoes2");
        Integer grau = Integer.valueOf(request.getParameter("grau"));
        
        if(request.getParameter("opcoes1").equals("celcius") && request.getParameter("opcoes2").equals("fahrenheit")) {
              grau = ((grau * 9)/5) + 32;
        } else if(request.getParameter("opcoes1").equals("fahrenheit") && request.getParameter("opcoes2").equals("celcius")) {
            grau = ((grau - 32) * 5) / 9;
        } else {
            System.out.println("Como nenhuma temperatura foi selecionada, a temperatura normal foi mantida");
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado da conversão: </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Você escolheu converter para: " + opcoes1 + " para " + opcoes2 +"</h2>");
            out.println("<h2>O resultado foi: " + grau + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
