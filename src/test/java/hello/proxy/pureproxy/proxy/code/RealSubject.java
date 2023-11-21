package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

/*
 * RealSubject는 Subject 인터페이스를 구현했다.
 * operation() 은 데이터 조회를 시뮬레이션 하기 위해 1초 쉬도록 했다.
 * 예를 들어서 데이터를 DB나 외부에서 조회하는데 1초가 걸린다고 생각하면 된다. 호출할 때마다 시스템에 큰 부하는 주는 데이터 조회라고 가정
 * */
@Slf4j
public class RealSubject implements Subject {
    @Override
    public String operation() {
        log.info("실제 객체 호출");
        sleep(1000);
        return "data";
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
