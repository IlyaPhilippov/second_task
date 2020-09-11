public class Starter {

    private boolean Rflag = false;
    private String filename;
    private String[] input;
    private String dir = ".";

    public Starter(String[] args) {
        input = args;
        start();
    }
    private void start() {
        if (input.length < 1) throw new IllegalArgumentException("Missing filename");
        if (input.length > 4) throw new IllegalArgumentException("Too many arguments");
        int i;
        for (i = 0; i < input.length - 1; i++) {
            switch (input[i]) {
                case "-d":
                    dir = input[i + 1];
                    i++;
                    break;
                case "-r":
                    Rflag = true;
                    break;
            }

        }
        if (i != input.length - 1) throw
                new IllegalArgumentException("Missing filename");
        filename = input[input.length - 1];
    }

    public boolean getRflag() {
        return Rflag;
    }
    public String getFilename() {
        return filename;
    }
    public String getDir() {
        return dir;
    }


}