package com.account.manager.accountmanager.util;

import com.account.manager.accountmanager.model.Account;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by Chukwudere Adindu.
 */
public class WebUtils {


	public static String convertAccountsToJson(List<Account> accounts) {

		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		for (Account account : accounts) {
			JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
					.add("firstName", account.getAccountName())
					.add("phone", account.getPhone())
					.add("accountNumber", account.getAccountNumber())
					.add("balance", account.getBalance());
			JsonObject jsonObject = objectBuilder.build();
			String jsonString;
			try (Writer writer = new StringWriter()) {
				Json.createWriter(writer).writeObject(jsonObject);
				jsonString = writer.toString();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			arrayBuilder.add(jsonString);
		}

		return arrayBuilder.build().toString().replace("\\", "");
	}
}
