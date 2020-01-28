package CreateDriveData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;

import DBconnectiom.DatabaseCon;

public class CreateDao {
	
	
	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}

	}
	
	
	
	
	public static Map<String, String> insertUser(CreateDrive cdd) throws JSONException {

		int affectedRows = 0;
		HashMap<String, String> mapResponse = new HashMap<>();
		try {
			Connection con = DatabaseCon.getDBConnection();
			PreparedStatement pst = con
					.prepareStatement("insert into drive(COMPANY_NAME,NO_OF_RSRES,EXP_REQ,CTC,JOINT_CRT,BOND,POSITION,FOLLOW_UP_DATE,EDU_CRT) values(?,?,?,?,?,?,?,?,?)");

			String CompanyName =cdd.getCompanyName();
			int resources =cdd.getResources();
			int exprequired =cdd.getExprequired();
			float ctc= cdd.getCtc();
			int joiningcriteria = cdd.getJoiningcriteria();
			float bond =cdd.getBond();
			int position=cdd.getPosition();
			String follow=cdd.getFollow();
			int educriteria=cdd.getEducriteria();
			// pst.setString(1, firstName);
			Object[] parameter = {CompanyName,resources,exprequired,ctc,joiningcriteria,bond,position,follow,educriteria};
			setValues(pst, parameter);
			affectedRows = pst.executeUpdate();
			if (affectedRows == 1)
				mapResponse.put("Msg", "SuccessFul SignUp");
			else
				mapResponse.put("Msg", "Error_In_SignUp");
			return mapResponse;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return mapResponse;

	}

}
