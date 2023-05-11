package net.swofty.db;

import net.swofty.db.proto.Database;
import net.swofty.db.proto.Document;

import java.util.HashMap;
import java.util.Optional;

public class DataFinder {

	private final HashMap<String, Document> documents;

	public DataFinder(Database database) {
		documents = new HashMap<>();
		for (Document document : database.getDocumentsList()) {
			documents.put(document.getDocumentKey(), document);
		}
	}

	public Optional<Document> getDocumentByKey(String key) {
		return Optional.ofNullable(documents.get(key));
	}
}

