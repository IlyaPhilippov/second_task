import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

    class tests {

        @Test
        void getLRflag() {
            Starter start1 = new Starter(new String[]{"-d", "test/123test123/", "abc.txt"});
            assertFalse(start1.getRflag());

            Starter start2 = new Starter(new String[]{"-d", "test/123test123/", "-r", "privet.txt"});
            assertTrue(start2.getRflag());
        }

        @Test
        void getDirectory() {
            Starter start1 = new Starter(new String[]{"-d", "test/123test123/", "abc.txt"});
            assertEquals("test/123test123/", start1.getDir());

            Starter start2 = new Starter(new String[]{"-r", "-d", "test/123test123", "privet.txt"});
            assertEquals("test/123test123", start2.getDir());
        }

        @Test
        void getFilename() {
            Starter start1 = new Starter(new String[]{"-d", "test/123test123/", "privet.txt"});
            assertEquals("privet.txt", start1.getFilename());

            Starter start2 = new Starter(new String[]{"-r", "-d", "test/123test123/task2test", "test1.txt"});
            assertEquals("test1.txt", start2.getFilename());
        }

        @Test
        void find() {
            List<File> answer = new Finder(false, "test/123test123/task2test", "test1.txt").find();
            List<File> list2 = new ArrayList<>();
            list2.add(new File("test/123test123/task2test/test1.txt"));
            assertEquals(list2, answer);

            List<File> answerR = new Finder(true, "test/123test123/", "privet.txt").find();
            List<File> list3 = new ArrayList<>();
            list3.add(new File("test/123test123/privet.txt"));
            list3.add(new File("test/123test123/task2test/privet.txt"));
            assertEquals(list3, answerR);
        }
    }

