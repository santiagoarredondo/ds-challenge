import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Graph graph = new Graph();
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] Args) {

    }

    private static void readFileNodes(String filePath) {
        //Graph graph = new Graph();
        //HashMap<String, Integer> hm = new HashMap<>();
        int count = 0;
        String line = "";
        String[] nd = new String[3];
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            while ((line = br.readLine()) != null) {
                nd = line.split(",");
                map.put(nd[0], count);
                //graph.addNode(hm.get(nd[1]));
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileEdges(String filePath) {
        String[] ed = new String[3];
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            while ((line = br.readLine()) != null) {
                ed = line.split(",");
                //graph.addEdge(map.get(ed[0]), map.get(ed[1]), Integer.parseInt(ed[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
