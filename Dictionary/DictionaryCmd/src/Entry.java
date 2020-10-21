import java.util.Scanner;

public class Entry {

    // Main

    public static void main(String[] args) {
        DictionaryCommandline dictionaryCommandline = new DictionaryCommandline();
        Scanner input = new Scanner(System.in);
        System.out.println("1. DictionaryBasic\n2. DictionaryAdvanced");
        System.out.print("Nhap vao lua chon cua ban: ");
        int option = input.nextInt();
        while (option != 1 && option != 2) {
            System.out.println("Lua chon khong hop le, vui long nhap lai!");
            System.out.println("1. DictionaryBasic\n2. DictionaryAdvanced");
            System.out.print("Nhap vao lua chon cua ban: ");
            option = input.nextInt();
        }
        if (option == 1) {
            dictionaryCommandline.dictionaryBasic();
        } else if (option == 2) {
            dictionaryCommandline.dictionaryAdvanced();
        }
    }
}
