import edu.duke.*;
import org.apache.commons.csv.*;
/**
 * Write a description of export_country here.
 * It helps us to give us the access to a csv file and to find which 
 * countries exports coffee among our list.
* @author (Kushal Ghosh) 
 * @version (15/03/2019)
 */
public class export_country {
    public void listofExports(CSVParser parser,String listOfInterest){//,String listOfInterest2){
        int check=0;
        for(CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            int l=value.length();
            if(l>16){//export.contains(listOfInterest)){//&&export.contains(listOfInterest2)){
                //System.out.println(l);
                System.out.println(record.get("Country")+" ");
                //System.out.print(record.get("Exports")+" ");
                //System.out.println(record.get("Value (dollars)"));
                check++;
            }
        }
        System.out.println(check);
    }
    public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listofExports(parser,"cocoa");
    }
}
