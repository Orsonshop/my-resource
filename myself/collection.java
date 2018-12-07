package myself;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class collection{
     Map<String,String> tastmap=new HashMap<String,String>();
    public void add(String a,String b){
        tastmap.put(a,b);
    }
    public collection(Map a){
        this.tastmap=a;
    }
    public void remove(String a,String b){
        tastmap.remove(a,b);

    }
    public void show(){
        Iterator iter= tastmap.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry entry= (Map.Entry) iter.next();
            String type= (String) entry.getKey();
            String name=(String)entry.getValue();
            System.out.println(type+"  "+name);
        }
    }
    public void show2(){
        for(Map.Entry<String,String> entry:tastmap.entrySet()){
            System.out.println(entry.getKey()+entry.getValue());
        }
    }
    public void find(String k){
        for(Map.Entry<String,String> entry:tastmap.entrySet()){
            if(entry.getKey()==k){
                System.out.println(entry.getValue());
            }
        }
    }
    public void turn(String k,String a){
        for(Map.Entry<String,String> entry:tastmap.entrySet()){
            if(entry.getValue()==k){
               tastmap.put(entry.getKey(),a);
            }
        }
    }
    public static void main(String[] args) {
        Map<String,String> tastmap=new HashMap<String,String>();
        collection my=new collection(tastmap);
        my.add("奶制品","牛奶");
        my.add("食品","饼干");
        my.add("玩具","小熊");
        my.add("家具","沙发");
        my.add("食品","火腿肠");
        my.show();
        my.remove("食品","饼干");
        my.show();
        my.show2();
        System.out.println("请输入要查询的类别");
        my.find("食品");
        my.turn("沙发","螺丝刀");
        my.show2();

    }
}
