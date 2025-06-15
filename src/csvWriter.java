import java.io.*;
import java.util.HashMap;

public class csvWriter {
    public static void writesLines (String filePath, HashMap<String,Integer> artists) throws IOException {

        FileWriter writer = new FileWriter(filePath);//writer

        writer.write("Artists: " + artists.size() + "\n");

        for (String name: artists.keySet()) {

            String count = Integer.toString(artists.get(name));//string of artist count
            writer.write(name + "," + count + "\n");
        }
        writer.close();
    }
    public static void fileInput(File inputFile) throws IOException {
        String fileName = inputFile.getAbsolutePath();//gets file from GUI

        HashMap<String,Integer> artistsSongCount = csvReader.getArtistSongCounts(fileName);//gets artist count
        String newFilename = fileName.substring(0,fileName.length()-4);//gets rid of ".csv"
        newFilename += " counted.csv";//marks that the file is "counted"
        writesLines(newFilename,artistsSongCount);
    }
}