package controller;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import algorithm.BubbleSort;
import algorithm.InsertionSort;
import algorithm.QuickSort;
import algorithm.Sort;
import data.DataController;
import data.Unit;

public class DemonstrationController {
    private final SequentialTransition sequentialTransition = new SequentialTransition();
    private Unit[] units;
    DataController dataController = new DataController();
    private InputTransformer transformer = new InputTransformer();
    private double width;
	public int speed;
	private int current;
	private int check;
	private int size;
	private int[] array = new int[size];	
	private int curInputArrayOption = 0; // 0 for manual, 1 for random
	private int curAlg = 0; // 0 for bubble, 1 for heap, 2 for quick sort
	
	private static final int MAX_ARRAY_LENGTH = 300;
	
	private String[] inputArrayOption = {"Random", "Manual"};
	
//------------------------------------Setter and Getter------------------------
    public int getSpeed() {
        return speed;
    }

    public int getCurAlg() {
        return curAlg;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int length) {
        this.size = length;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}
    
//---------------------------------------FXML---------------------------------------------
    @FXML
    private Label ArraySizeLabel;

    @FXML
    private TextField ArraySizeTF;

    @FXML
    private Label algorithmLabel;

    @FXML
    private Label arrSizeLabel;

    @FXML
    private Button arraySizeHelpBtn;

    @FXML
    private Pane drawPane;

    @FXML
    private Button generateBtn;

    @FXML
    private TextArea inputArrayTA;

    @FXML
    private ComboBox<String> inputOptionComboBox;

    @FXML
    private Button menuBtn;

    @FXML
    private Button sortBtn;

    @FXML
    private Label speedLabel;

    @FXML
    private Slider speedSlider;

    @FXML
    private Label timeLabel;

    @FXML
    void handleArraySizeHelpBtn(ActionEvent event) {
    	
    }

    @FXML
    void handleGenerateBtn(ActionEvent event) {
    	arrSizeLabel.setText(ArraySizeTF.getText());
    	curInputArrayOption = inputOptionComboBox.getSelectionModel().getSelectedIndex();
    	switch (curInputArrayOption) {
    		case 0: //random
    			size = Integer.parseInt(ArraySizeTF.getText());
                units = dataController.randomArr(size);
                createUnits(units);
    			break;
    		case 1: //manual
    			int[] newArr;
    			try {
    				newArr = transformer.StrToArr(transformer.deleteNewLineTabSpaces(inputArrayTA.getText()), ",");
    				size = newArr.length;
    				array = newArr;
                    units = dataController.createArr(newArr);
                    createUnits(units);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			break;
    	}
    }

    @FXML
    void handleMenuBtn(ActionEvent event) {
    	
    }
    
    @FXML
    void handleSortBtn(ActionEvent event) {
        String alg = ((Stage) sortBtn.getScene().getWindow()).getTitle();
        double cwidth = drawPane.getWidth()/units.length;
        Sort sort = new Sort(cwidth);
        if (alg.equals("Bubble Sort")) {
            sort = new BubbleSort(cwidth);
        } else if (alg.equals("Insertion Sort")){
            sort = new InsertionSort(cwidth);
        } else if (alg.equals("Quick Sort")) {
            sort = new QuickSort(cwidth);
        }
        sequentialTransition.getChildren().clear();
        ArrayList<Transition> transitions = sort.sorting(units);
        for (Transition transition : transitions) {
            sequentialTransition.getChildren().add(transition);
        }
        sequentialTransition.play();
    }

    @FXML
    void handleInputOptionComboBox(ActionEvent event) {
    	curInputArrayOption = inputOptionComboBox.getSelectionModel().getSelectedIndex();
    	switch (curInputArrayOption) {
    		case 0:
    			inputArrayTA.setDisable(true);
    		case 1:
                inputArrayTA.setDisable(false);
    	}
    }
    
    @FXML 
    void handleSpeedSlider(ActionEvent event){
    	speed = (int) Math.round(speedSlider.getValue());
    }
    
    @FXML
    void initialize() {	
    	inputOptionComboBox.getItems().removeAll(inputOptionComboBox.getItems());
    	inputOptionComboBox.getItems().addAll(inputArrayOption);
    	inputOptionComboBox.getSelectionModel().select(inputArrayOption[curInputArrayOption]);
    	
    	speedSlider.setMin(0);
    	speedSlider.setMax(100);
    	speedSlider.setValue(50);
    	speedLabel.setText("50ms");
    	ArraySizeTF.setText("12");
    	
    	speedSlider.valueProperty().addListener(
    			new ChangeListener<Number>() {
    			public void changed(ObservableValue<? extends Number>
    					observable, Number oldNumber, Number newNumber)
    			{
    				speedLabel.setText(Math.round(newNumber.doubleValue()) + "ms");
    			}
    			});
    }
    
  //-------------------------------VISUALIZATION----------------------------------
    public void createUnits(Unit... units) {
        this.width = drawPane.getWidth()/units.length;
        double unitHeight = drawPane.getHeight()/getMaxHeight(units);
        for (int i = 0; i < units.length; i++) {
            Unit unit = units[i];
            unit.setWidth(width);
            unit.setHeight(unit.getValue() * unitHeight);
            unit.setTranslateX(i * width);
            unit.setLayoutY(drawPane.getHeight() - unit.getHeight());
            unit.setFill(Color.BLACK);
            drawPane.getChildren().add(unit);
        }
    }
    public int getMaxHeight(Unit... units) {
        int maxHeight = -1;
        for (Unit unit : units) {
            maxHeight = Math.max(maxHeight, unit.getValue());
        }
        return maxHeight;
    }
    
}
