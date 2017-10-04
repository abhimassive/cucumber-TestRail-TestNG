package testrail;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestRailAPI {

	public static APIClient client() {
		// TODO make this read from settings/config file
		APIClient client = new APIClient("https://massiveqa.testrail.net");
		client.setUser("abhijeet.daspatnaik@massive.co");
		client.setPassword("/XaBDwr3.Oz17fIGtPpJ-VqOLz5WzyxiNgIA4vFJJ");

		return client;
	}

	public static JSONObject getCase(int p_caseId) throws Exception {
		APIClient client = TestRailAPI.client();
		JSONObject c = (JSONObject) client.sendGet("get_case/" + p_caseId);

		return c;
	}

	@SuppressWarnings("unchecked")
	public static JSONObject addResult(int p_statusId, String p_comment, int p_runId, int p_caseId) throws Exception {
		APIClient client = TestRailAPI.client();
		@SuppressWarnings("rawtypes")
		Map data = new HashMap();
		data.put("status_id", new Integer(p_statusId));
		data.put("comment", p_comment);
		JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" + p_runId + "/" + p_caseId, data);

		return r;
	}

}
