package net.swofty;

import net.swofty.db.SwoftyDatabase;
import net.swofty.db.function.DatabaseFunction;
import net.swofty.db.function.functions.GetFunction;
import net.swofty.db.function.functions.SetFunction;
import net.swofty.db.proto.ProtoHandler;

import java.util.LinkedHashMap;

public class Main {
	public static void main(String[] args) throws NoSuchMethodException {
		/*
		Initialize Functions
		 */
		DatabaseFunction.registerFunctions();

		/*
		Initialize Database
		 */
		new ProtoHandler();

		/*
		Testing
		 */
		SwoftyDatabase db = new SwoftyDatabase("example.swofty");

		DatabaseFunction.executeRunAmbiguously(db, SetFunction.class,
			  createLinkedHashMap("key1", String.class, "value1", String.class));
		String value1 = DatabaseFunction.executeRunAmbiguously(db, GetFunction.class,
			  createLinkedHashMap("key1", String.class));
		System.out.println(value1);

		SwoftyDatabase db2 = new SwoftyDatabase("example.swofty");
		DatabaseFunction.executeRunAmbiguously(db2, SetFunction.class,
			  createLinkedHashMap("key2", String.class, "value2", String.class));
		String value2 = DatabaseFunction.executeRunAmbiguously(db2, GetFunction.class,
			  createLinkedHashMap("key2", String.class));
		System.out.println(value2);
	}

	private static <K, V> LinkedHashMap<K, V> createLinkedHashMap(Object... keyValuePairs) {
		LinkedHashMap<K, V> map = new LinkedHashMap<>();
		for (int i = 0; i < keyValuePairs.length; i += 2) {
			map.put((K) keyValuePairs[i], (V) keyValuePairs[i + 1]);
		}
		return map;
	}
}