package com.taxi.user.pages;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Imagetext {

	public static void main(String[] args) throws TesseractException {

		ITesseract image = new Tesseract();

		image.setDatapath("/home/mounika/eclipse-workspace/Taxishare/TessData");

		File f = new File("/home/mounika/Downloads/q.jpg");
		String s = image.doOCR(f);

		System.out.println("Data from the image is" + s);

	}

}
