package algs.network;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import algs.list.DoubleLinkedList;
import algs.network.DFS_SearchArray;
import algs.network.DFS_SearchList;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FlowNetworkAdjacencyList;
import algs.network.FlowNetworkArray;
import algs.network.FordFulkerson;
import algs.network.ShortestPathArray;

/* Test backflows over flow networks. */
public class SampleBackflowTest {
    
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Example intended to show why traversing backedges to reduce flows works.
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[2];
		edgesIn = new EdgeInfo[2];
		
		edges = new ArrayList<>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   3));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   2));
		
		edges.add(new EdgeInfo(1, 4,   2));
		edges.add(new EdgeInfo(2, 3,   2));
		edges.add(new EdgeInfo(2, 4,   3));
		edges.add(new EdgeInfo(1, 3,   2));
		
		edges.add(edgesIn[0] = new EdgeInfo(3, 5,   3));		
		edges.add(edgesIn[1] = new EdgeInfo(4, 5,   2));
	}
	
	public void validate(FlowNetwork<?> network) {
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
		assertEquals(5, inSum);
	}
	
	@Test
	public void testFulkersonDFS () {
		FlowNetworkArray network = new FlowNetworkArray(6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchArray(network));
		ffa.compute();
		validate(network);
		assertEquals(5, network.getFlow());
	}
	
	@Test
	public void testFulkersonShortestPath () {
		FlowNetworkArray network = new FlowNetworkArray(6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new ShortestPathArray(network));
		ffa.compute();
		validate(network);
		assertEquals(5, network.getFlow());

		DoubleLinkedList<EdgeInfo> edges = network.getMinCut();
		for (Iterator<EdgeInfo> it = edges.iterator(); it.hasNext(); ) {
			System.out.println (it.next());
		}
	}
	
	@Test
	public void testFulkersonDFSList () {
		FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList(6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchList(network));
		ffa.compute();
		validate(network);
		assertEquals(5, network.getFlow());
	}
}
