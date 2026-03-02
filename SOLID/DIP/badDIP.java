package DIP;

// Business Logic
class BusinessLogicPlanService {
    MySQLRepository mySQLRepository;  //  ->    MongoDbRepository mongoDbRepository;

    public BusinessLogicPlanService(){ 
        mySQLRepository=new MySQLRepository();  // ->   mongoDbRepository=new MongoDbRepository();
    }

    // Define WHAT to do
    public void UpdateThePlanAndSave(){
        // 1. verify plan
        // 2. Update Plan
        // 3. save plan
        mySQLRepository.savePlan();     // -> mongoDbRepository.savePlan()
    }
}


// Implementation logic
class MySQLRepository{
    // defines HOW to do
    public void savePlan(){
        System.out.print("Saving the plan");
    }
}

class MongoDbRepository{
    // defines HOW to do
    public void savePlan(){
        System.out.print("Saving the plan");
    }
}


