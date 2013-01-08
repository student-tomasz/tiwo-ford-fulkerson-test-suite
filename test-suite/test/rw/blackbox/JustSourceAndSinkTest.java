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

        siecPrzeplywu = new FlowNetworkArray(4, 0, 1, edges);

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

        siecPrzeplywu = new FlowNetworkArray(4, 0, 1, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));

        assertTrue(fulkerson.compute(), "Algorytm nie wyznaczył maksymalnego przepływu.");

        assertEquals(siecPrzeplywu.getFlow(), 9, "Wyznaczony przepływ jest inny niż określa wyrocznia.");

        assertFalse(fulkerson.compute(), "Algorytm znalazł nowy przepływ maksymalny w uprzednio sprawdzonej sieci.");
    }
}
