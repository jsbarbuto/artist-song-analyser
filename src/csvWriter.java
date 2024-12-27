import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class csvWriter {
    public static void writesLines (String filePath, HashMap<String,Integer> artists) throws IOException {

        FileWriter writer = new FileWriter(filePath);

        for (String name: artists.keySet()){

            String count = Integer.toString(artists.get(name));
            ArrayList<String> keyPair = new ArrayList<>(Arrays.asList(name,count));
            String aName = keyPair.get(0); String number = keyPair.get(1);
            writer.write(aName); writer.write(", "); writer.write(count);
            writer.write("\n");
        }
        writer.close();
    }
}