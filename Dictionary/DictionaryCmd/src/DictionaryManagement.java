import java.io.*;
import java.util.Scanner;


public class DictionaryManagement {

    Scanner sc = new Scanner(System.in);
    /**
     * Method insertFromCommandline():
     *  chức năng nhập liệu.
     */

    public void insertFromCommandline() {
        System.out.print("Nhap vao so luong tu vung tieng Anh can them: ");
        int num = sc.nextInt();
        sc.nextLine();
        while (num <= 0) {
            System.out.println("So luong tu khong hop le, vui long nhap lai!");
            num = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < num; i++) {
            Word word = new Word();
            System.out.print("Nhap vao tu tieng Anh: ");
            word.setWord_target(sc.nextLine());
            System.out.print("Nhap vao dinh nghia tieng Viet: ");
            word.setWord_explain(sc.nextLine());
            Dictionary.words.add(word);
            System.out.println("------------------------------------------------------");
        }
    }
    /**
     * Method insertFromFile():
     *  chức năng nhập dữ liệu từ điển từ tệp dictionaries.txt.
     */

    public void insertFromFile() {
        BufferedReader bufferedReader = null;
        try {
            FileReader file = new FileReader(
                    "C:/Users/thanh/IdeaProjects/DictionaryCmd/src/dictionaries.txt");
            bufferedReader = new BufferedReader(file);
            String strLine = bufferedReader.readLine();
            while (strLine != null) {
                Word word = new Word();
                word.setWord_target(strLine.substring(0, strLine.indexOf("\t")));
                word.setWord_explain(strLine.substring(strLine.indexOf("\t") + 1));
                Dictionary.words.add(word);
                strLine = bufferedReader.readLine();
            }
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

    public void  dictionaryLookup() {
        System.out.print("Nhap vao tu can tra cuu: ");
        String input = sc.nextLine();
        for (Word word : Dictionary.words) {
            if (word.getWord_target().equals(input)) {
                System.out.println("Tu can tra cuu: " + word.getWord_target());
                System.out.println("Nghia cua tu: " + word.getWord_explain());
                return;
            }
        }
        System.out.println("Tu can tra cuu khong co trong tu dien");
    }
    // TODO: Thêm từ

    public void dictionaryAddWord() {
        Word word = new Word();
        System.out.print("Nhap vao tu tieng Anh can them: ");
        String newWord = sc.nextLine();
        for (int i = 0; i < Dictionary.words.size(); i++) {
            if(Dictionary.words.get(i).getWord_target().equals(newWord)) {
                System.out.println("Tu can them da co trong tu dien!");
                return;
            }
        }
        word.setWord_target(newWord);
        System.out.print("Nhap vao đinh nghia tieng Viet cua tu: ");
        word.setWord_explain(sc.nextLine());
        Dictionary.words.add(word);
        System.out.println("Da them tu moi vao tu dien!");
    }
    //TODO: Sửa từ

    public void dictionaryAlterWord() {
        System.out.print("Nhap vao tu can thay the: ");
        String altWord = sc.nextLine();
        for (Word word : Dictionary.words) {
            if(word.getWord_target().equals(altWord)) {
                System.out.print("Nhap vao tu thay the: ");
                word.setWord_target(sc.nextLine());
                System.out.print("Nhap vao nghia tieng Viet sau khi thay the: ");
                word.setWord_explain(sc.nextLine());
                System.out.println("Da thay the tu!");
                return;
            }
        }
        System.out.println("Tu can thay the khong co trong tu dien!");
    }
    //TODO: Xóa từ

    public void dictionaryRemoveWord() {
        System.out.print("Nhap vao tu can xoa: ");
        String delWord = sc.nextLine();
        for (Word word : Dictionary.words) {
            if(word.getWord_target().equals(delWord)) {
                Dictionary.words.remove(word);
                System.out.println("Da xoa tu!");
                return;
            }
        }
        System.out.println("Tu can xoa khong co trong tu dien!");
    }
    /**
     * Method dictionaryExportToFile:
     *  chức năng xuất dữ liệu từ điển hiện tại ra files.
     */
    public void dictionaryExportToFile() {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter file = new FileWriter(
                    "C:/Users/thanh/IdeaProjects/DictionaryCmd/src/dictionaries.txt");
            bufferedWriter = new BufferedWriter(file);
            for (Word word : Dictionary.words) {
                bufferedWriter.write(word.getWord_target() + "\t" + word.getWord_explain());
                bufferedWriter.newLine();
            }
            System.out.println("Da xuat du lieu ra File!");
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
