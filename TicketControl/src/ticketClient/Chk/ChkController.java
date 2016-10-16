package ticketClient.Chk;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ChkController implements Initializable{

	@FXML private Button prevBtn;
	@FXML private ImageView BarcodeImage;
	
	
	public String barcodeCheck(){
		
		//////////////////////////////////////////////////////
		// �����ͺ��̽����� ���ڵ� �̸� �������� 
		///////////////////////////////////////////////////////
		
		String barcodeNum = "101610111001"+".jpg"; //
		return barcodeNum;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prevBtn.setOnAction(event->handleBtnACtion(event));
	
		//�̹��� �ε�		
				File file = new File("d:/barcode/"+barcodeCheck()); 
				/////////////////////////////���ڵ� ���� ���
				Image image = new Image(file.toURI().toString());
				//�̹����� ������  ���ڵ�
				BarcodeImage.setImage(image);

	
	}
	public void handleBtnACtion(ActionEvent event) {
		try {
			Parent prev = FXMLLoader.load(getClass().getResource("..\\Main\\Main.fxml"));
			Scene scene = new Scene(prev);
			Stage primaryStage = (Stage) prevBtn.getScene().getWindow();
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}