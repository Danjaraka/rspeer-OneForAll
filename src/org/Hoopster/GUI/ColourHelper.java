package org.Hoopster.GUI;

import org.rspeer.runetek.api.component.tab.Skill;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ColourHelper {
    public static final Map<Skill, Color> FOREGROUND_COLOUR_MAP = createForegroundMap();

    private static Map<Skill, Color> createForegroundMap() {
        Map<Skill, Color> result = new HashMap<>();
        result.put(Skill.ATTACK, new Color(155, 32, 7));
        result.put(Skill.DEFENCE, new Color(98, 119, 190));
        result.put(Skill.STRENGTH, new Color(4, 149, 90));
        result.put(Skill.HITPOINTS, new Color(131, 126, 126));
        result.put(Skill.RANGED, new Color(109, 144, 23));
        result.put(Skill.PRAYER, new Color(159, 147, 35));
        result.put(Skill.MAGIC, new Color(50, 80, 193));
        result.put(Skill.COOKING, new Color(112, 35, 134));
        result.put(Skill.WOODCUTTING, new Color(52, 140, 37));
        result.put(Skill.FLETCHING, new Color(3, 141, 125));
        result.put(Skill.FISHING, new Color(106, 132, 164));
        result.put(Skill.FIREMAKING, new Color(189, 120, 25));
        result.put(Skill.CRAFTING, new Color(151, 110, 77));
        result.put(Skill.SMITHING, new Color(108, 107, 82));
        result.put(Skill.MINING, new Color(93, 143, 167));
        result.put(Skill.HERBLORE, new Color(7, 133, 9));
        result.put(Skill.AGILITY, new Color(58, 60, 137));
        result.put(Skill.THIEVING, new Color(108, 52, 87));
        result.put(Skill.SLAYER, new Color(100, 100, 100));
        result.put(Skill.FARMING, new Color(101, 152, 63));
        result.put(Skill.RUNECRAFTING, new Color(170, 141, 26));
        result.put(Skill.HUNTER, new Color(92, 89, 65));
        result.put(Skill.CONSTRUCTION, new Color(130, 116, 95));
        return Collections.unmodifiableMap(result);
    }

    public static final Map<Skill, Color> BACKGROUND_COLOUR_MAP = createBackgroundMap();

    private static Map<Skill, Color> createBackgroundMap() {
        Map<Skill, Color> result = new HashMap<>();
        result.put(Skill.ATTACK, new Color(94, 0, 0));
        result.put(Skill.DEFENCE, new Color(41, 71, 136));
        result.put(Skill.STRENGTH, new Color(0, 97, 43));
        result.put(Skill.HITPOINTS, new Color(131, 126, 126));
        result.put(Skill.RANGED, new Color(56, 93, 0));
        result.put(Skill.PRAYER, new Color(159, 147, 35));
        result.put(Skill.MAGIC, new Color(104, 97, 0));
        result.put(Skill.COOKING, new Color(60, 0, 83));
        result.put(Skill.WOODCUTTING, new Color(0, 89, 0));
        result.put(Skill.FLETCHING, new Color(0, 90, 76));
        result.put(Skill.FISHING, new Color(56, 83, 112));
        result.put(Skill.FIREMAKING, new Color(130, 71, 0));
        result.put(Skill.CRAFTING, new Color(98, 62, 32));
        result.put(Skill.SMITHING, new Color(60, 60, 37));
        result.put(Skill.MINING, new Color(39, 93, 115));
        result.put(Skill.HERBLORE, new Color(0, 82, 0));
        result.put(Skill.AGILITY, new Color(0, 18, 86));
        result.put(Skill.THIEVING, new Color(58, 4, 42));
        result.put(Skill.SLAYER, new Color(53, 53, 53));
        result.put(Skill.FARMING, new Color(49, 101, 10));
        result.put(Skill.RUNECRAFTING, new Color(113, 91, 0));
        result.put(Skill.HUNTER, new Color(46, 44, 22));
        result.put(Skill.CONSTRUCTION, new Color(80, 68, 49));
        return Collections.unmodifiableMap(result);
    }
}
