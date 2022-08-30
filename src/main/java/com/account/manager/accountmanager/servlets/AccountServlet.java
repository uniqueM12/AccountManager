package com.account.manager.accountmanager.servlets;

import com.account.manager.accountmanager.model.Account;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.account.manager.accountmanager.util.WebUtils.convertAccountsToJson;

@WebServlet(name = "AccountServlet", value = "/create-accounts")
public class AccountServlet extends HttpServlet {
	public static List<Account> accounts;

	public void init() {
		accounts = new ArrayList<>();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		System.out.println(name + phone);

		accounts = generateAccounts(name, phone);

		accounts.forEach(System.out::println);

		String accountsJson = convertAccountsToJson(accounts);

//		System.out.println(accountsJson);

		PrintWriter out = response.getWriter();

		out.print(accountsJson);
		out.flush();
	}

	public void destroy() {
	}

	private List<Account> generateAccounts(String name, String phone) {
		List<Account> accounts = new ArrayList<>();
		Random random = new Random();
		for (int j = 0; j < 10; j++) {
			String accountNumber = random.ints(10, 0, 9)
					.boxed()
					.map(e -> "" + e)
					.collect(Collectors.joining());
			Account account = new Account(name, phone, BigDecimal.ZERO);
			account.setAccountNumber(accountNumber);
			accounts.add(account);
		}

		return accounts;
	}
}