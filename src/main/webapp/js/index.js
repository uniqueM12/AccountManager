function createAccounts(formId) {

	// document.getElementById(formId).preventDe
	const xhttp = new XMLHttpRequest();
	const accountName = document.getElementById("accountName").value;
	const phone = document.getElementById("phone").value;
	xhttp.open("GET", "/AccountManager_war_exploded/create-accounts?name=" + accountName + "&phone=" + phone);
	xhttp.send();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("responseText", this.responseText);
			const accounts = JSON.parse(this.responseText);
			// Insert new rows to display accounts created.

			const table = document.getElementById("generated_accounts");
			accounts.forEach((account, i) => {
				// We already have a table header, so we insert after it.
				const row = table.insertRow(-1);
				const accountNameCell = row.insertCell(0);
				const accountNumberCell = row.insertCell(1);
				const balanceCell = row.insertCell(2);

				// Account details.
				accountNameCell.innerHTML = account.accountName;
				accountNumberCell.innerHTML = account.accountNumber;
				balanceCell.innerHTML = new String(account.balance);
			});

		}
	}
}

function depositMoney(formId) {
	const xhttp = new XMLHttpRequest();
	const accountNumber = document.getElementById("creditAccount").value;
	const amount = document.getElementById("amount").value;
	xhttp.open("GET", "/AccountManager_war_exploded/deposit?accountnumber=" + accountNumber + "&amount=" + amount);
	xhttp.send();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		}
	}
}

function withdrawMoney(formId) {
	const xhttp = new XMLHttpRequest();
	const debitAccount = document.getElementById("debitAccount").value;
	const debitAmount = document.getElementById("debitAmount").value;
	xhttp.open("GET", "/AccountManager_war_exploded/withdraw?accountnumber=" + debitAccount + "&amount=" + debitAmount);
	xhttp.send();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
		}
	}
}

function getTransactionLogs(){
	const xhttp = new XMLHttpRequest();
	const transactionAccounts = document.getElementById("transactionAccount").value;
	xhttp.open("GET", "/AccountManager_war_exploded/transactions?transactions=" + transactionAccounts);
	xhttp.send();

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("responseText", this.responseText);
			const transactions = JSON.parse(this.responseText);
			// Insert new rows to display accounts created.

			const table = document.getElementById("transactionLogs");

			transactions.forEach((transaction, i) => {
				// We already have a table header, so we insert after it.
				const row = table.insertRow(-1);
				const accountNumberCell = row.insertCell(0);
				const tranAmountCell = row.insertCell(1);
				const balanceCell = row.insertCell(2);
				const tranTypeCell = row.insertCell(3);

				// Account details.
				accountNumberCell.innerHTML = transaction.accountNumber;
				tranAmountCell.innerHTML = transaction.amount;
				balanceCell.innerHTML = new String(transaction.balance);
				tranTypeCell.innerHTML = transaction.transactionType;
			});

		}
	}
}