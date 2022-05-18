import java.io.*;

public class IO {
    public void writeFile(Statistics s) throws java.io.IOException{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s.getFileName()+".bin"));
        oos.writeObject(s);
        oos.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(s.getFileName() + ".txt"));
        ;
        writer.write(s.getVictory() + "-" + s.getLosses() + "-" + s.getUnfinishedGames() + "-" + s.getAvgFinishAtLines()
                + "-" + s.getAvgSuccessTime());
        writer.close();
    }

    public void readFile(Statistics s) throws java.io.IOException,ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s.getFileName()+ ".bin"));
        s = (Statistics) ois.readObject();
        ois.close();
    }

}
