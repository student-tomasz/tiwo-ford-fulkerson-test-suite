package algs.performance.network;

import org.junit.Test;

import algs.network.DFS_SearchArray;
import algs.network.DFS_SearchList;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FordFulkerson;
import algs.network.VertexStructure;
import algs.network.generator.FlowNetworkGenerator;
import algs.tests.common.TrialSuite;

public class CompleteGraphs {
    
	@Test
	public void testBFSTiming () {
		TrialSuite suiteArray = new TrialSuite();
		TrialSuite suiteList = new TrialSuite();
		
		long seed = 1263;
		
		int NUM_TRIALS = 8;
		int MIN_CAPACITY = 15;
		int MAX_CAPACITY = 20;

		for (int n = 8; n <= 256; n *= 2) {
			System.out.println (n);
			
			for (int k = 0; k < NUM_TRIALS; k++) {
				System.out.print(".." + k);
				FlowNetworkGenerator.setSeed(seed+k);
				FlowNetwork<EdgeInfo[][]> networkA = FlowNetworkGenerator.generateArray(n, n-3, n-3, MIN_CAPACITY, MAX_CAPACITY);
				FordFulkerson ffa = new FordFulkerson(networkA, new DFS_SearchArray(networkA));
				System.gc();
				
				long now = System.currentTimeMillis();
				ffa.compute();
				long end = System.currentTimeMillis();
				int checkSum = networkA.getFlow();
				suiteArray.addTrial(n, now, end);
				
				FlowNetworkGenerator.setSeed(seed+k);
				FlowNetwork<VertexStructure[]> networkL = FlowNetworkGenerator.generateList(n, n-3, n-3, MIN_CAPACITY, MAX_CAPACITY);
				ffa = new FordFulkerson(networkL, new DFS_SearchList(networkL));
				System.gc();
				
				now = System.currentTimeMillis();
				ffa.compute();
				end = System.currentTimeMillis();
				suiteList.addTrial(n, now, end);
				if (checkSum != networkL.getFlow()) {
					System.err.println ("DIFFERENT RESULTS!");
				}
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
