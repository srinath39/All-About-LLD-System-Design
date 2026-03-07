package Design_Patterns.Creational_Patterns.Singleton_Pattern;

class DatabaseConnection {
    public static DatabaseConnection databaseConnection;

    private DatabaseConnection(){
        // i wont be allowing anyone to allow obect to this call direclty
    }

    public static DatabaseConnection getInstance(){
        if(databaseConnection==null){
            databaseConnection=new DatabaseConnection();
        }
        return databaseConnection;
    }
}

class Main{
    public static void main(String[] args){
        DatabaseConnection databaseConnection1=DatabaseConnection.getInstance();
        DatabaseConnection databaseConnection2=DatabaseConnection.getInstance();
        if(databaseConnection1.equals(databaseConnection2)){
            System.out.println("Both objects are same");
        }else{
            System.out.println("Both objects are not same");
        }
    }
}
