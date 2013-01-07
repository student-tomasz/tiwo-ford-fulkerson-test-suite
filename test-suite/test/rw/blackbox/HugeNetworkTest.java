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
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 *
 * @author robert
 */
public class HugeNetworkTest {
    FordFulkerson fulkerson;
    public HugeNetworkTest() {
    }

    @BeforeSuite
    public void SetGeneratorSeed(){
        FlowNetworkGenerator.setSeed(System.nanoTime()+System.currentTimeMillis());
    }
    
    @Test
    public void Vertices1e1Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(10, 1, 5, 1, 4);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
    
    @Test
    public void Vertices1e2Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(100, 1, 5, 1, 4);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
    
    @Test
    public void Vertices1e3Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(1000, 1, 5, 1, 4);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
       
    /*@Test
    public void Vertices1e4Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(10000, 4, 12, 2, 7);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
    
    @Test
    public void Vertices1e5Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(100000, 2, 7, 4, 6);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
        
    @Test
    public void Vertices1e6Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(1000000, 1, 10, 5, 9);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
    
    @Test
    public void Vertices1e7Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(10000000, 1, 5, 3, 4);
        //fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        //assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        //assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }
    
    @Test
    public void Vertices1e8Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(100000000, 1, 4, 1, 3);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }

    @Test
    public void Vertices1e9Test(){
        System.gc();
        FlowNetwork<EdgeInfo[][]> siecPrzeplywu = FlowNetworkGenerator.generateArray(1000000000, 2, 5, 3, 6);
        fulkerson = new FordFulkerson((siecPrzeplywu), new DFS_SearchArray(siecPrzeplywu));
        assertEquals(fulkerson.compute(), true, "Nie znaleziono ścieżki powiększającej.");
        assertEquals(fulkerson.compute(),false,"Znaleziono ścieżkę powiększającej w sprawdzonej sieci przepływu.");
    }*/

}
