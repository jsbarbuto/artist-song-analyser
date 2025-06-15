import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class csvReader {

    public static ArrayList<String> readLines (String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return lines;
    }

    public static HashMap<String, Integer> getArtistSongCounts (String fileName) {
        HashMap<String, Integer> artists = new HashMap<>();

        ArrayList<String> lines = readLines(fileName);
        int i = 0;
        if (isHeader(lines.getFirst())) {
            i = 1;
        }

        for (; i<lines.size(); i++) {
            String line = lines.get(i);
            ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(",")));
            String currArtist = values.getFirst();
            if (!artists.containsKey(currArtist)) {
                artists.put(currArtist, 0);
            }
            if (artists.containsKey(currArtist)) {
                int artistCount = artists.get(currArtist);
                artists.replace(currArtist, artistCount + 1);
            }
        }
        System.out.println("There's " + artists.size() + " artists:");//total artists
        hashMapPrinter(artists);//artist count
        return artists;
    }

    public static boolean isHeader (String header) {
        ArrayList<String> values = new ArrayList<>(Arrays.asList(header.split(",")));
        //data must be in the format artist,song
        if (values.size() != 2) {
            return true;
        }
        for (String v : values) {
            if (v.toLowerCase().contains("artist")||
                    v.toLowerCase().contains("song") ||
                    v.toLowerCase().contains("title")) {
                return true;
            }
        }
        return false;
    }

    public static void hashMapPrinter (HashMap<String,Integer> artists){
        String grammerPoint;
        for (String artist : artists.keySet()) {

            if (artists.get(artist) == 1){
                grammerPoint = " time.";
            } else {grammerPoint = " times.";}
            System.out.println(artist + ": shows up "+artists.get(artist)+grammerPoint);
        }
    }
}