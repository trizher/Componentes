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

	private IntegerProperty year = new SimpleIntegerProperty();
	private IntegerProperty month = new SimpleIntegerProperty();
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

		year.addListener((o, ov, nv) -> establecerMes());
		month.addListener((o, ov, nv) -> establecerMes());
	}

	private void establecerMes() {
		LocalDate localDate = LocalDate.of(year.get(), month.get(), 1);
		
		
		int diasMes = YearMonth.of(year.getValue(), month.getValue()).lengthOfMonth();
		
		int comienzoMes = localDate.getDayOfWeek().getValue() - DIF_DIAS;
		
		limpiarLabels();

		for (int i = comienzoMes, j = 1; j < diasMes + 1; i++, j++) {
			labelList.get(i).setText(String.valueOf(j));
		}

		int numeroMes = month.get();
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

	private void limpiarLabels() {
		for (int i = 0; i < labelList.size(); i++) {
			labelList.get(i).setText("");
		}
		
	}

	public IntegerProperty yearProperty() {
		return this.year;
	}
	

	public int getYearProperty() {
		return this.yearProperty().get();
	}
	

	public void setYearProperty(final int year) {
		this.yearProperty().set(year);
	}
	

	public IntegerProperty monthProperty() {
		return this.month;
	}
	

	public int getMonthProperty() {
		return this.monthProperty().get();
	}
	

	public void setMonthProperty(final int month) {
		this.monthProperty().set(month);
	}
	



}
