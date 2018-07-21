package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ksharma
 */
public class DuplicateFiles {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>>contentMap=new HashMap<>();
        for(String path:paths){
            String []files=path.split("\\s+");
            String dir=files[0];
            for(int i=1;i<files.length;i++){
                String file=files[i];
                int contentIndex=file.indexOf('(');
                String fileName=dir+"/"+file.substring(0,contentIndex);
                String content=file.substring(contentIndex+1,file.length());
                contentMap.putIfAbsent(content,new ArrayList<>());
                List<String>fPaths=contentMap.get(content);
                fPaths.add(fileName);
                contentMap.put(content,fPaths);
            }
        }
        List<List<String>>result=new ArrayList<>();
        for(List<String>files:contentMap.values()){
            if(files.size()>1){
                result.add(files);
            }
        }
        return result;
    }

    public static void main(String []args){
        DuplicateFiles df=new DuplicateFiles();
        String []input=
                {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
       String[][] Output=
               {{"root/a/2.txt","root/c/d/4.txt","root/4.txt"},{"root/a/1.txt","root/c/3.txt"}};
        System.out.println(df.findDuplicate(input));
    }
}
