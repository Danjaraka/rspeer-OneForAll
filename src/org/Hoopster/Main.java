package org.Hoopster;

import org.Hoopster.GUI.ExperienceDisplay;
import org.Hoopster.data.Trees;
import org.rspeer.runetek.adapter.scene.Player;
import org.rspeer.runetek.adapter.scene.SceneObject;
import org.rspeer.runetek.api.commons.Time;
import org.rspeer.runetek.api.commons.math.Random;
import org.rspeer.runetek.api.component.Bank;
import org.rspeer.runetek.api.component.tab.Inventory;
import org.rspeer.runetek.api.movement.Movement;
import org.rspeer.runetek.api.query.SceneObjectQueryBuilder;
import org.rspeer.runetek.api.scene.Players;
import org.rspeer.runetek.api.scene.SceneObjects;
import org.rspeer.runetek.event.listeners.RenderListener;
import org.rspeer.runetek.event.listeners.SkillListener;
import org.rspeer.runetek.event.types.RenderEvent;
import org.rspeer.runetek.event.types.SkillEvent;
import org.rspeer.script.Script;
import org.rspeer.script.ScriptMeta;
import org.rspeer.ui.Log;

import java.awt.*;

@ScriptMeta(name = "Hoopster" ,desc = "Does everything", developer = "Hoopster")
public class Main extends Script implements RenderListener, SkillListener {

    private ExperienceDisplay experienceDisplay = new ExperienceDisplay();

    public static Trees tree;

    @Override
    public void onStart(){

    }
    @Override
    public int loop() {
        Player local = Players.getLocal();
        if(!local.isAnimating() || !local.isMoving()) {
            if(!tree.getTreeArea().contains(local) && !Inventory.isFull()) {
                Log.fine("Walking to tree area");
                Movement.walkTo(tree.getTreeArea().getCenter());
            }
            if (tree.getTreeArea().contains(local) && !Inventory.isFull()) {
                Log.fine("Cutting down tree");
                SceneObjectQueryBuilder trees = SceneObjects.newQuery().names("Tree").within(tree.getTreeArea());
                SceneObject tree = SceneObjects.getNearest(trees);
                    if (tree != null) {
                    tree.interact("Chop down");
                    Time.sleep(600, 1200);
                }
            }
            if (Inventory.isFull() && !tree.getBankArea().contains(local)) {
                Log.fine("Walking to bank");
                Time.sleep(600, 1200);
                Movement.walkTo(tree.getBankArea().getCenter());
            }
            if (Inventory.isFull() && tree.getBankArea().contains(local)){
                Log.fine("Depositing inventory");
                Bank.open();
                Time.sleep(300,2000);
                Bank.depositInventory();
            }
        }
        return Random.nextInt(1000,3000);
    }

    @Override
    public void onStop(){
        
    }

    @Override
    public void notify(RenderEvent renderEvent) {
        Graphics2D g2d = (Graphics2D) renderEvent.getSource();
        experienceDisplay.drawSkills(g2d);
    }

    @Override
    public void notify(SkillEvent skillEvent) {
        experienceDisplay.addSkill(skillEvent);
    }


}
