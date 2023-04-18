package net.swofty.db;

import com.google.protobuf.CodedInputStream;
import net.swofty.db.function.DatabaseFunction;
import net.swofty.db.proto.Entry;
import net.swofty.exceptions.SwoftyFunctionNotFound;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SwoftyDatabase {
	public final String dbFilePath;
	public final Map<String, Long> index;
	public long position;

	public SwoftyDatabase(String dbFilePath) {
		this.dbFilePath = dbFilePath;
		this.index = new HashMap<>();
		this.position = 0;
		try {
			loadIndex();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void loadIndex() throws IOException {
		File file = new File(dbFilePath);

		if (!file.exists()) {
			file.createNewFile();
			return;
		}

		try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
			while (raf.getFilePointer() < raf.length()) {
				long entryPosition = raf.getFilePointer();
				int entryLength = raf.readInt();
				byte[] entryBytes = new byte[entryLength];
				raf.read(entryBytes);

				Entry entry = Entry.parseFrom(entryBytes);
				index.put(entry.getKey(), entryPosition);

				position = raf.getFilePointer();
			}
		}
	}

	public String executeFunction(Class<? extends DatabaseFunction> function) throws SwoftyFunctionNotFound {
		for (DatabaseFunction registeredFunction : DatabaseFunction.registeredFunctions) {
			if (registeredFunction.name.equals(function.getSimpleName().toLowerCase().replace("function", ""))) {
				return registeredFunction.run(this);
			}
		}

		throw new SwoftyFunctionNotFound(function.toString());
	}
}
