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
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class NegativeSizeNetworkTest {

    FordFulkerson fulkerson;

    public NegativeSizeNetworkTest() {
    }

    @Test(expectedExceptions = NegativeArraySizeException.class)
    public void FailAtNegativeSizeNetworkTest() {
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = new FlowNetworkArray(-5, 2, 5, null);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
    }

    @Test(expectedExceptions = NegativeArraySizeException.class)
    public void FailAtNegativeSizeNetworkTest2() throws Exception {
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(-5, 1, 5, 3, 10);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
    }
    //Nie da się stworzyć sieci z ujemną wartością numVertices
}