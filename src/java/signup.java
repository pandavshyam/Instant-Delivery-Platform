import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

public class signup extends HttpServlet {

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
            
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            String usertype = request.getParameter("usertype");
            
            // Creatinf object of userdata
            
//            userdata ud = new userdata();
//            ud.setName(name);
//            ud.setPassword(password);
//            ud.setEmail(email);
//            ud.setMobile(mobile);
//            ud.setAddress(address);
//            ud.setUsertype(usertype);
            // Document to store in the database
            Document doc = new Document("name", name)
                .append("password", password)
                .append("email", email)
                .append("mobile", mobile)
                .append("address", address)
                .append("usertype", usertype);
            // Inserting
            collection.insertOne(doc);
            // Redirecting user
            response.sendRedirect("index.jsp?result=success");
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
    }
}
