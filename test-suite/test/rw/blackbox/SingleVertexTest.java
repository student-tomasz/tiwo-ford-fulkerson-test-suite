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
public class SingleVertexTest {

    public SingleVertexTest() {
    }

    @Test
    public void testCase1a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 512);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 126);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 126, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase1b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 104526);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 75269);
        EdgeInfo edge3 = new EdgeInfo(1, 0, 1523);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 75269, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase2() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, 43);
        EdgeInfo edge2 = new EdgeInfo(2, 1, 76);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test
    public void testCase3() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 0, 325);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 12);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test
    public void testCase4() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 9);
        EdgeInfo edge2 = new EdgeInfo(2, 1, 13);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test
    public void testCase5() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 107209);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 75269);
        EdgeInfo edge3 = new EdgeInfo(0, 2, 8301);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 83570, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase6a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 73);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 17);
        EdgeInfo edge3 = new EdgeInfo(1, 1, 345);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 17, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)//Czy przez pętle podnoszony jest jakikolwiek wyjątek
    public void testCase6b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 73);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 17);
        EdgeInfo edge3 = new EdgeInfo(1, 1, 345);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);
        
        flowNetwork.validate();

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        fulkerson.compute();
    }

    @Test
    public void testCase7a() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 5);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 7);
        EdgeInfo edge3 = new EdgeInfo(1, 0, 12);
        EdgeInfo edge4 = new EdgeInfo(2, 1, 3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);


        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 5, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test(expectedExceptions=Exception.class)
    public void testCase7b() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 16);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 8);
        EdgeInfo edge3 = new EdgeInfo(1, 0, 5);
        EdgeInfo edge4 = new EdgeInfo(2, 1, 2);
        EdgeInfo edge5 = new EdgeInfo(1, 2, 13);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);
        
        flowNetwork.validate();
    }
    
    @Test
    public void testCase7c() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 16);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 8);
        EdgeInfo edge3 = new EdgeInfo(1, 0, 5);
        EdgeInfo edge4 = new EdgeInfo(2, 1, 2);
        EdgeInfo edge5 = new EdgeInfo(1, 2, 13);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));
        
        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 16, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase8() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 3);

        preIterator.add(edge1);


        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test
    public void testCase9() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 13);
        EdgeInfo edge2 = new EdgeInfo(0, 2, 5);
        preIterator.add(edge1);
        preIterator.add(edge2);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 5, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase10() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(1, 2, 7);

        preIterator.add(edge1);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(3, 0, 2, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
}
