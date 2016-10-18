package ticketClient.payment;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ticketClient.TicketClient;
import ticketClient.menuresult.MenuResultController;
import ticketClient.purchase.PurchaseController;
import ticketServer.packet.BarcodePacket;

public class PaymentController implements Initializable {

	@FXML private Button prevBtn;
	@FXML private Button payBtn;
	@FXML private TextField dateTF;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		prevBtn.setOnAction(event->handleBtnAction(event));
		payBtn.setOnAction(event->handlePayBtnAction(event));
		
		dateTF.setText(PurchaseController.displayDate);
		
	}

	public void handleBtnAction(ActionEvent event) {
		try {
			Parent prev = FXMLLoader.load(getClass().getResource("..\\menuresult\\MenuResult.fxml"));
			Scene scene = new Scene(prev);
			Stage primaryStage = (Stage) prevBtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void handlePayBtnAction(ActionEvent event) {
//		
		String count = "0001";
		
		String dateBarcode = PurchaseController.selectedDate.substring(2, 8);
		BarcodeCreator newbc = new BarcodeCreator(MenuResultController.menuSelect, dateBarcode , count);

//		// 서버로 구매 요청
//		TicketClient.instance.send(new BarcodePacket(menu + date + count));
		
		try {
			Parent btna = FXMLLoader.load(getClass().getResource("..\\purchaseChk\\PurchaseChk.fxml"));
			Scene scene = new Scene(btna);
			Stage primaryStage = (Stage) payBtn.getScene().getWindow();
			primaryStage.setScene(scene);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
