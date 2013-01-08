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
import java.util.ArrayList;
import java.util.Iterator;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class JustSourceAndSinkTest {

    public JustSourceAndSinkTest() {
    }

    @Test
    public void testCase1() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test
    public void testCase2() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 9);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 9, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test
    public void testCase3a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 57956756);
        EdgeInfo edge2 = new EdgeInfo(1, 1, 6363);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 57956756, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase3b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 12);
        EdgeInfo edge2 = new EdgeInfo(1, 1, 2);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        siecPrzeplywu.validate();
        
        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
    
    @Test
    public void testCase4a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 346723);
        EdgeInfo edge2 = new EdgeInfo(0, 0, -1623474);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 346723, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase4b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 4);
        EdgeInfo edge2 = new EdgeInfo(0, 0, -2);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        siecPrzeplywu.validate();
        
        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
    
    @Test
    public void testCase5() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 0);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test
    public void testCase6a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, -5);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki o dodatniej przepustowości ze źródła do ujścia.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase6b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, -173848);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        siecPrzeplywu.validate();
        
        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
        
    @Test
    public void testCase7() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, 5);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test
    public void testCase8a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, -4);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase8b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, -1639273);
        preIterator.add(edge1);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
    
    @Test
    public void testCase9a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 12);
        EdgeInfo edge2 = new EdgeInfo(0, 1, 2);
        EdgeInfo edge3 = new EdgeInfo(0, 1, 4);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 18, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase9b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, 9);
        EdgeInfo edge2 = new EdgeInfo(1, 0, 3);
        EdgeInfo edge3 = new EdgeInfo(1, 0, 15);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
    
    @Test
    public void testCase10a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, -16);
        EdgeInfo edge2 = new EdgeInfo(0, 1, -5);
        EdgeInfo edge3 = new EdgeInfo(0, 1, -3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase10b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, -7);
        EdgeInfo edge2 = new EdgeInfo(1, 0, -1);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
    
    @Test
    public void testCase11a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, -16);
        EdgeInfo edge2 = new EdgeInfo(0, 1, -5);
        EdgeInfo edge3 = new EdgeInfo(0, 1, -3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase11b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, -7);
        EdgeInfo edge2 = new EdgeInfo(1, 0, -1);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
    
        @Test
    public void testCase11c() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, -16);
        EdgeInfo edge2 = new EdgeInfo(0, 1, -5);
        EdgeInfo edge3 = new EdgeInfo(0, 1, -3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase11d() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, -7);
        EdgeInfo edge2 = new EdgeInfo(1, 0, -1);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(2, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        fulkerson.compute();
    }
}
