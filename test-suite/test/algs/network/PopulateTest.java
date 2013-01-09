/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algs.network;
import java.util.ArrayList;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import static org.mockito.Mockito.*;
import java.util.Iterator;

/**
 *
 * @author mateusz
 */
public class PopulateTest {
   
    Iterator<EdgeInfo> edges;
    
    @BeforeMethod
    public void setUp(){
    }
    
    @Test
    public void testNumberOfCalls_hasNext(){
        
        edges = mock(Iterator.class);
        when(edges.hasNext()).thenReturn(true, true, true, true, true, true, true, true, false);
        when(edges.next()).thenReturn(mock(EdgeInfo.class));
        
        FlowNetworkArray fna = new FlowNetworkArray(6, 0, 5, edges);
        fna.populate(edges);
        
        verify(edges, times(8)).next();
    }  
}
