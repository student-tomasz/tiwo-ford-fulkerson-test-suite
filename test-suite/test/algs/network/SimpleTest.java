package algs.network;

import static org.junit.Assert.*;
import org.junit.Test;

import algs.network.EdgeInfo;
import algs.network.VertexInfo;

public class SimpleTest {
	
	@Test
	public void testSearches() {
		VertexInfo vi = new VertexInfo(3, false);
		assertEquals("[previous: " + 3 + ", forward: " + false + "]", vi.toString());
	}
	
	@Test
	public void testSimple() {
		EdgeInfo ei = new EdgeInfo (2, 10, 6);
		EdgeInfo ei2 = new EdgeInfo (2, 10, 6);
		
		assertEquals(ei, ei2);
		assertFalse(ei.equals(null));
		assertFalse(ei.equals("slkdj"));
		
		assertEquals(ei.hashCode(), ei2.hashCode());
	}
}
