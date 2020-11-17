import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.parser.JSONParser;
import org.bson.Document;
import org.json.JSONObject;

public class placeorder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            MongoClient mongoClient = new MongoClient("localhost" , 27017);
            MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
            MongoCollection<Document> collection = dbs.getCollection("users");
            
            // Set response type to JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        
            // Getting cokkies data
            Cookie ck[] = request.getCookies();
            String email = ck[1].getValue();

            // Getting all user data with the help of cookies
            Document doc = collection.find(eq("email",email)).first();
            String name = (String)doc.get("name");
            String mobile = (String)doc.get("mobile");
            String address = (String)doc.get("address");
            
            // Getting data from frontend
            String orders = request.getParameter("orders");
            
//            JSONParser parser = new JSONParser();
//            JSONObject json = (JSONObject) parser.parse(orders);

            // Creating json object
            JSONObject obj = new JSONObject();

            out.print(obj);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
