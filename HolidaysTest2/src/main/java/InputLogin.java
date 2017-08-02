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
 * Класс InputLogin является сервлетом, отправляет пользователю форму
 * для заполнения логина и пароля. Сервлет взаимодействует с классом
 * UserService и в случае совпадения вводимых данных с данными из базы
 * выдает соответствующее сообщение и отправляет пользователю форму 
 * для ввода начальной и конечной дат для определения количества 
 * выходных дней между этими датами.
 * 
 * СЕРВЛЕТ НЕ РАБОТАЕТ!!! (нет взаимодействия с классом UserService)
 * 
 */
public class InputLogin extends HttpServlet {
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
			out.println("<h1>Please, input login/password:</h1>");
			
			out.println("<form method=\'post\' action=\'/servlet/InputLogin\'>");
			out.println("<table>");
			
			out.println("<tr><td>Login:</td>");
			out.println("<td><input type='text' name='login'");
			out.println(" value=''></td></tr>");
			
			out.println("<tr><td>Password:</td>");
			out.println("<td><input type='text' name='password'");
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
			 * Здесь должно быть взаимодействие с классом UserService -
			 * в случае ответа "true", должно выполниться подтверждение
			 * авторизации и далее вызов сервлета с формой ввода двух дат: 
			 */
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Input login</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Congratulations! Autorisation complete</h3>");
			out.println("</body>");
			out.println("</html>");
			response.sendRedirect("InputData");
			/*
			 * в случае ответа "false", пользователь получает форму для заполнения
			 * логина и пароля заново: 
			 */
			response.sendRedirect("InputLogin");
			
		}
	}
}
		
		
		
		
		
		