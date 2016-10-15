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
		// 데이터베이스에서 바코드 이름 가져오기 
		///////////////////////////////////////////////////////
		
		String barcodeNum = "101610111001"+".jpg"; //
		return barcodeNum;
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prevBtn.setOnAction(event->handleBtnACtion(event));
	
		//이미지 로딩		
				File file = new File("d:/barcode/"+barcodeCheck()); 
				/////////////////////////////바코드 파일 경로
				Image image = new Image(file.toURI().toString());
				//이미지뷰 영역에  바코드
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
