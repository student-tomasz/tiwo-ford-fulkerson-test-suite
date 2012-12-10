package algs.model.tests.gametree.debug;

import org.junit.Test;

import algs.model.gametree.IComparator;
import algs.model.gametree.debug.AlphaBetaDebugNode;
import algs.model.gametree.debug.MinMaxNode;
import algs.model.gametree.debug.NegMaxNode;
import algs.model.gametree.debug.ScoreNode;

import junit.framework.TestCase;

public class TestGraphEntities extends TestCase {
	@Test
	public void testAlphaBeta() {
		AlphaBetaDebugNode abn = new AlphaBetaDebugNode(3, 8);
		
		assertEquals ("[3,8]", abn.toString());
		assertEquals (0, abn.value());
		abn.value(6);
		assertEquals (6, abn.value());
		
	}
	
	@Test
	public void testScore() {
		ScoreNode sn = new ScoreNode(7);
		assertEquals ("7", sn.nodeLabel());
		assertEquals (7, sn.score());
	}
	
	@Test
	public void testMinMax() {
		MinMaxNode mmn = new MinMaxNode(IComparator.MIN);
		assertEquals ("MIN: 0", mmn.nodeLabel());
		mmn.value(7);
		assertEquals ("MIN: 7", mmn.nodeLabel());
		assertEquals (7, mmn.value());
		
		mmn = new MinMaxNode(IComparator.MAX);
		assertEquals ("MAX: 0", mmn.nodeLabel());
		mmn.value(7);
		assertEquals ("MAX: 7", mmn.nodeLabel());
		assertEquals (7, mmn.value());
		
		try {
			mmn = new MinMaxNode(null);
			fail ("Fails to detect invalid selector");
		} catch (Exception e) {
			// good.
		}
	}
	
	@Test
	public void testNegMax() {
		NegMaxNode nmn = new NegMaxNode();
		assertEquals ("NEGMAX: 0", nmn.nodeLabel());
		nmn.value(6);
		assertEquals ("NEGMAX: 6", nmn.nodeLabel());
		assertEquals (6, nmn.value());
	}
}
