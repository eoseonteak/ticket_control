package ticketClient.Main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable{

	@FXML private Button btn1;	// �ı� ����
	@FXML private Button btn2;	// ���� Ȯ��
	@FXML private Button btn3;	// �޴� ����
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn1.setOnAction(event->handleBtn1Action(event));
		btn2.setOnAction(event->handleBtn2Action(event));
		btn3.setOnAction(event->handleBtn3Action(event));
	}

	public void handleBtn1Action(ActionEvent event) {
		try {
			Parent purchase = FXMLLoader.load(getClass().getResource("..\\Purchase\\TicketPurchase.fxml"));
			Scene scene = new Scene(purchase);
			Stage primaryStage = (Stage) btn1.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleBtn2Action(ActionEvent event) {
		try {
			Parent chk = FXMLLoader.load(getClass().getResource("..\\Chk\\TicketChk.fxml"));
			Scene scene = new Scene(chk);
			Stage primaryStage = (Stage) btn2.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleBtn3Action(ActionEvent event) {
		try {
			Parent menuInfo = FXMLLoader.load(getClass().getResource("..\\MenuInfo\\MenuInfo.fxml"));
			Scene scene = new Scene(menuInfo);
			Stage primaryStage = (Stage) btn3.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}