import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
import org.json.JSONArray;
import org.json.JSONObject;

public class userhistory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            MongoClient mongoClient = new MongoClient("localhost" , 27017);
            MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
            MongoCollection<Document> orderCollection = dbs.getCollection("orders");
            
            // Set response type to JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
        
            // Getting cokkies data
            Cookie ck[] = request.getCookies();
            String email = ck[1].getValue();

            // Getting all user data with the help of cookies
            MongoCursor<Document> cursor = orderCollection.find(eq("email",email)).iterator();
            JSONArray array = new JSONArray();
            JSONObject obj = new JSONObject();
            
            try {
                while (cursor.hasNext()) {
                    out.print(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
//            String responseToSend = "{\"result\" : \"Order Placed!!\"}";
//
//            out.print(JSON.parse(responseToSend));
            out.print(obj);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
