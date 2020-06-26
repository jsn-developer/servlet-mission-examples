package jp.co.solxyz.lessons.servlet.jsp.q01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * JSP編「世代分け」の解答例
 * @author HISATO
 *
 */
@WebServlet("/jsp01")
public class RangeOfAgeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ※サーブレット側で処理をする場合

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
