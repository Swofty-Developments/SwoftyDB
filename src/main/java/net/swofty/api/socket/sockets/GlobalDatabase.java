package net.swofty.api.socket.sockets;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import net.swofty.api.socket.SwoftySocket;
import net.swofty.db.DocumentUtility;
import net.swofty.db.proto.Document;
import net.swofty.db.proto.Entry;
import net.swofty.utility.RedisUtils;

import java.util.Map;

public class GlobalDatabase extends SwoftySocket {
	@Override
	public String getDatabaseKey() {
		return "global";
	}

	@Override
	public ByteString action(Map<String, String> data) throws InvalidProtocolBufferException {
		System.out.println(data);
		switch (data.get("command")) {
			case "GET":
				ByteString loadedSerializedDocument = RedisUtils.loadDocument("globalDatabase", "global");
				Document foundDocument = Document.parseFrom(loadedSerializedDocument);
				return foundDocument.toByteString();

			case "SET":
				ByteString loadedSerializedDocument2 = RedisUtils.loadDocument("globalDatabase", "global");
				Document foundDocument2 = Document.parseFrom(loadedSerializedDocument2);

				foundDocument2 = DocumentUtility.updateOrInsertEntryValue(foundDocument2, data.get("updateKey"), Entry.ValueCase.valueOf(data.get("updateType")), data.get("updateValue"));

				RedisUtils.saveDocument("globalDatabase", foundDocument2);
				break;

			case "SET-MASS":
				ByteString loadedSerializedDocument3 = RedisUtils.loadDocument("globalDatabase", "global");
				Document foundDocument3 = Document.parseFrom(loadedSerializedDocument3);

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

					foundDocument3 = DocumentUtility.updateOrInsertEntryValue(foundDocument3, key, type, value);
				}

				RedisUtils.saveDocument("globalDatabase", foundDocument3);
				break;
		}
		return null;
	}
}
