package Thmod.Actions.unique;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.ArrayList;

import basemod.DevConsole;

public class BackInTimeAction extends AbstractGameAction {
    private int playerToBe;
    private ArrayList<Integer> monToBe = new ArrayList<>();

    public BackInTimeAction(int playerToBe, ArrayList<Integer> monToBe){
        this.playerToBe = playerToBe;
        this.monToBe.addAll(monToBe);
    }

    public void update(){
        AbstractDungeon.player.currentHealth = this.playerToBe;
        AbstractDungeon.player.healthBarUpdatedEvent();
        for (int i = 0; i < this.monToBe.size(); i++) {
            DevConsole.logger.info("monster" + i + "___" + this.monToBe.get(i));
            AbstractMonster target = AbstractDungeon.getCurrRoom().monsters.monsters.get(i);
            if ((!(target.isDying)) && (target.currentHealth > 0) && (!(target.isEscaping))) {
                if (this.monToBe.get(i) != 0) {
                    target.currentHealth = this.monToBe.get(i);
                    target.healthBarUpdatedEvent();
                }
            }
        }
        this.isDone = true;
    }
}
