package ticketClient.payment;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.krysalis.barcode4j.BarcodeClassResolver;
import org.krysalis.barcode4j.DefaultBarcodeClassResolver;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.MimeTypes;

public class BarcodeCreator {
	
	public static String barcodeDate;
	
	public BarcodeCreator(String menu, String date, String random){
	
	////////////// menuA : 99번으로 시작
	////////////// menuB : 77번으로 시작


	  barcodeDate = menu+date+random; //바코드넘버
	
	  try{
		  AbstractBarcodeBean bean = null;
		  
		  BarcodeClassResolver resolver = new DefaultBarcodeClassResolver();
		  Class clazz = resolver.resolveBean("ean-13");
		  bean = (AbstractBarcodeBean)clazz.newInstance();
		  bean.doQuietZone(true);
			  
		  String dir = "c:/barcode/"; ////////////////////////////////////////////////////////경로설정
		  OutputStream out = new FileOutputStream(new File(dir + barcodeDate+"."+"jpg"));
		  try{
			  String mimeType = MimeTypes.expandFormat("jpg");
			  int imageType = BufferedImage.TYPE_BYTE_BINARY;
			  BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, mimeType, 203, imageType, false, 0);

			  // 바코드 길이가 일치하지 않으면 다시 생성하도록 구현해야 함.
			  switch (barcodeDate.length()){
			  case 10 : barcodeDate += "00";
			  case 11 : barcodeDate += "0";
			  }
			  
			  bean.generateBarcode(canvas, barcodeDate);
			  
			  canvas.finish();
			  
			  System.out.println("create image success.");
			  
		  } finally{
			  out.close();
		  }
	  } catch(Exception e){
		  e.printStackTrace();
	  }
	  		  
	
	}

}