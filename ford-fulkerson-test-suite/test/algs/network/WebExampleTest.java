package algs.network;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import algs.network.DFS_SearchArray;
import algs.network.DFS_SearchList;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FlowNetworkAdjacencyList;
import algs.network.FlowNetworkArray;
import algs.network.FordFulkerson;

/* Test the code on another example. */
public class WebExampleTest {
	
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Example drawn from 
	 *
	 * http://www.me.utexas.edu/~jensen/models/network/net11.html
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[3];
		edgesIn = new EdgeInfo[3];
		
		edges = new ArrayList<>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   15));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   10));
		edges.add(edgesOut[2] = new EdgeInfo(0, 3,   12));
		
		edges.add(new EdgeInfo(1, 4,   5));
		edges.add(new EdgeInfo(1, 5,   5));
		edges.add(new EdgeInfo(1, 6,   5));
		
		edges.add(new EdgeInfo(2, 4,   6));
		edges.add(new EdgeInfo(2, 5,   6));
		edges.add(new EdgeInfo(2, 6,   6));
		
		edges.add(new EdgeInfo(3, 4,   12));
		
		edges.add(edgesIn[0] = new EdgeInfo(4, 7,   10));
		edges.add(edgesIn[1] = new EdgeInfo(5, 7,   15));
		edges.add(edgesIn[2] = new EdgeInfo(6, 7,   15));
	}
	
	private void validate(FlowNetwork<?> network) {
		network.validate();
				
		int outSum = 0;
		int inSum = 0;
		for (int i = 0; i < edgesIn.length; i++) {
			inSum += edgesIn[i].getFlow();
		}
		for (int i = 0; i < edgesOut.length; i++) {
			outSum += edgesOut[i].getFlow();
		}
		
		assertEquals(inSum, outSum);
		assertEquals(30, inSum);		
	}
	
	@Test
	public void testFulkersonDFS() {
		FlowNetworkArray network = new FlowNetworkArray(8, 0, 7, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchArray(network));
		ffa.compute();
		validate(network);
	}
	
	@Test
	public void testFulkersonDFSList() {
		FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList(8, 0, 7, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchList(network));
		ffa.compute();
		validate(network);
	}
}
