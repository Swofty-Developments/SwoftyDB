package net.swofty.db;

import com.google.protobuf.ByteString;
import net.swofty.db.proto.Database;

import java.io.IOException;

public class DataManager {

	public static ByteString serializeDatabase(Database database) {
		return database.toByteString();
	}

	public static Database deserializeDatabase(ByteString serializedDatabase) {
		try {
			return Database.parseFrom(serializedDatabase);
		} catch (IOException e) {
			throw new RuntimeException("Failed to deserialize database", e);
		}
	}
}