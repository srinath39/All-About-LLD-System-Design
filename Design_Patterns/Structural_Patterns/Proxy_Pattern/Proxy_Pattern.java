import java.util.*;

interface IDatabaseService{
    public String getUserById(int id);
}

class StudentService implements IDatabaseService{

    public StudentService(){
        // connect to the database
    }
    
    public String getUserById(int id){
        // get User by id from Database
        return "SRINATH";
    }
}

class ProxyService implements IDatabaseService{

    private IDatabaseService databaseService;
    private HashMap<Integer,String> cachedData;

    public ProxyService(IDatabaseService databaseService){
        this.databaseService=databaseService;
        this.cachedData=new HashMap<>();
    }

    public String getUserById(int id){
        if(cachedData.containsKey(id)){
            System.out.println("found data in cache");
            return cachedData.get(id);
        }
        String data=databaseService.getUserById(id);
        cachedData.put(id,data);
        System.out.println("was a cache miss , data received data from source");
        return data;
    }
}


class FrontendService {
    IDatabaseService databaseService;

    public FrontendService(IDatabaseService databaseService){
        this.databaseService=databaseService;
    }

    public String getStudentNameById(int id){
        return databaseService.getUserById(id);
    }
}

class Main{
    public static void main(String[] args){
        IDatabaseService studentService=new StudentService();

        IDatabaseService proxyService=new ProxyService(studentService);

        FrontendService frontendService=new FrontendService(proxyService);
        System.out.println(frontendService.getStudentNameById(10));
        System.out.println(frontendService.getStudentNameById(10));
    }
}
