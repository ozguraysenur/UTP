package Classes;

import java.text.Collator;
import java.util.Locale;

public enum Nationality {

    Polish(new Locale("pl")),
    Ukrainian(new Locale("ua")),
    Belarussian(new Locale("by")),
    Slovak(new Locale("sk")),
    Lithuanian(new Locale("lt")),
    Latvian(new Locale("lv")),
    British(new Locale("en_UK")),
    Indian(new Locale("hi_IN")),
    Chinese(new Locale("cn")),
    Vietnamese(new Locale("vn"));
    Locale loc;
    Collator col;

     Nationality(Locale locale) {
        loc=locale;
        col=Collator.getInstance(loc);
    }

    public Locale getLoc() {
        return loc;
    }

    public Collator getCol() {
        return col;
    }
}
