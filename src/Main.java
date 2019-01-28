import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static Graph graph = new Graph();
    private static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] Args) throws InvalidNodeIDException, IOException, NodeAlreadyExistsException, NodeDoesNotExistException {

        readFileNodes("input.txt", map, graph);
        readFileEdges("input.txt", map, graph);

//        System.out.println(map.get("Colombia"));
//        System.out.println(map.get("Argentina"));
//        System.out.println(map.get("Venezuela"));
//        System.out.println(map.get("Peru"));
//        System.out.println(map.get("Mexico"));
//        System.out.println(map.get("Rusia"));
//        System.out.println(map.get("España"));

//        System.out.println(graph.nodeExists(map.get("Colombia")));
//        System.out.println(graph.nodeExists(map.get("Argentina")));
//        System.out.println(graph.nodeExists(map.get("Venezuela")));
//        System.out.println(graph.nodeExists(map.get("Peru")));
//        System.out.println(graph.nodeExists(map.get("Mexico")));
//        System.out.println(graph.nodeExists(map.get("Rusia")));
//        System.out.println(graph.nodeExists(map.get("España")));

//        System.out.println(graph.getNumEdges(0,1));
//        System.out.println(graph.getNumEdges(1, 0));
//        System.out.println(graph.getNumEdges(1, 2));
//        System.out.println(graph.getNumEdges(2, 6));
//        System.out.println(graph.getNumEdges(2, 3));
//        System.out.println(graph.getNumEdges(3, 0));
//        System.out.println(graph.getNumEdges(5, 4));


        //graph.printEdges();

        //graph.dijkstra(0);
        graph.shortestPath(0, 3);

    }

    private static void readFileNodes(String filePath, HashMap<String, Integer> m, Graph g) throws IOException, NodeAlreadyExistsException, InvalidNodeIDException, NodeDoesNotExistException {
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
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFileEdges(String filePath, HashMap<String, Integer> m, Graph g) throws InvalidNodeIDException, NodeDoesNotExistException, NodeAlreadyExistsException {
        String[] ed = new String[3];
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            while ((line = br.readLine()) != null) {
                ed = line.split(",");
                if (m.containsKey(ed[1]) == false) {
                    m.put(ed[1], m.size());
                    g.addNode(m.get(ed[1]));
                }
                g.addEdge(m.get(ed[0]), m.get(ed[1]), Integer.parseInt(ed[2]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
