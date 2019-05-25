package com.citygreen.signupin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citygreen.crud.CityGreenCRUDOperations;

/**
 * Servlet implementation class UserForgetPasswordServlet
 */
@WebServlet("/ForgetPassword")
public class UserForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserForgetPasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc = getServletContext();

		String contact = request.getParameter("contact");
		String mail = request.getParameter("mail");

		sc.setAttribute("contact", contact);
		sc.setAttribute("mail", mail);

		CityGreenCRUDOperations cgc = new CityGreenCRUDOperations();
		if (cgc.ForgotVerfication(mail, contact)) {

			RandomNumberGenerate rng = new RandomNumberGenerate();
			int rand = rng.randomNumber();

			sc.setAttribute("random", rand);

			SendMailForgetPassword smfp = new SendMailForgetPassword();
			smfp.Mailsend(mail, rand);

			RequestDispatcher rd = request.getRequestDispatcher("resetpassword.html");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("forgotpswdinvalid.html");
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
