package graph;

import java.util.*;

/**
 * @author ksharma
 */
public class Test {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) return paths;
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return paths;
        if (beginWord.equals(endWord)) {
            List<String> path = new ArrayList<String>();
            path.add(endWord);
            paths.add(path);
            return paths;
        }
        Set<String> q1 = new HashSet<>(), q2 = new HashSet<>();
        Map<String, List<String>> prev = new HashMap<>();
        q1.add(beginWord);
        dic.remove(beginWord);
        q2.add(endWord);
        dic.remove(endWord);
        boolean isL2R = true, found = false;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
                isL2R = !isL2R;
            }
            Set<String> next = new HashSet<>();
            for (String word : q1) {
                char[] chArr = word.toCharArray();
                for (int i = 0; i < chArr.length; ++i) {
                    char c = chArr[i];
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        if (ch == c) continue;
                        chArr[i] = ch;
                        String newWord = new String(chArr);
                        if (q2.contains(newWord)) {
                            found = true;
                            if (isL2R) {
                                record(word, newWord, prev);
                            } else {
                                record(newWord, word, prev);
                            }
                        } else if (dic.contains(newWord)) {
                            next.add(newWord);
                            if (isL2R) {
                                record(word, newWord, prev);
                            } else {
                                record(newWord, word, prev);
                            }
                        }
                    }
                    chArr[i] = c;
                }
            }
            if (found) break;
            q1 = next;
            dic.removeAll(next);
        }

        List<String> path = new LinkedList<String>();
        path.add(endWord);
        buildPaths(prev, path, endWord, beginWord, paths);
        return paths;
    }
    private void buildPaths(Map<String, List<String>> prev, List<String> path, String word, String target, List<List<String>> paths) {
        if (word.equals(target)) {
            paths.add(new ArrayList<String>(path));
            return;
        }
        if (!prev.containsKey(word)) return;
        for (String preWord : prev.get(word)) {
            path.add(0, preWord);
            buildPaths(prev, path, preWord, target, paths);
            path.remove(0);
        }
    }

    private void record (String a, String b, Map<String, List<String>> prev) {
        if (!prev.containsKey(b)) {
            prev.put(b, new ArrayList<String>());
        }
        prev.get(b).add(a);
    }

    public static void main(String []args){
        Test wl=new Test();
        String []input={"hot","dot","dog","lot","log","cog"};
        Set<String>s=new HashSet<>(Arrays.asList(input));
        System.out.println(wl.findLadders("hit","cog", Arrays.asList(input)));
    }
}
