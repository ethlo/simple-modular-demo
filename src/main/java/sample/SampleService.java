package sample;

import com.ethlo.time.ITU;

import java.time.OffsetDateTime;

public class SampleService {
    public OffsetDateTime parse(String input) {
        return ITU.parseDateTime(input);
    }
}
