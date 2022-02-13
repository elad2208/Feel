package com.hit.server;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hit.controller.DjController;
import com.hit.dm.Dj;

public class HandleRequest implements Runnable{
	
	private static String inputLine;
	


	Gson gson = new GsonBuilder().create();
	Socket socket;
	
	public HandleRequest(Socket s) {
		socket = s;
	}
	
	@Override
	public void run() {
		BufferedReader in;
		PrintWriter out;
	
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
 
			 String requestJson = in.readLine();
			 Request request = gson.fromJson( requestJson,Request.class);
			 DjController djController = new DjController();
			 switch(request.getHeaders().get("action")) {
			 case "dj/hire":
				 djController.hireDj(Long.parseLong(request.getBody().get("djId")),Long.parseLong( request.getBody().get("userId")));
			 case "dj/new":
				 djController.saveDJ(
						 new Dj(Long.parseLong(request.getBody().get("djId")),
								 request.getBody().get("djNickName"),
								 request.getBody().get("djGenre")));
			 
			 }
		          
        
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Server error");
		}
	}

}
