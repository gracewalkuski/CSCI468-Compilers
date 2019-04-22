import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

class CodeObject {
    private Queue IRNodeSequence;
    private String locationOfResult;
    private String resultType;

    CodeObject() {
        this.IRNodeSequence = new LinkedList<IRNode>();

    }

    public void add(IRNode node) {
        this.IRNodeSequence.add(node);
    }

}
