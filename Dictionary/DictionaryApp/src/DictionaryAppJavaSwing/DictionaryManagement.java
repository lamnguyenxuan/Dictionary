package DictionaryAppJavaSwing;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class DictionaryManagement {
    public static boolean checkDigit(String word) {
        boolean check = true;
        if (word.equals("")) {
            check = false;
        } else {
            for (int i = 0; i < word.length(); i++) {
                for (int j = 48; j <= 57; j++) {
                    if (word.charAt(i) == j) {
                        check = false;
                       break;
                    }
                }
            }
        }
        return check;
    }

    Scanner sc = new Scanner(System.in);
    public void sortList() {
        Collections.sort(Dictionary.words, new Comparator<Word>() {
            public int compare (Word w1, Word w2) {
                return w1.getWord_target().compareTo(w2.getWord_target());
            }
        });
    }
    /**
     * Method insertFromFile():
     *  chức năng nhập dữ liệu từ điển từ tệp dictionaries.txt.
     */

    public void insertFromFile() {
        BufferedReader bufferedReader = null;
        try {
            FileReader file = new FileReader("dictionaries\\dictionaries.txt");
            bufferedReader = new BufferedReader(file);
            String strLine = bufferedReader.readLine();
            while (strLine != null) {
                Word word = new Word();
                word.setWord_target(strLine.substring(0, strLine.indexOf("\t")));
                word.setWord_explain(strLine.substring(strLine.indexOf("\t") + 1));
                Dictionary.words.add(word);
                strLine = bufferedReader.readLine();
            }
            sortList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //Tra cứu từ điển bằng dòng lệnh

    
    /**
     * Method dictionaryExportToFile:
     *  chức năng xuất dữ liệu từ điển hiện tại ra files.
     */
    public void dictionaryExportToFile() {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter file = new FileWriter("dictionaries\\dictionaries.txt");
            bufferedWriter = new BufferedWriter(file);
            for (Word word : Dictionary.words) {
                bufferedWriter.write(word.getWord_target() + "\t" + word.getWord_explain());
                bufferedWriter.newLine();
            }
            sortList();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
