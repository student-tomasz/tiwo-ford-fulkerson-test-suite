/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algs.network;

import java.util.ArrayList;
import java.util.Iterator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


/**
 *
 * @author demon
 */
public class NetworkConstructorTest {
    
    Iterator<EdgeInfo> edges;
    @BeforeClass
    public void setUp() {
        ArrayList preIterator = new ArrayList(); // krawedzie i ich przepustowosc
        EdgeInfo edge1 = new EdgeInfo(0, 1, 3);
        EdgeInfo edge2 = new EdgeInfo(1, 3, 2);
        EdgeInfo edge3 = new EdgeInfo(3, 5, 3);
        EdgeInfo edge4 = new EdgeInfo(1, 4, 2);
        
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
                                
        edges = preIterator.iterator();
    }
    
    @Test
    public void validArgumentTest() {
        FlowNetworkArray network = new FlowNetworkArray( 4, 0, 3, edges);
        
        assertEquals(network.numVertices, 4);
        assertEquals(network.sourceIndex, 0);
        assertEquals(network.sinkIndex, 3);
        while(edges.hasNext()){
            EdgeInfo edge = edges.next();
            assertEquals(network.edge(edge.start, edge.end).capacity, edge.capacity);
        }
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void illegalNumVerticesTest() {
                FlowNetworkArray network = new FlowNetworkArray( -4, 0, 3, edges);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void illegalSourceIndexTest() {
                FlowNetworkArray network = new FlowNetworkArray( 4, -1, 3, edges);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void illegalSinkIndexTest() {
                FlowNetworkArray network = new FlowNetworkArray( 4, 0, -3, edges);
    }
    
    @Test
    public void noEdgesTest() {
                edges = new ArrayList().iterator();
                FlowNetworkArray network = new FlowNetworkArray( 4, 0, 3, edges);
                assertEquals(network.getEdgeStructure(), new EdgeInfo[4][4]);
    }   
}
