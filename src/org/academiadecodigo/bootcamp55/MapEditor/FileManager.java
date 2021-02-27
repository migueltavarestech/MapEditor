package org.academiadecodigo.bootcamp55.MapEditor;

import java.io.*;

public class FileManager {

    private static final String FILE_PATH = "resources/map.txt";

    public static String readFile(){
        String result = "";
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line = bufferedReader.readLine();

            while(line != null){
                result += line + "\n";
                line = bufferedReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("IO Exception");
        } finally {
            try{
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return result;
    }

    public static void writeFile(String file){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH));
            writer.write(file);
            writer.close();
        } catch (IOException ex) {
            System.err.println("IO Exception");
        }
    }

}
