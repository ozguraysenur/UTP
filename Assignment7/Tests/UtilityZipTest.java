import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.junit.Assert.*;

public class UtilityZipTest {


    ZipFile zip = new ZipFile("C:\\Users\\aysen\\IdeaProjects\\Assignment7\\src\\zipim.zip");
    ZipEntry entry =zip.getEntry("text.txt");
    File z = new File("C:\\Users\\aysen\\IdeaProjects\\Assignment7\\text");
    File txt =new File("C:\\Users\\aysen\\IdeaProjects\\Assignment7\\src\\zipim.zip\\text.txt");

    public UtilityZipTest() throws IOException {
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void searchwithName() throws IOException {
        List<String> names = UtilityZip.searchwithName(zip,"text");
        Assert.assertEquals(1,names.size());

    }

    @Test
    public void searchwithContent() {
        List<String> content = null;
        try {
            content = UtilityZip.searchwitContent(zip,"heloooooo");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(0,content.size());

    }
}