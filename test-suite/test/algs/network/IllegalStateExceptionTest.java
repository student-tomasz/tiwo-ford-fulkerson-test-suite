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
import java.lang.IllegalStateException;

/**
 *
 * @author demon
 */
public class IllegalStateExceptionTest {
    
    FlowNetworkArray network;
    
    @BeforeClass
    public void setUp() {
        ArrayList tmpEdges = new ArrayList();
        EdgeInfo edge = new EdgeInfo(1, 2, 1);
        tmpEdges.add(edge);
        Iterator edges = tmpEdges.iterator();
        network = new FlowNetworkArray(4, 0, 3, edges); //Create: (source) (v1) -e1-> (v2) (sink)
    }
    
    @Test(expectedExceptions = IllegalStateException.class)
    public void moreFlowThanCapacityTest() {
        network.edge(1, 2).flow = 2; //Wymuszam na krawędzi przepływ o wartości 2 mimo że jej przepustowość wynosi 1
        network.validate();
    }
    
    @Test(expectedExceptions = IllegalStateException.class)
    public void flowConservationTest() {
        network.edge(1, 2).flow = 1; //Z węzła 1 wychodzi 1 jednostka 0 wchodzi spowrotem. Przepływ danych się nie pokrywa.
        network.validate();
    }
}
