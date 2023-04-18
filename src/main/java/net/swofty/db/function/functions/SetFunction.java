package net.swofty.db.function.functions;

import net.swofty.db.SwoftyDatabase;
import net.swofty.db.function.DatabaseFunction;
import net.swofty.db.proto.Entry;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SetFunction extends DatabaseFunction {

	private String key;
	private String value;

	public SetFunction(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public SetFunction() {}

	@Override
	public String run(SwoftyDatabase database) {
		System.out.println("Setting " + value + " to " + key);
		try (RandomAccessFile raf = new RandomAccessFile(database.dbFilePath, "rw")) {
			if (database.index.containsKey(key)) {
				long existingPosition = database.index.get(key);
				raf.seek(existingPosition);

				Entry entry = Entry.newBuilder()
					  .setKey(key)
					  .setValue(value)
					  .build();

				byte[] entryBytes = entry.toByteArray();
				raf.writeInt(entryBytes.length);
				raf.write(entryBytes);
			} else {
				raf.seek(database.position);

				Entry entry = Entry.newBuilder()
					  .setKey(key)
					  .setValue(value)
					  .build();

				byte[] entryBytes = entry.toByteArray();
				raf.writeInt(entryBytes.length);
				raf.write(entryBytes);

				database.index.put(key, database.position);
				database.position = raf.getFilePointer();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
