package net.swofty.db;

import com.google.protobuf.ByteString;
import net.swofty.db.proto.CustomObject;
import net.swofty.db.proto.Document;
import net.swofty.db.proto.Entry;
import net.swofty.db.proto.ValueWrapper;

import java.util.Optional;

public class DocumentUtility {

	public static Document updateOrInsertEntryValue(Document document, String key, Entry.ValueCase newValueType, Object newValue) {
		Document.Builder documentBuilder = document.toBuilder();
		boolean entryUpdated = false;

		for (int i = 0; i < documentBuilder.getEntriesCount(); i++) {
			Entry entry = documentBuilder.getEntries(i);
			if (entry.getKey().equals(key)) {
				Entry.Builder entryBuilder = entry.toBuilder();
				switch (newValueType) {
					case STRING_VALUE:
						entryBuilder.setStringValue((String) newValue);
						break;
					case INT_VALUE:
						entryBuilder.setIntValue((Integer) newValue);
						break;
					case CUSTOM_OBJECT:
						entryBuilder.setCustomObject((CustomObject) newValue);
						break;
					case DOUBLE_VALUE: // Handle double values
						entryBuilder.setDoubleValue((Double) newValue);
						break;
					case LONG_VALUE: // Handle long values
						entryBuilder.setLongValue((Long) newValue);
						break;
					case VALUE_NOT_SET:
					default:
						throw new IllegalArgumentException("Invalid newValueType");
				}
				documentBuilder.setEntries(i, entryBuilder.build());
				entryUpdated = true;
				break;
			}
		}

		// If the entry was not updated, it means the key does not exist in the document,
		// so we create a new entry and add it to the document.
		if (!entryUpdated) {
			Entry.Builder entryBuilder = Entry.newBuilder();
			entryBuilder.setKey(key);
			switch (newValueType) {
				case STRING_VALUE:
					entryBuilder.setStringValue((String) newValue);
					break;
				case INT_VALUE:
					entryBuilder.setIntValue((Integer) newValue);
					break;
				case CUSTOM_OBJECT:
					entryBuilder.setCustomObject((CustomObject) newValue);
					break;
				case DOUBLE_VALUE: // Handle double values
					entryBuilder.setDoubleValue((Double) newValue);
					break;
				case LONG_VALUE: // Handle long values
					entryBuilder.setLongValue((Long) newValue);
					break;
				case VALUE_NOT_SET:
				default:
					throw new IllegalArgumentException("Invalid newValueType");
			}
			documentBuilder.addEntries(entryBuilder.build());
		}

		return documentBuilder.build();
	}

	public static Optional<ByteString> getValueForKeySerialized(Document document, String key) {
		for (Entry entry : document.getEntriesList()) {
			if (entry.getKey().equals(key)) {
				ValueWrapper.Builder valueWrapperBuilder = ValueWrapper.newBuilder();
				switch (entry.getValueCase()) {
					case STRING_VALUE:
						valueWrapperBuilder.setStringValue(entry.getStringValue());
						break;
					case INT_VALUE:
						valueWrapperBuilder.setIntValue(entry.getIntValue());
						break;
					case CUSTOM_OBJECT:
						valueWrapperBuilder.setCustomObject(entry.getCustomObject());
						break;
					case DOUBLE_VALUE:
						valueWrapperBuilder.setDoubleValue(entry.getDoubleValue());
						break;
					case LONG_VALUE:
						valueWrapperBuilder.setLongValue(entry.getLongValue());
						break;
					case VALUE_NOT_SET:
					default:
						return Optional.empty();
				}
				return Optional.of(valueWrapperBuilder.build().toByteString());
			}
		}
		return Optional.empty();
	}

	public static Object getValueForKey(Document document, String key) {
		for (Entry entry : document.getEntriesList()) {
			if (entry.getKey().equals(key)) {
				switch (entry.getValueCase()) {
					case STRING_VALUE:
						return entry.getStringValue();
					case INT_VALUE:
						return entry.getIntValue();
					case CUSTOM_OBJECT:
						return entry.getCustomObject();
					case DOUBLE_VALUE:
						return entry.getDoubleValue();
					case LONG_VALUE:
						return entry.getLongValue();
					case VALUE_NOT_SET:
					default:
						return null;
				}
			}
		}
		return null;
	}
}

