import javax.swing.text.html.StyleSheet;

public class Strings{
    
    public static boolean check_palindrom(String word){
        int i=0;
        int j=word.length()-1;
        while(i<j){
            if(word.charAt(i)!=word.charAt(j)){
                System.err.println("Not palindrom");
                return false;
            }
            i++;
            j--;
        }
        System.err.println("Palindrome");
        return true;
    }
    
    public static float shortest_path(String word){
        int x=0,y=0;
        for(int i=0;i<word.length();i++){
            char dir=word.charAt(i);
            if(dir =='S'){
                y--;
            }
            else if (dir =='N'){
                y++;
            }
            else if(dir =='E'){
                x++;
            }
            else if(dir =='W'){
                x--;
            }
        }
        int sx=x*x;
        int sy=y*y;
        return (float)Math.sqrt(sx+sy);
    }

    public static String capitalize(String str){
        StringBuilder st=new StringBuilder("");

        char ch=Character.toUpperCase(str.charAt(0));
        st.append(ch);

        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
                st.append(str.charAt(i));
                st.append(Character.toUpperCase(str.charAt(i+1)));
                i++;
                continue;
            }
            st.append(str.charAt(i));
        }

        //st.toString();
        return st.toString();
    }

    public static String compress(String str){
        StringBuilder newstr=new StringBuilder("");

        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1) ){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            if(count>1){
                newstr.append(count);
            }

            
        }
        return newstr.toString();
    }


    
    
    public static void main(String args[]){
        //System.out.println("Hello");
        //String word="mam";
        //check_palindrom(word); 
        //System.out.println(shortest_path("WNEENESENNN"));

        /*String fruits[]={"apple","mango","banana"};
        String largeString=fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largeString.compareTo(fruits[i])<0){
                largeString=fruits[i];
            }
        }
        System.err.println(largeString);*/

        StringBuilder str =new StringBuilder("Jayesh");
        System.out.println(str);

        /*for(char ch='a';ch<='z';ch++){
            str.append(ch);
        }*/
        
        /*Integer  a=10;
        a.toString();
        System.err.println(a);*/

        String word="aaabbccccddeeee";
        System.err.println(compress(word));


    }
}