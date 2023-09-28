import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static boolean itLetter(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private static StringBuffer getStringBuffer(String line, int k, String substring) {
        StringBuffer str = new StringBuffer();
        StringBuffer newLine = new StringBuffer();
        char[] strChar = line.toCharArray();
        for (int i = 0; i < line.length(); i++){
            if (itLetter(strChar[i])){
                str.append(strChar[i]);
            } else {
                if (str.length() == k){
                    newLine.append(substring);
                } else {
                    newLine.append(str);
                }
                newLine.append(' ');
                str.delete(0, str.length());
            }
        }
        return newLine;
    }

    public static void main(String[] args) throws Exception{
        FileWriter fw = new FileWriter("output.txt");
        FileReader fr = new FileReader("input.txt");
        Scanner in = new Scanner(fr);
        String substring = in.nextLine();
        int k = in.nextInt();
        Vector <String> text = new Vector<>();
        while(in.hasNextLine()){
            String line = in.nextLine();
            line += ' ';
            StringBuffer newLine = getStringBuffer(line, k, substring);
            text.add(newLine.toString());
        }

        for(String lines: text){
            fw.write(lines + '\n');
        }
        fw.close();
        fr.close();
    }

}