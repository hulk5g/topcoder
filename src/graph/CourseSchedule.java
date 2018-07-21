package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ksharma
 */
public class CourseSchedule {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[]graph=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        char[] visited=new char[numCourses];
        Arrays.fill(visited,'w');
        LinkedList<Integer>result=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(visited[i]=='w'){
                if(!dfs(i,visited,result,graph))return new int[0];
            }
        }
        int[] r=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            r[i]=result.get(i);
        }
        return r;
    }

    private boolean dfs(int src, char[] visited, LinkedList<Integer> result, List<Integer>[] graph) {
        visited[src]='g';
        for(int j:graph[src]){
            if(visited[j]=='g')return false;
            if(visited[j]=='w'){
                if(!dfs(j,visited,result,graph))return false;
            }
        }
        visited[src]='b';
        result.addFirst(src);
        return true;
    }

    public static void main(String []args){
        CourseSchedule cs=new CourseSchedule();
        int[][] input={{1,0}};
        int[] result=cs.findOrder(2,input);
        for(int a:result){
            System.out.println(a);
        }
    }
}
