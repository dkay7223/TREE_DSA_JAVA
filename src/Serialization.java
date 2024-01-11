import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Serialization {


    public static AVLDictionary read() {
        AVLDictionary dictionary=new AVLDictionary();
        try {
            File myObj = new File("Dictionary.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] line = data.split(",");
                try {
                    String spell = line[0];
                    String meaning = line[1];

                    Word w=new Word(spell,meaning);

                    dictionary.insert(w);
                } catch (NumberFormatException e) {
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return dictionary;
    }



}
