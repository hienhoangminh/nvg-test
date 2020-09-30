package constants;

import lombok.Getter;

public class AwsConstants {
    public enum Language {
        English("English"),
        Espanol("Espanol"),
        Deustch("Deustch");

        @Getter
        String name;

        Language(String language) {
            this.name = name;
        }
    }
}
