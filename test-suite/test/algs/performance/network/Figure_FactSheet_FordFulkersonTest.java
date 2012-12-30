package algs.performance.network;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import algs.network.DFS_SearchArray;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FlowNetworkArray;
import algs.network.FordFulkerson;

public class Figure_FactSheet_FordFulkersonTest {
    
	FlowNetwork<EdgeInfo[][]> network;
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Figure 8 Fact Sheet
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[2];
		edgesIn = new EdgeInfo[2];
		
		edges = new ArrayList<>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   3));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   2));
		
		edges.add(new EdgeInfo(1, 3,   2));
		edges.add(new EdgeInfo(1, 4,   2));
		edges.add(new EdgeInfo(2, 3,   2));
		edges.add(new EdgeInfo(2, 4,   3));
		
		
		edges.add(edgesOut[0] = new EdgeInfo(3, 5,   3));
		edges.add(edgesOut[1] = new EdgeInfo(4, 5,   2));
	}
	
	/**
	 * Step through the compute method to see the different iterations of paths
	 * found in the FactSheet. 
	 */
	@Test
	public void testDFSExample () {
		network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ff = new FordFulkerson (network, new DFS_SearchArray(network));
		ff.compute();
		
		System.out.println(network);
		
		assertEquals(5, network.getFlow());
	}
}
