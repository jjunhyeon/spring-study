package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;


public class ProxyPatternTest {

    @Test
    void noProxyTest(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        // 총 3초의 시간 소요, clinet가 realsubject 조회
        client.execute();
        client.execute();
        client.execute();
    }

    /*
    * realSubject와 cacheProxy를 생성하고 둘을 연결한다.
    * 결과적으로 cacheProxy와 realSubject를 참조하는 런타임 객체 의존관계가 완성된다.
    * 그리고 마지막으로 client에 realSubject가 아닌 cacheProxy를 주입한다.
    * 이 과정을 통해 client -> cacheProxy -> realSubject 런타임 객체 의존 관계가 완성된다.
    * */
    @Test
    void cacheProxyTest(){
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
