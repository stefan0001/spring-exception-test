package test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MyModel {
    String name;
    boolean throwException = false;

    @JsonProperty("foo")
    public String foo() {
        if (throwException) {
            throw new RuntimeException();
        }
        return "bar";
    }
}
