package LSP;

class Bird {
    public void fly(){
        System.out.println("I can fly");
    }
}

class Ostrich extends Bird{
    @Override
    public void fly(){
        System.out.println("I cannot fly");
    }
}

class Main{
    public static void main(String args[]){

        // Bird object 
        Bird bird=new Bird();
        makeBirdFly(bird);   // "I can fly"

        // Ostrich Object with parent class Reference Variable
        Bird bird_OSBird=new Ostrich();
        makeBirdFly(bird_OSBird);    // "I cannot fly"
    }


    public static void makeBirdFly(Bird bird){  
        // the expection of this class is, it need to execute the method which is in Parent class
        // Irrespective of whatever the child object is 
        bird.fly();
    }
}


