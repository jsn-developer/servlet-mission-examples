package jp.co.solxyz.lessons.servlet.jsp.q01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp01")
public class RangeOfAgeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		ageに値が入っていない -> 「空です」
		20歳未満 -> 「こどもです」
		20歳～60際 -> 「おとなです」
		61歳以上 -> 「おじいちゃんです」
	 	*/

		// パラメータの取得
		String param = req.getParameter("age");

		String message;

		try {
			int age = Integer.parseInt(param);

			if (age < 20) {
				message = "こどもです";
			} else if (age <= 60) {
				message = "おとなです";
			} else {
				message = "おじいちゃんです";
			}

		} catch (NumberFormatException e) {
			// 空の場合はNumberFormatExceptionが出るのでここで空とする
			message = "空です";
		}

		req.setAttribute("message", message);

		req.getRequestDispatcher("/WEB-INF/jsp/q01/ages.jsp").forward(req, resp);;
	}
}
