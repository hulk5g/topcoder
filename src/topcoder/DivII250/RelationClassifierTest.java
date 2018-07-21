package topcoder.DivII250;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RelationClassifierTest {
    @Test
    public void isBijection() throws Exception {
        RelationClassifier rt=new RelationClassifier();
        int []domain={1,2};
        int []range={3,4};
        Assertions.assertSame(rt.isBijection(domain,range),"Bijection");
    }

}
