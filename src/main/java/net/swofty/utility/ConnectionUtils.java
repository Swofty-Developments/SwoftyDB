package net.swofty.utility;

import com.google.protobuf.ByteString;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionUtils {
	public PrintWriter out ;
	public InputStream in;

	public ConnectionUtils(String IP, int port) throws IOException {
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(IP, port);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = clientSocket.getInputStream();
	}

	public ByteString makeConnection(JSONObject object) {
		out.println(object.toString());
		return ConnectionUtils.makeConnection(in);
	}

	public static ByteString makeConnection(InputStream inputStream) {
		byte[] sizeBuffer = new byte[4];
		try {
			inputStream.read(sizeBuffer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		int byteStringSize = java.nio.ByteBuffer.wrap(sizeBuffer).getInt();

		// Receive the ByteString data
		byte[] byteStringBuffer = new byte[byteStringSize];
		try {
			inputStream.read(byteStringBuffer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return ByteString.copyFrom(byteStringBuffer);
	}
}
