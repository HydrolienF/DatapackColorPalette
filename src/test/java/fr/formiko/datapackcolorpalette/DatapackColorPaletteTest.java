package fr.formiko.datapackcolorpalette;

import java.util.Set;
import org.junit.jupiter.api.Test;

public class DatapackColorPaletteTest {
    @Test
    void testBiomeColorToPng() {
        DatapackColorPalette.biomeColorToPng("src/test/resources/2", Set.of());
        // DatapackColorPalette.biomeColorToPng("/home/hydrolien/git/MvndiSeasons/datapacks/MvndiSeasons/data/mvndi/worldgen/biome/",
        // Set.of());
    }
}
