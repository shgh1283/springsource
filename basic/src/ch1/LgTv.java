package ch1;

// 변수
//     1) 멤버 변수 : 클래스 안에 선언된 변수
//                    객체인 경우 Null 로 초기화 됨
//                    기본 타입 변수인 경우 0 or '' or 0.0, false 초기화 됨 
//     2) 지역변수 : 메소드나 {} 안에 선언된 변수
//     3) 매개 변수 : powerOn(int x) => x를 부를 때

public class LgTv implements TV {

    // 멤버 변수(== 인스턴스 변수, 필드, 특성, 속성)
    private Speaker speaker;

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void powerOn() {
        System.out.println("SamsungTv - 전원 On");
    }

    @Override
    public void powerOff() {
        System.out.println("SamsungTv - 전원 Off");
    }

    @Override
    public void volumeUp() {
        // System.out.println("SamsungTv - 볼륨 On");
        speaker.volumeUp();
    }

    @Override
    public void volumeDown() {
        // System.out.println("SamsungTv - 볼륨 Down");
        speaker.volumeDown();
    }

}
