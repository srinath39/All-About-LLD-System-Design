package LSP;


interface IBird{
    public void fly();
}

class Bird {
    
}

class Duck extends Bird implements IBird{
    public void fly(){
        System.out.println("I can fly");
    }
}


class Ostrich extends Bird implements IBird{
    public void fly(){
        System.out.println("I cannot fly");
    }
}



