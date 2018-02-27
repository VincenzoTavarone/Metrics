package common;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Common {

    public static ArrayList<String> getJavaFiles(String path){
        ArrayList<String> files = new ArrayList<String>();
        File directory = new File(path);
        for(File file : directory.listFiles()){
            if(file.isDirectory()){
                files.addAll(getJavaFiles(file.getPath()));
            }else {
                if(file.getPath().endsWith(".java"))
                    files.add(file.getPath());
            }
        }

        Collections.sort(files);

        return files;
    }

}
