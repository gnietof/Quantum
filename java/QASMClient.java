package com.gnf.qasm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

public class QASMClient {

	public static String TOKEN = <YOUR TOKEN>;
	public static String TRANSPILER = "https://cloud-transpiler.quantum.ibm.com/transpile";

	public static void main(String[] args) {

		QASMClient qasm = new QASMClient();

		try {
			File f = new File(<YOUR FILE PATH>);
			qasm.doRequest("ibm_torino", new FileInputStream(f), 1);
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist!");
			e.printStackTrace();
		}

	}

	private void doRequest(String backend, InputStream is, int level) {
		ObjectMapper om = new ObjectMapper();

		try {
			String params = String.format("backend=%s&optimization_level=%d&ai=false", backend, level);

			String code = new String(is.readAllBytes(),StandardCharsets.UTF_8);
			Map<String,String> map = new HashMap<String, String>();
			map.put("qasm_circuits", code);

			URL url = new URL(TRANSPILER + "?" + params);
			HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
			uc.setRequestMethod("POST");
			uc.setRequestProperty("Content-Type", "application/json");
			uc.setRequestProperty("Accept", "application/json");
			uc.setRequestProperty("Authorization", "Bearer " + TOKEN);
			
			uc.setDoOutput(true);
			OutputStream os = uc.getOutputStream();
			om.writeValue(os,map);

			int rc = uc.getResponseCode();
			if (rc == HttpURLConnection.HTTP_OK) {
				String s = new String(uc.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
				System.out.println(s);

			} else {
				String s = new String(uc.getErrorStream().readAllBytes(), StandardCharsets.UTF_8);
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
