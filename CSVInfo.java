import edu.duke.*;
import org.apache.commons.csv.*;
import java.lang.*;
/**
 * Write a description of CSVInfo here.
 * It help us to give the information about any particular country.
 * @author (Kushal Ghosh) 
 * @version (15/03/2019)
 */
public class CSVInfo {
    public void countryInfo(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            String country = record.get("Country");
            if (country.contains("Nauru")){
                System.out.println(record.get("Exports"));
            }
        }
    }
    public static void main(String[] argc){
	    CSVInfo ob1 = new CSVInfo();
	    ob1.countryInfo();
    }
}
