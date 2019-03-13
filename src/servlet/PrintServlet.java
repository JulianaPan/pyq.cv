package servlet;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import print.CreateAccessiblePDF;

/**
 * Servlet implementation class PrintServlet
 */
@WebServlet("/PrintServlet")
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd");
		//System.out.println(ft.format(date.getTime()));
		String pdfName = "≈À”Í‹Áresume" + ft.format(date.getTime()) + ".pdf";
		System.out.println(pdfName);
		
		final String pdfDest = "target/CV"+ ft.format(date.getTime()) + ".pdf";
	    final String[] files = {"whole"};
		File file = new File(pdfDest);
    	file.getParentFile().mkdirs();
		
		new CreateAccessiblePDF().createPdf(pdfDest);
		
			//response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode("¥Ú”°±Í«©.pdf", "UTF-8"));
			//response.addHeader("Content-Disposition", "attachment;filename=" + pdfName);  
	        //OutputStream os= new BufferedOutputStream(response.getOutputStream());  
	        //response.setContentType("application/pdf;charset=gb2312");  
	        //os.write(buffer);  
	        //os.flush();  
	        //os.close(); 

        request.getRequestDispatcher("whole.html").forward(request,response);
		
		
	}

}
