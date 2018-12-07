package multithread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class allway {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<String,String>();
        map.put("生活用品","毛巾");
        map.put("生活用品","地毯");
        map.put("食品","火腿肠");
        map.put("食品","酸奶");
        map.put("清洁用品","洗面奶");
        System.out.println("***********************");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println("key="+entry.getKey()+"value:"+entry.getValue());
        }
        System.out.println("***********************");
        for(String key:map.keySet()){
            System.out.println("key:"+key);
        }
        for(String value:map.values()){
            System.out.println("value:"+value);
        }

        System.out.println("***********************");
        Iterator <Map.Entry<String,String>> entries=map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String,String> entry=entries.next();
            System.out.println("key="+entry.getKey()+"value:"+entry.getValue());
        }
        System.out.println("***********************");
        Map maps=new HashMap();
        Iterator enteies=map.entrySet().iterator();
        while (enteies.hasNext()){
            Map.Entry entry=(Map.Entry)enteies.next();
            String key=(String)entry.getKey();
            String value=(String)entry.getValue();
            System.out.println("key="+entry.getKey()+"value:"+entry.getValue());
        }
    }

}
