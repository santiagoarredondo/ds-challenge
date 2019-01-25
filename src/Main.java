import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

 /*   private static final String INPUT_FILE = "C:\\Users\\sarredondo\\Functional-Programming\\DataStructuresa\\Data\\in\\input.txt";
    private static final String ENCODED_FILE = "C:\\Users\\sarredondo\\Functional-Programming\\DataStructuresa\\Data\\in\\encoded.txt";
    private static final String DECODED_FILE = "C:\\Users\\sarredondo\\Functional-Programming\\DataStructuresa\\Data\\in\\encoded.txt";
    private static final String OUTPUT_FILE = "C:\\Users\\sarredondo\\Functional-Programming\\DataStructuresa\\Data\\out\\output.txt";

    private static String readFile(String filePath){
        BufferedReader objReader = null;
        String text = "";
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(filePath));
            while ((strCurrentLine = objReader.readLine()) != null) {
                text+=strCurrentLine+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return text;
    }

    *//*
    private static void writeFile(String filePath, String fileContent){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(fileContent+"");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    *//*

    private static void writeFile(String filePath, String fileContent){
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            byte[] strToBytes = fileContent.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getNormalNotation(byte[] array){
        String text="";
        char currentChar;
        for (int i=0; i<array.length; i++){
            currentChar = (char)array[i];
            text+=currentChar;
        }
        System.out.println(text);
        return text;
    }

    public static String getBinaryNotation(byte[] array){
        String text="";
        char currentChar;
        for (int i=0; i<array.length; i++){
            currentChar = (char)array[i];
            text+=Integer.toBinaryString(currentChar)+"";
        }
        System.out.println(text);
        return text;
    }

    private static int[] toIntegerArray(byte[] array){
        int[] rta = new int[array.length];
        for (int i=0; i<array.length; i++){
            rta[i]=(int) array[i];
        }
        return rta;
    }

    public void loadData(){
        String fileText = readFile(DECODED_FILE);
        byte[] orig = fileText.getBytes();
        Huffman huf = new Huffman(orig);
        byte[] orig2 = huf.decode(readFile(ENCODED_FILE).getBytes());
        getNormalNotation(orig2);
    }

    public void saveData(){
        writeFile(INPUT_FILE,readFile(INPUT_FILE));
        writeFile(DECODED_FILE,readFile(DECODED_FILE));
    }

    public static void main(String[] args) {
        String fileText = readFile(INPUT_FILE);
        byte[] orig = fileText.getBytes();
        Huffman huf = new Huffman(orig);
        byte[] kood = huf.encode(orig);
        System.out.println("---- ENCODED ----");
        System.out.println("writing...");
        writeFile(ENCODED_FILE,getNormalNotation(kood));
        System.out.println("reading...");
        String encoded = readFile(ENCODED_FILE);
        System.out.println("end");
        byte[] orig2 = huf.decode(kood);
        System.out.println("---- DECODED ----");
        System.out.println("writing...");
        writeFile(DECODED_FILE,getNormalNotation(orig2));
        System.out.println("reading...");
        String decoded = readFile(DECODED_FILE);
        System.out.println(Arrays.equals(orig, orig2)); // must be equal: orig, orig2
        System.out.println("Length of encoded file: " + encoded.length());
        System.out.println("Lenght of decoded file: " + decoded.length());
    }*/

}
