package mvc.employee.view;

import application.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainController {



	private Stage primaryStage;
	ViewLoader <AnchorPane , EmployeeController > viewLoaderEmp;

	public void setStage (Stage primaryStage ){
	this.primaryStage= primaryStage;
	}
	public void setEmployeeFXML (ViewLoader <AnchorPane ,
	EmployeeController> viewLoaderEmp){
	this.viewLoaderEmp = viewLoaderEmp;}
	@FXML private void menuItem_About() {
		//AlertBox.showAndWait(...);
		}
	@FXML private void menuItem_Exit () {
	primaryStage.fireEvent (
	new WindowEvent (primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
	}

