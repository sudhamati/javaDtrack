package CreateDriveData;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UtilityJson {

	private static final ObjectMapper mapper = new ObjectMapper();

	public static Object getObjectFromJSON(String jsonString, Class<?> className) {
		Object readValue = null;
		System.out.println(jsonString);

		try {
			readValue = mapper.readValue(jsonString, className);
		} catch (Exception e) {

			System.out.println(e);
		}
		return readValue;
	}

	public static String getJSONFromObject(Object object) {
		String jsonData = null;

		try {
			jsonData = mapper.writeValueAsString(object);

		} catch (Exception e) {
			System.out.println("Error in  getJSONFromObject " + e);
		}
		return jsonData;
	}

}
