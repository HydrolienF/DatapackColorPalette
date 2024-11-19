package fr.formiko.datapackcolorpalette;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;
import java.util.Map;

public class BiomeColorPalette {
    private String paletteName;
    // private int skyColor;
    // private int foliageColor;
    // private int grassColor;
    // private int waterColor;
    // private int waterFogColor;
    // private int fogColor;
    private int colors[] = new int[6];

    public BiomeColorPalette() {
        paletteName = "";
        colors = new int[] {-1, -1, -1, -1, -1, -1};
    }

    public String paletteName() { return paletteName; }
    public int skyColor() { return colors[0]; }
    public int foliageColor() { return colors[1]; }
    public int grassColor() { return colors[2]; }
    public int waterColor() { return colors[3]; }
    public int waterFogColor() { return colors[4]; }
    public int fogColor() { return colors[5]; }


    public BiomeColorPalette paletteName(String paletteName) {
        this.paletteName = paletteName;
        return this;
    }
    public BiomeColorPalette skyColor(int skyColor) {
        this.colors[0] = skyColor;
        return this;
    }
    public BiomeColorPalette foliageColor(int foliageColor) {
        this.colors[1] = foliageColor;
        return this;
    }
    public BiomeColorPalette grassColor(int grassColor) {
        this.colors[2] = grassColor;
        return this;
    }
    public BiomeColorPalette waterColor(int waterColor) {
        this.colors[3] = waterColor;
        return this;
    }
    public BiomeColorPalette waterFogColor(int waterFogColor) {
        this.colors[4] = waterFogColor;
        return this;
    }
    public BiomeColorPalette fogColor(int fogColor) {
        this.colors[5] = fogColor;
        return this;
    }

    public int getBiomeColorWithAlpha(int index) { return colors[index] == -1 ? 0x00ffffff : colors[index]; }

    @Override
    public String toString() {
        return "BiomeColorPalette{" + "skyColor=" + skyColor() + ", waterColor=" + waterColor() + ", grassColor=" + grassColor()
                + ", foliageColor=" + foliageColor() + ", waterFogColor=" + waterFogColor() + ", fogColor=" + fogColor() + '}';
    }

    public void saveAsPng() {
        File file = new File("out/", paletteName + ".png");
        BufferedImage image = new BufferedImage(6, 1, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < 6; i++) {
            image.setRGB(i, 0, getBiomeColorWithAlpha(i));
        }
        try {
            javax.imageio.ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveAllAsPng(Collection<BiomeColorPalette> palettes) {
        File file = new File("all.png");
        int k = 0;
        int length = palettes.size();
        BufferedImage image = new BufferedImage(6, length, BufferedImage.TYPE_INT_RGB);

        for (BiomeColorPalette palette : palettes) {
            for (int i = 0; i < 6; i++) {
                image.setRGB(i, k, palette.getBiomeColorWithAlpha(i));
            }
            k++;
        }
        try {
            javax.imageio.ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveAllAsPng(Map<String, BiomeColorPaletteSet> palettes) {
        File file = new File("all.png");
        int k = 0;
        int length = palettes.size();
        BufferedImage image = new BufferedImage(6 * 2, length * 2, BufferedImage.TYPE_INT_ARGB * 2);

        for (BiomeColorPaletteSet set : palettes.values()) {
            for (int i = 0; i < 6; i++) {
                image.setRGB(i * 2, k * 2, set.spring().getBiomeColorWithAlpha(i));
                image.setRGB(i * 2 + 1, k * 2, set.summer().getBiomeColorWithAlpha(i));
                image.setRGB(i * 2, k * 2 + 1, set.autumn().getBiomeColorWithAlpha(i));
                image.setRGB(i * 2 + 1, k * 2 + 1, set.winter().getBiomeColorWithAlpha(i));
            }
            k++;
        }
        try {
            javax.imageio.ImageIO.write(image, "png", file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
