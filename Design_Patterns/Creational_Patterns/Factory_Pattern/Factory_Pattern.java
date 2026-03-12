// whenever you want to create an object in a client code , but want to avoid client 
// being tightly coupled to the object class
// we need to use factory pattern

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


interface INotification {
    public void sendNotification();
}

class SmsNotification implements INotification {
    public void sendNotification() {
        System.out.println("Sending sms notification");
    }
}

class EmailNotification implements INotification {
    public void sendNotification() {
        System.out.println("Sending Email notification");
    }
}


// completely voilates Voilates OCP 
// class NotificationFactory {
//     public static INotification getNotificationObject(String type){
//         INotification notification=null;
//         switch (type) {
//             case "SMS":
//                 notification=new SmsNotification();
//                 break;
//             case "EMAIL":
//                 notification=new EmailNotification();
//                 break;
//             default:
//                 break;
//         }
//         return notification;
//     }
// }


// factory class which almost follows OCP 
class NotificationFactory {

    private static Map<String, Supplier<INotification>> registry = new HashMap<>();

    static {
        registry.put("EMAIL", EmailNotification::new);
        registry.put("SMS", SmsNotification::new);
    }

    public static INotification create(String type) {
        Supplier<INotification> supplier = registry.get(type);

        if(supplier != null){
            return supplier.get();
        }

        return null;
    }
}

// note: Instead of using Hard coded text here , we usually use ENUMS  


class Main {
    public static void main(String[] args) {
        // SmsNotification notification=new SmsNotification(); // avoid this
        INotification notification=NotificationFactory.create("EMAIL");
        notification.sendNotification();
    }
}