package src;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
    private HashMap<String, Integer> wordCounter;

    public DuplicateCounter() {
        wordCounter = new HashMap<>();
    }
    public void count(String dataFile) {
        try {
            wordCounter = new HashMap<>();
            FileInputStream inStream = new FileInputStream(dataFile);
            Scanner in = new Scanner(inStream);
            int count;
            while (in.hasNext()) {
                String str = in.next().toLowerCase();
                if (str.endsWith(".") || str.endsWith("?") || str.endsWith(",") || str.endsWith(":") || str.endsWith(")"))
                    str = str.substring(0, str.length() - 1);
                if (str.startsWith("("))
                    str = str.substring(1);
                if ((count = wordCounter.getOrDefault(str, -1)) == -1)
                    wordCounter.put(str, 1);
                else
                    wordCounter.replace(str, count + 1);
                }
                inStream.close();
                in.close();
        }
        catch(Exception e) 
        {
            System.out.println("Error while opening file: "+dataFile);
        }   
    }
    public void write(String outputFile) {
        File f = new File(outputFile);
        try {
            if(!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(f, false);
            PrintWriter out = new PrintWriter(outStream);
            out.print(wordCounter);
            out.flush();
            outStream.close();
        }
        catch(Exception e) 
        {
            System.out.println("Error while opening file: "+outputFile);
        }   
    }
}
