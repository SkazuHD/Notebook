package medieninformatiker;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        Book note = new Book();
        note.clearScreen();

        System.out.println("Welcome im your personal Notebook");
        System.out.println("Restore Notebook from File? (Y/N)");
        if(input.nextLine().equals("Y")){
            note.clearScreen();
            note.loadEntry();

        }
        while (true){

            note.showOptions();

    }}


}