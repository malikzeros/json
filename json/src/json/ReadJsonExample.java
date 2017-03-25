package json;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
 
public class ReadJsonExample {
 
    public static void main(String a[]) throws IOException{
        String url= "http://localhost/jsonInput.php";
        File jsonInputFile = new File("D:\\malik\\xampp\\htdocs\\jsonInput.php");
        InputStream is;
        try {
            //is = new FileInputStream(jsonInputFile);
            is = new URL(url).openStream();
            // Create JsonReader from Json.
            JsonReader reader = Json.createReader(is);
            // Get the JsonObject structure from JsonReader.
            JsonObject empObj = reader.readObject();
            reader.close();
            // read string data
            System.out.println("Emp Name: " + empObj.getString("emp_name"));
            // read integer data
            System.out.println("Emp Id: " + empObj.getInt("emp_id"));
            // read inner json element
            JsonObject addrObj = empObj.getJsonObject("address");
            System.out.println("City: " + addrObj.getString("city"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
