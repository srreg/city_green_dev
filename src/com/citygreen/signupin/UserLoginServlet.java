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
import javax.servlet.http.HttpSession;

import com.citygreen.crud.CityGreenCRUDOperations;
import com.citygreen.crud.UserBean;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		
		String user_name = request.getParameter("userid");
		String password = request.getParameter("pswd");
		String dpswd = Base64.getEncoder().encodeToString(password.getBytes());		
		
		CityGreenCRUDOperations cgc = new CityGreenCRUDOperations();
		List<UserBean> userlist = cgc.userLogin(user_name, user_name, dpswd);
		String upswd = null, umail = null, ucontact = null;
		for(UserBean Userdetals: userlist) {
			umail = Userdetals.GetUser_Email();
			ucontact = Userdetals.GetUser_Contactnumber();
			upswd = Userdetals.GetUser_Password();
			Userdetals.GetUser_Name();
		}
		
		sess.setAttribute("plants", userlist);
		
		if(((user_name.equals(umail)) || (user_name.equals(ucontact))) && dpswd.equals(upswd) ) {
			RequestDispatcher rd = request.getRequestDispatcher("plantingdetails.html");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("userlogininvalid.html");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
