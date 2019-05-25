package com.citygreen.signupin;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citygreen.crud.CityGreenCRUDOperations;

/**
 * Servlet implementation class UserPasswordUpdate
 */
@WebServlet("/UserPasswordUpdate")
public class UserPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserPasswordUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = getServletContext();

		String urandom = request.getParameter("random");
		String upswd = request.getParameter("pswd");
		String ucnfmpswd = request.getParameter("cpswd");

		int rand = Integer.parseInt(urandom);

		String mail = (String) context.getAttribute("mail");
		String contact = (String) context.getAttribute("contact");
		int random = (int) context.getAttribute("random");

		if ((rand == random) && (upswd.equals(ucnfmpswd))) {

			String encpswd = Base64.getEncoder().encodeToString(upswd.getBytes());
			CityGreenCRUDOperations cgc = new CityGreenCRUDOperations();
			cgc.pswdUpdate(encpswd, contact);

			SendMailpswdChangedConfirmation smpc = new SendMailpswdChangedConfirmation();
			smpc.Mailsend(mail);

			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("resetpasswordinvalid.html");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
