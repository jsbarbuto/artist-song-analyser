import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class csvReader {

    public static ArrayList<String> ReadsLines (String filePath){
        ArrayList<String> lines = new ArrayList<>();
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while((line = br.readLine()) != null){
                lines.add(line);
            }
        } catch (IOException e ) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return lines;
    }

    public static HashMap<String, Integer> GameMusicReader (String fileName) {
        HashMap <String, Integer> artists = new HashMap<>();

        for(String line:  ReadsLines(fileName)){
            if (line.equals("Artists / source,Song Title")) {continue; }
            ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(",")));
            String firstIndex = values.getFirst();
            if (!artists.containsKey(firstIndex)){
                artists.put(firstIndex,0);
            }
            if (artists.containsKey(firstIndex)){
                int artistCount = artists.get(firstIndex);
                artists.replace(firstIndex,artistCount+1);
            }
        }
        String finalStr = "There's " + artists.size()+ " artists:";
        System.out.println(finalStr);//total artists
        hashMapPrinter(artists);//artist count
        return artists;
    }

    public static void hashMapPrinter (HashMap<String,Integer> artists){
        String grammerPoint;
        for (String artist :artists.keySet()) {

            if (artists.get(artist) ==1){
                grammerPoint = " time.";
            } else {grammerPoint = " times.";}
            System.out.println(artist+": shows up "+artists.get(artist)+grammerPoint);
        }
    }
}