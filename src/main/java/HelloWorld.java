import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class HelloWorld extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> env = System.getenv();

        String message = env.get("HELLO_MESSAGE");
        if (message == null) { message = "Hello World!";}
        resp.getWriter().println("<h1>" + message + "</h1>");
        resp.getWriter().println("This message brought to you by pod <b>" + env.get("HOSTNAME") +
                                 "</b> running release <b>" + env.get("WORKFLOW_RELEASE")  + ".</b><br>");

        resp.getWriter().format("%n<br>%n<hr>%n<br>%nEnvironment Variables:<br>%n<br>%n");
        for (String envName : env.keySet()) {
            resp.getWriter().format("%s = %s <br>%n", envName, env.get(envName));
        }
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new HelloWorld()),"/*");
        server.start();
        server.join();   
    }
}
