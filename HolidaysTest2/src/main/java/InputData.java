import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Класс InputData является сервлетом, отправляет пользователю форму
 * для заполнения начальной и конечной дат для определения количества 
 * выходных дней между этими датами. Сервлет взаимодействует с классом
 * DateService и отправляет пользователю форму-ответ c количеством 
 * выходных дней.
 * 
 * СЕРВЛЕТ НЕ РАБОТАЕТ!!! (нет взаимодействия с классом DateService,
 * нет формы-ответа)
 * 
 */
public class InputData extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,
		HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		Enumeration<String> params = request.getParameterNames();
		if(!params.hasMoreElements()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>InputLogin</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Please, input start/end data:</h1>");
			
			out.println("<form method=\'post\' action=\'/servlet/InputLogin\'>");
			out.println("<table>");
			
			out.println("<tr><td>Start data:</td>");
			out.println("<td><input type='text' name='start_data'");
			out.println(" value=''></td></tr>");
			
			out.println("<tr><td>End data:</td>");
			out.println("<td><input type='text' name='end_data'");
			out.println(" value=''></td></tr>");
			
			out.println("</table>");
			out.println("<br>");
			
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			
			out.println("</body>");
			out.println("</html>");
		} else {
			/*
			 *Получаем данные из формы 
			 */
			PrintWriter printWriter = response.getWriter();		
			List<String> allParamValue = new ArrayList<String>();
			while (params.hasMoreElements()) {
				String paramName = (String)params.nextElement();
				String paramValue = request.getParameter(paramName);
				allParamValue.add(paramValue);
			}
			//printWriter.println(allParamValue.toString());
			printWriter.close();
			
			/*
			 * Здесь должно быть взаимодействие с классом DateService -
			 * после подсчета выходных дней между двумя датами сервлет
			 * должен отправить пользователю форму с ответом. 
			 */
						
		}
	}
}
		
		
		
		
		
		