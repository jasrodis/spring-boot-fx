package org.jasrodis.bootfx.gui.utils;

import java.io.InputStream;

import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

/**
 * Factory class for glyphs from Fontawesome library. <br>
 * <b>Usage example:</b>
 * 
 * <pre>
 * Glyph g = GlyphFactory.create(FontAwesome.Glyph.CLOSE);
 * g.setTextFill(Color.RED);
 * Button button = new Button("", g);
 * </pre>
 * 
 */
public final class GlyphFactory {
    private static final GlyphFont fontawesome;

    private GlyphFactory() {
    }

    static {
        InputStream is = GlyphFactory.class.getResourceAsStream("/fonts/fontawesome-webfont");
        fontawesome = new FontAwesome(is);
        GlyphFontRegistry.register(fontawesome);
    }

    /**
     * Creates a glyph for given identifier
     * @param icon one of the font code available in {@link FontAwesome} Glyph enum.
     * @return created glyph
     */
    public static Glyph create(FontAwesome.Glyph icon) {
        return fontawesome.create(icon);
    }

}
