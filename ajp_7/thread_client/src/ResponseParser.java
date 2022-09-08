import com.google.gson.Gson;

public class ResponseParser {
    static Gson gson = new Gson();

    public static String to_json(Response response) {
        return gson.toJson(response);
    }

    public static Response from_json(String json_string) {
        return gson.fromJson(json_string, Response.class);
    }
}
