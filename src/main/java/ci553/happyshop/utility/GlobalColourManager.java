package ci553.happyshop.utility;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public final class GlobalColourManager {
    private GlobalColourManager() {}

    public enum Scheme { DEFAULT, DARK }

    private static Scheme current = Scheme.DEFAULT;
    private static final List<Scene> scenes = new ArrayList<>();

    public static void register(Scene scene) {
        scenes.add(scene);
        applyToScene(scene);
    }

    public static void toggle() {
        current = (current == Scheme.DEFAULT) ? Scheme.DARK : Scheme.DEFAULT;
        for (Scene s : scenes) applyToScene(s);
    }

    private static void applyToScene(Scene scene) {
        Parent root = scene.getRoot();
        applyRecursively(root);
    }

    private static void applyRecursively(Node node) {
        applyNodeColours(node);

        if (node instanceof Parent parent) {
            for (Node child : parent.getChildrenUnmodifiable()) {
                applyRecursively(child);
            }
        }
    }

    private static void resetNode(Node node){
        node.setStyle(null);

        if (node instanceof Region r) {
            r.setBackground(null);
        }
        if (node instanceof Label l) {
            l.setTextFill(null);
        }
    }

    private static void applyNodeColours(Node node) {
        if (current == Scheme.DEFAULT) {
            // light mode defaullt
            resetNode(node);
            return;
        }


        // dark mode
        if (node instanceof Region r) {
            r.setBackground(new Background(new BackgroundFill(Color.web("#1e1e1e"), CornerRadii.EMPTY, null)));
        }

        if (node instanceof Label l) {
            l.setTextFill(Color.web("#e8e8e8"));
        }

        if (node instanceof Button b) {
            b.setStyle("-fx-font-size: 15px; -fx-background-color: #3b82f6; -fx-text-fill: white;");
        }

        if (node instanceof TextArea ta) {
            ta.setStyle("-fx-control-inner-background: #222; -fx-text-fill: white;");
        } else if (node instanceof TextField tf) {
            tf.setStyle("-fx-control-inner-background: #222; -fx-text-fill: white;");
        } else if (node instanceof ComboBoxBase<?> cb) {
            cb.setStyle("-fx-background-color: #333; -fx-text-fill: white;");
        } else if (node instanceof ListView<?> lv) {
            lv.setStyle("-fx-control-inner-background: #222; -fx-text-fill: white;");
        }
    }
}
