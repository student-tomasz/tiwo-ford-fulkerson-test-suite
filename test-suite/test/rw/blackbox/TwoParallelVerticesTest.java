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
public class TwoParallelVerticesTest {
    /*ArrayList preIterator;
    Iterator<EdgeInfo> edges;
    FlowNetwork siecPrzeplywu;*/
    FordFulkerson fulkerson;
    public TwoParallelVerticesTest() {
    }
    
    @DataProvider
    public static Iterator<FlowNetworkArray> sieci(){
        ArrayList<EdgeInfo> zbiorKrawedzi = new ArrayList<>();
        ArrayList<FlowNetworkArray> zbiorSieci = new ArrayList<>();
        EdgeInfo edge1, edge2, edge3, edge4, edge5, edge6, edge7, edge8;
        
        edge1 = new EdgeInfo(0, 1, 1);
        edge2 = new EdgeInfo(0, 2, 4);
        edge3 = new EdgeInfo(1, 3, 2);
        edge4 = new EdgeInfo(2, 3, 3);
        zbiorKrawedzi.add(edge1);
        zbiorKrawedzi.add(edge2);
        zbiorKrawedzi.add(edge3);
        zbiorKrawedzi.add(edge4);
        
        zbiorSieci.add(new FlowNetworkArray(4, 0, 3, zbiorKrawedzi.iterator()));
        
        return zbiorSieci.iterator();
    }

    @Test(dataProvider="sieci")
    public void TwoParallelVerticesTest(FlowNetworkArray siecPrzeplywu) throws Exception {
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
   /* @Test
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
        
        assertEquals(siecPrzeplywu, 4, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
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
        
        assertEquals(siecPrzeplywu, 4, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
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
        
        assertEquals(siecPrzeplywu, 4, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test
    public void testCase4() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 7);
        EdgeInfo edge2 = new EdgeInfo(0, 2, 1);
        EdgeInfo edge3 = new EdgeInfo(1, 3, 5);
        EdgeInfo edge4 = new EdgeInfo(2, 3, 3);
        EdgeInfo edge5 = new EdgeInfo(2, 1, 9);
        EdgeInfo edge6 = new EdgeInfo(1, 2, 6);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        preIterator.add(edge6);
        
        edges = preIterator.iterator();
        
        siecPrzeplywu=new FlowNetworkArray(4, 0, 3, edges);
        
        fulkerson=new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertTrue(fulkerson.compute(),"Algorytm nie wyznaczył maksymalnego przepływu.");
        
        assertEquals(siecPrzeplywu, 4, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
        
        assertFalse(fulkerson.compute(),"Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }*/
    
}
