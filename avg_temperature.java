import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of avg_temperature here.
 * 
 * @author (Kushla Ghosh) 
 * @version (20/03/2019)
 */
public class avg_temperature {
    public double testHottestInDayInDatabase(){
        int counter = 0,counter1 = 0 ;
        DirectoryResource dr = new DirectoryResource();
        double avgTemp = 0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            for(CSVRecord currentRow : parser){
                double currTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double currHumidity = Double.parseDouble(currentRow.get("Humidity"));
                if(currHumidity >80 || currHumidity == 80){
                    avgTemp = avgTemp + currTemp;
                    counter++;
                }
            }
            counter1 = counter + counter1;
        }
        return avgTemp/counter1;
    }
    public void testAvgTemperature(){
        double avgTemp = testHottestInDayInDatabase();
        System.out.println("The avarage temperature is "+avgTemp);
    }
}

