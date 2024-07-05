public class Oops{
    public static void main(String args[]){
        //System.out.println("Hello");
        
        /*Pen p1=new Pen(); 
        p1.SetColor("Black");
        p1.SetTip(1);
        System.out.println(p1.color);
        System.out.println(p1.tip);*/

        /*BankAccount b1=new BankAccount();
        b1.username="Jayesh";
        System.out.println(b1.username);
        //b1.password="xyz";
        b1.SetPassword("abc");
        System.out.println(b1.GetPassword());*/

        
        /*Student s=new Student("Jayesh", 46);
        System.out.println(s.name);
        System.out.println(s.roll);
        Student s1=new Student();
        Student s2=new Student("Dnyanadev");
        Student s3=new Student(17);
        System.err.println(s2.name);
        System.err.println(s3.roll);*/

        /*Student s=new Student("Jayesh", 46);
        System.out.println(s.name);
        System.out.println(s.roll);
        s.marks[0]=100;
        s.marks[1]=90;
        s.marks[2]=80;
        Student s1=new Student(s); // passing object as argument 
        
        System.err.println(s1.name);
        System.err.println(s1.roll);
        
        for(int i=0;i<=s1.marks.length;i++){
            System.err.println(s1.marks[i]);
        }*/ 

        //Inheritance 
        //Fish shark=new Fish();
        //shark.eat();

        /*Dog d=new Dog();
        d.eat(); 
        d.legs=4;
        System.err.println(d.legs);*/ 

        Horse h=new Horse();
        h.eat();
        h.walk();
        System.err.println(h.color);

        Chicken c =new Chicken();
        c.eat();
        c.walk();
        System.err.println(c.color);

    }
}

class Pen{
    String color;
    int tip;

    void SetColor(String color){
        this.color=color;
    }

    void SetTip(int tip){
        this.tip=tip;
    }
}

/*class Student{
    String name;
    int roll_no;
    float percentage;

    void CalPercentage(int math,int phy,int che){
        percentage=(math+phy+che)/3;
    }

}*/

class BankAccount{
    public String username;
    private String password;

    public void SetPassword(String pwd){
        this.password=pwd;  //this keyword is used to reffer the curent object 
    }

    public String GetPassword(){
        return password;
    }
}

class Student{
    String name;
    int roll;
    int marks[];
    
    //constructor 
    Student(String name,int roll){
        marks=new int[3];
        System.out.println("Construcotor is called....");
        this.name=name;
        this.roll=roll;
    }

    //constructor overloading
    Student(){
        System.out.println("Construcotor is called....");
    }
    
    Student(int roll){
        this.roll=roll;
    }

    Student(String name){
        this.name=name;
    }

    //copy constructor 

    //1.Shallow constructor
    /*Student(Student s){
        marks=new int[3];
        this.name=s.name;
        this.roll=s.roll;
        this.marks=s.marks;
    }*/

    //2.Deep constructor 
    Student(Student s){
        marks=new int[3];
        this.name=s.name;
        this.roll=s.roll;
        for(int i=0;i<marks.length;i++){
            this.marks[i]=s.marks[i];
        }
    }
}


//Inheritance
/*class Animal{
    String color;

    void eat(){
        System.err.println("eats");
    }

    void breathe(){
        System.err.println("breathes");
    }
}*/


/*class Fish extends Animal{
    int fins;

    void swim(){
        System.err.println("Swim");
    }
}*/

//Multilevel Inheritance
/*class Mammels extends Animal{
    int legs;
}

class Dog extends Mammels{
    String breed;
}*/ 



//Abstraction

abstract class Animal{ 
    String color;

    Animal(){
        System.err.println("Animal constructor called..");
        color="Brown";
    }

    void eat(){
        System.err.println("eats");
    }

    abstract void walk();  //Gives idea about implimentation
} 

class Horse extends Animal{
    String color;

    Horse(){
        System.err.println("Horse constructor called..");
        color="Black";
    }

    void walk(){
        System.err.println("Walks on 4 legs");
    }
}

class Chicken extends Animal{
    String color;

    Chicken(){
        System.err.println("Chicken constructor is called..");
        color="Yellow";
    }

    void walk(){
        System.out.println("Walks on 2 legs");
    }
}











