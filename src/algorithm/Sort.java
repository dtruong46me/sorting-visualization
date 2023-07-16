package algorithm;

import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import data.Unit;

import java.util.ArrayList;

public class Sort {
    private double width;
    public static Color START = Color.BLACK;
    public static Color CHECKING = Color.GREEN;
    public static Color COMPARE = Color.RED;
    public static ArrayList<Transition> transitions = new ArrayList<>();
    void colorUnit(Unit[] arr, Color color, int...a) {
        ParallelTransition pt = new ParallelTransition();

        for (int i = 0; i < a.length; i++) {
            FillTransition ft = new FillTransition();
            ft.setShape(arr[a[i]]);
            ft.setToValue(color);
            ft.setDuration(Duration.millis(100));
            pt.getChildren().add(ft);
        }
        transitions.add(pt);
    }
    public Sort(double width) {
        this.width = width;
    }
    public double getWidth() {
        return width;
    }


    void swap(Unit[] arr, int i, int j) {
        ParallelTransition pt = new ParallelTransition();
        Unit tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        pt.getChildren().addAll(arr[i].move(width*(i - j)), arr[j].move(width*(j - i)));
        transitions.add(pt);
    }
    public ArrayList<Transition> sorting(Unit[] arr) {
        return transitions;
    }
}
