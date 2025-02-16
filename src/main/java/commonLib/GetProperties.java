package commonLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
	Properties properties;
	
	public GetProperties(String file_path) throws Exception, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(file_path));
	}
	
	public String get_property(String key) {
		return properties.getProperty(key);
	}

}
