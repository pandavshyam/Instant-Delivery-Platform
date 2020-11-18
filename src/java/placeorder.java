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
import org.json.JSONArray;
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

            // Creating json object
//            JSONObject obj = new JSONObject();
//            obj.put("orders",request.getParameter("orders"));
//            String order = request.getParameter("orders");
//            JSONArray array = new JSONArray(order);
//            JSONObject json = new JSONObject(order);
            BasicDBObject json =(BasicDBObject) JSON.parse(request.getParameter("orders"));
            
            // Inserting into the database
            MongoCollection<Document> orderCollection = dbs.getCollection("orders");
            
            Document orderDoc = new Document("name", name)
                    .append("email", email)
                    .append("mobile", mobile)
                    .append("address",address)
                    .append("orders", json)
                    .append("status", false);
            
            orderCollection.insertOne(orderDoc);

//            out.print();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
