package info.seleniumcucumber.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ipConfig = new FileInputStream("./src/test/resources/configs/config.properties");
			prop.load(ipConfig);

			FileInputStream ipLogin = new FileInputStream("./src/test/resources/configs/login.properties");
			prop.load(ipLogin);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

}