import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;

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
        
            // Getting cookie data
            Cookie cookie = null;
            Cookie ck[] = request.getCookies();
            String email = null;
            
            if( ck != null ) {
                for (int i = 0; i < ck.length; i++) {
                   cookie = ck[i];
                   if (cookie.getName().equals("em")){
                       email = cookie.getValue();
                   }
                }
            }

            // Getting all user data with the help of cookies
            Document doc = collection.find(eq("email",email)).first();
            String name = (String)doc.get("name");
            String mobile = (String)doc.get("mobile");
            String address = (String)doc.get("address");

            // Getting input data
            String orders = request.getParameter("orders");
            
            // Inserting into the database
            MongoCollection<Document> orderCollection = dbs.getCollection("orders");
            
            // Creating document that need to be inserted into the database
            Document orderDoc = new Document("name", name)
                    .append("email", email)
                    .append("mobile", mobile)
                    .append("address",address)
                    .append("orders", JSON.parse(orders))
                    .append("date", new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime()))
                    .append("status", false);
            
            orderCollection.insertOne(orderDoc);
            
            String responseToSend = "{\"result\" : \"Order Placed!!\"}";

            out.print(JSON.parse(responseToSend));
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
