/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algs.network;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mochtera
 */
public class Main {
    
    
    public static final void main(String[] args){
        
        int numVertices = 6; //ilość węzłów w grafie
        int srcIndex = 0; //indeks węzła źródłowego
        int sinkIndex = 5;  //indeks węzła docelowego
        
        //Tworzę poszczególne krawędzie i przypisuję im przpustowość
        ArrayList preIterator = new ArrayList();
        EdgeInfo edge1 = new EdgeInfo(0, 1, 3);
        EdgeInfo edge2 = new EdgeInfo(1, 3, 2);
        EdgeInfo edge3 = new EdgeInfo(3, 5, 3);
        EdgeInfo edge4 = new EdgeInfo(1, 4, 2);
        EdgeInfo edge5 = new EdgeInfo(0, 2, 2);
        EdgeInfo edge6 = new EdgeInfo(2, 4, 3);
        EdgeInfo edge7 = new EdgeInfo(4, 5, 2);
        EdgeInfo edge8 = new EdgeInfo(2, 3, 2);
        preIterator.add(edge1);
        preIterator.add(edge2);
        preIterator.add(edge3);
        preIterator.add(edge4);
        preIterator.add(edge5);
        preIterator.add(edge6);
        preIterator.add(edge7);
        preIterator.add(edge8);
                                
        Iterator<EdgeInfo> edges = preIterator.iterator();  //zbiór krawędzi grafu
        Iterator<EdgeInfo> edges2 = preIterator.iterator();  //zbiór krawędzi grafu
        
        
        

        System.out.println("Wersja z podwójną listą. Pamięciożerna");
        FlowNetworkAdjacencyList network = new FlowNetworkAdjacencyList(numVertices, srcIndex, sinkIndex, edges);  //graf przepływu sieci na listach
        
        System.out.println("Przed:");
        System.out.println(network.toString());
        BFS_SearchList search = new BFS_SearchList(network);//algorytm przeszukiwania wszerz
        FordFulkerson fordFulkerson = new FordFulkerson(network, search);
        fordFulkerson.compute();//wykonaj algorytm
        
        System.out.println("Po:");
        System.out.println(network.toString());
        
        
        System.out.println("Wersja z macierzą dwuwymiarową. Oszczedniejsza");   
        FlowNetworkArray networkArray = new FlowNetworkArray(numVertices, srcIndex, sinkIndex, edges2);  //graf przepływu sieci na macierzach
        
        System.out.println("Przed:");
        System.out.println(networkArray.toString());
        BFS_SearchArray searchArray = new BFS_SearchArray(networkArray);//algorytm przeszukiwania wszerz
        fordFulkerson = new FordFulkerson(networkArray, searchArray);
        fordFulkerson.compute();//wykonaj algorytm
        
        System.out.println("Po:");
        System.out.println(networkArray.toString());
    }   
}