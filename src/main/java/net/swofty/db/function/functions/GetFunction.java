package net.swofty.db.function.functions;

import net.swofty.db.SwoftyDatabase;
import net.swofty.db.function.DatabaseFunction;
import net.swofty.db.proto.Entry;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class GetFunction extends DatabaseFunction {

	private String key;

	public GetFunction(String key) {
		this.key = key;
	}

	public GetFunction() {}

	@Override
	public String run(SwoftyDatabase database) {
		System.out.println("Reading " + key);

		System.out.println(database.index);
		if (!database.index.containsKey(key)) {
			return null;
		}

		try (RandomAccessFile raf = new RandomAccessFile(database.dbFilePath, "r")) {
			raf.seek(database.index.get(key));

			int entryLength = raf.readInt();
			byte[] entryBytes = new byte[entryLength];
			raf.read(entryBytes);

			Entry entry = Entry.parseFrom(entryBytes);
			return entry.getValue();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
