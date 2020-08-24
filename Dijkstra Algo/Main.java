package p1;

import java.util.*;

public class Main {
	
	int []distance;
	Set<Integer> visited;
	PriorityQueue<Node> pQueue;
	int V;
	
	public Main(int v){
		V=v;
		distance = new int[V];
		visited=new HashSet<>();
		pQueue=new PriorityQueue<Node>(V,new Node());
	}

	public static void main(String[] args) {
		int V = 5; 
        int source = 0; 
  
        // Adjacency list representation of the  
        // connected edges 
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >(); 
  
        // Initialize list for every node 
        for (int i = 0; i < V; i++) { 
            ArrayList<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
  
        // Inputs for the DPQ graph 
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
        
        Main md=new Main(V);
        md.Dijstra(adj,0);
        
        System.out.println("The shorted path from node :"); 
        for (int i = 0; i < md.distance.length; i++) 
            System.out.println(source + " to " + i + " is "
                               + md.distance[i]);
        
	}
	
	public void Dijstra(ArrayList<ArrayList<Node>> ar,int source){
		Arrays.fill(distance, Integer.MAX_VALUE);
		pQueue.add(new Node(source,0));
		distance[source]=0;
		
		while(!pQueue.isEmpty()){
			int u=pQueue.remove().val;
			visited.add(u);
		for(int i=0;i<ar.get(source).size();i++){
			Node v=ar.get(source).get(i);
			if(!visited.contains(v.val)){
				int newDistance=distance[u]+v.distance;
				if(distance[v.val]>newDistance)
					distance[v.val]=newDistance;
				
				pQueue.add(new Node(v.val,distance[v.val]));
			}
			
		}
		}
	}

}

class Node implements Comparator<Node>{
	int val,distance;
	public Node(int v,int d){
		val=v;
		distance=d;
	}
	public Node(){
		
	}
	@Override
	public int compare(Node n1, Node n2) {
		if(n1.distance<n2.distance)
			return -1;
		if(n1.distance>n2.distance)
			return 1;
		return 0;
	}
	
	
}
