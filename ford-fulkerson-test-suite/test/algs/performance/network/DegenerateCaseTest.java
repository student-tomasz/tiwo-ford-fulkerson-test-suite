package algs.performance.network;

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
import algs.network.VertexStructure;
import algs.tests.common.TrialSuite;

public class DegenerateCaseTest {
    
	FlowNetwork<EdgeInfo[][]> networkA;
	ArrayList<EdgeInfo> edges;
	EdgeInfo[] edgesOut;
	EdgeInfo[] edgesIn;
	
	/**
	 * Example for the worst-case behavior of DFS version of Flow Network. Taken from Cormen, but it is 
	 * not replicable in practice, since it supposes that the search algorithm alternates the resulting
	 * augmenting paths. It seems impossible to actually make this happen (although it *may*). So we don't
	 * worry about it.
	 */
        @Before
	public void setUp() {
		edgesOut = new EdgeInfo[2];
		edgesIn = new EdgeInfo[2];
		
		edges = new ArrayList<>();
		edges.add(edgesOut[0] = new EdgeInfo(0, 1,   1000000));
		
		edges.add(new EdgeInfo(1, 2,   1));
		edges.add(edgesOut[1] = new EdgeInfo(0, 2,   1000000));

		edges.add(edgesIn[0] = new EdgeInfo(1, 3,   1000000));		
		edges.add(edgesIn[1] = new EdgeInfo(2, 3,   1000000));
	}
	
	@Test
	public void testBFSTiming () {
		TrialSuite suiteArray = new TrialSuite();
		TrialSuite suiteList = new TrialSuite();
		
		int NUM_TRIALS = 8;

		for (int k = 0; k < NUM_TRIALS; k++) {
			System.out.print(".." + k);
			networkA = new FlowNetworkArray (4, 0, 3, edges.iterator());			
			FordFulkerson ffa = new FordFulkerson(networkA, new DFS_SearchArray(networkA));
			System.gc();
			
			long now = System.currentTimeMillis();
			ffa.compute();
			long end = System.currentTimeMillis();
			int checkSum = networkA.getFlow();
			suiteArray.addTrial(4, now, end);
			
			FlowNetwork<VertexStructure[]> networkL = new FlowNetworkAdjacencyList (4, 0, 3, edges.iterator());			
			ffa = new FordFulkerson(networkL, new DFS_SearchList(networkL));
			System.gc();
			
			now = System.currentTimeMillis();
			ffa.compute();
			end = System.currentTimeMillis();
			suiteList.addTrial(4, now, end);
			if (checkSum != networkL.getFlow()) {
				System.err.println ("DIFFERENT RESULTS!");
			}
		}
		
                System.out.println();
                System.out.println();
		System.out.println("Array");
		System.out.println(suiteArray.computeTable());
		
		System.out.println("List");
		System.out.println(suiteList.computeTable());
	}
	
}
