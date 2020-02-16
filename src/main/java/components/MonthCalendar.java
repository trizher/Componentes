package components;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ResourceBundle;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MonthCalendar extends VBox implements Initializable {

	private IntegerProperty yearProperty = new SimpleIntegerProperty();
	private IntegerProperty monthProperty = new SimpleIntegerProperty();
	private ListProperty<Label> labelList = new SimpleListProperty<Label>(FXCollections.observableArrayList());
	private final int DIF_DIAS = 1;

	@FXML
	private VBox view;

	@FXML
	private Label monthLabel, unoLabel, dosLabel, tresLabel, cuatroLabel, cincoLabel, seisLabel, sieteLabel, ochoLabel,
			nueveLabel, diezLabel, onceLabel, doceLabel, treceLabel, catorceLabel, quinceLabel, dieciseisLabel,
			diecisieteLabel, dieciochoLabel, diecinueveLabel, veinteLabel, veintiunoLabel, veintidosLabel,
			veintitresLabel, veinticuatroLabel, veinticincoLabel, veintiseisLabel, veintisieteLabel, veintiochoLabel,
			veintinueveLabel, treintaLabel, treintaYUnoLabel, treintaYDosLabel, treintaYTresLabel, treintaYCuatroLabel,
			treintaYCincoLabel, treintaYSeisLabel, treintaYSieteLabel, treintaYOchoLabel, treintaYNueveLabel,
			cuarentaLabel, cuarentaYUnoLabel, cuarentaYDosLabel;

	public MonthCalendar() {
		super();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MonthCalendarView.fxml"));
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
		labelList.addAll(unoLabel, dosLabel, tresLabel, cuatroLabel, cincoLabel, seisLabel, sieteLabel, ochoLabel,
				nueveLabel, diezLabel, onceLabel, doceLabel, treceLabel, catorceLabel, quinceLabel, dieciseisLabel,
				diecisieteLabel, dieciochoLabel, diecinueveLabel, veinteLabel, veintiunoLabel, veintidosLabel,
				veintitresLabel, veinticuatroLabel, veinticincoLabel, veintiseisLabel, veintisieteLabel,
				veintiochoLabel, veintinueveLabel, treintaLabel, treintaYUnoLabel, treintaYDosLabel, treintaYTresLabel,
				treintaYCuatroLabel, treintaYCincoLabel, treintaYSeisLabel, treintaYSieteLabel, treintaYOchoLabel,
				treintaYNueveLabel, cuarentaLabel, cuarentaYUnoLabel, cuarentaYDosLabel);

		yearProperty.addListener((o, ov, nv) -> establecerMes());
		monthProperty.addListener((o, ov, nv) -> establecerMes());
	}

	private void establecerMes() {
		LocalDate localDate = LocalDate.of(yearProperty.get(), monthProperty.get(), 1);
		int diasMes = YearMonth.of(yearProperty.getValue(), monthProperty.getValue()).lengthOfMonth();
		int comienzoMes = localDate.getDayOfWeek().getValue() - DIF_DIAS;

		for (int i = comienzoMes, j = 1; i < diasMes; i++, j++) {
			labelList.get(i).setText(String.valueOf(j));
		}

		int numeroMes = monthProperty.get();
		if (numeroMes == 1) {
			monthLabel.setText("Enero");
		} else if (numeroMes == 2) {
			monthLabel.setText("Febrero");
		} else if (numeroMes == 3) {
			monthLabel.setText("Marzo");
		} else if (numeroMes == 4) {
			monthLabel.setText("Abril");
		} else if (numeroMes == 5) {
			monthLabel.setText("Mayo");
		} else if (numeroMes == 6) {
			monthLabel.setText("Junio");
		} else if (numeroMes == 7) {
			monthLabel.setText("Julio");
		} else if (numeroMes == 8) {
			monthLabel.setText("Agosto");
		} else if (numeroMes == 9) {
			monthLabel.setText("Septiembre");
		} else if (numeroMes == 10) {
			monthLabel.setText("Octubre");
		} else if (numeroMes == 11) {
			monthLabel.setText("Noviembre");
		} else if (numeroMes == 12) {
			monthLabel.setText("Diciembre");
		}

	}

	public IntegerProperty monthPropertyProperty() {
		return this.monthProperty;
	}

	public int getMonthProperty() {
		return this.monthPropertyProperty().get();
	}

	public void setMonthProperty(final int monthProperty) {
		this.monthPropertyProperty().set(monthProperty);
	}

	public IntegerProperty yearPropertyProperty() {
		return this.yearProperty;
	}

	public int getYearProperty() {
		return this.yearPropertyProperty().get();
	}

	public void setYearProperty(final int yearProperty) {
		this.yearPropertyProperty().set(yearProperty);
	}

}
