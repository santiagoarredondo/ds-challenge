public class Graph {

    private final int CAPACITY = 194;
    private boolean[] nodes = new boolean[CAPACITY]; //Specifies when an ID (which is determined by the hashMap) is part of the tree
    private int[][] edges = new int[CAPACITY][CAPACITY]; //Specifies a relation between two nodes
    private int[][] distance = new int[CAPACITY][CAPACITY]; //Specifies the distance between two nodes
    private int size = 0;

    public Graph() {
        this.nodes = nodes;
        this.edges = edges;
        this.distance = distance;
    }

    public boolean nodeExists(int id) throws InvalidNodeIDException { //This method gets passed the value returned by hashMap.get(key)
        if ((id < 0) || (id > (this.CAPACITY - 1))) {
            throw new InvalidNodeIDException("Invalid node ID");
        }
        if (this.nodes[id] == true) {
            return true;
        }
        return false;
    }

    public void addNode(int id) throws NodeAlreadyExistsException, InvalidNodeIDException {
            if ((id < 0) || (id > (this.CAPACITY - 1))) {
            throw new InvalidNodeIDException("Invalid node ID");
        }
        if (this.nodes[id] == true) {
            throw new NodeAlreadyExistsException("Node already exists");
        }
        this.nodes[id] = true; //Sets the array true in the position specified by the id
        size++;
    }

    public void addEdge(int origin, int dest, int dist) throws NodeDoesNotExistException, InvalidNodeIDException {
        if (((origin < 0) || (origin > (this.CAPACITY - 1))) || (((dest < 0) || (dest > (this.CAPACITY - 1))))) {
            throw new InvalidNodeIDException("Invalid node ID");
        }
        if ((this.nodes[origin] == false) || (this.nodes[dest] == false)) {
            throw new NodeDoesNotExistException("Node does not exists");
        }
        this.edges[origin][dest]++; //Adds 1, representing an edge from origin to dest
        this.distance[origin][dest] = dist;
    }

    //Dijkstra...

}
