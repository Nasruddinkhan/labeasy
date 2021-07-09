package com.labeasy.utils;



import static com.labeasy.utils.PdfUtil.addImage;
import static com.labeasy.utils.PdfUtil.createContent;
import static com.labeasy.utils.PdfUtil.createHeadings;
import static com.labeasy.utils.PdfUtil.createLine;
import static com.labeasy.utils.PdfUtil.generateBarCode;
import static com.labeasy.utils.PdfUtil.initializeFonts;
import static com.labeasy.utils.PdfUtil.printPageNumber;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.labeasy.dto.AppointmentDto;
import com.labeasy.dto.TestNamesDto;

@Component
public class GenerateInvoice {
	
	private static String AP_INV_PDF_PATH="D:\\Invoice\\";
	private static String AP_INV_PDF_NAME="AP101_invoice";
	
	private static String AP_INV_PDF_LOGO_PATH="D:\\Invoice\\";
	private static String AP_INV_PDF_LOGO_NAME="logo.jpeg";

	private int pageNumber = 0;


	public String createPDF(AppointmentDto appointmentDto) {
		Document doc = new Document();
		PdfWriter docWriter = null;
		PdfContentByte cb = null;
		initializeFonts();
		String filePath = null;
		try {
			 filePath = AP_INV_PDF_PATH+ "AP" + appointmentDto.getAppointmentId()+ appointmentDto.getAndInvoiceDto().getBillingId() +"_invoice.pdf";
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(filePath));
			doc.addAuthor("NEWZON Infotech");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("newzoninfotech.com");
			doc.addTitle("Invoice");
			doc.setPageSize(PageSize.LETTER);
			doc.open();
			cb = docWriter.getDirectContent();
			
			int yAxis = 0;
			
			int loopSize=appointmentDto.getTestNames().size();
			
			
			boolean beginPage = true;
			// Loop is writing the test details in report body
			int i=0;
			//for (int i = 1; i < loopSize; i++) {
				
			for(TestNamesDto testDto: appointmentDto.getTestNames()) {
				
				i++;
				
				//Only for first page patient header details will display
				if(i==1)
				{
					firstPageHeaderPatientDetail(appointmentDto, cb);
				}
				
				if (beginPage) 
				{
					beginPage = false;
					generateHeader(doc, cb);
					// To handle next page header patient details
					if(pageNumber==0) 
					{
						yAxis = 535;
					}
					else
					{
						yAxis = 625;	
					}
				}
				generateReportDetailsBody(testDto, doc, cb, i, yAxis);
				yAxis = yAxis - 15;
				
				// Handle to adjust footer details in new page
				if(i==(loopSize-1) && yAxis < 251)
				{
					yAxis = 625;
					printPageNumber(cb, pageNumber);
					pageNumber++;
					doc.newPage();
					generateHeader(doc, cb);
					beginPage = true;
				}
				// Handle to write footer details
				if(i==(loopSize-1) && yAxis > 251)
				{
					generateFooter(appointmentDto, docWriter, cb, yAxis, beginPage);
				}
				// To create new page
				if (yAxis < 50) 
				{
					printPageNumber(cb, pageNumber);
					pageNumber++;
					doc.newPage();
					beginPage = true;
				}
			}
			printPageNumber(cb, pageNumber);
			pageNumber++;

			System.out.println("GenerateInvoice.createPDF SUCCESS");
		} 
		catch (DocumentException dex) 
		{
			dex.printStackTrace();
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		} 
		finally 
		{
			if (doc != null) 
			{
				doc.close();
			}
			if (docWriter != null) 
			{
				docWriter.close();
			}
		}
		return filePath;
	}
	
	private void generateHeader(Document doc, PdfContentByte cb) {
		try {
			cb.setLineWidth(1f);
			//Invoice image logoD:
			addImage(doc, 40, 700, AP_INV_PDF_LOGO_PATH+AP_INV_PDF_LOGO_NAME); 
		    // Invoice Header  
			createHeadings(cb, 572, 745, "LAB EASY INDIA PVT LTD", 11, PdfContentByte.ALIGN_RIGHT);
			createContent(cb, 572, 730, "203, Paradigm Business Center, Sakinaka Safed Pool,", PdfContentByte.ALIGN_RIGHT);
			createContent(cb, 572, 715, "Andheri Kurla Road, Andheri East, Mumbai 400072.", PdfContentByte.ALIGN_RIGHT);
			createContent(cb, 572, 700, "Phone no.: +91 8369663232, 9967276977", PdfContentByte.ALIGN_RIGHT);
			createContent(cb, 572, 685, "Email: support@labeasyindia.com, Website: www.labeasyindia.com", PdfContentByte.ALIGN_RIGHT);
			createLine(cb, 572, 670, 40);			
			createHeadings(cb, 300, 655, "INVOICE", 10, PdfContentByte.ALIGN_CENTER);
			createLine(cb, 572, 640, 40);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void firstPageHeaderPatientDetail(AppointmentDto appointmentDto, PdfContentByte cb)
	{
		createContent(cb, 40, 625, "PATIENT NAME :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 40, 610, "REF. BY              :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 40, 595, "P. ADDRESS      :", PdfContentByte.ALIGN_LEFT);
		
		createHeadings(cb, 110, 625, appointmentDto.getName(), 8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 110, 610, appointmentDto.getReffredBy(),8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 110, 595, appointmentDto.getAreLocStreetName(), 8, PdfContentByte.ALIGN_LEFT);
		
		createContent(cb, 400, 625, "AGE/SEX       :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 400, 610, "BILL DATE     :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 400, 595, "CID/BILL NO  :", PdfContentByte.ALIGN_LEFT);
		
		createHeadings(cb, 460, 625, appointmentDto.getAge()+"/"+appointmentDto.getGender(),8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 460, 610, getCurrDateTime(),8, PdfContentByte.ALIGN_LEFT); 
		createHeadings(cb, 460, 595, ""+appointmentDto.getAndInvoiceDto().getBillingId(),8, PdfContentByte.ALIGN_LEFT); // TODO Need to check how to show
		
		createLine(cb, 572, 580, 40);
		createHeadings(cb, 40, 565, "SL", 8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 70, 565, "Investigation", 8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 572, 565, "Amount", 8, PdfContentByte.ALIGN_RIGHT);
		createLine(cb, 572, 550, 40);
		
	}
	
	private void generateReportDetailsBody(TestNamesDto testDto, Document doc, PdfContentByte cb, int index, int y) {
		//DecimalFormat df = new DecimalFormat("0.00");
		try {
			createContent(cb, 40, y, index+"", PdfContentByte.ALIGN_LEFT);
			createContent(cb, 70, y, testDto.getName(), PdfContentByte.ALIGN_LEFT);
			createContent(cb, 572, y, testDto.getPrice()+"", PdfContentByte.ALIGN_RIGHT);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void generateFooter(AppointmentDto appointmentDto, PdfWriter docWriter, PdfContentByte cb, int yAxis, boolean isPageBegin) {
		// Invoice Total amount section with footer details
		if(!isPageBegin) {
			yAxis=yAxis-15;
			createLine(cb, 572, yAxis, 40);
		}
		yAxis=yAxis-15;
		createHeadings(cb, 510, yAxis, "Total :", 8, PdfContentByte.ALIGN_RIGHT);
		createHeadings(cb, 572, yAxis, appointmentDto.getAndInvoiceDto().getTotalAmmount()+"", 8, PdfContentByte.ALIGN_RIGHT);
		yAxis=yAxis-15;
		createContent(cb, 510, yAxis, "Discount :", PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 572, yAxis, appointmentDto.getAndInvoiceDto().getDiscountAmmount()+"", PdfContentByte.ALIGN_RIGHT);
		yAxis=yAxis-15;
		createContent(cb, 510, yAxis, "Recieved :", PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 572, yAxis, appointmentDto.getAndInvoiceDto().getPaymentAmmount()+"", PdfContentByte.ALIGN_RIGHT);
		yAxis=yAxis-15;
		createLine(cb, 572, yAxis, 40);
		yAxis=yAxis-15;
		createContent(cb, 40, yAxis, "Recieved Amount : "+convert(appointmentDto.getAndInvoiceDto().getPaymentAmmount().intValue()).toUpperCase(), PdfContentByte.ALIGN_LEFT);
		yAxis=yAxis-15;
		createContent(cb, 40, yAxis, "By : LAB EASY INDIA PVT LTD at "+getCurrDateTime(), PdfContentByte.ALIGN_LEFT); 
		yAxis=yAxis-15;
		createLine(cb, 572, yAxis, 40);
		yAxis=yAxis-15;
		createHeadings(cb, 40, yAxis, "CIN NO.: U85190MH2020PTC336033",7, PdfContentByte.ALIGN_LEFT);
		yAxis=yAxis-15;
		createHeadings(cb, 40, yAxis, "PAN: AAECL1374R | TAN: MUML12042C",7, PdfContentByte.ALIGN_LEFT);
		yAxis=yAxis-15;
		createHeadings(cb, 40, yAxis, "Thank you so much for using our services.",7, PdfContentByte.ALIGN_LEFT);
		yAxis=yAxis-15;
		createHeadings(cb, 40, yAxis, "We hope to serve you again",7, PdfContentByte.ALIGN_LEFT);
		yAxis=yAxis-15;
		createContent(cb, 40, yAxis, "Happy Health!", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 572, yAxis, "*This is an electronically generated slip and does not require signature.", PdfContentByte.ALIGN_RIGHT);
		
		generateBarCode(docWriter, 507, yAxis+20,  "68719771", 15f, 0.80f);  // TODO generate bar code number
	}

	
	
	
	
	
	
	
	
	///////////////////KEEP BELOW CODES IN UTIL CLASS

	private static final String[] specialNames = { "", " thousand", " million", " billion", " trillion", " quadrillion",
			" quintillion" };

	private static final String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	private static String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20) {
			current = numNames[number % 100];
			number /= 100;
		} else {
			current = numNames[number % 10];
			number /= 10;

			current = tensNames[number % 10] + current;
			number /= 10;
		}
		if (number == 0)
			return current;
		return numNames[number] + " hundred" + current;
	}

	public static String convert(int number) {

		if (number == 0) {
			return "zero";
		}

		String prefix = "";

		if (number < 0) {
			number = -number;
			prefix = "negative";
		}

		String current = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				current = s + specialNames[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);

		return (prefix + current).trim() + " only";
	}

	
	
	public String getCurrDateTime()
	{
		LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");  
	    return myDateObj.format(myFormatObj);  
	}

	
	
}