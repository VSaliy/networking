package com.example.networking.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Controller;

@Controller
public class Client {

    private static final String IP = "172.25.3.93";
//	private static final String IP = "127.0.0.1";
    private static final int PORT = 1248;

    public String call(String msg) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        StringBuilder resp = new StringBuilder();
        try {
            try (Socket clientSocket = new Socket(IP, PORT);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                executorService.execute(new Runnable() {
                    public void run() {
                        while (clientSocket.isConnected()) {
                            try {
                                resp.append(in.readLine());
                                System.out.println(resp.toString());
                                Thread.sleep(100);

                            } catch (IOException | InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }
                });
                out.println(msg);
                Thread.sleep(1000);
                return resp.toString();
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            executorService.shutdown();
        }
        return "";
    }

    private void startConnection(String ip, int port) {
        // TODO Auto-generated method stub

    }
}
