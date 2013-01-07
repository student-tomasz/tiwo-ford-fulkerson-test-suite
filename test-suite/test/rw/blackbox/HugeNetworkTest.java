/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.blackbox;

import algs.network.DFS_SearchArray;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FordFulkerson;
import algs.network.generator.FlowNetworkGenerator;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class HugeNetworkTest {
    FordFulkerson fulkerson;
    public HugeNetworkTest() {
    }

    @Test
    public void failAtCompute(){
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(1000000000, 1, 5, 1, 4);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
    }
}
