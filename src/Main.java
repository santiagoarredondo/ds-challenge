import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Graph graph = new Graph();
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] Args) throws InvalidNodeIDException, IOException, NodeAlreadyExistsException {

        readFileNodes("input.txt", map, graph);

        /*System.out.println(graph.nodeExists(map.get("perro")));
        System.out.println(graph.nodeExists(map.get("carro")));
        System.out.println(graph.nodeExists(map.get("roto")));

        System.out.println(map.get("perro"));
        System.out.println(map.get("carro"));
        System.out.println(map.get("roto"));*/
    }

    private static void readFileNodes(String filePath, HashMap<String, Integer> m, Graph g) throws IOException, NodeAlreadyExistsException, InvalidNodeIDException {
        int count = 0;
        String line = "";
        String[] nd = new String[3];
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while ((line = br.readLine()) != null) {
                nd = line.split(",");
                if (m.containsKey(nd[0]) == false) {
                    m.put(nd[0], count);
                    g.addNode(m.get(nd[0]));
                    count++;
                }
            }
            fis.getChannel().position(0);  //Resets the buffered reader so it can start reading the file from the first line
            br = new BufferedReader(new InputStreamReader(fis));
            
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void readFileEdges(String filePath) throws InvalidNodeIDException, NodeDoesNotExistException {
        String[] ed = new String[3];
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            while ((line = br.readLine()) != null) {
                ed = line.split(",");
                graph.addEdge(map.get(ed[0]), map.get(ed[1]), Integer.parseInt(ed[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
