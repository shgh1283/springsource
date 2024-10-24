package ch1;

public class SamsungTv implements TV {

    // 멤버 변수(== 인스턴스 변수, 필드, 특성, 속성)
    private Speaker speaker;

    public void setBritzSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void powerOn() {
        System.out.println("LgTv - 전원 On");
    }

    @Override
    public void powerOff() {
        System.out.println("LgTv - 전원 Off");
    }

    @Override
    public void volumeUp() {
        // System.out.println("LgTv - 볼륨 On");
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        // System.out.println("LgTv - 볼륨 Down");
        speaker.volumeDown();
    }

}
