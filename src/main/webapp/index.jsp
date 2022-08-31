<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="css/custom.css">
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="create-accounts?name=Adili&phone=08104142404&counts=4">account Servlet</a>
<a href="deposit?accountnumber=99&amount=50.00">Deposit Servlet</a>
<a href="transactions?accountnumber=99">Transaction Logs</a>

<h2>Account Management Platform</h2>
<p>Demo</p>

<!-- <button class="button" onclick="submit('createAccountForm')">Create Account</button> -->

<p>Created Account</p>
<div class="row">
    <div class="col-75">
        <div class="container">
            <form id="createAccountForm" method="POST" onsubmit="return false">
                <div class="row">
                    <div class="col-50">
                        <label for="accountName">Account Name</label>
                        <input type="text" id="accountName" name="accountName" placeholder="Account owner's name">
                        <label for="phone">Phone Number</label>
                        <input type="number" id="phone" name="phoneNumber" placeholder="Enter phone number (start with zero)">
                        <input type="hidden" id="operation" name="operation" value="create_accounts">
                    </div>
                </div>
            </form>
            <button class="button" onclick="createAccounts('createAccountForm')">Create Account</button>
        </div>
    </div>
</div>
<table id="generated_accounts">
    <tr>
        <th>Account Name</th>
        <th>Account Number</th>
        <th>Balance</th>
    </tr>
</table>

<h2>Deposits</h2>
<div class="col-75">
    <div class="container">
        <form id="credit" method="POST" onsubmit="return false">
            <div class="row">
                <div class="col-50">
                    <label for="creditAccount">Account Number</label>
                    <input type="text" id="creditAccount" name="accountNumber" placeholder="Account  number">
                    <label for="amount">Credit Amount</label>
                    <input type="number" id="amount" name="phoneNumber" placeholder="Amount">
                </div>
            </div>
        </form>
        <button class="button" onclick="depositMoney('createAccountForm')">Deposit funds</button>
    </div>
</div>
<h2>Withdrawals</h2>
<div class="col-75">
    <div class="container">
        <form id="debit" method="POST" onsubmit="return false">
            <div class="row">
                <div class="col-50">
                    <label for="debitAccount">Account Number</label>
                    <input type="text" id="debitAccount" name="accountNumber" placeholder="Account  number">
                    <label for="debitAmount">Debit Amount</label>
                    <input type="number" id="debitAmount" name="phoneNumber" placeholder="Amount">
                </div>
            </div>
        </form>
        <button class="button" onclick="withdrawMoney('createAccountForm')">Withdraw funds</button>
    </div>
</div>
<h2>Transaction Logs</h2>
<div class="col-75">
    <div class="container">
        <form id="logs" method="POST" onsubmit="return false">
            <div class="row">
                <div class="col-50">
                    <label for="transactionAccount">Transaction Accounts</label>
                    <input type="text" id="transactionAccount" name="accountNumber" placeholder="Account  number">
                </div>
            </div>
        </form>
        <button class="button" onclick="getTransactionLogs()">Get transaction logs</button>
    </div>
</div>
<table id="transactionLogs">
    <tr>
        <th>Account Number</th>
        <th>Tran Amount</th>
        <th>Balance</th>
        <th>Type</th>
    </tr>
</table>

<hr>
<script src="js/index.js"></script>
</body>
</html>