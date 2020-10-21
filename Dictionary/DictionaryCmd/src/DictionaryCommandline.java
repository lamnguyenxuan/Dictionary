import java.util.Scanner;

public class DictionaryCommandline {

    Scanner sc = new Scanner(System.in);
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    /**
     * Method showAllWords:
     *  chức năng  hiển thị kết quả danh sách dữ liệu từ điển
     * trên màn hình.
     */

    public void showAllWords() {
        System.out.printf("%-15s %-33s %-40s %n", "No", "|English", "|Vietnamese");
        for(int i = 0; i < Dictionary.words.size(); i++) {
            System.out.printf("%-15s %-33s %-40s %n", i + 1,
                    Dictionary.words.get(i).getWord_target(),
                    Dictionary.words.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }

    public void  dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        while(true) {
            System.out.println();
            System.out.printf("%-25s%-25s%-25s%-25s%n","1. Dictionary Lookup",
                    "2. Add Word", "3. Alter Word", "4. Remove Word");
            System.out.printf("%-25s%-25s%-25s%-25s%n","5. Search Word",
                    "6. Show All Words", "7. Export To File", "8. Exit");
            System.out.print("Nhap vao lua chon: ");
            int select = sc.nextInt();
            sc.nextLine();
            switch (select) {
                case 1: {
                    dictionaryManagement.dictionaryLookup();
                    break;
                }
                case 2: {
                    dictionaryManagement.dictionaryAddWord();
                    break;
                }
                case 3: {
                    dictionaryManagement.dictionaryAlterWord();
                    break;
                }
                case 4: {
                    dictionaryManagement.dictionaryRemoveWord();
                    break;
                }
                case 5: {
                    dictionarySearcher();
                    break;
                }
                case 6: {
                    showAllWords();
                    break;
                }
                case 7: {
                    dictionaryManagement.dictionaryExportToFile();
                    break;
                }
                case 8: {
                    return;
                }
                default:
                    System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        }

    }
    /**
     * Method dictionarySearcher:
     *  chức năng tìm kiếm các từ.
     */

    public void dictionarySearcher() {
        System.out.print("Nhap vao nhung ki tu bat đau cua cac tu can tim: ");
        String initialChars = sc.nextLine();
        int count = 0;
        for(Word word : Dictionary.words) {
            if(word.getWord_target().startsWith(initialChars)) {
                System.out.printf("%-40s %-40s %n", word.getWord_target(), word.getWord_explain());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong co tu nao bat dau voi " + initialChars);
        }
    }

}
