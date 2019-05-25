package com.citygreen.signupin;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.citygreen.crud.CityGreenCRUDOperations;
import com.citygreen.crud.UserBean;

/**
 * Servlet implementation class UserSignupServlet
 */
@WebServlet("/signup")
public class UserSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_email = request.getParameter("email");
		String user_contact = request.getParameter("contactnumber");
		
		CityGreenValidation cgv = new CityGreenValidation();
		List<UserBean> userlist = cgv.useridvalidate(user_email, user_contact);
		
		String  umail = null, ucontact = null;
		
		for(UserBean Userdetals: userlist) {
			umail = Userdetals.GetUser_Email();
			ucontact = Userdetals.GetUser_Contactnumber();
		}
		
		if(((user_email.equals(umail)) || (user_contact.equals(ucontact)))) {
			RequestDispatcher rd = request.getRequestDispatcher("UserSignupinvalid.html");
			rd.forward(request, response);
		}else {
			CityGreenCRUDOperations cgo = new CityGreenCRUDOperations();
			
			UserBean user = new UserBean();
			user.SetUser_Name(request.getParameter("name"));
			user.SetUser_Email(request.getParameter("email"));
			user.SetUser_Contactnumber(request.getParameter("contactnumber"));
			user.SetUser_location(request.getParameter("location"));
			user.SetUser_Gender(request.getParameter("gender"));
			
			String to_mail = request.getParameter("email");
			
			String pswd = request.getParameter("pswd");
			String encodepswd = Base64.getEncoder().encodeToString(pswd.getBytes());
			
			user.SetUser_Password(encodepswd);
			
			SendMail sm = new SendMail();
			sm.Mailsend(to_mail);
			
			cgo.userSignup(user);
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
			rd.forward(request, response);
		}
		
		/*RequestDispatcher rd = request.getRequestDispatcher("UserLogin.html");
		rd.forward(request, response);*/
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
