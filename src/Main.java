import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] Args) {
        
    }

    private static void readFile(String filePath) {
        HashMap<String, Integer> hm = new HashMap<>();
        int count = 0;
        String line = "";
        String[] nd = new String[1];
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            while ((line = br.readLine()) != null) {
                nd = line.split(",");
                hm.put(nd[1], count);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
