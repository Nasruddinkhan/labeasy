package com.labeasy.utils;

import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtil {

	private static BaseFont bfBold;
	private static BaseFont bf;

	public static void createHeadings(PdfContentByte cb, float xAxis, float yAxis, String text, int fontSize, int align) {
		cb.beginText();
		cb.setFontAndSize(bfBold, fontSize);
		cb.showTextAligned(align, text.trim(), xAxis, yAxis, 0);
		cb.endText();
	}

	public static void printPageNumber(PdfContentByte cb, int pageNumber) {
		cb.beginText();
		cb.setFontAndSize(bfBold, 8);
		cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber + 1), 570, 25, 0);
		cb.endText();
		//pageNumber++;
	}

	public static void createContent(PdfContentByte cb, float xAxis, float yAxis, String text, int align) {
		cb.beginText();
		cb.setFontAndSize(bf, 8);
		cb.showTextAligned(align, text.trim(), xAxis, yAxis, 0);
		cb.endText();
	}

	public static void createLine(PdfContentByte cb, float xAxis, float yAxis, int lineWidth) {
		cb.moveTo(lineWidth, yAxis);
		cb.lineTo(xAxis, yAxis);
		cb.closePathStroke();
	}

	public static void addImage(Document doc, float xAxis, float yAxis, String imgPath) throws Exception {
		Image companyLogo = Image.getInstance(imgPath);
		companyLogo.setAbsolutePosition(xAxis, yAxis);
		companyLogo.scalePercent(xAxis);
		doc.add(companyLogo);
	}

	public static void generateBarCode(PdfWriter docWriter, float xAxis, float yAxis, String barCodeVal, float barCodeHieght, float barCodeWidth) {
		//Bar Code					
		PdfContentByte canvas = docWriter.getDirectContent();
		Barcode128 code128 = new Barcode128();
		code128.setCode(barCodeVal);
		code128.setBarHeight(barCodeHieght);
		code128.setX(barCodeWidth);
		code128.setCodeType(Barcode128.CODE128);
		PdfTemplate template = code128.createTemplateWithBarcode(canvas, BaseColor.BLACK, BaseColor.BLACK);
		/*
		 * float x = 36; float z = 750; float w = template.getWidth(); float h =
		 * template.getHeight();
		 */
		canvas.saveState();
		//canvas.setColorFill(BaseColor.BLUE);
		//canvas.rectangle(x, z, w, h);
		canvas.fill();
		canvas.restoreState();
		canvas.addTemplate(template, xAxis, yAxis);
	}

	public static void initializeFonts() {
		try {
			bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
