# SwoftyDB
![badge](https://img.shields.io/github/v/release/Swofty-Developments/SwoftyDB)
![badge](https://img.shields.io/github/last-commit/Swofty-Developments/SwoftyDB)
[![badge](https://img.shields.io/discord/830345347867476000?label=discord)](https://discord.gg/atlasmc)
[![badge](https://img.shields.io/github/license/Swofty-Developments/SwoftyDB)](https://github.com/Swofty-Developments/SwoftyDB/blob/master/LICENSE.txt)

**[JavaDoc 1.0.0](https://swofty-developments.github.io/SwoftyDB/)**

Simple way to store MongoDB-like "documents", with every document having a key, and a list of key + value pairs. Supports storing raw byte data using the systems default File Storage, and Redis.

## Table of contents

* [Getting started](#getting-started)
* [Usage](#usage)
* [License](#license)

## Getting started

This API is intended for stand-alone usage, meaning that you do not need to run anything extra to use this library.

### Add SwoftyDB to your project 

First, you need to setup the dependency inside of your POM.xml. Replace **VERSION** with the version of the release.

<details>
    <summary>Maven</summary>

```xml
<dependency>
    <groupId>net.swofty</groupId>
    <artifactId>swoftydb</artifactId>
    <version>VERSION</version>
</dependency>
```
</details>

<details>
    <summary>Gradle</summary>

```gradle
dependencies {
    implementation 'net.swofty:swoftydb:VERSION'
}
```
</details>

## Usage

As previously described - This schema supports documents. Documents are unsorted, and can be fetched with a document key. From the perspective of saving user data, this would be the players username, or UUID. Inside a document is a list of entries, which are keys and values. Traditional data types such as strings, longs, floats are all supported, aswell as pure Java objects. Here is some example usage taken from the projects Main.java class;

### Basic Document Creation (internally within project)
```java
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
```

### Loading Basic Document (internally within project)
```java
		ByteString loadedSerializedDocument = RedisUtils.loadDocument("userDatabase", "user1");
		Document foundDocument = Document.parseFrom(loadedSerializedDocument);
		Document updatedDocument = DocumentUtility.updateOrInsertEntryValue(foundDocument, "username", Entry.ValueCase.STRING_VALUE, "Warmlexs");
		System.out.println(updatedDocument);
```

### Loading Basic Document (externally using TCP sockets)
```java
		JSONObject toSend = new JSONObject();
		toSend.put("key", "user");
		JSONObject innerData = new JSONObject();
		innerData.put("command", "GET");
		innerData.put("key", "user1");
		toSend.put("data", innerData);
		ByteString receivedByteString = new ConnectionUtils("127.0.0.1", 4000).makeConnection(toSend);
		Document receivedDocument = Document.parseFrom(receivedByteString);
		System.out.println(receivedDocument);
		System.out.println(DocumentUtility.getValueForKey(receivedDocument, "username"));
```

### Setting Basic Document (externally using TCP sockets)
```java
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
```

### Custom Commands (externally using TCP sockets)
```java
		JSONObject toSend3 = new JSONObject();
		toSend3.put("key", "user");
		JSONObject innerData3 = new JSONObject();
		innerData3.put("command", "CONTAINS");
		innerData3.put("key", "user123");
		toSend3.put("data", innerData3);
		ByteString receivedByteString3 = new ConnectionUtils("127.0.0.1", 4000).makeConnection(toSend3);
		boolean contains = receivedByteString3.byteAt(0) == 1;
		System.out.println(contains);
```

## License
SwoftyDB is licensed under the permissive MIT license. Please see [`LICENSE.txt`](https://github.com/Swofty-Developments/SwoftyDB/blob/master/LICENSE.txt) for more information.
