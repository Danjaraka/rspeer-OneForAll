package org.Hoopster.data;

import org.rspeer.runetek.api.component.tab.Skill;
import org.rspeer.runetek.api.component.tab.Skills;
import org.rspeer.runetek.api.movement.position.Area;

public enum Trees {

    //TODO MAKE A BANK AREA ENUM AND CALL HERE
    REGULAR("Tree", "Logs",1, Area.rectangular(3177, 3237, 3197, 3207), Area.rectangular(3211, 3213, 3205, 3223,2)),
    OAK("OAK", "Oak logs",15, Area.rectangular(3034, 3275, 3067, 326),Area.rectangular(3034, 3275, 3067, 3260));


    private final String name, logName;
    private final int requiredLevel;
    private final Area treeArea;            //Tree Location
    private final Area bankArea;            //Place to bank

    Trees(final String name, final String logName, final int requiredLevel,final Area bankArea, final Area treeArea) {
        this.name = name;
        this.logName = logName;
        this.requiredLevel = requiredLevel;
        this.treeArea = treeArea;
        this.bankArea = bankArea;
    }

    public String getName() {return name;}

    public String getLogName() {return logName;};

    public int getRequiredLevel() {return requiredLevel;};

    public Area getBankArea() {return bankArea;};

    public Area getTreeArea() {return treeArea;};

    public boolean isAccessible() {
        return Skills.getCurrentLevel(Skill.WOODCUTTING) >= requiredLevel;
    }

}
