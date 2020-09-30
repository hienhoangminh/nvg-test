package pages;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public abstract class AbstractPage {
    public abstract boolean isAt();

    public boolean isAt(long timeout, TimeUnit timeUnit) {
        try {
            await().atMost(timeout, timeUnit)
                    .ignoreExceptions()
                    .until(() -> isAt());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}