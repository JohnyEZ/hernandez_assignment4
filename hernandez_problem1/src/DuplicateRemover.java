package src;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;


public class DuplicateRemover {
    private HashSet<String> uniqueWords;

    public DuplicateRemover() {
        uniqueWords = new HashSet<>();
    }
    public void remove(String dataFile) {
        try{
            uniqueWords = new HashSet<>();
            FileInputStream inStream = new FileInputStream(dataFile);
            Scanner in = new Scanner(inStream);
            while (in.hasNext()) {
                String str = in.next().toLowerCase();
                if (str.endsWith(".") || str.endsWith("?") || str.endsWith(",") || str.endsWith(":") || str.endsWith(")"))
                    str = str.substring(0, str.length() - 1);
                if (str.startsWith("("))
                    str = str.substring(1);
                uniqueWords.add(str);
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
        try{
            if(!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(f, false);
            PrintWriter out = new PrintWriter(outStream);
            for (String word: uniqueWords) {
                out.print(word + " ");
            }
            out.flush();
            outStream.close();
        }
        catch(Exception e) //if we encounter any exception while writing
        {
            System.out.println("Error while writing to file: "+outputFile);
        }
    }
}
