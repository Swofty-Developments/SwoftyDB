package net.swofty.db.function;

import net.swofty.db.SwoftyDatabase;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public abstract class DatabaseFunction {

	public static ArrayList<DatabaseFunction> registeredFunctions = new ArrayList<>();

	public String name;

	protected DatabaseFunction() {
		this.name = this.getClass().getSimpleName().toLowerCase().replace("function", "");
	}

	public abstract String run(SwoftyDatabase database);

	public static void registerFunctions() {
		Reflections reflection = new Reflections("net.swofty.db.function.functions");
		for(Class<? extends DatabaseFunction> l:reflection.getSubTypesOf(DatabaseFunction.class)) {
			try {
				DatabaseFunction functionClass = l.newInstance();
				registeredFunctions.add(functionClass);
			} catch (InstantiationException | IllegalAccessException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static String executeRunAmbiguously(SwoftyDatabase database, Class<? extends DatabaseFunction> function, LinkedHashMap<String, Class<?>> values) throws NoSuchMethodException {
		Class<?>[] classes = values.values().toArray(new Class[0]);
		Constructor<? extends DatabaseFunction> ctor = function.getDeclaredConstructor(classes);

		Object[] passedInValues = values.keySet().toArray(new String[0]);
		try {
			return ctor.newInstance(passedInValues).run(database);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
