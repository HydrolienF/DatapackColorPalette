package fr.formiko.datapackcolorpalette;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ColorConverterTest {
    @ParameterizedTest
    @CsvSource({
        "000000, 0",
        "ffffff, 16777215",
        "77a8ff, 7842047"
    })
    void testToMinecraft(String in, int out){
        // return Integer.parseInt(color, 16);
        assertEquals(out, ColorConverter.toMinecraft(in));
    }
    @ParameterizedTest
    @CsvSource({
        "0, 000000",
        "16777215, ffffff",
        "7842047, 77a8ff"
    })
    void testToHEX(int in, String out){
        assertEquals(out, ColorConverter.toHEX(in));
    }
}
