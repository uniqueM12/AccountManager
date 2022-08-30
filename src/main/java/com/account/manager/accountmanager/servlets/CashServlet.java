package com.account.manager.accountmanager.servlets;

import com.account.manager.accountmanager.model.Account;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CashServlet", value = "/move-cash")
public class CashServlet extends HttpServlet {
	public static List<Account> accounts;

	public void init() {
		accounts = new ArrayList<>();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		// Hello
		PrintWriter out = response.getWriter();

		accounts = AccountServlet.accounts;
//		JsonObject json = Json.createObjectBuilder().add("key", Json.createValue(message)).build();

//		out.print(json);
//		out.flush();
	}

	public void destroy() {
	}
}