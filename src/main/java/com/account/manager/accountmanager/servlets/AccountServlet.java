package com.account.manager.accountmanager.servlets;

import com.account.manager.accountmanager.dto.Account;
import com.account.manager.accountmanager.util.FinanceUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.account.manager.accountmanager.util.WebUtils.convertAccountsToJson;

@WebServlet(name = "AccountServlet", value = "/create-accounts")
public class AccountServlet extends HttpServlet {

	public void init() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		System.out.println(name + phone);

		FinanceUtil.accounts = generateAccounts(name, phone);

		FinanceUtil.accounts.forEach(System.out::println);

		String accountsJson = convertAccountsToJson(FinanceUtil.accounts);

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