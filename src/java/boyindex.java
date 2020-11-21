import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.types.ObjectId;

public class boyindex extends HttpServlet {
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
            
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("status", false);
        
            FindIterable cursor = orderCollection.find(whereQuery);

            ArrayList orders = new ArrayList < > ();

            for (Document doc : cursor) { 
                ArrayList users = new ArrayList < > (doc.values());
                ArrayList s = (ArrayList) users.get(5);
                for (int i = 0; i < s.size(); i++){
                    Document particularOrder = new Document();
                    particularOrder = (Document) s.get(i);

                    ArrayList temp = new ArrayList < > ();
                    temp.add(particularOrder.get("snack"));
                    temp.add(particularOrder.get("quantity"));
                    temp.add(users.get(1));
                    temp.add(users.get(3));
                    temp.add(users.get(4));
                    temp.add(users.get(0));
                    orders.add(temp);
                }
            }
            out.print(JSON.serialize(orders));
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            MongoClient mongoClient = new MongoClient("localhost" , 27017);
            MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
            MongoCollection<Document> orderCollection = dbs.getCollection("orders");
            
            // Set response type to JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            String id = request.getParameter("id");
            
            BasicDBObject whereQuery = new BasicDBObject();
            whereQuery.put("_id", new ObjectId(id));

            // Querying the collection
            Document doc = orderCollection.find(whereQuery).first();
            
            orderCollection.updateOne(doc, new Document("$set", new Document("status", true)));
            
//            out.print(JSON.serialize(doc.toJson()));
            response.sendRedirect("boy.html");
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
