package BFS;

import java.util.*;

/**
 * @author ksharma
 */
public class CutOffTree {
    class Point {
        int x;
        int y;
        int val;
        int steps;
        public Point(int x,int y,int val,int steps){
            this.x=x;
            this.y=y;
            this.val=val;
            this.steps=steps;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Point))
                return false;

            Point point = (Point) o;

            if (x != point.x)
                return false;
            return y == point.y;
        }

        @Override public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest==null ||forest.size()==0||forest.get(0)==null ||forest.get(0).size()==0||forest.get(0).get(0)==0){
            return -1;
        }
        List<Point> nodes=new ArrayList<>();
       for(int i=0;i<forest.size();i++){
           for(int j=0;j<forest.get(i).size();j++){
               if(forest.get(i).get(j)>1){
                   Point p=new Point(i,j,forest.get(i).get(j),0);
                   nodes.add(p);
               }
           }
       }
       Collections.sort(nodes,(a,b)->a.val-b.val);
        Point prev=new Point(0,0,forest.get(0).get(0),0);
        int totalSteps=0;
        for(int i=0;i<nodes.size();i++){
            int count=bfs(prev,nodes.get(i),forest);
            if(count==-1)return -1;
            totalSteps+=count;
            prev=nodes.get(i);
        }
        return totalSteps;
    }

    private int bfs(Point src, Point target,List<List<Integer>>forest) {
        Set<Point> seen=new HashSet<>();
        Queue<Point>Q=new LinkedList<>();
        Q.add(src);
        seen.add(src);
        int [][]dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!Q.isEmpty()){
            Point top=Q.poll();
            if(top.equals(target)){
                int x=top.x;
                int y=top.y;
                List<Integer>row=forest.get(x);
                row.remove(y);
                row.add(y,1);
                return top.steps;
            }
            for(int []d:dir){
                int newX=top.x+d[0];
                int newY=top.y+d[1];
                if(newX>=0 && newX<forest.size() && newY>=0 && newY<forest.get(0).size() && forest.get(newX).get
                        (newY)>0){
                    Point p=new Point(newX,newY,forest.get(newX).get(newY),top.steps+1);
                    if(!seen.contains(p)){
                        seen.add(p);
                        Q.offer(p);
                    }
                }

            }
        }
        return -1;
    }

    public static void main(String []args){
        CutOffTree ct=new CutOffTree();
        List<List<Integer>> input=new ArrayList<>();
        List<Integer> in1=new ArrayList<>();
        in1.add(2);
        in1.add(3);
        in1.add(4);
        input.add(in1);
        List<Integer> in2=new ArrayList<>();
        in2.add(0);
        in2.add(0);
        in2.add(5);
        input.add(in2);
        List<Integer> in3=new ArrayList<>();
        in3.add(8);
        in3.add(7);
        in3.add(6);
        input.add(in3);

        System.out.println(ct.cutOffTree(input));
    }
}
