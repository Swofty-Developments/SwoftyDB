package net.swofty.api.socket.sockets;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import net.swofty.api.socket.SwoftySocket;
import net.swofty.db.DocumentUtility;
import net.swofty.db.proto.Document;
import net.swofty.db.proto.Entry;
import net.swofty.utility.RedisUtils;

import java.util.Map;

public class UserDatabase extends SwoftySocket {
	@Override
	public String getDatabaseKey() {
		return "user";
	}

	@Override
	public ByteString action(Map<String, String> data) throws InvalidProtocolBufferException {
		ByteString loadedSerializedDocument = RedisUtils.loadDocument("userDatabase", data.get("key"));
		Document foundDocument = null;
		if (loadedSerializedDocument != null) { foundDocument = Document.parseFrom(loadedSerializedDocument); }

		System.out.println(data.get("command"));

		switch (data.get("command")) {
			case "CREATE":
				Document newDocument = Document.newBuilder().setDocumentKey(data.get("key")).build();
				RedisUtils.saveDocument("userDatabase", newDocument);
				// Return a ByteString representing true to indicate that the operation was successful
				return ByteString.copyFrom(new byte[] {1});

			case "CONTAINS":
				System.out.println("Contains");
				if (loadedSerializedDocument == null) {
					return ByteString.copyFrom(new byte[]{0});
				} else {
					return ByteString.copyFrom(new byte[]{1});
				}

			case "CONTAINS-KEY":
				if (DocumentUtility.getValueForKey(foundDocument, data.get("key")).isPresent()) {
					return ByteString.copyFrom(new byte[]{1});
				} else {
					return ByteString.copyFrom(new byte[]{0});
				}

			case "GET":
				return foundDocument.toByteString();

			case "SET":
				foundDocument = DocumentUtility.updateOrInsertEntryValue(foundDocument, data.get("updateKey"), Entry.ValueCase.valueOf(data.get("updateType")), data.get("updateValue"));
				System.out.println(foundDocument);
				RedisUtils.saveDocument("userDatabase", foundDocument);
				break;

			case "SET-MASS":
				// Get the list of keys and values from the data map
				String serializedKeys = data.get("updateKeys");
				String serializedValues = data.get("updateValues");
				String serializedTypes = data.get("updateTypes");

				String[] keys = serializedKeys.split(",");
				String[] values = serializedValues.split(",");
				String[] types = serializedTypes.split(",");

				if (keys.length != values.length || keys.length != types.length) {
					throw new IllegalArgumentException("Mismatch in number of keys, values and types");
				}

				// Update each key-value pair in the document
				for (int i = 0; i < keys.length; i++) {
					String key = keys[i];
					String value = values[i];
					Entry.ValueCase type = Entry.ValueCase.valueOf(types[i]);

					foundDocument = DocumentUtility.updateOrInsertEntryValue(foundDocument, key, type, value);
				}

				RedisUtils.saveDocument("userDatabase", foundDocument);
				break;
		}
		return null;
	}
}
