package print;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfViewerPreferences;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.font.FontProvider;

public class CreateAccessiblePDF {
	public static final String resourceFolder = "WebContent/";
	public static final String resources = resourceFolder;
	public static final String htmlSource = "WebContent/whole.html";
	
	public static final String src = htmlSource;
    public static final String pdfDest = "target/panCV.pdf";
    public static final String[] files = {"whole"};
    /*
    public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
    	File file = new File(pdfDest);
    	System.out.println("Parsing: " + htmlSource);
    	file.getParentFile().mkdirs();
    	
    	new CreateAccessiblePDF().createPdf(pdfDest);

	}
	*/
    
    public void createPdf(String dest) throws IOException {
    	System.out.println("Parsing: " + htmlSource);
    	FileOutputStream outputStream = new FileOutputStream(dest);
    	
    	WriterProperties writerProperties = new WriterProperties();
    	//Add metadata
        writerProperties.addXmpMetadata();
        
        PdfWriter pdfWriter = new PdfWriter(outputStream, writerProperties);
        
        PdfDocument pdfDoc = new PdfDocument(pdfWriter);
        pdfDoc.getCatalog().setLang(new PdfString("en-US"));
        //Set the document to be tagged
        pdfDoc.setTagged();
        pdfDoc.getCatalog().setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));
    

        //Set meta tags
        PdfDocumentInfo pdfMetaData = pdfDoc.getDocumentInfo();
        pdfMetaData.setAuthor("Samuel Huylebroeck");
        pdfMetaData.addCreationDate();
        pdfMetaData.getProducer();
        pdfMetaData.setCreator("iText Software");
        pdfMetaData.setKeywords("example, accessibility");
        pdfMetaData.setSubject("PDF accessibility");
        //Title is derived from html
        
        // pdf conversion
        ConverterProperties props = new ConverterProperties();
        FontProvider fp = new FontProvider();
        fp.addStandardPdfFonts();
        fp.addDirectory(resources);//The noto-nashk font file (.ttf extension) is placed in the resources
    
        props.setFontProvider(fp);
        props.setBaseUri(resources);
        //Setup custom tagworker factory for better tagging of headers
        DefaultTagWorkerFactory tagWorkerFactory = new AccessibilityTagWorkerFactory();
        props.setTagWorkerFactory(tagWorkerFactory);
        
        try (FileInputStream fileInputStream = new FileInputStream(src)) {
            HtmlConverter.convertToPdf(fileInputStream, pdfDoc, props);
        }
        pdfDoc.close();

    }
}
