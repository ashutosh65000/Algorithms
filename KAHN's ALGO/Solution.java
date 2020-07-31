import java.util.*;
 public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> graph[]=new ArrayList[numCourses];
        int indegree[]=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<prerequisites.length;i++){
                if(graph[prerequisites[i][0]]==null)
                    graph[prerequisites[i][0]]=new ArrayList();
                graph[prerequisites[i][0]].add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        //System.out.println(Arrays.toString(indegree));
        for(int index=0;index<numCourses;index++){
            if(indegree[index]==0)
                queue.offer(index);
        }
        
        int count=0;
        int result[]=new int[numCourses];
        Stack<Integer> st=new Stack<>();
        while(!queue.isEmpty()){
            int temp=queue.poll();
            //result[count++]=temp;
            st.push(temp);
            count++;
            if(graph[temp]!=null){
                for(int k:graph[temp]){
                    indegree[k]--;
                    if(indegree[k]==0)
                        queue.offer(k);
                }
            }
        }
        
        int index=0;
        if(count==numCourses)
        {
        while(!st.isEmpty()){
            result[index++]=st.pop();
        }
            return result;
        }
        else
            return new int[0];
    }
}