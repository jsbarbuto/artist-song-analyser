import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class csvWriter {
    public static void writesLines (String filePath, HashMap<String,Integer> artists) throws IOException {

        FileWriter writer = new FileWriter(filePath);//writer

        writer.write("There's "+artists.size()+" artists"+"\n");
        int i= artists.size();//index
        for (String name: artists.keySet()){
            i--;
            String count = Integer.toString(artists.get(name));//string of artist count
            ArrayList<String> keyPair = new ArrayList<>(Arrays.asList(name,count));//artist and count in list
            String aName = keyPair.get(0); String number = keyPair.get(1);//name
            writer.write(aName); writer.write(", "); writer.write(count);
            if(i==0){break;}//prevents unneeded line
            writer.write("\n");
        }
        writer.close();
    }
    public static void fileInput(File inputFile) throws IOException {
        String fileName = inputFile.getAbsolutePath();//gets file from GUI
        HashMap<String,Integer> artists = csvReader.GameMusicReader(fileName);//gets artist count
        String newFilename = fileName.substring(0,fileName.length()-4);//gets rid of ".csv"
        newFilename += " counted.csv";//marks that the file is "counted"
        writesLines(newFilename,artists);
    }
}