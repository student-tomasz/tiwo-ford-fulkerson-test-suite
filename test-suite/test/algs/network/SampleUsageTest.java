package algs.network;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;

public class SampleUsageTest {
        
    private int numVertices = 6; // liczba wezlow w grafie
    private int srcIndex = 0;    // indeks wezla zrodlowego
    private int sinkIndex = 5;   // indeks wezla docelowego
            
    private FlowNetwork network;
    private Search search;
    private FordFulkerson ffalgorithm;
    private Iterator<EdgeInfo> edges;
    private Iterator<EdgeInfo> edges2;
    
    @BeforeTest
    public void createNetwork() {
        ArrayList preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 3);
        EdgeInfo edge2 = new EdgeInfo(1, 3, 2);
        EdgeInfo edge3 = new EdgeInfo(3, 5, 3);
        EdgeInfo edge4 = new EdgeInfo(1, 4, 2);
        EdgeInfo edge5 = new EdgeInfo(0, 2, 2);
        EdgeInfo edge6 = new EdgeInfo(2, 4, 3);
        EdgeInfo edge7 = new EdgeInfo(4, 5, 2);
        EdgeInfo edge8 = new EdgeInfo(2, 3, 2);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        preIterator.add(edge6);
        preIterator.add(edge7);
        preIterator.add(edge8);
                                
        edges = preIterator.iterator();  // zbior krawedzi grafu
        edges2 = preIterator.iterator(); // zbior krawedzi grafu
    }
    
    @Test
    public void listTest() {
        System.out.println("Implementacja z podwojna lista. Wysoka zlozonosc pamieciowa.");
        network = new FlowNetworkAdjacencyList(numVertices, srcIndex, sinkIndex, edges); // graf przeplywu sieci na listach
        
        System.out.println("Przed:");
        System.out.println(network.toString());
        
        search = new DFS_SearchList(network); // algorytm przeszukiwania wzdluz
        ffalgorithm = new FordFulkerson(network, search);
        ffalgorithm.compute(); // wykonaj algorytm
        
        System.out.println("Po:");
        System.out.println(network.toString());
    }
    
    @Test
    public void arrayTest() {   
        System.out.println("Implementacja z macierza dwuwymiarowa. Oszczedniejsza pamieciowo.");   
        network = new FlowNetworkArray(numVertices, srcIndex, sinkIndex, edges2); // graf przeplywu sieci na macierzy
        
        System.out.println("Przed:");
        System.out.println(network.toString());
        search = new DFS_SearchArray(network); // algorytm przeszukiwania wzdluz
        ffalgorithm = new FordFulkerson(network, search);
        ffalgorithm.compute(); // wykonaj algorytm
        
        System.out.println("Po:");
        System.out.println(network.toString());
    }   
}
