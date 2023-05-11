package net.swofty;

import com.google.protobuf.ByteString;
import net.swofty.api.SwoftyAPI;
import net.swofty.db.DataFinder;
import net.swofty.db.DataManager;
import net.swofty.db.DocumentUtility;
import net.swofty.db.proto.*;
import net.swofty.utility.ConnectionUtils;
import net.swofty.utility.RedisUtils;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Main {
	public static void main(String[] args) throws IOException {
		/*
		Start API
		 */
		SwoftyAPI.start(4000);

		/*
		Testing
		 */
		Document.Builder documentBuilder = Document.newBuilder();
		documentBuilder.setDocumentKey("user1");

		Entry.Builder entryBuilder = Entry.newBuilder();
		entryBuilder.setKey("username").setStringValue("Swofty");
		documentBuilder.addEntries(entryBuilder.build());

		Entry.Builder entryBuilder2 = Entry.newBuilder();
		entryBuilder2.setKey("exampleObject");

		CustomObject.Builder customObjectBuilder = CustomObject.newBuilder();
		customObjectBuilder.setId(1).setName("Custom Object");
		//customObjectBuilder.setSerializedJavaObject() pass through byte string of object

		entryBuilder2.setCustomObject(customObjectBuilder.build());
		documentBuilder.addEntries(entryBuilder2.build());
		// FileUtils.saveToFile(serializedDatabase, "database.atlas");
		RedisUtils.saveDocument("userDatabase", documentBuilder.build());


		// ByteString loadedSerializedDatabase = FileUtils.loadFromFile("database.atlas");
		ByteString loadedSerializedDocument = RedisUtils.loadDocument("userDatabase", "user1");
		Document foundDocument = Document.parseFrom(loadedSerializedDocument);
		Document updatedDocument = DocumentUtility.updateOrInsertEntryValue(foundDocument, "username", Entry.ValueCase.STRING_VALUE, "Warmlexs");
		System.out.println(updatedDocument);

		/*
		Socket Testing
		 */
		JSONObject toSend2 = new JSONObject();
		toSend2.put("key", "user");
		JSONObject innerData2 = new JSONObject();
		innerData2.put("command", "SET");
		innerData2.put("key", "user1");
		innerData2.put("updateKey", "username");
		innerData2.put("updateType", Entry.ValueCase.STRING_VALUE.toString());
		innerData2.put("updateValue", "fwefw");
		toSend2.put("data", innerData2);
		ByteString receivedByteString2 = new ConnectionUtils("127.0.0.1", 4000).makeConnection(toSend2);


		JSONObject toSend = new JSONObject();
		toSend.put("key", "user");
		JSONObject innerData = new JSONObject();
		innerData.put("command", "GET");
		innerData.put("key", "user1");
		toSend.put("data", innerData);
		ByteString receivedByteString = new ConnectionUtils("127.0.0.1", 4000).makeConnection(toSend);
		Document receivedDocument = Document.parseFrom(receivedByteString);
		System.out.println(receivedDocument);
		System.out.println(DocumentUtility.getValueForKey(receivedDocument, "username").get());


		JSONObject toSend3 = new JSONObject();
		toSend3.put("key", "user");
		JSONObject innerData3 = new JSONObject();
		innerData3.put("command", "CONTAINS");
		innerData3.put("key", "user123");
		toSend3.put("data", innerData3);
		ByteString receivedByteString3 = new ConnectionUtils("127.0.0.1", 4000).makeConnection(toSend3);
		boolean contains = receivedByteString3.byteAt(0) == 1;
		System.out.println(contains);
	}


}