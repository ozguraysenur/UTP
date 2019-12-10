import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class UtilityJar {
    public static List<String> searchwithName(File file, String name) throws IOException {
        if(!file.isFile()){
            return null;
        }
        JarFile zip =new JarFile(file);
        List<String> names =zip
                .stream()
                .filter(e -> namepredicate(e,name))
                .map(e->((JarEntry) e).getName())
                .collect(Collectors.toList());
        zip.close();

        return names;
    }
    public static boolean namepredicate(JarEntry entry,String name){

        return entry.getName().contains(name);
    }
    public static List<String> searchwitContent(File directry, String content) throws IOException {
        if(!directry.isDirectory()){
            return null;
        }
        JarFile zip =new JarFile(directry);
        List<String> names =zip
                .stream()
                .filter(e -> contentpredicate(e,content,zip))
                .map(x->((JarEntry) x).getName())
                .collect(Collectors.toList());
        zip.close();
        return names;
    }
    public static boolean contentpredicate(JarEntry entry,String content ,JarFile zip){
        try {

            InputStream in =zip.getInputStream(entry);
            Scanner scanner =new Scanner(in);
            String cont =scanner.findWithinHorizon(content,(int)entry.getSize());
            scanner.close();
            return cont !=null;

        } catch (IOException e) {
            return false;
        }
    }
}
