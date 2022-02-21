package com.test;

import java.util.List;

import com.test.backtracking.EightQueens;
import com.test.backtracking.GraphColoring;
import com.test.backtracking.GraphColoring.Graph;
import com.test.backtracking.Knapsack;
import com.test.backtracking.Permutations;
import com.test.backtracking.Sudoku;
import com.test.backtracking.TravelingSaleman;

import junit.framework.TestCase;

public class BacktrackingSample extends TestCase
{
    public void testEightQueens()
    {
        System.out.println("-------- EightQueens -------");
        EightQueens queens = new EightQueens();
        queens.eightQueen();
        assertEquals(92, queens.getValue());
    }
    
    public void testGraphColoring()
    {
        System.out.println("-------- GraphColoring -------");
        GraphColoring coloring = new GraphColoring();
        
        // 五角星
        Graph graphA = new Graph();
        graphA.addVertex("A");
        graphA.addVertex("B");
        graphA.addVertex("C");
        graphA.addVertex("D");
        graphA.addVertex("E");
        
        graphA.addEdge(0, 2);
        graphA.addEdge(0, 3);
        graphA.addEdge(1, 3);
        graphA.addEdge(1, 4);
        graphA.addEdge(2, 4);
        
        coloring.resetValue();
        coloring.coloring(graphA, 1);
        assertEquals(0, coloring.getValue());
        
        coloring.resetValue();
        coloring.coloring(graphA, 2);
        assertEquals(0, coloring.getValue());
        
        coloring.resetValue();
        coloring.coloring(graphA, 3);
        assertEquals(1, coloring.getValue());
    }
    
    public void testKnapsack()
    {
        System.out.println("-------- Knapsack -------");
        
        Knapsack knapsack = new Knapsack();
        
        List<Knapsack.Goods> goodsList =
            Knapsack.createGoodsList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {1, 3, 5, 7, 9, 11, 13, 15, 17});
        
        assertEquals(2, knapsack.knapsack(goodsList, 3));
        knapsack.reset();
        
        assertEquals(45, knapsack.knapsack(goodsList, 81));
        knapsack.reset();
        
        assertEquals(17, knapsack.knapsack(goodsList, 30));
        knapsack.reset();
        
        assertEquals(18, knapsack.knapsack(goodsList, 31));
        knapsack.reset();
        
        assertEquals(18, knapsack.knapsack(goodsList, 32));
        knapsack.reset();
    }
    
    public void testPermutations()
    {
        System.out.println("-------- Permutations -------");
        
        Permutations permutations = new Permutations();
        assertEquals(1, permutations.reorder('a'));
        assertEquals(2 * 1, permutations.reorder('a', 'b'));
        assertEquals(3 * 2 * 1, permutations.reorder('a', 'b', 'c'));
        assertEquals(4 * 3 * 2 * 1, permutations.reorder(false, 'a', 'b', 'c', 'd'));
        assertEquals(5 * 4 * 3 * 2 * 1, permutations.reorder(false, 'a', 'b', 'c', 'd', 'f'));
    }
    
    public void testSudoku()
    {
        System.out.println("-------- Sudoku -------");
        
        Sudoku sudoku = new Sudoku();
        
        Sudoku.NineSquare nineSquare = new Sudoku.NineSquare();
        sudoku.fill(nineSquare);
        nineSquare.reset();
        
        // 初始化
        nineSquare.setInitValue(8, 8, 0);
        sudoku.fill(nineSquare);
        nineSquare.reset();
    }
    
    public void testTravelingSaleman()
    {
        System.out.println("-------- TravelingSaleman -------");
        
        TravelingSaleman.Graph graph = new TravelingSaleman.Graph();
        
        // 添加节点
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        
        // 添加边
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 3);
        graph.addEdge(0, 3, 4);
        graph.addEdge(0, 4, 5);
        
        graph.addEdge(1, 0, 6);
        graph.addEdge(1, 2, 7);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 4, 1);
        
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 2, 3);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 6);
        
        graph.addEdge(3, 0, 1);
        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 4, 7);
        
        graph.addEdge(4, 0, 1);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 2, 9);
        graph.addEdge(4, 3, 10);
        
        TravelingSaleman saleman = new TravelingSaleman();
        saleman.travelMin(graph);
    }
}
