package main;

import common.Common;
import mnk.Monkey;
import sha.SHA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<String> files = Common.getJavaFiles(args[0]);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            writer.write("filename; SHA; MNK\n");
            for(String file : files){
                int sha = SHA.calculateSHA(file);
                double mnk = Monkey.getMonkeyValue();
                writer.write(file+"; "+sha+"; "+mnk+"\n");
            }
            writer.flush();
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
