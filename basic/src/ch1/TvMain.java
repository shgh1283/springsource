package ch1;

public class TvMain {
    public static void main(String[] args) {
        // LgTv 사용
        // LgTv lgTv = new LgTv();

        // lgTv.setBritzSpeaker(new BritzSpeaker());

        // lgTv.powerOn();
        // lgTv.volumeUp();
        // lgTv.volumeDown();
        // lgTv.powerOff();

        // SamsungTv samsungTv = new SamsungTv();
        // samsungTv.setBritzSpeaker(new BritzSpeaker());
        // samsungTv.powerOn();
        // samsungTv.volumeUp();
        // samsungTv.volumeDown();
        // samsungTv.powerOff();

        TV tv = new SamsungTv();

        // ((SamsungTv) tv).setBritzSpeaker(new BritzSpeaker());

        tv = new LgTv();
        ((LgTv) tv).setSpeaker(new BritzSpeaker());

        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
