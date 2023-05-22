package net.swofty.api;

import com.google.protobuf.ByteString;
import net.swofty.api.socket.SwoftySocket;
import org.json.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;

public class SwoftyAPI {
	public static ServerSocket serverSocket;

	public static void start(int port) throws IOException {
		SwoftySocket.registerAll();

		serverSocket = new ServerSocket(port);

		new Thread(() -> {
			while (true) {
				try {
					Socket clientSocket = serverSocket.accept();
					new Thread(() -> {
						try {
							InputStream inputStream = clientSocket.getInputStream();
							OutputStream outputStream = clientSocket.getOutputStream();

							String rawMessage = new BufferedReader(new InputStreamReader(inputStream)).readLine();
							JSONObject json = new JSONObject(rawMessage);

							OutputStream finalOutputStream = outputStream;
							for (SwoftySocket socket : SwoftySocket.sockets) {
								if (socket.getDatabaseKey().equals(json.getString("key"))) {
									HashMap<String, String> data = new HashMap<>();

									for (String x : json.getJSONObject("data").keySet()) {
										data.put(x, json.getJSONObject("data").getString(String.valueOf(x)));
									}

									ByteString toReturn = socket.action(data);
									System.out.println("Returning " + toReturn);
									byte[] sizeBuffer = java.nio.ByteBuffer.allocate(4).putInt(toReturn.size()).array();
									System.out.println("Time: " + System.currentTimeMillis());
									System.out.println("SizeBuffer " + Arrays.toString(sizeBuffer));
									finalOutputStream.write(sizeBuffer);

									// Send the ByteString data
									finalOutputStream.write(toReturn.toByteArray());
									finalOutputStream.flush();
									System.out.println("Time 2: " + System.currentTimeMillis());
								}
							}
						} catch (RuntimeException | IOException e) {}
						try {
							clientSocket.close();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}).start();
				} catch (RuntimeException ignored) {} catch (IOException e) {
					throw new RuntimeException(e);}
			}
		}).start();
	}
}
