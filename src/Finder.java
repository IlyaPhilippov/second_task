import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Finder {
    private List<File> files = new ArrayList<>();
    private boolean Rflag;
    private String directory;
    private String filename;

    public Finder(boolean flag, String dir, String file) {
        Rflag = flag;
        directory = dir;
        filename = file;
    }

    public List<File> find() {
        files.clear();
        if (Rflag) Rfinder(new File(directory));
        else finder();
        return files;
    }

    private void finder() {
        File dir = new File(directory);
        for(File item : dir.listFiles()){
            if (filename.equals(item.getName())) files.add(item);
        }
    }

    private void Rfinder(File directory) {
        for(File item : directory.listFiles()){
            if (item.isDirectory()) {
                Rfinder(item);
            }
            if (filename.equals(item.getName())) files.add(item);
        }
    }

}
