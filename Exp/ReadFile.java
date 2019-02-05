import java.io.*;
import java.util.*;

public class ReadFile{
    private HashMap<String, ArrayList<String>> map = new HashMap<>();
    private ArrayList<String> pathList;
    ReadFile(ArrayList<String> list){
        pathList = list;
    }

    public void readAllFiles(){
        for(String path : pathList){
            //System.out.println("Data for file -> "+path);
            try{
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
                String line;
                ArrayList<String> list;
                while((line = br.readLine()) != null){
                    //System.out.println(line);
                    if(map.containsKey(path)){
                        list = map.get(path);
                        list.add(line);
                    }
                    else{
                        list = new ArrayList<String>();
                        list.add(line);
                        map.put(path, list);
                    }
                    
                }
                br.close();
            }
            catch(IOException e){
                System.out.println(e.toString());
            }
        }

        //map.forEach((X,Y)->{System.out.println(X+" "+Y);});

    }

    public HashMap<String,ArrayList<String>> getData(){
        return map;
    }

}