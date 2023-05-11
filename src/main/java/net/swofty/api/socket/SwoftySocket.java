package net.swofty.api.socket;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.checkerframework.checker.units.qual.A;
import org.reflections.Reflections;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;

public abstract class SwoftySocket {

	public static ArrayList<SwoftySocket> sockets = new ArrayList<>();

	public abstract String getDatabaseKey();
	public abstract ByteString action(Map<String, String> data) throws InvalidProtocolBufferException;

	public static void registerAll() {
		Reflections reflection = new Reflections("net.swofty.api.socket.sockets");
		for (Class<? extends SwoftySocket> l : reflection.getSubTypesOf(SwoftySocket.class)) {
			try {
				sockets.add(l.newInstance());
			} catch (InstantiationException | IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
	}
}
