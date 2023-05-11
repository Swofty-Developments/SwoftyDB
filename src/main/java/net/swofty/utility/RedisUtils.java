package net.swofty.utility;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import net.swofty.db.proto.Document;
import redis.clients.jedis.Jedis;

public class RedisUtils {

	public static String REDIS_HOST = "localhost";
	public static int REDIS_PORT = 6379;

	public static void saveDocument(String databaseName, Document document) {
		try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {
			ByteString documentByteString = document.toByteString();
			jedis.set(databaseName + "-" + document.getDocumentKey(), documentByteString.toStringUtf8());
		}
	}

	public static ByteString loadDocument(String databaseName, String documentKey) throws InvalidProtocolBufferException {
		try (Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT)) {
			// Fetch the serialized document from Redis
			String serializedDocument = jedis.get(databaseName + "-" + documentKey);
			if (serializedDocument == null) {
				return null;
			}
			// Deserialize the document
			return ByteString.copyFromUtf8(serializedDocument);
		}
	}
}

