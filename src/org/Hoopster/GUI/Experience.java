package org.Hoopster.GUI;

import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;

import java.awt.*;

public class Experience {
    private Skill skill;
    private int startXp;
    private long startTime;
    private int startLvl;

    public Experience(Skill skill) {
        this.skill = skill;
        startXp = Skills.getExperience(skill);
        startTime = System.currentTimeMillis();
        startLvl = Skills.getLevel(skill);
    }

    public final String xpHour() {
        final long upTime = System.currentTimeMillis() - startTime;
        double gainedXp = Skills.getExperience(skill) - startXp;
        return String.format("%.1f", (gainedXp * 3600000 / upTime) / 1000) + "k/h";
    }

    public Skill getSkill() {
        return skill;
    }

    public final double xpToLvl() {
        return ((double) Skills.getExperienceToNextLevel(skill) / 1000);
    }

    public final double gainedXp() {
        return ((double) Skills.getExperience(skill) - startXp) / 1000;
    }

    public final int gainedLvl() {
        int currentSkillLevel = Skills.getLevel(skill);
        return currentSkillLevel - startLvl;
    }

    public final long percentToLvl() {

        long currentXp = Skills.getExperience(skill);

        int currentSkillLvl = Skills.getLevel(skill);

        long xpNextLvl = Skills.getExperienceAt(currentSkillLvl);

        long xpAtLvl = Skills.getExperienceAt(currentSkillLvl + 1);

        return (((xpNextLvl - currentXp) * 100) / (xpNextLvl - xpAtLvl));

    }

    public final long percentThroughLevel() {

        long currentXp = Skills.getExperience(skill);

        int currentSkillLvl = Skills.getLevel(skill);

        long xpNextLvl = Skills.getExperienceAt(currentSkillLvl);

        long xpAtLvl = Skills.getExperienceAt(currentSkillLvl + 1);

        return (100 - (((xpNextLvl - currentXp) * 100) / (xpNextLvl - xpAtLvl)));

    }
}