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
public class JustOneElementTest {

    public JustOneElementTest() {
    }

    @Test
    public void testCase1() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(1, 0, 1, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test(expectedExceptions=Exception.class)
    public void testCase2() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(1, 2, 1, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
    
    @Test(expectedExceptions=Exception.class)
    public void testCase3() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork flowNetwork;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(1, 1, 0, edges);

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

        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(1, 0, 0, edges);

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
        EdgeInfo edge1 = new EdgeInfo(0, 0, 5);
        preIterator.add(edge1);
        edges = preIterator.iterator();

        flowNetwork = new FlowNetworkArray(1, 0, 0, edges);

        fulkerson = new FordFulkerson(flowNetwork, new DFS_SearchArray(flowNetwork));

        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez ścieżki ze źródła do ujścia.");

        assertEquals(flowNetwork.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    } 
}
