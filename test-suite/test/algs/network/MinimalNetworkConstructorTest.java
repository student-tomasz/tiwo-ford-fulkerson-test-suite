package algs.network;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import algs.network.FlowNetworkArray;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 *
 * @author demon
 */
public class MinimalNetworkConstructorTest {
    
       
    @Test
    public void validArgumentTest() {
        FlowNetworkArray network = new FlowNetworkArray(0, 1, 2);
        
        assertEquals(network.sourceIndex, 0);
        assertEquals(network.sinkIndex, 1);
        assertEquals(network.numVertices, 2);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidArgumentTest() {
        FlowNetworkArray network = new FlowNetworkArray(-1, -2, -1);        
    }
    

}
