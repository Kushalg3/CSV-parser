import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of max_temparature here.
 * 
 * @author (Kushal Ghosh) 
 * @version (15/03/2019)
 */
public class max_temparature {
    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for(CSVRecord currentRow : parser){
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if(currentTemp > largestTemp) {
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;
    }
    public void testHottestInDay() {
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temparature was "+largest.get("TemperatureF")+" at "+largest.get("TimeEDT"));
    }
    public CSVRecord testHottestInDayInDatabase(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord largestSoFar = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if(largestSoFar == null){
                largestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if (currentTemp > largestTemp){
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;
    }
    public void testHottestHourInFile() {
        CSVRecord largest = testHottestInDayInDatabase();
        System.out.println("Hottest temperature was "+largest.get("TemperatureF")+" at "+largest.get("DateUTC"));
    }
}
