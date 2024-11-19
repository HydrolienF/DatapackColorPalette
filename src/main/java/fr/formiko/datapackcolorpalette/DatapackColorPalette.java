package fr.formiko.datapackcolorpalette;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;;;

public class DatapackColorPalette {

    public static void biomeColorToPng(String biomesJsonsPath, Collection<String> excludedStrings) {
        Map<String, BiomeColorPaletteSet> biomeColorPalettes = new HashMap<>();

        File path = new File(biomesJsonsPath);
        for (File file : path.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".json")) {
                String name = file.getName().replace(".json", "");
                // Open with jackson
                ObjectMapper mapper = new ObjectMapper();
                try (InputStream is = new FileInputStream(file)) {
                    JsonNode jsonNode = mapper.readTree(is);
                    //@formatter:off
                    BiomeColorPalette biomeColorPalette = new BiomeColorPalette()
                        .paletteName(name)
                        .skyColor(jsonNode.at("/effects/sky_color").asInt())
                        .foliageColor(jsonNode.at("/effects/foliage_color").asInt())
                        .grassColor(jsonNode.at("/effects/grass_color").asInt())
                        .waterColor(jsonNode.at("/effects/water_color").asInt())
                        .waterFogColor(jsonNode.at("/effects/water_fog_color").asInt())
                        .fogColor(jsonNode.at("/effects/fog_color").asInt());
                    //@formatter:on
                    // biomeColorPalette.saveAsPng();
                    // biomeColorPalettes.add(biomeColorPalette);

                    if (name.endsWith("_spring")) {
                        String nameWithoutSeason = name.replace("_spring", "");
                        if (biomeColorPalettes.containsKey(nameWithoutSeason)) {
                            biomeColorPalettes.get(nameWithoutSeason).spring(biomeColorPalette);
                        } else {
                            biomeColorPalettes.put(nameWithoutSeason, new BiomeColorPaletteSet().spring(biomeColorPalette));
                        }
                    } else if (name.endsWith("_summer")) {
                        String nameWithoutSeason = name.replace("_summer", "");
                        if (biomeColorPalettes.containsKey(nameWithoutSeason)) {
                            biomeColorPalettes.get(nameWithoutSeason).summer(biomeColorPalette);
                        } else {
                            biomeColorPalettes.put(nameWithoutSeason, new BiomeColorPaletteSet().summer(biomeColorPalette));
                        }
                    } else if (name.endsWith("_autumn")) {
                        String nameWithoutSeason = name.replace("_autumn", "");
                        if (biomeColorPalettes.containsKey(nameWithoutSeason)) {
                            biomeColorPalettes.get(nameWithoutSeason).autumn(biomeColorPalette);
                        } else {
                            biomeColorPalettes.put(nameWithoutSeason, new BiomeColorPaletteSet().autumn(biomeColorPalette));
                        }
                    } else if (name.endsWith("_winter")) {
                        String nameWithoutSeason = name.replace("_winter", "");
                        if (biomeColorPalettes.containsKey(nameWithoutSeason)) {
                            biomeColorPalettes.get(nameWithoutSeason).winter(biomeColorPalette);
                        } else {
                            biomeColorPalettes.put(nameWithoutSeason, new BiomeColorPaletteSet().winter(biomeColorPalette));
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        BiomeColorPalette.saveAllAsPng(biomeColorPalettes);
    }
    public static void biomeColorToPng(String biomesJsonsPath) { biomeColorToPng(biomesJsonsPath, Set.of()); }
    public static void pngToBiomeColor(String biomesJsonsPath, Collection<String> excludedStrings) {
        System.out.println("pngToBiomeColor");
    }
    public static void pngToBiomeColor(String biomesJsonsPath) { pngToBiomeColor(biomesJsonsPath, Set.of()); }
}
