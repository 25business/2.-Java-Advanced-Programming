import java.util.HashMap;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        HashMap<String, Object> user_data = new HashMap();
        user_data.put("first_name", "John");
        user_data.put("age", 27);
        user_data.put("is_developer", true);
        user_data.put("hobbies", new String[]{"drawing", "workout", "running"});

        System.out.printf("""
                    Name: %s
                    Age:  %d
                    Developer? %b
                    Hobbies: %s
                    """, user_data.get("first_name"),
                    user_data.get("age"), user_data.get("is_developer"),
                    Arrays.toString((String[])user_data.get("hobbies")));

        for(String key : user_data.keySet()) {
            Object o = user_data.get(key);
            //System.out.println(o.getClass().getName());
            //System.out.println(o.getClass().getSimpleName());

            if(o.getClass().getSimpleName().equals("String[]")) {
                System.out.println(key + ":");
                for(String item : (String[])o) {
                    System.out.println("    - " + item);
                }
            }
            /*
            if(o instanceof String[] array) {
                System.out.println(key + ":");
                for(String item : array) {
                    System.out.println("    - " + item);
                }
            } else {
                System.out.printf("%s: %s\n", key, o);
            }*/
        }
    }
}
