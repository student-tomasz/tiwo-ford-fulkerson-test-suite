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

    public NegativeSizeNetworkTest() {
    }

    @Test(expectedExceptions = NegativeArraySizeException.class)
    public void FailAtNegativeSizeNetworkTest() {
        FordFulkerson fulkerson;
        FlowNetwork<EdgeInfo[][]> flowNetwork = new FlowNetworkArray(-5, 2, 5, null);
        fulkerson = new FordFulkerson((flowNetwork), new DFS_SearchArray(flowNetwork));
    }

    @Test(expectedExceptions = NegativeArraySizeException.class)
    public void FailAtNegativeSizeNetworkTest2() throws Exception {
        FordFulkerson fulkerson;
        FlowNetwork<EdgeInfo[][]> flowNetwork = FlowNetworkGenerator.generateArray(-5, 1, 5, 3, 10);
        fulkerson = new FordFulkerson((flowNetwork), new DFS_SearchArray(flowNetwork));
    }
    //Nie da się stworzyć sieci z ujemną wartością numVertices
}