package driverFactory;

import lombok.Data;
import lombok.Getter;

public enum DriverType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    IE("ie");

    @Getter
    private String type;


    DriverType(String type) {
        this.type = type;
    }
}
