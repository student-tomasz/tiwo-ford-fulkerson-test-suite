package algs.model.tests.tree;

import org.junit.Test;

import algs.model.tree.BalancedTree;
import algs.model.tree.RightThreadedBinaryTree;
import algs.model.tree.debug.BinaryTreeDebugger;

import junit.framework.TestCase;

public class VisualizerTest extends TestCase {
	
	@Test 
	public void testVisualization() {
		// 5-levels of complete trees.
		RightThreadedBinaryTree<Integer> bt = RightThreadedTreeTest.buildComplete(4);
		BinaryTreeDebugger btd = new BinaryTreeDebugger(); 
		
		bt.accept(btd);
		
		// process the debugger
		System.out.println (btd.getInputString());
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	public void testVisualizationAnother() {
		// 5-levels of complete trees.
		BalancedTree<Integer,Integer> bt = new BalancedTree<Integer,Integer>();
		BinaryTreeDebugger btd = new BinaryTreeDebugger(); 
		
		bt.insert(25, 25);
		bt.insert(43, 43);
		bt.insert(26, 26);
		bt.insert(16, 16);
		bt.insert(17, 17);
		bt.insert(15, 15);
		bt.insert(13, 13);
		
		bt.accept(btd);
		
		// process the debugger
		System.out.println (btd.getInputString());
		
		bt.insert(14, 14);
		
		btd = new BinaryTreeDebugger();
		bt.accept(btd);
		
		// process the debugger
		System.out.println (btd.getInputString());
	}
	
}