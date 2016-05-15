package Questions;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgorithmn 
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		
		final int INFINITY = Integer.MAX_VALUE;
		
		int numNodes = in.nextInt();
		int numPaths = in.nextInt();
		
		//Limits: numNodes < 2000.
		ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, Integer> weights = new HashMap<Integer, Integer>();
		
		for (int i = 0;i < numNodes;++i) paths.add(new ArrayList<Integer>());
		
		for (int i = 0;i < numPaths;++i)
		{
			int start = in.nextInt()-1;
			int end = in.nextInt()-1;
			int weight = in.nextInt();
			
			paths.get(start).add(end);
			paths.get(end).add(start);
			weights.put(map(start, end), weight);
			weights.put(map(end, start), weight);
		}
		
		int startNode = 0;
		int endNode = 5;
		
		int[] nodeVal = new int[numNodes];
		
		for (int i = 0;i < numNodes;++i) nodeVal[i] = INFINITY;
		
		nodeVal[startNode] = 0;
		
		PriorityQueue<NodeWeights> d = new PriorityQueue<NodeWeights>();
		
		d.add(new NodeWeights(0, 0));
		
		while (!d.isEmpty())
		{
			NodeWeights polled = d.poll();
			
			int cWeight = polled.weight;
			int node = polled.node;
			
			ArrayList<Integer> neighbours = paths.get(node);
			
			while (!neighbours.isEmpty())
			{
				int neighbour = neighbours.get(0);
				
				//Removes from both.
				neighbours.remove(0);
				paths.get(neighbour).remove(new Integer(node));
				
				int nWeight = weights.get(map(node, neighbour)) + cWeight;
				
				if (nodeVal[neighbour] > nWeight)
				{
					nodeVal[neighbour] = nWeight;
				}
				
				d.add(new NodeWeights(nodeVal[neighbour], neighbour));
			}
		}
		
		System.out.println(nodeVal[endNode]);
	}
	
	public static class NodeWeights implements Comparable<NodeWeights>
	{
		int weight = 0;
		int node = 0;
		
		public NodeWeights(int x, int y)
		{
			weight = x;
			node = y;
		}
		
		public int compareTo(NodeWeights o) 
		{
			if (o.weight > weight) return -1;
			else if (o.weight < weight) return 1;
			else return 0;
		}
	}
	
	public static int map(int x, int y)
	{
		return x + y * 100000;
	}
}
