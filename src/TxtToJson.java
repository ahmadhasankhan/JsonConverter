/**
 * Created by ahmadhassan on 20/02/15.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtToJson {
    public static void main(String[] args) {
        // Simple message
        System.out.println("Hello World");
        System.out.println("Hello1");

        FileWriter fw = null;
        File newTextFile = null;

        try {

            File folder = new File("/Users/ahmadhassan/ahmad/input");
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println(listOfFiles.length);
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                    if (listOfFiles[i].getName() != ".DS_Store") {
                        System.out.println(listOfFiles[i].getName() != ".DS_Store");

                        newTextFile = new File("/Users/ahmadhassan/ahmad/output/" + listOfFiles[i].getName());
                        System.out.println("/Users/ahmadhassan/ahmad/output/" + listOfFiles[i].getName());
                        fw = new FileWriter(newTextFile);

                        BufferedReader br = new BufferedReader(new FileReader("/Users/ahmadhassan/ahmad/input/" + listOfFiles[i].getName()));
                        for (String line; (line = br.readLine()) != null; ) {
                            String[] stringArray;
                            stringArray = line.split("\\|");
                            fw.write("{" + "\"city_id\"" + ": " + stringArray[5].replaceAll("\\s", "") + ", " + "\"id\"" + ": " + stringArray[1].replaceAll("\\s", "") + ", " + "\"name\"" + ": " + "\"" + stringArray[2].replaceAll("\\s", "") + "\"" + "}," + "\n");
                            System.out.println("{" + "\"city_id\"" + ": " + stringArray[5].replaceAll("\\s", "") + ", " + "\"id\"" + ": " + stringArray[1].replaceAll("\\s", "") + ", " + "\"name\"" + ": " + "\"" + stringArray[2].replaceAll("\\s", "") + "\"" + "},");
                            fw.flush();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }

}
