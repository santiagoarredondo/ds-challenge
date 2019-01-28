import java.util.ArrayList;

public class Graph {

    private static final int CAPACIDAD = 100;
    protected boolean[] array;
    protected int[][] table;
    protected int[][] dist;
    protected int size;
    protected int numtable;
    protected int cont=0;

    public Graph() {
        // TODO Auto-generated constructor stub
        super();
        this.array=new boolean[CAPACIDAD];
        this.table=new int[CAPACIDAD][CAPACIDAD];
        this.dist=new int[CAPACIDAD][CAPACIDAD];
        this.size=0;
        this.numtable=0;
    }

    public boolean nodeExists(int id)throws InvalidNodeIDException{
        if (id<0||id>CAPACIDAD)
            throw new InvalidNodeIDException("valor invalido");
        return(array[id]==true);
    }

    public int getNumtable(int origin, int dest)throws InvalidNodeIDException{
        if((origin<0||origin>CAPACIDAD)||(dest<0||dest>CAPACIDAD))
            throw new InvalidNodeIDException("invalid Node ID");
        return numtable;
    }

    public void addNode(int id) throws NodeAlreadyExistsException, InvalidNodeIDException{
        if (id<0||id>CAPACIDAD)
            throw new InvalidNodeIDException("valor invalido");
        if (array[id]==true)
            throw new NodeAlreadyExistsException("ya existe");
        array[id]=true;
        size++;
    }

    public void removeNode(int id) throws NodeDoesNotExistException, InvalidNodeIDException{
        if (id<0||id>CAPACIDAD)
            throw new InvalidNodeIDException("valor invalido");
        if (array[id]==false)
            throw new NodeDoesNotExistException("no existe");
        array[id]=false;
        numtable=0;
        size--;
        array[id]=false;
        for (int i = 0; i < table.length; i++){	// El primer índice recorre las filas.
            for (int j = 0; j < table.length; j++){	// El segundo índice recorre las columnas.
                table[i][id]=0;
                table[id][j]=0;
            }
        }
    }

    public int getInDegree(int id) throws InvalidNodeIDException, NodeDoesNotExistException{
        if (id<0||id>CAPACIDAD)
            throw new InvalidNodeIDException("valor invalido");
        if (array[id]==false)
            throw new NodeDoesNotExistException("no existe");

        for(int i=0; i<CAPACIDAD; i++){
            //cont+=table[i][id];
            if(getNumtable(i,id)==0)
                ;
            else
                cont+=table[i][id];
        }

        int m=0;
        while(m!=CAPACIDAD){
            cont+=table[m][id];
            m++;
        }
        return cont;
    }

    public int getEdgeDist(int origin , int dest ) throws InvalidNodeIDException{
        if ((origin<0||origin>CAPACIDAD)||(dest<0||dest>CAPACIDAD))
            throw new InvalidNodeIDException("valor invalido");
        if(getNumtable(origin, dest)==0)
            return Integer.MAX_VALUE;
        else
            return dist[origin][dest];
    }


    public void addEdge(int origin, int dest) throws InvalidNodeIDException, NodeDoesNotExistException{
        addEdge(origin, dest, 1);
    }

    public void addEdge(int origin, int dest, int distance) throws InvalidNodeIDException, NodeDoesNotExistException{
        if(origin<0||origin>CAPACIDAD||dest<0||dest>CAPACIDAD)
            throw new InvalidNodeIDException("Invalid node ID");
        if(array[origin]==false||array[dest]==false)
            throw new NodeDoesNotExistException("Ya existe");
        table[origin][dest]++;
        numtable++;
        dist[origin][dest]=distance;
    }

    public void dijkstra(int origin) throws InvalidNodeIDException{
        boolean[] known=new boolean[CAPACIDAD];
        int[] dv = new int[CAPACIDAD];
        int[] pv = new int[CAPACIDAD];
        for(int i=0;i<CAPACIDAD;i++){
            dv[i]=Integer.MAX_VALUE;
            pv[i]=-1;
        }
        dv[origin]=0;
        while(true){
            //Paso 1: Buscar el nodo actual
            int actual=-1;
            int mindv=Integer.MAX_VALUE;
            for(int i=0;i<CAPACIDAD;i++){
                //Si nodo existe y no es conocido
                if(array[i] && !known[i]){
                    if(dv[i]<mindv){
                        actual=i;
                        mindv=dv[i];
                    }
                }
            }
            //no econtramos nada
            if(actual==-1){
                break;
            }
            known[actual]=true;
            //mirar los vecinos del nodo actual
            for(int i=0;i<CAPACIDAD;i++){
                if(table[actual][i]>0){
                    if(dv[actual]+dist[actual][i]<dv[i]){
                        dv[i] = dv[actual]+dist[actual][i];
                        pv[i] = actual;
                    }
                }
            }
            //Mostrar la tabla
            System.out.println("=============================");
            System.out.println(" v    known    dv    pv");
            System.out.println("=============================");
            for(int i=0;i<CAPACIDAD;i++){
                if(array[i]){
                    System.out.printf("%2d    %1b    %4d    %4d  %n",i,known[i],dv[i],pv[i]);
                }
            }
            System.out.println("=============================");
        }
    }

}
