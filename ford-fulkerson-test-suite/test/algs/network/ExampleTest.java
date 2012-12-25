package algs.network;

import java.util.ArrayList;

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

/* Test FlowNetwork code */
public class ExampleTest {
	
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Example drawn from [Drozdek, Algorithms in Java], p. 391
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[3];
		edgesIn = new EdgeInfo[3];
		
		edges = new ArrayList<EdgeInfo>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   2));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   4));
		edges.add(edgesOut[2] = new EdgeInfo(0, 3,   1));
		
		edges.add(new EdgeInfo(1, 4,   5));
		
		edges.add(new EdgeInfo(2, 1,   2));
		edges.add(new EdgeInfo(2, 6,   3));
		
		edges.add(new EdgeInfo(3, 5,   2));
		edges.add(new EdgeInfo(3, 6,   3));
		
		edges.add(edgesIn[0] = new EdgeInfo(4, 7,   3));
		
		edges.add(new EdgeInfo(5, 4,   5));
		
		edges.add(edgesIn[1] = new EdgeInfo(5, 7,   2));
		edges.add(edgesIn[2] = new EdgeInfo(6, 7,   1));
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
		
		assertEquals (inSum, outSum);
		assertEquals (5, inSum);
		
		assertEquals (5, network.getFlow());
		
		// output mincut
		DoubleLinkedList<EdgeInfo> dl = network.getMinCut();
		EdgeInfo ei;
		while (!dl.isEmpty()) {
			ei = dl.removeFirst();
			System.out.println (ei);
		}

		assertEquals (2, network.edge(0, 1).getFlow());
		assertEquals (2, network.edge(0, 2).getFlow());
		assertEquals (1, network.edge(0, 3).getFlow());
		assertEquals (3, network.edge(1, 4).getFlow());
		assertEquals (1, network.edge(2, 1).getFlow());
		assertEquals (1, network.edge(2, 6).getFlow());
		assertEquals (1, network.edge(3, 5).getFlow());
		assertEquals (0, network.edge(3, 6).getFlow());
		assertEquals (3, network.edge(4, 7).getFlow());
		assertEquals (0, network.edge(5, 4).getFlow());
		assertEquals (1, network.edge(5, 7).getFlow());
		assertEquals (1, network.edge(6, 7).getFlow());
	}
	
	@Test
	public void testFulkersonDFS () {
		// (int numVertices, Iterator<EdgeInfo> edges, int srcIndex, int tgtIndex) {
		FlowNetworkArray network = new FlowNetworkArray(8, 0, 7, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchArray(network));
		ffa.compute();
		validate(network);
	}
	
        @Test
	public void testFulkersonDFSList () {
		// (int numVertices, Iterator<EdgeInfo> edges, int srcIndex, int tgtIndex) {
		FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList(8, 0, 7, edges.iterator());
		FordFulkerson ffa = new FordFulkerson(network, new DFS_SearchList(network));
		ffa.compute();
		validate(network);
	}
}
