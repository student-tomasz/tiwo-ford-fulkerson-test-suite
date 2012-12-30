package algs.performance.network;

import org.junit.Test;

import algs.network.generator.FlowNetworkGenerator;
import algs.network.DFS_SearchArray;
import algs.network.DFS_SearchList;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FordFulkerson;
import algs.network.VertexStructure;
import algs.tests.common.TrialSuite;

public class SparseVsDense {
	
	@Test
	public void testDFSTiming () {
		TrialSuite suiteArray = new TrialSuite();
		TrialSuite suiteList = new TrialSuite();
		TrialSuite suiteOptimal = new TrialSuite();
		
		// all experiments run with 1263 as seed
		long seed = 1263;
		
		int NUM_TRIALS = 8;
		int MIN_FANIN = 2;
		int MAX_FANIN = 2;
		int MIN_CAPACITY = 1;
		int MAX_CAPACITY = 160;

		System.out.println ("DFS on ARRAY and LIST implementation");
		for (int n = 32; n <= 1024; n *= 2) {
			System.out.println (n);
			
			for (int k = 0; k < NUM_TRIALS; k++) {
				System.out.print(".." + k);
				FlowNetworkGenerator.setSeed(seed+k);
				FlowNetwork<EdgeInfo[][]> networkA = FlowNetworkGenerator.generateArray(n, MIN_FANIN, MAX_FANIN, MIN_CAPACITY, MAX_CAPACITY);
				FordFulkerson ffa = new FordFulkerson(networkA, new DFS_SearchArray(networkA));
				System.gc();
				
				// array
				long now = System.currentTimeMillis();
				ffa.compute();
				long end = System.currentTimeMillis();
				int checkSum = networkA.getFlow();
				suiteArray.addTrial(n, now, end);
				
				// list
				FlowNetworkGenerator.setSeed(seed+k);
				FlowNetwork<VertexStructure[]> networkL = FlowNetworkGenerator.generateList(n, MIN_FANIN, MAX_FANIN, MIN_CAPACITY, MAX_CAPACITY);
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
		
		System.out.println ("Array");
		System.out.println (suiteArray.computeTable());
		
		System.out.println ("List");
		System.out.println (suiteList.computeTable());
	}
}
