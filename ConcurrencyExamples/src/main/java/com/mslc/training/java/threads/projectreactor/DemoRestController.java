//package com.mslc.training.java.threads.projectreactor;
//
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//import java.time.Duration;
//
//@RestController
//public class DemoRestController {
//
//
//    @GetMapping(path = "/demo", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE})
//    public Flux<Long> handleDemo() {
//
//        System.out.println("Thread : " + Thread.currentThread().getName() + " has handled the request...");
//
//        Flux f = Flux
//                .interval(Duration.ofSeconds(1))
//                .take(10)
//                .map(x -> x + 1)
//                .log();
//
//        System.out.println("Thread : " + Thread.currentThread().getName() + " is leaving....");
//        return f;
//    }
//}
