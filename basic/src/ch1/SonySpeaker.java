package ch1;

public class SonySpeaker implements Speaker {

    @Override
    public void volumeUp() {

        System.out.println("SonySpeaker volumeUP");
    }

    @Override
    public void volumeDown() {

        System.out.println("SonySpeaker volumeDown");

    }

}
