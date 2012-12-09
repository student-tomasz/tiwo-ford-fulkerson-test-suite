package ford_fulkerson.tree.debug;

import ford_fulkerson.debug.DottyDebugger;
import ford_fulkerson.tree.BalancedBinaryNode;
import ford_fulkerson.tree.BinaryNode;
import ford_fulkerson.tree.IBalancedVisitor;
import ford_fulkerson.tree.IVisitor;
import ford_fulkerson.tree.IVisitor;

/**
 * Debugging subclass for binary trees.
 * 
 * @author George Heineman
 * @version 1.0, 6/15/08
 * @since 1.0
 */
@SuppressWarnings("unchecked")
public class BinaryTreeDebugger extends DottyDebugger implements IVisitor, IBalancedVisitor {

	/** 
	 * Default to having nodes with complex record shapes.
	 * 
	 * Subclasses should override as needed.
	 */
	public String edgeType() {
		return "dir=forward";
	}
	
	/**
	 * Visit (parent, child) pair by visiting both nodes, then add the edge. 
	 */
	@SuppressWarnings("unchecked")
	public void visit(BinaryNode parent, BinaryNode n) {
		// if not yet seen, visit node. Only have to check parent (for root).
		if (parent != null && !nodes.contains(parent)) {
			visitNode(parent);
		}
		
		if (!nodes.contains(n)) {
			visitNode(n);
		}
		
		if (parent != null) {
			visitEdge(parent, n);		
		}
		
	}

	@Override
	public void visit(BalancedBinaryNode parent, BalancedBinaryNode n) {
		// if not yet seen, visit node. Only have to check parent (for root).
		if (parent != null && !nodes.contains(parent)) {
			visitNode(parent);
		}
		
		if (!nodes.contains(n)) {
			visitNode(n);
		}
		
		if (parent != null) {
			visitEdge(parent, n);		
		}
	}

}
