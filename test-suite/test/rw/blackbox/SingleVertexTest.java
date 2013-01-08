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
        
    @Test
    public void testCase2() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, 43);
        EdgeInfo edge2 = new EdgeInfo(2, 1, 76);
        preIterator.add(edge1);
        preIterator.add(edge2);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 2, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");
        
        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }  
        
    @Test
    public void testCase3() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, 325);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 12);
        preIterator.add(edge1);
        preIterator.add(edge2);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 2, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");
        
        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test
    public void testCase4() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 9);
        EdgeInfo edge2 = new EdgeInfo(2, 1, 13);
        preIterator.add(edge1);
        preIterator.add(edge2);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 2, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");
        
        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test
    public void testCase5() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 107209);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 75269);
        EdgeInfo edge3 = new EdgeInfo(0, 2, 8301);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 2, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertEquals(siecPrzeplywu.getFlow(), 83570, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
}
