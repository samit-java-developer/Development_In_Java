package com.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		
		ServletOutputStream os=response.getOutputStream();
		
		String path=getServletContext().getRealPath("deepak_image.jpg");
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		byte[] b=new byte[(int)file.length()];
		fis.read(b);
		
		os.write(b);
		os.flush();
		
		os.close();
	}

}
