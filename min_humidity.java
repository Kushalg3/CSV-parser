import edu.duke.*;
import org.apache.commons.csv.*; 
import java.io.*;
/**
 * Write a description of min_humidity here.
 * 
 * @author (Kushal Ghosh) 
 * @version (18/03/2019)
 */
public class min_humidity {
    public CSVRecord lowestHumidityHourInFile(CSVParser parser,File f) {
        CSVRecord lowestSoFar = null;;
        for(CSVRecord currentRow : parser){
            try{
                if(lowestSoFar == null){
                    lowestSoFar = currentRow;
                }
                else{
                    double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                    double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                    if(currentHumidity < lowestHumidity) {
                        lowestSoFar = currentRow;
                    }
                }
            }
            catch(Exception e){
                System.out.println("The error in "+f.getName());
                e.printStackTrace();
            }
        }
        return lowestSoFar;
    }
    public void testlowestHumidityInDay() {
        //FileResource fr = new FileResource();
        //CSVRecord lowest = lowestHumidityHourInFile(fr.getCSVParser(),f);
        //System.out.println("lowest Humidity was "+lowest.get("Humidity")+" at "+lowest.get("TimeEDT"));
    }
    public CSVRecord testlowestHumidityInDayInDatabase(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityHourInFile(fr.getCSVParser(),f);
            if(lowestSoFar == null){
                lowestSoFar = currentRow;
            }
            else{
                double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestSoFar.get("Humidity"));
                if (currentHumidity < lowestHumidity){
                    lowestSoFar = currentRow;
                }
            }
        }
        return lowestSoFar;
    }
    public void testlowestHumidityHourInFile() {
        CSVRecord lowest = testlowestHumidityInDayInDatabase();
        System.out.println("lowest Humidity was "+lowest.get("Humidity")+" at "+lowest.get("DateUTC"));
    }
}
