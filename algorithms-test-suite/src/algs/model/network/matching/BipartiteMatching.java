package algs.model.network.matching;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import algs.model.network.DFS_SearchArray;
import algs.model.network.EdgeInfo;
import algs.model.network.FlowNetworkArray;
import algs.model.network.FordFulkerson;

/**
 * Computes a matching in a bipartite graph whose vertices are divided into two distinct 
 * sets S and T and whose edges only exist between vertices in S and vertices in T.
 * <p>
 * Computes the matching by converting the problem into a FlowNetwork problem.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public class BipartiteMatching {

	/** Edges for S and T. */
	ArrayList<EdgeInfo> edges;

	/** Unique id counter. */
	int ctr = 0;			  	   						      

	/** Maps to convert between Matching problem and FlowNetwork problem. */
	Hashtable<Object,Integer> map = new Hashtable<Object,Integer>();

	/** Map to convert from FlowNetwork problem and Matching problem. */
	Hashtable<Integer,Object> reverse = new Hashtable<Integer,Object>();

	/** Source index of flow network problem. */
	int srcIndex;	 

	/** Target index of flow network problem. */
	int tgtIndex;   

	/** Number of vertices in flow network problem. */
	int numVertices;

	/**
	 * Construct matching instance from information.
	 * <p>
	 * Note that the objects which make up the vertex sets must have properly
	 * implements {@link Object#hashCode()} and {@link Object#equals(Object)}
	 * methods.
	 * <p>
	 * @param setS     Set S being matched to T
	 * @param setT     Set T being matched to S
	 * @param pairs    edges crossing from S to T
	 * 
	 * @throws RuntimeException    if an error in input occurs.
	 */
	public BipartiteMatching (Object[] setS, Object[] setT, Object[][] pairs) { 

		// ensure that S and T are disjoint
		for (Object o : setS) {
			if (contains(setT, o)) { throw new RuntimeException  ("Matching sets must be disjoint."); }
		}
		for (Object o : setT) {
			if (contains(setS, o)) { throw new RuntimeException  ("Matching sets must be disjoint."); }
		}

		edges = new ArrayList<EdgeInfo>();
		// convert pairs into appropriate input for FlowNetwork. Ensure structure is ok
		for (int i = 0; i < pairs.length; i++) {
			if (pairs[i].length != 2) {
				throw new RuntimeException  ("Edge information not in pairs (s,t)");
			}

			if (!contains(setS, pairs[i][0]) || !contains(setT, pairs[i][1])) {
				throw new RuntimeException  ("Invalid Edge:" + i);
			}

			Integer src = map.get(pairs[i][0]);
			Integer tgt = map.get(pairs[i][1]);
			if (src == null) { map.put(pairs[i][0], src = ++ctr); reverse.put(src, pairs[i][0]);}
			if (tgt == null) { map.put(pairs[i][1], tgt = ++ctr); reverse.put(tgt, pairs[i][1]);}

			edges.add(new EdgeInfo(src, tgt, 1));
		}

		// add extra "source" and "target" vertices.
		srcIndex = 0;
		tgtIndex = setS.length + setT.length+1;
		numVertices = tgtIndex+1;
		for (Object o : setS) {
			this.edges.add(new EdgeInfo(srcIndex, map.get(o), 1));
		}
		for (Object o : setT) {
			this.edges.add(new EdgeInfo(map.get(o), tgtIndex, 1));
		}
	}

	/**
	 * Compute a solution to the FlowNetwork problem and find all edges in the 
	 * solution whose flow is 1, since these are valid solutions to the matching
	 * problem. 
	 * <p>
	 * Return an Iterator of Pair objects that reflect the discovered matching. 
	 */
	public Iterator<Pair> compute() {
		FlowNetworkArray network = new FlowNetworkArray(numVertices, srcIndex, tgtIndex, edges.iterator());
		FordFulkerson solver = new FordFulkerson (network, new DFS_SearchArray(network));
		solver.compute();

		// retrieve from original edgeInfo set; ignore created edges to the
		// added 'source' and 'target'. Only include in solution if flow == 1
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for (EdgeInfo ei : edges) {
			if (ei.start != srcIndex && ei.end != tgtIndex) {
				if (ei.getFlow() == 1) {
					pairs.add(new Pair(reverse.get(ei.start), reverse.get(ei.end)));
				}
			}
		}

		return pairs.iterator();
	}

	/** Helper method to determine if element is a member of the array. */
	private boolean contains (Object[] set, Object element) {
		for (Object i : set) {
			if (i.equals(element)) { return true; }
		}
		return false;
	}
}