package Thmod.Relics;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import Thmod.Characters.RemiriaScarlet;
import Thmod.Monsters.Remiria;

public class ThirstyCross extends AbstractThRelic {
    public static final String ID = "ThirstyCross";
    private AbstractPlayer p = AbstractDungeon.player;
    private int blood;

    public ThirstyCross()
    {
        super("ThirstyCross",  RelicTier.SPECIAL, LandingSound.HEAVY);
        if(AbstractDungeon.player != null){
            this.blood = (int) ((float) AbstractDungeon.player.maxHealth * 0.04);
        }
        else {

            this.blood = 3;
        }
        this.description = getUpdatedDescription();
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
        initializeTips();
    }

    public void atBattleStart() {
        if(AbstractDungeon.player != null){
            this.blood = (int) ((float) AbstractDungeon.player.maxHealth * 0.04);
        }
        else {
            this.blood = 3;
        }
        this.description = getUpdatedDescription();
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
        initializeTips();
        AbstractDungeon.actionManager.addToTop(new ApplyPowerAction(p,p,new StrengthPower(p,2),2));
        beginLongPulse();
        this.pulse = true;
    }

    public void atTurnStart() {
        beginLongPulse();
        this.pulse = true;
    }

    public void onUseCard(AbstractCard targetCard, UseCardAction useCardAction) {
        if(targetCard.type == AbstractCard.CardType.ATTACK){
            this.pulse = false;
            stopPulse();
        }
    }

    public void onPlayerEndTurn() {
        if(this.pulse){
            AbstractDungeon.actionManager.addToTop(new DamageAction(p, new DamageInfo(p, 3, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
            if(p.hasPower("DashPower")){
                AbstractPower reapply = p.getPower("DashPower");
                AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(p,p,"DashPower"));
                AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p,p,reapply));
            }
        }
    }

    protected  void onRightClick(){
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + this.blood + this.DESCRIPTIONS[1];
    }

    public AbstractRelic makeCopy() {
        return new ThirstyCross();
    }
}
