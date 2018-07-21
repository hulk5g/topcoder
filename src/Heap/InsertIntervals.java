package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ksharma
 */
public class InsertIntervals {
    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override public String toString() {
            return "Interval{" + "start=" + start + ", end=" + end + '}';
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        return sol3(intervals,newInterval);
    }
    public List<Interval>sol3(List<Interval>intervals, Interval newInterval){
        int i=0;
        List<Interval>result=new ArrayList<>();
        while(i<intervals.size() && intervals.get(i).start<newInterval.start){
            i++;
        }
        intervals.add(i,newInterval);
        Interval prev=null;
        for(Interval interval:intervals){
            if(prev==null || prev.end < interval.start){
                prev=interval;
                result.add(prev);
            }else{
                prev.end=Math.max(prev.end,interval.end);
            }
        }
        return result;
    }

    public List<Interval>sol2(List<Interval>intervals, Interval newInterval){
      List<Interval>result=new ArrayList<>();
      int a = findMaxEnd(intervals,newInterval.start);
      int b = findMinStart(intervals,newInterval.end);
        result.addAll(intervals.subList(0,a));
      if(a<=b){
          int start=Math.min(intervals.get(a).start,newInterval.start);
          int end=Math.max(intervals.get(b).end,newInterval.end);
          result.add(new Interval(start,end));
      }else{
          result.add(newInterval);
      }
      result.addAll(intervals.subList(b+1,intervals.size()));
      return result;
    }

    //finds an interval whose start is less than or equal to new interval's end
    private int findMinStart(List<Interval> intervals, int end) {
        int lo=0;
        int high=intervals.size()-1;
        while(lo<=high){
            int mid = lo+(high-lo)/2;
            Interval midInt=intervals.get(mid);
            if(midInt.start==end)return mid;
            if(midInt.start>end){
                high=mid-1;
            }else{
                lo=mid+1;
            }
        }

        return high;
    }

    //finds an interval whose end is after new interval's start
    private int findMaxEnd(List<Interval> intervals, int start) {
        int lo=0;
        int high=intervals.size()-1;
        while(lo<=high){
            int mid = lo+(high-lo)/2;
            Interval midInt=intervals.get(mid);
            if(midInt.end==start)return mid;
            if(midInt.end<start){
                lo=mid+1;
            }else{
                high=mid-1;
            }
        }

        return lo;
    }

    private int merge(List<Interval> intervals, Interval newInterval) {
        int lo=0;
        int high=intervals.size()-1;
        while(lo<=high){
            int mid = lo+(high-lo)/2;
            Interval midInt=intervals.get(mid);
            if(midInt.start<newInterval.start){
                lo=mid+1;
            }else{
                high=mid-1;
            }
        }

       return lo;
    }

    public List<Interval>sol1(List<Interval>intervals, Interval newInterval){
        PriorityQueue<Interval> pq=new PriorityQueue<>((a,b)->a.start-b.start);
        for(Interval i:intervals){
            pq.offer(i);
        }
        pq.offer(newInterval);
        List<Interval>result=new ArrayList<>();
        while(!pq.isEmpty()){
            Interval first=pq.poll();
            if(!pq.isEmpty() && pq.peek().start<=first.end){
                Interval mergedInterval=new Interval(first.start,Math.max(first.end,pq.poll().end));
                pq.offer(mergedInterval);
            }else{
                result.add(first);
            }
        }
        return result;
    }

    public static void main(String []args){
        InsertIntervals ii=new InsertIntervals();
        List<Interval>list=new ArrayList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(3,5));
        list.add(new Interval(6,7));
        list.add(new Interval(8,10));
        list.add(new Interval(12,16));


        List<Interval> result=ii.insert(list,new Interval(4,8));
        System.out.println(result);
    }
}
