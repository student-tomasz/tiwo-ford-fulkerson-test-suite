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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class SingleVertexTest {
    ArrayList preIterator;
    Iterator<EdgeInfo> edges;
    FlowNetwork siecPrzeplywu;
    FordFulkerson fulkerson;
    public SingleVertexTest() {
    }
    
    @Test
    public void testCase1() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 512);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 126);
        preIterator.add(edge1);
        preIterator.add(edge2);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 2, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertEquals(siecPrzeplywu.getFlow(), 126, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
        @Test
        public void testCase1b() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 104526);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 75269);
        EdgeInfo edge3 = new EdgeInfo(1, 0, 1523);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 2, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertEquals(siecPrzeplywu.getFlow(), 75269, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
        

}
