
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import org.bson.Document;

public class test {
    public static void main(String args[]){
        MongoClient mongoClient = new MongoClient("localhost" , 27017);
        MongoDatabase dbs = mongoClient.getDatabase("instantdeliveryapp");
        MongoCollection<Document> orderCollection = dbs.getCollection("orders");
        
        String email = "pandavshyam@gmail.com";
        
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("email", email);
        
        FindIterable cursor = orderCollection.find(whereQuery);
        
        ArrayList orders = new ArrayList < > ();
        
        for (Document doc : cursor) { 
            ArrayList users = new ArrayList < > (doc.values());
            ArrayList s = (ArrayList) users.get(5);
            for (int i = 0; i < s.size(); i++){
                Document particularOrder = new Document();
                particularOrder = (Document) s.get(i);
                orders.add(new Document("date",users.get(6))
                .append("addr", users.get(4))
                .append("snack",particularOrder.get("snack"))
                .append("quantity",particularOrder.get("quantity"))
                );
            }
        }
        System.out.println(orders.toString());
    }
}
