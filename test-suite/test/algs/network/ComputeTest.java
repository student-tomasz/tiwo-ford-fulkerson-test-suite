/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algs.network;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author mateusz
 */
public class ComputeTest {
    
    int numVertices; // Liczba wezlow w grafie
    int srcIndex;    // indeks wezla zrodlowego
    int sinkIndex;   // indeks wezla docelowego
    ArrayList preIterator;
    Iterator<EdgeInfo> edges;
    FlowNetwork network;
    Search s;
    FordFulkerson ffalgorithm;
    
    @BeforeMethod
    public void setUp(){
        
        numVertices = 6;
        srcIndex = 0;
        sinkIndex = 5;
        
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
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
        edges = preIterator.iterator();
    }
    
    @Test
    public void testFindAugmentingPath(){ //sprawdź czy liczba wywołań się zgadza
      
        network = new FlowNetworkAdjacencyList(numVertices, srcIndex, sinkIndex, edges); // graf przeplywu sieci na listach
        
        s= new DFS_SearchList(network); // algorytm przeszukiwania wzdluz
        Search search = spy(s);
        ffalgorithm = new FordFulkerson(network, search);
        ffalgorithm.compute(); // wykonaj algorytm
        verify(search, times(4)).findAugmentingPath(any(VertexInfo[].class)); //metoda powinna zostać wywołana 4 razy, przy czym ostatni raz zwrócić false
        
    }
}
