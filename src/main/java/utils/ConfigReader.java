package utils;

import java.io.IOException;
import java.util.Properties;


public class ConfigReader {

	public static void PopulateSettings() throws IOException {
		ConfigReader reader = new ConfigReader();
		reader.ReadProperty();
	}
	
	private void ReadProperty() throws IOException {
		Properties p = new Properties();
		p.load(getClass().getResourceAsStream("globalconfig.properties"));
		
		Settings.app = p.getProperty("app");
		Settings.username = p.getProperty("username");
		Settings.password = p.getProperty("password");
		
	}
}
