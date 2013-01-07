/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.blackbox;

import algs.network.DFS_SearchArray;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FlowNetworkArray;
import algs.network.FordFulkerson;
import algs.network.Search;
import java.util.ArrayList;
import java.util.Iterator;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class TwoParallelVerticesTest {
    ArrayList preIterator;
    Iterator<EdgeInfo> edges;
    FlowNetwork siecPrzeplywu;
    FordFulkerson fulkerson;
    public TwoParallelVerticesTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testCase1() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 1);
        EdgeInfo edge2 = new EdgeInfo(0, 2, 4);
        EdgeInfo edge3 = new EdgeInfo(1, 3, 2);
        EdgeInfo edge4 = new EdgeInfo(2, 3, 3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 3, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test
    public void testCase2() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 3);
        EdgeInfo edge2 = new EdgeInfo(0, 2, 6);
        EdgeInfo edge3 = new EdgeInfo(1, 3, 10);
        EdgeInfo edge4 = new EdgeInfo(2, 3, 4);
        EdgeInfo edge5 = new EdgeInfo(1, 2, 2);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 3, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test
    public void testCase3() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 7);
        EdgeInfo edge2 = new EdgeInfo(0, 2, 1);
        EdgeInfo edge3 = new EdgeInfo(1, 3, 5);
        EdgeInfo edge4 = new EdgeInfo(2, 3, 3);
        EdgeInfo edge5 = new EdgeInfo(2, 1, 9);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 3, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
}
