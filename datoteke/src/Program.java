import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> redovi = new ArrayList<>();
        String resources_path = System.getenv("JAVA_RESOURCES");
        File f = new File(resources_path + "\\raven.txt");
        if(f.exists()) {
            Scanner reader = new Scanner(f);
            reader.useDelimiter("\\n");
            while(reader.hasNext()) {
                redovi.add(reader.next());
            }
        } else {
            System.err.println("File not found on address: " + f.getAbsolutePath());
        }

        int count_nevermore = 0;
        for(String red : redovi) {
            String[] podela = red.split(" ");
            for(String rec : podela) {
                if(rec.toLowerCase().indexOf("nevermore") > -1) {
                    count_nevermore++;
                }
            }
        }
        System.out.println("Count nevermore: " + count_nevermore);
    }
}
