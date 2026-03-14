import java.util.*;

class WheatherStation {
    private float temp;
    private IObserveHelper observeHelper;

    public WheatherStation(IObserveHelper observeHelper){
        this.observeHelper=observeHelper;
    }

    public void setTemperature(float temp){
        this.temp=temp;
        observeHelper.notifyObservers(temp);
    }

    public float getTemperature(){
        return this.temp;
    }

}

interface IObserveHelper{
    public void addWhetherDataObservers(IWeatherObserver observer);
    public void removeWhetherDataObservers(IWeatherObserver observer);
    public void notifyObservers(float temp);
}

class ObserverHelper implements IObserveHelper{
    private List<IWeatherObserver> observers;

    public ObserverHelper(){
        observers=new LinkedList<>();
    }

    public void addWhetherDataObservers(IWeatherObserver observer){
        observers.add(observer);
    }

    public void removeWhetherDataObservers(IWeatherObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(float temp){
        for(IWeatherObserver observer:observers){
            observer.updateTemp(temp);
        }
    }
}

interface IWeatherObserver{
    public void updateTemp(float temp);
}

class MobileApp implements IWeatherObserver{
    public void updateTemp(float temp){
        System.out.println("Temperature updated in Mobile App with "+temp);
    }
}


class BillBoard implements IWeatherObserver{
    public void updateTemp(float temp){
        System.out.println("Temperature updated in Bill Board with "+temp);
    }
}


class Main{
    public static void main(String[] args){
        IWeatherObserver app=new MobileApp();
        IWeatherObserver billBoard=new BillBoard();

        IObserveHelper observeHelper=new ObserverHelper();
        observeHelper.addWhetherDataObservers(billBoard);
        observeHelper.addWhetherDataObservers(app);
    
        WheatherStation station=new WheatherStation(observeHelper);

        station.setTemperature(30.78f);
    }
}