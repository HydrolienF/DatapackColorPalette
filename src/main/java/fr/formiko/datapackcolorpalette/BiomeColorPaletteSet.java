package fr.formiko.datapackcolorpalette;

public class BiomeColorPaletteSet {
    private BiomeColorPalette[] palettes;
    public BiomeColorPaletteSet() { palettes = new BiomeColorPalette[4]; }

    public BiomeColorPaletteSet spring(BiomeColorPalette palette) {
        palettes[0] = palette;
        return this;
    }
    public BiomeColorPaletteSet summer(BiomeColorPalette palette) {
        palettes[1] = palette;
        return this;
    }
    public BiomeColorPaletteSet autumn(BiomeColorPalette palette) {
        palettes[2] = palette;
        return this;
    }
    public BiomeColorPaletteSet winter(BiomeColorPalette palette) {
        palettes[3] = palette;
        return this;
    }

    public BiomeColorPalette spring() { return palettes[0]; }
    public BiomeColorPalette summer() { return palettes[1]; }
    public BiomeColorPalette autumn() { return palettes[2]; }
    public BiomeColorPalette winter() { return palettes[3]; }
}
