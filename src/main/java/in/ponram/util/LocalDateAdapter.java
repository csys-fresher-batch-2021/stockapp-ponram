package in.ponram.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
public class LocalDateAdapter implements JsonSerializer<LocalDate> {
	public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
		return new JsonPrimitive(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	}
}