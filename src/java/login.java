import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            // Database Connection
            
            MongoClient mongoClient = new MongoClient("localhost" , 27017);
            MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
            MongoCollection<Document> collection = dbs.getCollection("users");
            
            // Getting user data from index.html
            
            PrintWriter out = response.getWriter();
            
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            if (email.equals("boy") && password.equals("boy")){
                response.sendRedirect("boy.html");
            }
            
            // Querying the collection
            Document doc = collection.find(and(eq("email",email),eq("password",password))).first();
            
            if (!doc.equals(null)){
                
                // Creating cookies
                Cookie ck = new Cookie("em",email);
                response.addCookie(ck);
                response.sendRedirect("user.jsp?result=success");
            }
            response.sendRedirect("index.jsp.jsp?result=false");
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
