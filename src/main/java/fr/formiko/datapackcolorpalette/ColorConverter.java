package fr.formiko.datapackcolorpalette;

public class ColorConverter {
    /** convert from base 16 to base 10 */
    public static int toMinecraft(String color) { return Integer.parseInt(color, 16); }
    /** convert from base 10 to base 16 */
    public static String toHEX(int color) {
        String out = Integer.toHexString(color);
        if (out.length() < 6) {
            out = "0".repeat(6 - out.length()) + out;
        }
        return out;
    }
}
