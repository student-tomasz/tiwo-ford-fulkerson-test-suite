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
public class TwoSerialVerticesTest {

    ArrayList preIterator;
    Iterator<EdgeInfo> edges;
    FlowNetwork flowNetwork;
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

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 3, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase2a() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 15);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 1);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 21);
        EdgeInfo edge4 = new EdgeInfo(1, 2, 5);
        EdgeInfo edge5 = new EdgeInfo(1, 2, 7);
        EdgeInfo edge6 = new EdgeInfo(1, 2, 3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        preIterator.add(edge6);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 15, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase2b() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 15);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 1);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 21);
        EdgeInfo edge4 = new EdgeInfo(1, 2, 5);
        EdgeInfo edge5 = new EdgeInfo(1, 2, 7);
        EdgeInfo edge6 = new EdgeInfo(1, 2, 3);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        preIterator.add(edge6);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        flowNetwork.validate();
    }

    @Test
    public void testCase3() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 3);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 0);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 4);

        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);


        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy maksymalny przepływ w sieci o zerowym przepływie maksymalnym.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test
    public void testCase4() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 7);
        EdgeInfo edge2 = new EdgeInfo(1, 2, -1);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 8);

        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy maksymalny przepływ w sieci o zerowym przepływie maksymalnym.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test
    public void testCase5() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 12);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 4);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 15);
        EdgeInfo edge4 = new EdgeInfo(2, 1, 6);

        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 4, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase6() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 9);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 7);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 2);
        EdgeInfo edge4 = new EdgeInfo(1, 3, 5);

        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 7, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }

    @Test
    public void testCase7() throws Exception {
        preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 11);
        EdgeInfo edge2 = new EdgeInfo(1, 2, 3);
        EdgeInfo edge3 = new EdgeInfo(2, 3, 10);
        EdgeInfo edge4 = new EdgeInfo(0, 2, 6);

        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(4, 0, 3, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(flowNetwork.getFlow(), 9, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
}
