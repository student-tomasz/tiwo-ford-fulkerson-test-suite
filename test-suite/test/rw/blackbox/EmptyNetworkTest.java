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
import algs.network.generator.FlowNetworkGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author robert
 */
public class EmptyNetworkTest {

    public EmptyNetworkTest() {
    }

    @Test(expectedExceptions = Exception.class)
    public void testCase1() {
        FordFulkerson fulkerson;
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = new FlowNetworkArray(0, 2, 5, null);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez jakichkolwiek węzłów.");
        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }

    @Test(expectedExceptions=Exception.class)
    public void testCase2() throws Exception {
        ArrayList preIterator;
        Iterator<EdgeInfo> edges;
        FlowNetwork siecPrzeplywu;
        FordFulkerson fulkerson;

        preIterator = new ArrayList(); // krawedzie i ich przepustowosc

        edges = preIterator.iterator();

        siecPrzeplywu = new FlowNetworkArray(0, 0, 0, edges);

        fulkerson = new FordFulkerson(siecPrzeplywu, new DFS_SearchArray(siecPrzeplywu));
        
        assertFalse(fulkerson.compute(), "Algorytm znalazł niezerowy przepływ maksymalny w sieci bez jakichkolwiek węzłów.");
        assertEquals(siecPrzeplywu.getFlow(), 0, "Wyznaczony przepływ jest inny niż określa wyrocznia.");
    }
}