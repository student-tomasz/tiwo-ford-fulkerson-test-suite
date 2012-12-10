package algs.network;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import algs.network.DFS_SearchArray;
import algs.network.EdgeInfo;
import algs.network.FlowNetworkArray;
import algs.network.FordFulkerson;
import algs.network.ShortestPathArray;
import algs.network.debug.CreateImage;


public class CreateImageTest extends TestCase {

	@Test
	public void testSimple() {

		ArrayList<EdgeInfo> edges = new ArrayList<EdgeInfo>();

		edges.add(new EdgeInfo(0, 1,   300));  // CHI
		edges.add(new EdgeInfo(0, 2,   300));  // DC

		// these drain all into a single target node (6)
		edges.add(new EdgeInfo(3, 5,   300));  // HOU
		edges.add(new EdgeInfo(4, 5,   300));  // BOS
		
		edges.add(new EdgeInfo(1, 3,   200, 7));  // CHI - HOU
		edges.add(new EdgeInfo(1, 4,   200, 6));  // CHI - BOS

		edges.add(new EdgeInfo(2, 3,   280, 4));  // DC - HOU
		edges.add(new EdgeInfo(2, 4,   350, 6));  // DC - BOS
		
		FlowNetworkArray network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		FordFulkerson ff = new FordFulkerson (network, new DFS_SearchArray(network));
		ff.compute();
		new CreateImage().outputGraph(network);
		
		assertEquals (3600, network.getCost());
		assertEquals (600, network.getFlow());
		
		network = new FlowNetworkArray (6, 0, 5, edges.iterator());
		ff = new FordFulkerson (network, new ShortestPathArray(network));
		ff.compute();
		CreateImage ci = new CreateImage();
		ci.outputGraph(network);
		
		assertEquals (3300, network.getCost());
		assertEquals (600, network.getFlow());
		System.out.println(network);
	}

}