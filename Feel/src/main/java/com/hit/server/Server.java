package com.hit.server;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	private static boolean serverUp = true;

	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(12345);
			while(serverUp){
				Socket DjHiresApplication = server.accept();
				new Thread(new HandleRequest(DjHiresApplication)).start();
			}
			server.close();
		} catch (Exception e) {
			System.out.println("tired of waiting for connection");
		}

	}
}
