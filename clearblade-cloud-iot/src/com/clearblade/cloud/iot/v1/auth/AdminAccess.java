package com.clearblade.cloud.iot.v1.auth;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.clearblade.cloud.iot.v1.utils.AuthParams;
import com.clearblade.cloud.iot.v1.utils.Constants;

public class AdminAccess {

	static Logger log = Logger.getLogger(AdminAccess.class.getName());
	
	static AuthParams authParams;

	public AuthParams getSystemCredentials() {

		String pathToAuthFile = System.getenv(Constants.AUTH_ACCESS);

		JSONParser jsonParser = new JSONParser();
		try (FileReader authReader = new FileReader(pathToAuthFile)) {
			// Read JSON file
			Object obj = jsonParser.parse(authReader);
			JSONObject authJSONObject = (JSONObject) obj;
			if (authJSONObject != null) {

				authParams = new AuthParams();

				String adminSystemKey = (authJSONObject.get(Constants.ADMIN_SYSTEM_KEY)).toString();
				authParams.setAdminSystemKey(adminSystemKey);

				String adminToken = (authJSONObject.get(Constants.ADMIN_TOKEN)).toString();
				authParams.setAdminToken(adminToken);

				String baseURL = (authJSONObject.get(Constants.BASE_URL)).toString();
				authParams.setBaseURL(baseURL);

				String projectName = (authJSONObject.get(Constants.PROJECT_NAME)).toString();
				authParams.setProject(projectName);

				this.setAuthParams(authParams);
			}

		} catch (FileNotFoundException e) {
			log.log(Level.SEVERE, "Configuration file missing.");
			e.printStackTrace();
		} catch (IOException e) {
			log.log(Level.SEVERE, "Error occurred while reading configuration from file.");
			e.printStackTrace();
		} catch (ParseException e) {
			log.log(Level.SEVERE, "Can not parse configuration objects from file.");
			e.printStackTrace();
		}
		return authParams;
	}

	public AuthParams getAuthParams() {
		return authParams;
	}

	public void setAuthParams(AuthParams setAuthParams) {
		authParams = setAuthParams;
	}

}
