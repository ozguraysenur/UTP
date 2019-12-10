import com.sun.org.apache.xerces.internal.impl.xs.SchemaNamespaceSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UtilityZip {
    public static List<String> searchwithName(ZipFile zipi,final  String name) {

        ZipFile zip = null;
        try {
           // zip = new ZipFile(zipi.get);
            List<String> names =zipi
                    .stream()
                    .filter(e -> namepredicate(e,name))
                    .map(e->((ZipEntry) e).getName())
                    .collect(Collectors.toList());
            zipi.close();
            return names;
        } catch (IOException e) {
           return null;
        }

    }
    public static boolean namepredicate(ZipEntry entry,String name){
        return entry.getName().contains(name);
    }
    public static List<String> searchwitContent(ZipFile zipFile, String content) throws IOException {

        List<String> names =zipFile
                .stream()
                .filter(e -> contentpredicate(e,content,zipFile))
                .map(x->((ZipEntry) x).getName())
                .collect(Collectors.toList());
        zipFile.close();
        return names;
    }
    public static boolean contentpredicate(ZipEntry entry,String content ,ZipFile zip){
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
