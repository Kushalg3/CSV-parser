import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of min_temperature here.
 * 
 * @author (Kushal Ghosh) 
 * @version (18/03/2019)
 */
public class min_temperature {
    public CSVRecord ColdestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for(CSVRecord currentRow : parser){
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if(currentTemp < coldestTemp) {
                    coldestSoFar = currentRow;
                }
            }
        }
        return coldestSoFar;
    }
    public void testColdestInDay() {
        FileResource fr = new FileResource();
        CSVRecord coldest = ColdestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temparature was "+coldest.get("TemperatureF")+" at "+coldest.get("TimeEDT"));
    }
    public CSVRecord testColdestInDayInDatabase(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = ColdestHourInFile(fr.getCSVParser());
            if(coldestSoFar == null){
                coldestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (currentTemp < coldestTemp){
                    coldestSoFar = currentRow;
                }
            }
        }
        return coldestSoFar;
    }
    public void testColdestHourInFile() {
        CSVRecord coldest = testColdestInDayInDatabase();
        System.out.println("Coldest temperature was "+coldest.get("TemperatureF")+" at "+coldest.get("DateUTC"));
    }
}
