import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilityFile {
     static  final int length=255;
    static Path path;
    static File file;

    public static List<String> searchwithName(File directory ,String name){
        if(!directory.isDirectory()){
            return null;
        }
        Predicate<Path> isFile = Files::isRegularFile;
        Predicate<Path> byname = f -> f.getFileName().toString().equals(name);

        path= directory.toPath();
        try {
            Stream<Path> str = Files.walk(path);
            List<String> files =str.
                    filter(isFile.and(byname))
                    .map(x -> x.toString())
                    .collect(Collectors.toList());
            str.close();
            return files;

        }catch (IOException e) {
           return null;
        }

    }
    public static List<File> searchwithContent(File directory, String content){
        if(!directory.isDirectory()){
            return null;
        }
        Predicate<Path> isFile = Files::isRegularFile;



        path= directory.toPath();
        try {

            List<File> files =Files
                    .find(path,length,( p,att)->contain(path,content))
                    .map(p->p.toFile())
                    .filter(File::isFile)
                    .collect(Collectors.toList());

            return files;

        }catch (IOException e) {
            return null;
        }
    }
    public static boolean contain(Path path,final String content ){

           // File file =path.toFile();
        String line ;
        try {
            FileReader fReader = new FileReader(path.toFile());
            BufferedReader fileBuff = new BufferedReader(fReader);
            while ((line = fileBuff.readLine()) != null) {
                if(line.contains(content)){
                    return true;
                }
            }
            fileBuff.close();

            //return Files.lines(path).anyMatch(line -> line.contains(content));
        } catch (IOException e) {

        }
//        InputStream in = null;
//        try {
//            in = new FileInputStream(path.toFile());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Scanner scanner=new Scanner(in);
//            String result =scanner.findWithinHorizon(content ,(int) file.length());
//            scanner.close();
//            return result != null;
        return false;
    }

    public static void main(String[] args) {
        File diir =new File("C:\\Users\\aysen\\IdeaProjects\\Assignment7\\src\\hiii");
        String line;
        FileReader fReader = null;
        try {
            fReader = new FileReader(diir);

        BufferedReader fileBuff = new BufferedReader(fReader);
        while ((line = fileBuff.readLine()) != null) {
            if(line.contains("aysenur")){
                System.out.println("aysenur var");
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
