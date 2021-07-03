package com.labeasy.utils;



import static com.labeasy.utils.PdfUtil.addImage;
import static com.labeasy.utils.PdfUtil.createContent;
import static com.labeasy.utils.PdfUtil.createHeadings;
import static com.labeasy.utils.PdfUtil.createLine;
import static com.labeasy.utils.PdfUtil.generateBarCode;
import static com.labeasy.utils.PdfUtil.initializeFonts;
import static com.labeasy.utils.PdfUtil.printPageNumber;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateInvoice {

	private int pageNumber = 0;

	public static void main(String[] args) {
		String pdfFilename = "";
		GenerateInvoice generateInvoice = new GenerateInvoice();
		/*if (args.length < 1) {
			System.err.println("Usage: java " + generateInvoice.getClass().getName() + " PDF_Filename");
			System.exit(1);
		}

		pdfFilename = args[0].trim();*/
		
		pdfFilename="invoice.pdf";
		generateInvoice.createPDF(pdfFilename ,"","","");
	}

	private void createPDF(String pdfFilename, Object custDetail, Object invDetails, Object testListwithPrice) {
		Document doc = new Document();
		PdfWriter docWriter = null;
		PdfContentByte cb = null;
		initializeFonts();
		try {
			String path = "D:\\Invoice\\" + pdfFilename;
			
			docWriter = PdfWriter.getInstance(doc, new FileOutputStream(path));
			doc.addAuthor("NEWZON Infotech");
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("newzoninfotech.com");
			doc.addTitle("Invoice");
			doc.setPageSize(PageSize.LETTER);
			doc.open();
			cb = docWriter.getDirectContent();
			
			int yAxis = 0;
			int loopSize=10;
			boolean beginPage = true;
			// Loop is writing the test details in report body
			for (int i = 1; i < loopSize; i++) {
				
				//Only for first page patient header details will display
				if(i==1)
				{
					firstPageHeaderPatientDetail(cb);
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
				generateReportDetailsBody(doc, cb, i, yAxis);
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
					generateFooter(docWriter, cb, yAxis, beginPage);
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
	}
	
	private void generateHeader(Document doc, PdfContentByte cb) {
		try {
			cb.setLineWidth(1f);
			//Invoice image logoD:
			addImage(doc, 40, 700, "D:\\Invoice\\logo.jpeg");
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
	
	private void firstPageHeaderPatientDetail(PdfContentByte cb)
	{
		createContent(cb, 40, 625, "PATIENT NAME :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 40, 610, "REF. BY              :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 40, 595, "P. ADDRESS      :", PdfContentByte.ALIGN_LEFT);
		
		createHeadings(cb, 110, 625, "HAMIDUDDIN KHAN",8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 110, 610, "SELF",8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 110, 595, "JARIMARI",8, PdfContentByte.ALIGN_LEFT);
		
		createContent(cb, 400, 625, "AGE/SEX       :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 400, 610, "BILL DATE     :", PdfContentByte.ALIGN_LEFT);
		createContent(cb, 400, 595, "CID/BILL NO  :", PdfContentByte.ALIGN_LEFT);
		
		createHeadings(cb, 460, 625, "31/MALE",8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 460, 610, "18/02/2021 18:40",8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 460, 595, "101554",8, PdfContentByte.ALIGN_LEFT);
		
		createLine(cb, 572, 580, 40);
		createHeadings(cb, 40, 565, "SL", 8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 70, 565, "Investigation", 8, PdfContentByte.ALIGN_LEFT);
		createHeadings(cb, 572, 565, "Amount", 8, PdfContentByte.ALIGN_RIGHT);
		createLine(cb, 572, 550, 40);
		
	}
	
	private void generateReportDetailsBody(Document doc, PdfContentByte cb, int index, int y) {
		//DecimalFormat df = new DecimalFormat("0.00");
		try {
			createContent(cb, 40, y, index+"", PdfContentByte.ALIGN_LEFT);
			createContent(cb, 70, y, "CBC (COMPLETE BLOOD COUNT)", PdfContentByte.ALIGN_LEFT);
			createContent(cb, 572, y, "250", PdfContentByte.ALIGN_RIGHT);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void generateFooter(PdfWriter docWriter, PdfContentByte cb, int yAxis, boolean isPageBegin) {
		// Invoice Total amount section with footer details
		if(!isPageBegin) {
			yAxis=yAxis-15;
			createLine(cb, 572, yAxis, 40);
		}
		yAxis=yAxis-15;
		createHeadings(cb, 510, yAxis, "Total :", 8, PdfContentByte.ALIGN_RIGHT);
		createHeadings(cb, 572, yAxis, "7240", 8, PdfContentByte.ALIGN_RIGHT);
		yAxis=yAxis-15;
		createContent(cb, 510, yAxis, "Discount :", PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 572, yAxis, "724", PdfContentByte.ALIGN_RIGHT);
		yAxis=yAxis-15;
		createContent(cb, 510, yAxis, "Recieved :", PdfContentByte.ALIGN_RIGHT);
		createContent(cb, 572, yAxis, "6516", PdfContentByte.ALIGN_RIGHT);
		yAxis=yAxis-15;
		createLine(cb, 572, yAxis, 40);
		yAxis=yAxis-15;
		createContent(cb, 40, yAxis, "Recieved Amount : Six Thousand Five Hudred And Sixteen Only", PdfContentByte.ALIGN_LEFT);
		yAxis=yAxis-15;
		createContent(cb, 40, yAxis, "By : LAB EASY INDIA PVT LTD at 27/02/21 16:38", PdfContentByte.ALIGN_LEFT);
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
		
		generateBarCode(docWriter, 507, yAxis+20,  "68719771", 15f, 0.80f);
	}



}