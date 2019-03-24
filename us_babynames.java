import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
/**
 * Write a description of us_babynames here.
 * 
 * @author (Kushal Ghosh) 
 * @version (21/03/2019)
 */
public class us_babynames {
    public void printName(){
        FileResource fr = new FileResource();
        for(CSVRecord record : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(record.get(2));
            if(numBorn<=100){
                System.out.println("Name "+record.get(0)+" Gender "+record.get(1)+" Num Born "+record.get(2));
            }
        }
    }
    public void totalBirth(FileResource f){
        //int totalBirth = 0,totalGirls=0,totalBoys=0;
        int totalBirth = 0;
        for(CSVRecord record : f.getCSVParser(false)){
            //int numBorn = Integer.parseInt(record.get(2));
            //totalBirth+=numBorn;
            //if(record.get(1).equals("M")){
              //  totalBoys+=numBorn;
            //}
            //else{
              //  totalGirls+=numBorn;
              //  }
            if(record.get(1).equals("F")){
                if(record.get(0).equals("Emily")){
                    break;
                }
                else{
                    int numBorns = Integer.parseInt(record.get(2));
                    totalBirth = totalBirth + numBorns;
                }
            }
        }
        System.out.println("The total no. of born is "+totalBirth);
        //System.out.println("Total no. of birth is :"+totalBirth);
        //System.out.println("Total no. of Boys is :"+totalBoys);
        //System.out.println("Total no. of Girls is :"+totalGirls);
    }
    public void test(){
        FileResource fr = new FileResource();
        totalBirth(fr);
    }
    public void searchNameByRankInDataFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0,count2 = 0;
        for (CSVRecord rec : parser){
            if(rec.get(1).equals("M")){
                if(rec.get(0).equals("Owen")){
                    count++;
                    break;
                }
                else{
                    count++;
                }
            }
        }
        System.out.println("Chose the new file name.");
        fr = new FileResource();
        parser = fr.getCSVParser(false);
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("M")){
                if(count2 == (count-1)){
                    System.out.println("The name will be "+rec.get(0));
                    break;
                }
                else{
                    count2++;
                }
            }
        }
    }
    public void highestRank(){
        DirectoryResource dr = new DirectoryResource();
        double memory = 0;
        String fileName = null;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            double rank = 0;
            int count = 0;
            for(CSVRecord rec : parser){
                if(rec.get(1).equals("F")){
                    if(rec.get(0).equals("Genevieve")){
                        rank++;
                        count++;
                        break;
                    }
                    else{
                        rank++;
                    }
                }
            }
            if(count != 0){
                if(memory == 0 || memory >rank){
                    memory = rank;
                    fileName = f.getName();
                }
            }
        }
        System.out.println("The file name is :"+fileName);
    }
    public void avg_rank(){
        DirectoryResource dr = new DirectoryResource();
        double totalRank = 0;
        int count = 0;
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            double rank = 0;
            for(CSVRecord rec : parser){
                if(rec.get(1).equals("F")){
                    if(rec.get(0).equals("Susan")){
                        rank++;
                        totalRank = totalRank + rank;
                        count++;
                        break;
                    }
                    else{
                        rank++;
                    }
                }
            }
        }
        System.out.println(count);
        double avgRank = totalRank/count;
        System.out.println("The average rank of the given name is "+avgRank);
    }
    public void totalName(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0;
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("F")){
                count++;
            }
        }
        System.out.println("The total number of Boys is : "+count);
    }
    public void boysRank(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0;
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("M")){
                if(rec.get(0).equals("Frank")){
                    count++;
                    System.out.println("The rank of the name is "+count);
                }
                else{
                    count++;
                }
            }
        }
    }
    public void girlsRank(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0;
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("F")){
                if(rec.get(0).equals("Emily")){
                    count++;
                    System.out.println("The rank of the name is "+count);
                }
                else{
                    count++;
                }
            }
        }
    }
    public void totalNumBirth(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0,count2 = 0;
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("M")){
                count++;
            }
            else{
                count2++;
            }
        }
        System.out.println("Total no. of boys is "+count);
        System.out.println("Total no. of girls is "+count2);
    }
    public void printNameByRank(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int count = 0;
        for(CSVRecord rec : parser){
            if(rec.get(1).equals("F")){
                count++;
            }
            if(count == 350){
                System.out.println("The name is "+rec.get(0));
                break;
            }
        }
    }
}
