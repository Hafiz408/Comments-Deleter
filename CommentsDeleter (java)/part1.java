import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import edu.duke.*;
import java.io.*;
public class part1 {
  public void main(){
      DirectoryResource dr = new DirectoryResource();
      for(File f : dr.selectedFiles()){
          FileResource fr = new FileResource(f);
          try{
              String fileName = f.getName();
              int index = fileName.indexOf(".");
              fileName = fileName.substring(0,index) + "-comments removed" + fileName.substring(index);
              FileWriter fw = new FileWriter(fileName);
              String text = fr.asString();
              int startIndex =0, stopIndex;
              while(true){
                  stopIndex = text.indexOf("/*",startIndex);
                  if(stopIndex == -1){
                      String line = text.substring(startIndex);                 
                      fw.write(line);
                      break;
                    }
                  String line = text.substring(startIndex,stopIndex);                 
                  fw.write(line);
                  startIndex = text.indexOf("*/",stopIndex+2) + 3;                  
                }
              fw.close();
          }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
      }
      System.out.println("Successful");
  }
}