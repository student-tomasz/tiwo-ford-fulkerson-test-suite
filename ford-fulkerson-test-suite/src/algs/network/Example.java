package algs.network;

import java.util.ArrayList;
import java.util.Iterator;

public class Example {
    
    public static void main(String[] args){
        
        int numVertices = 6; // Liczba wezlow w grafie
        int srcIndex = 0;    // indeks wezla zrodlowego
        int sinkIndex = 5;   // indeks wezla docelowego
        
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
                                
        Iterator<EdgeInfo> edges = preIterator.iterator();  // zbior krawedzi grafu
        Iterator<EdgeInfo> edges2 = preIterator.iterator(); // zbior krawedzi grafu
        
        
        FlowNetwork network;
        Search search;
        FordFulkerson ffalgorithm;
        

        System.out.println("Implementacja z podwojna lista. Wysoka zlozonosc pamieciowa.");
        network = new FlowNetworkAdjacencyList(numVertices, srcIndex, sinkIndex, edges); // graf przeplywu sieci na listach
        
        System.out.println("Przed:");
        System.out.println(network.toString());
        
        search = new DFS_SearchList(network); // algorytm przeszukiwania wzdluz
        ffalgorithm = new FordFulkerson(network, search);
        ffalgorithm.compute(); // wykonaj algorytm
        
        System.out.println("Po:");
        System.out.println(network.toString());
        
        
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