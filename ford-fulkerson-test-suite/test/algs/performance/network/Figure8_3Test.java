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

public class Figure8_3Test {
    
	FlowNetwork<EdgeInfo[][]> network;
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Figure 8-3
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[3];
		edgesIn = new EdgeInfo[2];
		
		edges = new ArrayList<>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   10));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   5));
		edges.add(edgesOut[2] = new EdgeInfo(0, 3,   4));
		
		edges.add(new EdgeInfo(1, 2,   3));
		edges.add(new EdgeInfo(2, 3,   5));
		edges.add(new EdgeInfo(3, 5,   8));
		edges.add(new EdgeInfo(5, 2,   3));
		edges.add(new EdgeInfo(2, 4,   2));
		edges.add(new EdgeInfo(4, 2,   4));
		edges.add(new EdgeInfo(1, 4,   5));
		
		edges.add(edgesOut[0] = new EdgeInfo(4, 6,   7));
		edges.add(edgesOut[1] = new EdgeInfo(5, 6,   11));

	}
	
	@Test
	public void testExample () {
		network = new FlowNetworkArray(7, 0, 6, edges.iterator());		
		FordFulkerson ff = new FordFulkerson(network, new DFS_SearchArray(network));
		ff.compute();
		System.out.println(network);
		assertEquals(15, network.getFlow());
	}
}
