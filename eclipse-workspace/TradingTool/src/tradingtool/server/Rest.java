package tradingtool.server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class Rest extends Application{
	@Override
	public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<>();
    classes.add(Server.class);
    return classes;
  }
	
	public static String toJSON(Object o) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(o);
	}
} 