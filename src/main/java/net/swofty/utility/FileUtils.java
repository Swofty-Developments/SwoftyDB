package net.swofty.utility;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.protobuf.ByteString;

public class FileUtils {

	public static void saveToFile(ByteString data, String filePath) {
		try {
			Path path = Paths.get(filePath);
			Files.write(path, data.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("Failed to save data to file", e);
		}
	}

	public static ByteString loadFromFile(String filePath) {
		try {
			Path path = Paths.get(filePath);
			byte[] data = Files.readAllBytes(path);
			return ByteString.copyFrom(data);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load data from file", e);
		}
	}
}

