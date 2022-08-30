package com.account.manager.accountmanager.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.stream.Collectors;

import static com.account.manager.accountmanager.util.WebUtils.convertAccountsToJson;

@WebServlet(name = "DepositServlet", value = "/deposit")
public class DepositServlet extends HttpServlet {

	public void init() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String accountNumber = request.getParameter("accountnumber");
		String amount = request.getParameter("amount");

		AccountServlet.accounts = AccountServlet.accounts.stream()
//				.filter(e -> e.getAccountNumber().equalsIgnoreCase(accountNumber))
//				.limit(1)
				.peek(account -> {
					if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
						BigDecimal currentBalance = account.getBalance().add(new BigDecimal(amount));
						account.setBalance(currentBalance);
					}
				})
				.collect(Collectors.toList());

//		for (Account account : selectedAccounts) {
//
//			accounts.remove(account);
//			BigDecimal currentBalance = account.getBalance().add(new BigDecimal(amount));
//			account.setBalance(currentBalance);
//			accounts.add(account);
//		}

		AccountServlet.accounts.forEach(System.out::println);

		String accountsJson = convertAccountsToJson(AccountServlet.accounts);

//		System.out.println(accountsJson);

		PrintWriter out = response.getWriter();

		out.print(accountsJson);
		out.flush();
	}

	public void destroy() {
	}
}