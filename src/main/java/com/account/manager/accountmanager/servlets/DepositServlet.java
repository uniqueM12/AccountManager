package com.account.manager.accountmanager.servlets;

import com.account.manager.accountmanager.enums.TransactionTypes;
import com.account.manager.accountmanager.util.FinanceUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

		FinanceUtil.accounts = FinanceUtil.accounts.stream()
				.peek(account -> {
					if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
						BigDecimal currentBalance = account.getBalance().add(new BigDecimal(amount));
						account.setBalance(currentBalance);
						FinanceUtil.addTransactionLog(accountNumber, new BigDecimal(amount).setScale(2, RoundingMode.HALF_EVEN), account.getBalance(), TransactionTypes.DEPOSIT);
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