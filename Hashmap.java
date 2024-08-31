import java.util.*;
public class Hashmap {
    
    public static String getStart(HashMap<String,String> h){
        HashMap<String,String> r=new HashMap<>();

        for(String key:h.keySet()){
            r.put(h.get(key),key);
        }

        for(String key:h.keySet()){
            if(!r.containsKey(key)){
                return key;
            }
        }

        return null;
    }

    public static void main(String[] args){
        //System.err.println("Hello world");
        HashMap<String,String> h=new HashMap<>();
        h.put("Chennai","Bengluru");
        h.put("Mumbai","Delhi");
        h.put("Goa","Chennai");
        h.put("Delhi","Goa");

        String start=getStart(h);
        System.out.print(start);
        for(String key:h.keySet()){
            System.out.print("-->"+h.get(start));
            start=h.get(start);
        }
        System.err.println();


        int[] arr ={15,2,-2,-8,1,7,10,23};

        HashMap<Integer,Integer> map=new HashMap<>();

        int sum=0;
        int len=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                len=Math.max(len,i-map.get(sum));
            }else{
                map.put(sum,i);
            }
        }

        System.out.println(len);


        int[] arr1 ={10,2,-2,-20,10};

        HashMap<Integer,Integer> map1=new HashMap<>();
        int k=-10;
        map1.put(0,1);

        sum=0;
        int ans=0;

        for(int i=0;i<arr1.length;i++){
            sum+=arr1[i];
            if(map1.containsKey(sum-k)){
                ans+=map1.get(sum-k);
            }

            map1.put(sum,map1.getOrDefault(sum, 0)+1);
        }

        System.out.println(ans);

    }
}
