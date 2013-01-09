/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algs.network;

import algs.list.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;


/**
 *
 * @author demon
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
public class ToStringTest {
    
    VertexStructure[] struct;    
    List<EdgeInfo> forward;
    List<EdgeInfo> backward;
    
    @BeforeMethod
    public void setup(){
         struct = VertexStructure.construct(1);
         forward = new List<EdgeInfo>();
         backward = new List<EdgeInfo>();
    }
    
    @Test
    public void testEmpty(){
        System.out.println(struct[0].toString());
        System.out.println("forward:" + forward + ", backward:" + backward);
        assertEquals(struct[0].toString(), "forward:" + forward + ", backward:" + backward);
    }
    
    @Test
    public void testOneEdge(){
        
        EdgeInfo eiForward = new EdgeInfo(0,1,1);
        EdgeInfo eiBackward = new EdgeInfo(0,1,1);

        struct[0].addForward(eiForward);
        struct[0].addBackward(eiBackward);
        
        forward.append(eiForward);
        backward.append(eiBackward);
        System.out.println(struct[0].toString());
        System.out.println("forward:" + forward + ", backward:" + backward);
        assertEquals(struct[0].toString(), "forward:" + forward + ", backward:" + backward);
    }
    
    @Test
    public void testThreeEdges(){
        
        for(int i=0; i<3; i++){
            
            EdgeInfo eiForward = new EdgeInfo(i,i+1,1);
            EdgeInfo eiBackward = new EdgeInfo(i,i+1,1);

            struct[0].addForward(eiForward);
            struct[0].addBackward(eiBackward);
        
            forward.append(eiForward);
            backward.append(eiBackward);
        }
        System.out.println(struct[0].toString());
        System.out.println("forward:" + forward + ", backward:" + backward);
        assertEquals(struct[0].toString(), "forward:" + forward + ", backward:" + backward);
    }
}
