package DIP;

// Business Logic
class BusinessLogicPlanService {
    IRepository repository;  

    public BusinessLogicPlanService(IRepository repository){ 
        this.repository=repository;  
    }

    // Define WHAT to do
    public void UpdateThePlanAndSave(){
        // 1. verify plan
        // 2. Update Plan
        // 3. save plan
        repository.savePlan();    
    }
}


interface IRepository{
    public void savePlan();
}


// Implementation logic
class MySQLRepository implements IRepository{
    // defines HOW to do
    public void savePlan(){
        System.out.print("Saving the plan");
    }
}

class MongoDbRepository implements IRepository{
    // defines HOW to do
    public void savePlan(){
        System.out.print("Saving the plan");
    }
}


