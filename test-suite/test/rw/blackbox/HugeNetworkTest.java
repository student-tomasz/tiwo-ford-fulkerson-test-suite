/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.blackbox;

import algs.network.DFS_SearchArray;
import algs.network.EdgeInfo;
import algs.network.FlowNetwork;
import algs.network.FordFulkerson;
import algs.network.generator.FlowNetworkGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class HugeNetworkTest {
    FordFulkerson fulkerson;
    int flowBefore, flowAfter;
    public HugeNetworkTest() {
    }

    @BeforeSuite
    public void SetGeneratorSeed(){
        FlowNetworkGenerator.setSeed(System.nanoTime()+System.currentTimeMillis());
    }
    
    @DataProvider
    public static Iterator<Integer[]> arrayData(){
        ArrayList<Integer[]> argumenty = new ArrayList<>();
        Integer[] arg1e1={10,         1, 5, 1, 4};
        argumenty.add(arg1e1);
        Integer[] arg1e2={100,        3, 9, 7,15};
        argumenty.add(arg1e2);
        Integer[] arg1e3={1000,       6, 8, 2, 4};
        argumenty.add(arg1e3);
        /*Integer[] arg1e4={10000,      4,12, 2, 7};
        argumenty.add(arg1e4);
        Integer[] arg1e5={100000,     2, 7, 4, 6};
        argumenty.add(arg1e5);
        Integer[] arg1e6={1000000,    1,10, 5, 9};
        argumenty.add(arg1e6);
        Integer[] arg1e7={10000000,   1, 5, 3, 4};
        argumenty.add(arg1e7);
        Integer[] arg1e8={100000000,  1, 4, 1, 3};
        argumenty.add(arg1e8);
        Integer[] arg1e9={1000000000, 2, 5, 3, 6};
        argumenty.add(arg1e9);   */ 
        return argumenty.iterator();
    }
    
    
    @Test(dataProvider="arrayData")
    public void ComputeTest(int numVertices, int minFanOut, int maxFanOut, int minCapacity, int maxCapacity){
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(numVertices, minFanOut, maxFanOut, minCapacity, maxCapacity);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
    
    @Test(dataProvider="arrayData")
    public void ComputedFlowTest(int numVertices, int minFanOut, int maxFanOut, int minCapacity, int maxCapacity){
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(numVertices, minFanOut, maxFanOut, minCapacity, maxCapacity);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        flowBefore=siecPrzeplywu.getFlow();
        fulkerson.compute();
        flowAfter=siecPrzeplywu.getFlow();
        assertNotEquals(flowBefore, flowAfter, "Algorytm nie wyznaczył maksymalnego przepływu.");
    }
    
}
