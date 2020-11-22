import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("email", email);
            whereQuery.put("status", true);
        
            FindIterable cursor = orderCollection.find(whereQuery);

            ArrayList orders = new ArrayList < > ();

            for (Document doc : cursor) { 
                ArrayList users = new ArrayList < > (doc.values());
                ArrayList s = (ArrayList) users.get(5);
                for (int i = 0; i < s.size(); i++){
                    Document particularOrder = new Document();
                    particularOrder = (Document) s.get(i);
//                    orders.add(new Document("date",users.get(6))
//                    .append("addr", users.get(4))
//                    .append("snack",particularOrder.get("snack"))
//                    .append("quantity",particularOrder.get("quantity"))
//                    );
                    ArrayList temp = new ArrayList < > ();
                    temp.add(users.get(6));
                    temp.add(users.get(4));
                    temp.add(particularOrder.get("snack"));
                    temp.add(particularOrder.get("quantity"));
                    orders.add(temp);
                }
            }
            out.print(JSON.serialize(orders));
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
