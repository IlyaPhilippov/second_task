import java.io.File;
import java.util.List;

public class task2 {

    public static void main(String[] args) {
        try {
            Starter start = new Starter(args);
            boolean Rflag = start.getRflag();
            String directory = start.getDir();
            String filename = start.getFilename();
            List<File> list = new Finder(Rflag, directory, filename).find();
            for (File item : list) System.out.println(item);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
