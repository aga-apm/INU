package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mvc.employee.model.dal.EmployeesDAL;
import mvc.employee.model.dal.OraConn;
import mvc.employee.view.AlertBox;
import mvc.employee.view.EmployeeController;
import mvc.employee.view.MainController;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		if (OraDbConnect()>0)return;

		ViewLoader <BorderPane, Object> viewLoader = new ViewLoader <BorderPane, Object>("../mvc/employee/view/Main.fxml");
		BorderPane borderPane = viewLoader.getLayout();

		ViewLoader <AnchorPane, EmployeeController> viewLoaderEmp = new ViewLoader <AnchorPane, EmployeeController>("../mvc/employee/view/EmployeeData.fxml");
		AnchorPane anchorPaneEmp = viewLoaderEmp.getLayout();
		borderPane.setCenter(anchorPaneEmp);

		((MainController) viewLoader.getControler()).setStage(primaryStage);
		EmployeeController empControler = viewLoaderEmp.getControler();
		((MainController) viewLoader.getControler()).setStage(primaryStage);
		((MainController) viewLoader.getControler()).setEmployeeFXML(viewLoaderEmp);

		empControler.setEmployees(new EmployeesDAL().getEmployees());

		Scene scene = new Scene(borderPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pracownicy");
		primaryStage.setOnHiding(e-> primaryStage_Hiding(e));
		primaryStage.setOnCloseRequest(e-> primaryStage_CloseRequest (e));
		primaryStage.show();

	}

	int OraDbConnect () {
		int ret = OraConn.open ("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf", "xlic17", "xlic17");

		if (ret > 0){
			System.out.println("Nawiązanie połączenia z bazą danych."+
				" Nieprawidłowy użytkownik lub hasło.\n" +
				"[" + OraConn.getErr() + "] " + OraConn.getErrMsg());
	AlertBox.showAndWait( AlertType.ERROR,
	"Nawiązanie połączenia z bazą danych",
	"Nieprawidłowy użytkownik lub hasło.\n" +
	"[" + OraConn.getErr () + "] " + OraConn.getErrMsg ());
		}
		return ret;
	}

	void primaryStage_Hiding (WindowEvent e) { OraConn.close();}
	/*void primaryStage_CloseRequest (WindowEvent e) {
	Optional< ButtonType > result = AlertBox.showAndWait (
	AlertType.CONFIRMATION,

	"Kończenie pracy ",
	"Czy chcesz zamknąć aplikację");
	if (result.orElse (ButtonType.CANCEL) != ButtonType.OK)
	e.consume();
	}*/

	private Object primaryStage_CloseRequest(WindowEvent e) {
		// TODO Auto-generated method stub
		return null;
	}



	public static void main(String[] args) {
		launch(args);
	}
}
