package medieninformatiker;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        Book note = new Book();
        note.clearScreen();
        note.loadEntry();
        System.out.println("Welcome im your personal Notebook");
        while (true){

            note.showOptions();

    }}


}