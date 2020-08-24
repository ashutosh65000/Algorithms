# Dijkstra Algorithm

**Application** - To find shortest path from given source node to all nother nodes

**Limitation** - Won't work on negative edges


## Explanation

**Basic** - We need to assign every node with **INF**  value except source node
			At every node we add weight of edge with cost of vertex from which 
			we arrived  and  compare it with current cost of vertex(destination)
			
			we start it from the source node and put it in the **priority Queue**
			and in the **Set** to mark it as visited 
			Then we visit all its neighbors with same concept
			and keep on updating the distance array which represents distance of every
			node from source node
			We need priority queue because here we are not following BFS or DFS 
			Here after visiting source vertex we need the vertex with smallest weight
			And using priority Queue saves some time
			
			Now comes the code
			
			This the code of Node class with vertex value and cost(distance) with implementing
				comparator
			
		```
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
		```
			This part is related to creating a graph 
			
		```
		int V = 5; 
        int source = 0; 
  
         Adjacency list representation of the  
         connected edges 
        ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >(); 
  
        // Initialize list for every node 
        for (int i = 0; i < V; i++) { 
            ArrayList<Node> item = new ArrayList<Node>(); 
            adj.add(item); 
        } 
  
        adj.get(0).add(new Node(1, 9)); 
        adj.get(0).add(new Node(2, 6)); 
        adj.get(0).add(new Node(3, 5)); 
        adj.get(0).add(new Node(4, 3)); 
  
        adj.get(2).add(new Node(1, 2)); 
        adj.get(2).add(new Node(3, 4)); 
		```
		
		
		this is the main core algorithm which should not be hard to understand given by the 
		above explanation 
		we visit source node and put in priority Queue and Set 
		Then we visit it's neighbors and check if they have not already been visted 
		if not visited then we add them in priority queue
		We poll the minimum value from priority Queue to follow algorithm
		
		```
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
		```
