import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.io.*;
import java.lang.reflect.MalformedParametersException;
import java.net.URL;

public class GeneratorBuilder {

    static String generatorName;

    public static void main(String[] args) throws WrongNumberArgsException, IOException {

        args = new String[1];
        args[0] = "item";


        if(args.length == 1) {
            if(args[0].equals(args[0].toLowerCase())) {
                if(args[0].isEmpty()) {
                    throw new MalformedParametersException("Name is empty");
                }
                generatorName = args[0];

                File dir = getFileFromResources("BlankFiles");
                File[] files = dir.listFiles();
                for(File f: files) {
                    cloneFile(f);
                }

            }else{
                throw new MalformedParametersException("Name is not LowerCase");
            }
        }else {
            throw new WrongNumberArgsException("");
        }
    }
    static void cloneFile(File file) throws IOException {
        new File("CreatedFiles").mkdir();
        FileOutputStream stream = new FileOutputStream(new File("CreatedFiles", replaceXyz(file.getName())));
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String line = fileReader.readLine();
        while(line != null) {
            line = replaceXyz(line);

            stream.write(line.getBytes());
            stream.write(System.lineSeparator().getBytes());

            line = fileReader.readLine();
        }

    }
    static String replaceXyz(String toReplace) {
        toReplace = toReplace.replaceAll("xyz", generatorName);

        String camelCase = generatorName.toUpperCase().charAt(0) + generatorName.substring(1);
        toReplace = toReplace.replaceAll("Xyz",camelCase);

        toReplace = toReplace.replaceAll("XYZ", generatorName.toUpperCase());
        return toReplace;
    }

    private static File getFileFromResources(String fileName) {

        ClassLoader classLoader = GeneratorBuilder.class.getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
