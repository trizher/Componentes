package components;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;

public class ListSelector<T> extends GridPane implements Initializable {

	// model

	private ListProperty<T> leftItems = new SimpleListProperty<>(FXCollections.observableArrayList());
	private ListProperty<T> rightItems = new SimpleListProperty<>(FXCollections.observableArrayList());
	private StringProperty leftTitle = new SimpleStringProperty();
	private StringProperty rightTitle = new SimpleStringProperty();

	// view

	@FXML
	private GridPane view;

	@FXML
	private Label leftLabel;

	@FXML
	private Label rightLabel;

	@FXML
	private ListView<T> leftList;

	@FXML
	private Button moveLeftButton;

	@FXML
	private Button moveAllLeftButton;

	@FXML
	private Button moveAllRightButton;

	@FXML
	private Button moveRightButton;

	@FXML
	private ListView<T> rightList;

	public ListSelector() {
		super();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ListSelectorView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		leftLabel.textProperty().bind(leftTitle);
		rightLabel.textProperty().bind(rightTitle);

		leftList.itemsProperty().bind(leftItems);
		rightList.itemsProperty().bind(rightItems);
		
		leftList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		rightList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		moveRightButton.disableProperty().bind(leftList.getSelectionModel().selectedItemProperty().isNull());
		moveLeftButton.disableProperty().bind(rightList.getSelectionModel().selectedItemProperty().isNull());
		moveAllRightButton.disableProperty().bind(Bindings.isEmpty(leftItems));
		moveAllLeftButton.disableProperty().bind(Bindings.isEmpty(rightItems));
	}

	@FXML
	void onMoveAllLeftAction(ActionEvent event) {
		leftItems.addAll(rightItems);
		rightItems.clear();
	}

	@FXML
	void onMoveAllRightAction(ActionEvent event) {
		rightItems.addAll(leftItems);
		leftItems.clear();
	}

	@FXML
	void onMoveLeftAction(ActionEvent event) {
		leftItems.addAll(rightList.getSelectionModel().getSelectedItems());
		rightItems.removeAll(rightList.getSelectionModel().getSelectedItems());
	}

	@FXML
	void onMoveRightAction(ActionEvent event) {
		rightItems.addAll(leftList.getSelectionModel().getSelectedItems());
		leftItems.removeAll(leftList.getSelectionModel().getSelectedItems());
	}

	public ListProperty<T> leftItemsProperty() {
		return this.leftItems;
	}

	public ObservableList<T> getLeftItems() {
		return this.leftItemsProperty().get();
	}

	public void setLeftItems(final ObservableList<T> leftItems) {
		this.leftItemsProperty().set(leftItems);
	}

	public ListProperty<T> rightItemsProperty() {
		return this.rightItems;
	}

	public ObservableList<T> getRightItems() {
		return this.rightItemsProperty().get();
	}

	public void setRightItems(final ObservableList<T> rightItems) {
		this.rightItemsProperty().set(rightItems);
	}

	public StringProperty leftTitleProperty() {
		return this.leftTitle;
	}

	public String getLeftTitle() {
		return this.leftTitleProperty().get();
	}

	public void setLeftTitle(final String leftTitle) {
		this.leftTitleProperty().set(leftTitle);
	}

	public StringProperty rightTitleProperty() {
		return this.rightTitle;
	}

	public String getRightTitle() {
		return this.rightTitleProperty().get();
	}

	public void setRightTitle(final String rightTitle) {
		this.rightTitleProperty().set(rightTitle);
	}

	public GridPane getView() {
		return view;
	}
	
	

}
