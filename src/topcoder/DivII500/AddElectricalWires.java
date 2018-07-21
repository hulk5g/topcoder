package topcoder.DivII500;

import java.util.*;

/**
 * @author ksharma
 */
public class AddElectricalWires {
    public int maxNewWires(String[] wires, int[] gridConnections){
        int n=wires.length;
        Map<Integer,Set<Integer>>map=new HashMap<>();
        for(int i=0;i<wires.length;i++){
            String s=wires[i];
            for(int j=0;j<s.length();j++){
                int a=s.charAt(j)-'0';
                map.putIfAbsent(i,new HashSet<>());
                map.putIfAbsent(j,new HashSet<>());
                if(a==1){
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }

        Set<Integer>terminal=new HashSet<Integer>();
        for(int i:gridConnections){
            terminal.add(i);
        }
        Set<Integer>visited=new HashSet<Integer>();
        Set<String>done=new HashSet<>();
        int maxCount=0;
        for(int i=0;i<wires.length;i++) {
            String s = wires[i];
            for (int j = 0; j < s.length(); j++) {
                int a=s.charAt(j)-'0';
                if(i!=j && a==0 && !done.contains(i+"_"+j) && !done.contains(j+"_"+i)){
                    visited.clear();
                    map.get(i).add(j);
                    map.get(j).add(i);
                    if(dfs(map,terminal,visited,i,new HashSet<Integer>())){
                        maxCount++;
                    }else{
                       map.get(i).remove(j);
                        map.get(j).remove(i);
                    }
                    done.add(i+"_"+j);
                }
            }
        }
        return maxCount;
    }

    private boolean dfs(Map<Integer,Set<Integer>>map, Set<Integer> terminal, Set<Integer> visited,int root,
            Set<Integer>terminalVisited) {
        if(!visited.contains(root)){
            visited.add(root);
            if(terminal.contains(root))terminalVisited.add(root);
            if(terminalVisited.size()>1)return false;
            for(int i:map.get(root)){
                if(!dfs(map,terminal,visited,i,terminalVisited)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AddElectricalWires aw=new AddElectricalWires();
        System.out.println(aw.maxNewWires(new String[]{"01000","10100","01010","00100","00000"},new int[]{2,4}));
    }
}
