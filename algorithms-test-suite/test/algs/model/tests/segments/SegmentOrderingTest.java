package algs.model.tests.segments;

import java.util.Comparator;

import org.junit.Test;

import algs.model.ILineSegment;
import algs.model.IPoint;
import algs.model.problems.segmentIntersection.LineState;
import algs.model.twod.TwoDLineSegment;
import algs.model.twod.TwoDPoint;

import junit.framework.TestCase;

public class SegmentOrderingTest extends TestCase {

	@Test
	public void testSegmentOrdering() {
		// Test known intersection
		ILineSegment s1 = new TwoDLineSegment(new TwoDPoint(20,20), new TwoDPoint(10,10));
		ILineSegment s2 = new TwoDLineSegment(new TwoDPoint(18,30), new TwoDPoint(15,2));
	
		LineState ls = new LineState();
		ls.setSweepPoint(s1.getStart());
		
		Comparator<ILineSegment> c = ls.seg_order;
		
		// note: only comparisons available when both s1 and s2 are defined at the sweep point.
		
		// until their intersection s2 < s1
		int cmp = c.compare(s1,s2);
		assertEquals (1, cmp);

		
		// at their intersection point and beyond, we swap 
		IPoint p = s1.intersection(s2);
		ls.setSweepPoint(p);
		cmp = c.compare(s1,s2);
		assertEquals (-1, cmp);
	}		
}
