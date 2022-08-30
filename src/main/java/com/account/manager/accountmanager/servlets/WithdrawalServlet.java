package com.account.manager.accountmanager.servlets;

import com.account.manager.accountmanager.util.FinanceUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.stream.Collectors;

import static com.account.manager.accountmanager.util.WebUtils.convertAccountsToJson;

@WebServlet(name = "WithdrawalServlet", value = "/withdraw")
public class WithdrawalServlet extends HttpServlet {

	public void init() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String accountNumber = request.getParameter("accountnumber");
		String amount = request.getParameter("amount");

		FinanceUtil.accounts = FinanceUtil.accounts.stream()
				.peek(account -> {
					if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
						if (account.getBalance().compareTo(new BigDecimal(amount)) > -1) {
							BigDecimal currentBalance = account.getBalance().subtract(new BigDecimal(amount));
							account.setBalance(currentBalance);
						} else if (account.getBalance().compareTo(new BigDecimal(amount)) < 1) {
							System.out.println("insufficient funds");
						}
					}
				})
				.collect(Collectors.toList());

		FinanceUtil.accounts.forEach(System.out::println);

		String accountsJson = convertAccountsToJson(FinanceUtil.accounts);

		PrintWriter out = response.getWriter();

		out.print(accountsJson);
		out.flush();
	}

	public void destroy() {
	}
}