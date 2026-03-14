package Design_Patterns.Creational_Patterns.Prototye_Pattern;

class UserProfile implements Cloneable {

    String name;
    String address;

    public UserProfile(int userId) {
        System.out.println("Loading from database...");
        this.name = "Ram";
        this.address = "Hyderabad";
    }

    public UserProfile clone() {
        return new UserProfile(this.name, this.address);
    }

    private UserProfile(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

UserProfile original = new UserProfile(1);

UserProfile u1 = original.clone();
UserProfile u2 = original.clone();
UserProfile u3 = original.clone();