package utils;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.graph.DelegateTree;
import edu.uci.ics.jung.graph.DirectedOrderedSparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.EdgeShape;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author pavponn
 */
public class TreePainter {
    private int edgeNumber;

    public static void paintTree(final Tree tree) {
        new TreePainter().paint(tree);
    }

    private TreePainter() {
        edgeNumber = 0;
    }

    private void paint(final Tree tree) {
        Layout<Tree, Integer> layout = new TreeLayout<>(createTree(tree));

        BasicVisualizationServer<Tree, Integer> visualizationServer =
                new BasicVisualizationServer<>(layout);

        visualizationServer.getRenderContext().setVertexShapeTransformer(n -> {
            double w = Math.max(n.toString().length() * 15, 25);
            return new Ellipse2D.Double(-(w / 2), -10, w, 25);
        });

        configureVisualizationServer(visualizationServer);
        configureJFrame(new JFrame(), visualizationServer);
    }

    private DelegateTree<Tree, Integer> createTree(Tree tree) {
        DelegateTree<Tree, Integer> delegateTree = new DelegateTree<>(new DirectedOrderedSparseMultigraph<>());
        delegateTree.addVertex(tree);
        return buildRecursive(tree, delegateTree);
    }

    private DelegateTree<Tree, Integer> buildRecursive(Tree tree, DelegateTree<Tree, Integer> delegateTree) {
        for (Tree child : tree.getChildren()) {
            delegateTree.addChild(edgeNumber++, tree, child);
            delegateTree = buildRecursive(child, delegateTree);
        }
        return delegateTree;
    }

    private void configureVisualizationServer(BasicVisualizationServer<Tree, Integer> server) {
        server.getRenderContext().setEdgeShapeTransformer(new EdgeShape.Wedge<>(2));
        server.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
        server.getRenderContext().setVertexFillPaintTransformer(delegateTree -> Color.GREEN);
        server.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
    }

    private void configureJFrame(JFrame frame, BasicVisualizationServer<Tree, Integer> server) {
        frame.setVisible(true);
        frame.getContentPane().add(server);
        frame.setMinimumSize(new Dimension(1000, 1000));
    }
}
