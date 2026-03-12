import java.util.*;

interface IWheatherStation{
    public void addWhetherDataObservers(IWeatherObserver observer);
    public void removeWhetherDataObservers(IWeatherObserver observer);
    public void notifyObservers();
}


interface IWeatherObserver{
    public void updateTemp(float temp);
}

class WheatherStation implements IWheatherStation{
    private List<IWeatherObserver> observers;
    private float temp;

    public WheatherStation(){
        observers=new LinkedList();
    }

    public void addWhetherDataObservers(IWeatherObserver observer){
        observers.add(observer);
    }

    public void removeWhetherDataObservers(IWeatherObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(IWeatherObserver observer:observers){
            observer.updateTemp(this.temp);
        }
    }

    public void setTemperature(float temp){
        this.temp=temp;
        notifyObservers();
    }

    public float getTemperature(){
        return this.temp;
    }

}

class MobileApp implements IWeatherObserver{
    public void updateTemp(float temp){
        System.out.print("Temperature updated in Mobile App");
    }
}


class BillBoard implements IWeatherObserver{
    public void updateTemp(float temp){
        System.out.print("Temperature updated in Mobile App");
    }
}


class Main{
    public static void main(String[] args){
        IWeatherObserver app=new MobileApp();
        IWeatherObserver billBoard=new BillBoard();

        WheatherStation station=new WheatherStation();
        station.addWhetherDataObservers(app);
        station.addWhetherDataObservers(billBoard);

        station.setTemperature(30.78f);
    }
}