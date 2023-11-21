package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{
    
    // real 객체(프록시가 호출하는 대상)
    private Subject target;
    // 구한 값을 세팅하는 cacheValue
    private String cacheValue;

    public CacheProxy(Subject target){
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        // 만약 cacheValue의 값이 있다면 real 데이터는 호출되지 않음
        return cacheValue == null ? cacheValue = target.operation() : cacheValue;
    }
}
