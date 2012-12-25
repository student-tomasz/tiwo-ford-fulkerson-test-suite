package algs.network;

import java.util.ArrayList;
import java.util.Hashtable;
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

/* Test the code on the Cormen example. */
public class CormenExampleTest {
	
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Example drawn from [Cormen], p. 581
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[2];
		edgesIn = new EdgeInfo[2];
		
		edges = new ArrayList<>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   16));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   13));
		
		edges.add(new EdgeInfo(1, 2,   10));
		edges.add(new EdgeInfo(1, 3,   12));
		
		edges.add(new EdgeInfo(2, 1,   4));
		edges.add(new EdgeInfo(2, 4,   14));
		
		edges.add(new EdgeInfo(3, 2,   9));
		edges.add(edgesIn[0] = new EdgeInfo(3, 5,   20));
		
		edges.add(new EdgeInfo(4, 3,   7));
		edges.add(edgesIn[1] = new EdgeInfo(4, 5,   4));
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
		
		assertEquals (inSum, outSum);
		assertEquals (23, inSum);
		
		// ensure minCut is satisfied
		
		// just for testing purposes
		Hashtable<EdgeInfo,Integer> edges = new Hashtable<>();
		EdgeInfo res[] = new EdgeInfo[] { new EdgeInfo (1, 3, 12),
				new EdgeInfo (4, 3, 7),
				new EdgeInfo (4, 5, 4)
		};
		for (EdgeInfo ei : res) {
			edges.put (ei, 1);
		}
		DoubleLinkedList<EdgeInfo> s = network.getMinCut();
		java.util.Iterator<EdgeInfo> it = s.iterator();
		while (it.hasNext()) {
			EdgeInfo ei = it.next();
			assertEquals (ei + " is not found", new Integer(1), edges.get(ei)); 
			edges.remove(ei);
		}
		assertEquals (0, edges.size());
	}
	
	@Test
	public void testFulkersonShortestPath () {
		FlowNetworkArray network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new ShortestPathArray(network));
		ffa.compute();
		validate (network);
		assertEquals (23, network.getFlow());

		DoubleLinkedList<EdgeInfo> edges = network.getMinCut();
		for (Iterator<EdgeInfo> it = edges.iterator(); it.hasNext(); ) {
			System.out.println (it.next());
		}
	}
	
	@Test
	public void testFulkersonDFS () {
		FlowNetworkArray network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchArray(network));
		ffa.compute();
		validate (network);

	}

	@Test
	public void testFulkersonDFSList () {
		FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList(6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchList(network));
		ffa.compute();
		validate (network);
	}
}
