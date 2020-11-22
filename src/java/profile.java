import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.currentDate;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

public class profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            // Database Connection
            
            MongoClient mongoClient = new MongoClient("localhost" , 27017);
            MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
            MongoCollection<Document> collection = dbs.getCollection("users");
            
            // Getting user data from index.html
            
            PrintWriter out = response.getWriter();
            
            // Getting cookie data
            Cookie cookie = null;
            Cookie ck[] = request.getCookies();
            String email = null;
            
            // Getting particular cookie only
            if( ck != null ) {
                for (int i = 0; i < ck.length; i++) {
                   cookie = ck[i];
                   if (cookie.getName().equals("em")){
                       email = cookie.getValue();
                   }
                }
            }
            // Querying the collection
            Document doc = collection.find(eq("email",email)).first();
            
            out.print(JSON.serialize(doc.values()));
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            // Database Connection
            
            MongoClient mongoClient = new MongoClient("localhost" , 27017);
            MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
            MongoCollection<Document> collection = dbs.getCollection("users");
            
            // Getting user data from index.html
            
            PrintWriter out = response.getWriter();

            
            // Querying the collection
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            
            Document dc = new Document();
            dc.put("email", email);
            
            collection.updateOne(dc, new Document("$set",new Document("name",name)
            .append("mobile", mobile)
            .append("address", address)));
            
            out.println(dc);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
        
}
