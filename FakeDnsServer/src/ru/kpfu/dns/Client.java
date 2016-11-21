package ru.kpfu.dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		try (Socket socket = new Socket("localhost", 4848);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {
			writer.println("kpfu.ru");
			System.out.println(reader.readLine());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
