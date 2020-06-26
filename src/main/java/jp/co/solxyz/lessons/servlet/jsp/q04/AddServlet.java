package jp.co.solxyz.lessons.servlet.jsp.q04;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp04")
public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String result;
		try {

			// 二つの値を数値化する。
			// どちらか片方でも数値で無ければエラーとして値なしにする

			int num1 = Integer.parseInt(req.getParameter("number1"));
			int num2 = Integer.parseInt(req.getParameter("number2"));

			result = String.valueOf(num1 + num2);

		} catch (NumberFormatException e) {
			result = "値がありません";
		}

		req.setAttribute("result", result);
		req.getRequestDispatcher("/WEB-INF/jsp/q04/add.jsp").forward(req, resp);
	}
}
