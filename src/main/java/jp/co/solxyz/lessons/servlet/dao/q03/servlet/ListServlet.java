package jp.co.solxyz.lessons.servlet.dao.q03.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.solxyz.lessons.servlet.dao.q03.dao.CustomerDao;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/dao03list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDao customerDao = new CustomerDao();

		request.setAttribute("CUST_LIST", customerDao.getCustomerList());

		request.getRequestDispatcher("/WEB-INF/dao/q03/customer-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// パラメータの取得
		String state = (String) request.getParameter("state");
		String sort = (String) request.getParameter("sort");
		String mobile = (String) request.getParameter("mobile");

		CustomerDao customerDao = new CustomerDao();

		Object custList = customerDao.getCustomerList(state, mobile, sort);

		request.setAttribute("CUST_LIST", custList);

		request.getRequestDispatcher("/WEB-INF/dao/q03/customer-list.jsp").forward(request, response);
	}

}
