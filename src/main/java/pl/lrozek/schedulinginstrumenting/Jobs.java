package pl.lrozek.schedulinginstrumenting;

import static java.util.concurrent.TimeUnit.SECONDS;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class Jobs {

    public static final long rate = 30;

    private final Tracer tracer;

    @Scheduled(fixedRate = rate, timeUnit = SECONDS)
    public void job1() {
        log("job1");
    }

    @Schedules({
            @Scheduled(initialDelay = 5, fixedRate = rate, timeUnit = SECONDS)
    })
    public void job2() {
        log("job2");
    }

    @Schedules({
            @Scheduled(initialDelay = 10, fixedRate = rate, timeUnit = SECONDS),
            @Scheduled(initialDelay = 15, fixedRate = rate, timeUnit = SECONDS),

    })
    public void job3() {
        log("job3");
    }

    private void log(String name) {
        log.info("{}: {}", name, tracer.currentSpan());
    }

}
