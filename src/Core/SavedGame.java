package Core;

import javax.swing.*;
import java.io.*;
// oyunu daha kolay kaydedebilmek icin oyunu serialize eden , dosyaya okuyup yazan siniftir.
public class SavedGame implements Serializable {
    private static final long serialVersionUID = 1L;
    public   JTextField[][] savedMatris ;
    public String equation ;
    public int currentLine;
    public int currentColumn;
    public int seconds;
   //public int [][] savedMatris ;

    public SavedGame() {//Constructor
        savedMatris = new JTextField[9][9];
        equation="";
        currentColumn=0;
        currentLine=0;
        seconds=0;
    }




    public static void writeGame(SavedGame s){
        String filename = "SavedGame.dat";
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filename));
            writer.writeObject(s);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SavedGame readGame(){
        String filename = "SavedGame.dat";
        File f = new File("SavedGame.dat");
        if(!f.exists()){
            return null;
        }
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename));
            SavedGame savedGame = (SavedGame) reader.readObject();
            reader.close();
            return savedGame;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            return null;
        }
        return null;
    }



}
