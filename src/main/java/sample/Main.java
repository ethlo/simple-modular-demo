package sample;

import com.ethlo.time.ITU;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(args).map(ITU::parseLenient).toList());
    }
}
