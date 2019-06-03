package project.all;
import java.awt.print.PrinterException;

import javax.print.PrintException;

import com.qoppa.pdf.PDFException;
import com.qoppa.pdf.PrintSettings;
import com.qoppa.pdfPrint.PDFPrint;

public class printInfo {
	
	
	public printInfo(){
		
		try {
			PDFPrint print = new PDFPrint("file/animalTest.pdf",null);
			print.printToDefaultPrinter(new PrintSettings());
			
		}catch(PDFException e) {
			e.printStackTrace();
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	


}
