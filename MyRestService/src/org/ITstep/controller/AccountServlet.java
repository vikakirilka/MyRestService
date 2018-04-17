package org.ITstep.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ITstep.model.Account;
import org.ITstep.service.AccountService;


@SuppressWarnings("serial")
@WebServlet("/account")
public class AccountServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountService accService = new AccountService();
		   Account account = new Account((String)request.getParameter("login"), accService.convertDate((String)request.getParameter("birthDay")));
		   accService.saveAccount(account);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountService accService = new AccountService();
		   accService.deleteAccount((String)request.getParameter("login"));
	}

}
