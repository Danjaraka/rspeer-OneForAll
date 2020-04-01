package org.Hoopster.GUI;

import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;
import org.rspeer.runetek.event.types.SkillEvent;

import java.awt.*;
import java.util.*;
import java.util.List;

public class ExperienceDisplay {

    private static int BOTTOM_Y = 325;
    private List<Experience> skillList = new ArrayList<>();

    public void addSkill(SkillEvent skillEvent) {
        if (skillEvent.getType() == SkillEvent.TYPE_EXPERIENCE && skillList.stream().noneMatch(e -> e.getSkill().equals(skillEvent.getSource()))) {
            skillList.add(new Experience(skillEvent.getSource()));
        }
    }

    public void drawSkills(Graphics2D g2d) {
        for (int i = 0; i < skillList.size(); i++) {
            Experience experience = skillList.get(i);
            Skill skill = experience.getSkill();
            int x = 5;
            int y = BOTTOM_Y - (i * 15);
            int width = 350;
            g2d.setColor(ColourHelper.FOREGROUND_COLOUR_MAP.get(skill));
            g2d.fillRect(x, y + 2, width, 15);
            int percentageWidth = (int) (((100.0 - experience.percentToLvl()) / 100.0) * width);
            g2d.setColor(ColourHelper.BACKGROUND_COLOUR_MAP.get(skill));
            g2d.fillRect(x + (width - percentageWidth), y + 2, percentageWidth, 15);

            g2d.setColor(Color.darkGray);
            g2d.drawRect(x, y + 2, width, 15);

            g2d.setColor(Color.black);
            Font myFont = new Font("Calibri", Font.PLAIN, 12);
            g2d.setFont(myFont);
            String displayText = String.format("%s (Lvl. %d - %d%%) | %.1f k gained | %.1f k rem. | %s", skill.toString(), Skills.getLevel(skill), experience.percentToLvl(), experience.gainedXp(), experience.xpToLvl(), experience.xpHour());
            g2d.drawString(displayText, x + 2, y + 14);
        }
    }

}