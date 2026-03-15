package Design_Patterns.Behavioural_Patterns.Command_Pattern;
import java.util.*;


// receiver bank
class BankAccount {
    private double totalAmount;

    public BankAccount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void withDrawAmount(double curAmount) {
        if (curAmount > totalAmount) {
            System.out.println("unsufficient amount");
            return;
        }
        totalAmount -= curAmount;
        System.out.println(curAmount + " has been removed from bank");
    }

    public void depositAmount(double curAmount) {
        totalAmount += curAmount;
        System.out.println(curAmount + " has been added in bank");
    }

    public double getBalance() {
        return totalAmount;
    }
}

// command interface
interface ICommand {
    public void execute();
    public void unexecute();
}

// command concrete class
class WithdrawCommand implements ICommand {
    private BankAccount bankAccount;
    private double amount;

    public WithdrawCommand(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public void execute() {
        this.bankAccount.withDrawAmount(amount);
    }

    public void unexecute(){
        this.bankAccount.depositAmount(amount);
    }
}

// command concrete class
class DepositAmount implements ICommand {
    private BankAccount bankAccount;
    private double amount;

    public DepositAmount(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public void execute() {
        this.bankAccount.depositAmount(amount);
    }

    public void unexecute(){
        this.bankAccount.withDrawAmount(amount);
    }
}

// Invoker class
class ATM {
    private ArrayList<ICommand> commandData;

    public ATM(){
        commandData=new ArrayList<>();
    }

    public void executeCommand(ICommand command) {
        command.execute();
        commandData.add(command);
    }

    public void undoLastCommand(){
        if(commandData.isEmpty()){
            System.out.println("There are no commands to undo");
            return;
        }
        ICommand lastCommand=commandData.getLast();
        lastCommand.unexecute();
        commandData.remove(lastCommand);
    }

}

// client code
class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0);

        ATM atm = new ATM();

        System.out.println("available balance " + bankAccount.getBalance());
        atm.executeCommand(new WithdrawCommand(bankAccount, 200.0));
        System.out.println("available balance " + bankAccount.getBalance());
        atm.undoLastCommand();
        System.out.println("available balance " + bankAccount.getBalance());
        atm.undoLastCommand();
    }
}