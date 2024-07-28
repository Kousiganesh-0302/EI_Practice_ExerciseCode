public class TV {
    private int currentChannel = 1;

    public void turnOn() {
        System.out.println("TV is on");
    }

    public void turnOff() {
        System.out.println("TV is off");
    }

    public void changeChannel(int channel) {
        currentChannel = channel;
        System.out.println("TV channel changed to " + currentChannel);
    }
}
