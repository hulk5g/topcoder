package Sorting;

import java.util.*;

/**
 * @author ksharma
 */
public class MergeIntervals {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        PriorityQueue<Interval>pq=new PriorityQueue<>((a,b)->a.start-b.start);
        pq.addAll(intervals);
        List<Interval> result=new ArrayList<>();
        while(!pq.isEmpty()){
            Interval top1=pq.poll();
            if(!pq.isEmpty()){
                Interval top2=pq.peek();
                if(top1.end>=top2.start){
                    pq.poll();
                    Interval temp=new Interval(top1.start,Math.max(top1.end,top2.end));
                    pq.add(temp);
                }else{
                    result.add(top1);
                }
            }else{
                result.add(top1);
            }
        }
        return result;
    }

    public static void main(String []args){
        MergeIntervals ms=new MergeIntervals();
        List<Interval> list=new ArrayList<>();
        MergeIntervals.Interval mt=new Interval();
        list.add(new Interval(1,4));
        list.add(new Interval(4,5));
        Deque<String> dq=new LinkedList<>();

        System.out.println(ms.merge(list));
    }
}
