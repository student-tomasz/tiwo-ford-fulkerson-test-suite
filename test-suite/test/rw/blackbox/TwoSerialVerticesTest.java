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
public class TwoSerialVerticesTest {
    ArrayList preIterator;
    Iterator<EdgeInfo> edges;
    FlowNetwork siecPrzeplywu;
    FordFulkerson fulkerson;
    public TwoSerialVerticesTest() {
    }
    
    @Test
    public void testCase1() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 5);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 3);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 7);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 3, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertEquals(siecPrzeplywu.getFlow(), 3, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
}
