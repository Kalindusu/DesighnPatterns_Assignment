// Bridge Pattern in Java

// Abstraction
abstract class RemoteControl {
    protected Device device;

    protected RemoteControl(Device device) {
        this.device = device;
    }

    public abstract void togglePower();
}

// Implementation interface
interface Device {
    void turnOn();
    void turnOff();
    boolean isOn();
}

// Concrete implementation for TV
class TV implements Device {
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Turning on the TV");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Turning off the TV");
    }

    @Override
    public boolean isOn() {
        return on;
    }
}

// Concrete implementation for Radio
class Radio implements Device {
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Turning on the Radio");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Turning off the Radio");
    }

    @Override
    public boolean isOn() {
        return on;
    }
}

// Refined abstraction for a Remote Control
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        if (device.isOn()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }
}

public class BridgeDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remoteControl = new BasicRemote(tv);

        remoteControl.togglePower(); // Output: Turning on the TV
        remoteControl.togglePower(); // Output: Turning off the TV

        Device radio = new Radio();
        remoteControl = new BasicRemote(radio);
        remoteControl.togglePower(); // Output: Turning on the Radio
        remoteControl.togglePower(); // Output: Turning off the Radio
    }
}
