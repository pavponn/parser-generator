package utils;

import java.util.Arrays;
import java.util.List;

/**
 * @author pavponn
 */
public class Tree {
    private String node;
    private List<Tree> children;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public List<Tree> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return node;
    }
}
