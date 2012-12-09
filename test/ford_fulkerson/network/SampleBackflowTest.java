package ford_fulkerson.network;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import org.junit.Test;

import ford_fulkerson.list.DoubleLinkedList;
import ford_fulkerson.network.BFS_SearchArray;
import ford_fulkerson.network.BFS_SearchList;
import ford_fulkerson.network.DFS_SearchArray;
import ford_fulkerson.network.DFS_SearchList;
import ford_fulkerson.network.EdgeInfo;
import ford_fulkerson.network.FlowNetwork;
import ford_fulkerson.network.FlowNetworkAdjacencyList;
import ford_fulkerson.network.FlowNetworkArray;
import ford_fulkerson.network.FordFulkerson;
import ford_fulkerson.network.Optimized;
import ford_fulkerson.network.ShortestPathArray;

/** Test backflows over flow networks. */
public class SampleBackflowTest extends TestCase {
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Example intended to show why traversing backedges to reduce flows works.
	 * 
	 */
	public void setUp() {
		edgesOut = new EdgeInfo[2];
		edgesIn = new EdgeInfo[2];
		
		edges = new ArrayList<EdgeInfo>();
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
		
		assertEquals (inSum, outSum);
		assertEquals (5, inSum);
	}
	
	@Test
	public void testFulkersonDFS () {
		FlowNetworkArray network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchArray(network));
		ffa.compute();
		validate (network);
		assertEquals (5, network.getFlow());
	}
	
	@Test
	public void testFulkersonBFS () {
		FlowNetworkArray network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new BFS_SearchArray(network));
		ffa.compute();
		validate (network);
		assertEquals (5, network.getFlow());

		DoubleLinkedList<EdgeInfo> edges = network.getMinCut();
		for (Iterator<EdgeInfo> it = edges.iterator(); it.hasNext(); ) {
			System.out.println (it.next());
		}
	}
	
	@Test
	public void testFulkersonBFSList () {
		FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new BFS_SearchList(network));
		ffa.compute();
		validate (network);
		assertEquals (5, network.getFlow());
	}

	@Test
	public void testFulkersonShortestPath () {
		FlowNetworkArray network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new ShortestPathArray(network));
		ffa.compute();
		validate (network);
		assertEquals (5, network.getFlow());

		DoubleLinkedList<EdgeInfo> edges = network.getMinCut();
		for (Iterator<EdgeInfo> it = edges.iterator(); it.hasNext(); ) {
			System.out.println (it.next());
		}
	}
	
	@Test
	public void testFulkersonDFSList () {
		FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList (6, 0, 5, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchList(network));
		ffa.compute();
		validate (network);
		assertEquals (5, network.getFlow());
	}
	
	@Test
	public void testMoreOptimized () {
		Optimized network = new Optimized(6, 0, 5, edges.iterator());
		int maxFlow = network.compute(0,5);
		assertEquals (5, maxFlow);
	}
}
