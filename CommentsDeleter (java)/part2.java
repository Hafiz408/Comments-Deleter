
import edu.duke.*;
import java.io.*;
public class part2 {
    public void execute(){
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            String fileName = f.getAbsolutePath();
            try {
               Runtime runTime = Runtime.getRuntime();            
               String executablePath = "E:\\Packages\\OOPS package\\comments deleter\\main.exe";            
               Process process = runTime.exec(executablePath);
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
        System.out.println("END");
    }
}
