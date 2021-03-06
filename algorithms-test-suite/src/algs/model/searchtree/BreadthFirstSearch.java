package algs.model.searchtree;

import java.util.Iterator;

import algs.model.list.DoubleLinkedList;
import algs.model.searchtree.states.StateStorageFactory;

/**
 * Given an initial state and a target goal state, expand in breadth-first
 * manner all available moves until the target goal state is reached.
 * <p>
 * This search approach is guaranteed to find the shortest possible path to
 * the goal state, should one exist.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
public class BreadthFirstSearch implements ISearch {
	
	/** Storage type. Defaults to HASH for efficiency. */
	int closedStorage = StateStorageFactory.HASH;
	
	/** Determine structure to use for storing CLOSED set. */
	public void storageType (int type) {
		closedStorage = type;
	}
	
	/** 
	 * Initiate the search for the target state.
	 */
	public Solution search(INode initial, INode goal) {
		// Return now if initial is the goal
		if (initial.equals(goal)) {	return new Solution (initial, goal); }
		
		// Start from the initial state
		INodeSet open = StateStorageFactory.create(StateStorageFactory.QUEUE);
		open.insert(initial.copy()); 
		
		// states we have already visited.
		INodeSet closed = StateStorageFactory.create(closedStorage);
		while (!open.isEmpty()) {
			INode n = open.remove();
			closed.insert(n);
			
			// All successor moves translate into appended OPEN states.
			DoubleLinkedList<IMove> moves = n.validMoves();
			for (Iterator<IMove> it = moves.iterator(); it.hasNext(); ) {
				IMove move = it.next();
				
				// make move on a copy
				INode successor = n.copy();
				move.execute(successor);
				numMoves++; /* STATS */
					
				// If already visited, search this state no more
				if (closed.contains(successor) != null) {
					continue;
				}
			
				// Record previous move for solution trace. If solution, leave 
				// now, otherwise add to the OPEN set.
				successor.storedData(new Transition(move, n));
				if (successor.equals(goal)) {
					numOpen = open.size(); numClosed = closed.size();  /* STATS */
					return new Solution (initial, successor);
				}
				open.insert(successor);				
			}
		}
		
		// No solution.
		numOpen = open.size(); numClosed = closed.size();  /* STATS */
		return new Solution (initial, goal, false);
	}

	// statistical information to evaluate algorithms effectiveness.
	public int numMoves = 0;
	public int numOpen = 0;
	public int numClosed = 0;
}
