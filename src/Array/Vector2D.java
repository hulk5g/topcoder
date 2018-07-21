package Array;

import java.util.Iterator;
import java.util.List;

/**
 * @author ksharma
 */
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> it;
    List<Integer> oneDList;
    Iterator<Integer> oneDIt;

    public Vector2D(List<List<Integer>> vec2d) {
        it=vec2d.iterator();
    }

    @Override
    public Integer next() {
        if(oneDIt!=null && oneDIt.hasNext()){
            return oneDIt.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(oneDIt==null || !oneDIt.hasNext()){
            if(it.hasNext()){
                oneDList=it.next();
                oneDIt=oneDList.iterator();
            }else{
                return false;
            }
        }
        return oneDIt.hasNext();
    }
}
