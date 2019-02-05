import java.io.*;
import java.util.*;

public class ReadFile{
    private HashMap<String,String> map = new HashMap<>();
    private ArrayList<String> pathList;
    ReadFile(ArrayList<String> list){
        pathList = list;
    }

    public void readAllFiles(){
		StringBuilder fileData = new StringBuilder();
        for(String path : pathList){
            //System.out.println("Data for file -> "+path);
            try{
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
                String line;
                ArrayList<String> list;
                while((line = br.readLine()) != null){
                    fileData.append(line);
                }
                br.close();
				map.put(path,fileData.toString());
				fileData.setLength(0);
            }
            catch(IOException e){
                System.out.println(e.toString());
            }
        }

        //map.forEach((X,Y)->{System.out.println(X+" "+Y);});

    }

    public HashMap<String,String> getData(){
        return map;
    }

}