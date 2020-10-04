package istic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import istic.dao.SectionDao;
import istic.services.Section;

@WebServlet(name="section", urlPatterns = {"/Section"})
public class SectionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private SectionDao sectionDao = new SectionDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter printer = response.getWriter();
		List<Section> sections = sectionDao.findAll();
		
		String url = request.getRequestURL().substring(0,request.getRequestURL().length()-request.getRequestURI().length());
		
		printer.println("<HTML>\n<BODY>");
		printer.println("<button onclick=\"location.href='"+ url + "'\" type=\"button\">précédent</button>");
		printer.println("<br>Noms des sections : <UL>");
		for (Section section : sections) {
			printer.println("<LI>");
			printer.println(section.getName());
			printer.println("</LI>");
		}
		printer.println("</UL>");
		
		printer.println("</HTML>\n</BODY>");
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sectionName = request.getParameter("name");
		Section section = new Section();
		section.setName(sectionName);
		sectionDao = new SectionDao();
		sectionDao.save(section);
		
		doGet(request, response);

	}	
}
