package jp.co.solxyz.lessons.servlet.jsp.q03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsp03")
public class GreetingServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 今回はサーブレットのみを解答例として載せます。
		// 他の問題と同様に、JSPでも同じ処理ができます。

		String param = req.getParameter("time");

		String message;

		try {

			int time = Integer.parseInt(param);

			// 24時間であまり算し、
			// 25時 -> 深夜1時に変換する
			time = time % 24;

			switch (time) {
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
				message = "おはようございます。今は" + time + "時です";
				break;
			case 12:
			case 13:
			case 14:
			case 15:
			case 16:
			case 17:
				message = "こんにちは。今は" + time + "時です";
				break;
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				message = "こんばんは。今は" + time + "時です";
				break;
			default:
				message = "空です";
				break;
			}

		}catch (NumberFormatException e) {
			message = "空です";
		}

		req.setAttribute("message", message);
		req.getRequestDispatcher("/WEB-INF/jsp/q03/greeting.jsp").forward(req, resp);;


	}
}
