import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class UtilityFileTest {
    public  File diir =new File("C:\\Users\\aysen\\IdeaProjects\\Assignment7\\dir");
    public File file =new File("dir\\hiii.txt");
    @Before public void before(){

    }

    @Test
    public void searchwithName() {
        List<String> filename =UtilityFile.searchwithName(diir,"hiii");
        Assert.assertEquals(1,filename.size());
        Assert.assertEquals("hiii.txt",file.getName());
    }

    @Test
    public void searchwithContent() {
        List<File> content =UtilityFile.searchwithContent(diir,"helooooo");
        Assert.assertEquals(0,content.size());


    }
}