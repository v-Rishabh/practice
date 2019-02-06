package schibsted;

import java.util.*;
import java.io.*;

public class getFileName{

    private String path;

    getFileName(String path){
        this.path = path;
    }
    public ArrayList<String> returnNames(){
        ArrayList<String> al = new ArrayList<>();
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f : files){
            al.add(f.toString());
        }
        return al;
    }
}