package ru.kpfu.dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {

	public static void main(String[] args) {

		Map<String, String> dnsMap = new HashMap<>();
		dnsMap.put("mail.ru", "217.69.139.199");
		dnsMap.put("kpfu.ru", "178.213.240.16");

		try (ServerSocket serverSocket = new ServerSocket(4848)) {

			while (!Thread.currentThread().isInterrupted()) {

				try (Socket socket = serverSocket.accept();
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);) {
					String domain = reader.readLine();
					writer.println(dnsMap.get(domain));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}