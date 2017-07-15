/**
 * @author mohamed265
 * Created On : Mar 25, 2017 10:46:57 AM
 */
package com.mohamed265.weatherchecker.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author mohamed265
 *
 */
public class PropertiesReader {

	private static final Logger logger = Logger.getLogger(PropertiesReader.class);

	public static String getApiUrl() {
		Properties prop = new Properties();
		try {
			prop.load(PropertiesReader.class.getClassLoader().getResourceAsStream(Constants.PROPERTIES_FILE));

			return prop.getProperty(Constants.Propeties.API_URL);

		} catch (IOException ex) {
			logger.error(ex);
		}
		return null;
	}

}
