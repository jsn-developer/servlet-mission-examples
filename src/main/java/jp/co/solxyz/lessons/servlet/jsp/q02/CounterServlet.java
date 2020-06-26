package jp.co.solxyz.lessons.servlet.jsp.q02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp02")
public class CounterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ※サーブレット側で処理をする場合

		String param = req.getParameter("number");

		String message;

		try {
			int number = Integer.parseInt(param);

			message = "" + number;

			for(int i = number -1; i >= 0; i--) {
				message = message + "," + i;
			}

		} catch (NumberFormatException e) {
			// 空の場合はNumberFormatExceptionが出るのでここで空とする
			message = "空です";
		}
		req.setAttribute("message", message);

		req.getRequestDispatcher("/WEB-INF/jsp/q02/counter.jsp").forward(req, resp);
	}
}
