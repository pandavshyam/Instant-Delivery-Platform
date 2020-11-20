
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
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

        for(Document doc : cursor) {
            ArrayList users = new ArrayList < > (doc.values());
            System.out.printf("%s: %s%n", users.get(1), users.get(2));            
        }
    }
}
