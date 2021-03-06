package Thmod.Cards.ElementCards.RareCards;

import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;

import java.util.ArrayList;

import Thmod.Actions.common.ChangeOrbAction;
import Thmod.Actions.unique.ChooseAction;
import Thmod.Actions.unique.ElementMixAction;
import Thmod.Cards.AbstractKomeijiCards;
import Thmod.Orbs.ElementOrb.AbstractElementOrb;
import Thmod.Orbs.ElementOrb.EarthOrb;
import Thmod.Orbs.ElementOrb.FireOrb;
import Thmod.Orbs.ElementOrb.LunaOrb;
import Thmod.Orbs.ElementOrb.MetalOrb;
import Thmod.Orbs.ElementOrb.SunOrb;
import Thmod.Orbs.ElementOrb.WaterOrb;
import Thmod.Orbs.ElementOrb.WoodOrb;

public class ElementMix extends AbstractKomeijiCards {
    public static final String ID = "ElementMix";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String[] EXTENDED_DESCRIPTION;
    private static final int COST = 0;

    public ElementMix() {
        super("ElementMix", ElementMix.NAME,  0, ElementMix.DESCRIPTION, CardType.SKILL, CardRarity.RARE, CardTarget.NONE, CardSet_k.OTHER);
        this.exhaust = true;
    }

    public void use(final AbstractPlayer p, final AbstractMonster m) {
        ElementMixAction mixAction = new ElementMixAction();
        final ChooseAction choice2 = new ChooseAction(this, m, ElementMix.EXTENDED_DESCRIPTION[15], true, 1);
        choice2.add(ElementMix.EXTENDED_DESCRIPTION[1], ElementMix.EXTENDED_DESCRIPTION[2], () -> {
            AbstractElementOrb orb = new EarthOrb();
            mixAction.addOrb(orb);
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
        });
        choice2.add(ElementMix.EXTENDED_DESCRIPTION[3], ElementMix.EXTENDED_DESCRIPTION[4], () -> {
            AbstractElementOrb orb = new FireOrb();
            mixAction.addOrb(orb);
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
        });
        choice2.add(ElementMix.EXTENDED_DESCRIPTION[7], ElementMix.EXTENDED_DESCRIPTION[8], () -> {
            AbstractElementOrb orb = new MetalOrb();
            mixAction.addOrb(orb);
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
        });
        choice2.add(ElementMix.EXTENDED_DESCRIPTION[11], ElementMix.EXTENDED_DESCRIPTION[12], () -> {
            AbstractElementOrb orb = new WaterOrb();
            mixAction.addOrb(orb);
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
        });
        choice2.add(ElementMix.EXTENDED_DESCRIPTION[13], ElementMix.EXTENDED_DESCRIPTION[14], () -> {
            AbstractElementOrb orb = new WoodOrb();
            mixAction.addOrb(orb);
            AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
        });
        if(this.upgraded){
            choice2.add(ElementMix.EXTENDED_DESCRIPTION[5], ElementMix.EXTENDED_DESCRIPTION[6], () -> {
                AbstractElementOrb orb = new LunaOrb();
                mixAction.addOrb(orb);
                AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
            });

            choice2.add(ElementMix.EXTENDED_DESCRIPTION[9], ElementMix.EXTENDED_DESCRIPTION[10], () -> {
                AbstractElementOrb orb = new SunOrb();
                mixAction.addOrb(orb);
                AbstractDungeon.actionManager.addToBottom(new ChannelAction(orb));
            });
        }
        AbstractDungeon.actionManager.addToBottom(choice2);

        boolean hasEle = false;
        for(int i = 0;i < p.orbs.size();i ++){
            if(p.orbs.get(i) instanceof AbstractElementOrb){
                hasEle = true;
                break;
            }
        }
        if(hasEle) {
            final ChooseAction choice = new ChooseAction(this, m, ElementMix.EXTENDED_DESCRIPTION[0], true, 1);
            for (int i = (AbstractDungeon.player.orbs.size() - 1); i >= 0; i--) {
                if (AbstractDungeon.player.orbs.get(i) instanceof EarthOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[1], ElementMix.EXTENDED_DESCRIPTION[2], () -> {
                        mixAction.addOrb(new EarthOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
                if (AbstractDungeon.player.orbs.get(i) instanceof FireOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[3], ElementMix.EXTENDED_DESCRIPTION[4], () -> {
                        mixAction.addOrb(new FireOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
                if (AbstractDungeon.player.orbs.get(i) instanceof LunaOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[5], ElementMix.EXTENDED_DESCRIPTION[6], () -> {
                        mixAction.addOrb(new LunaOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
                if (AbstractDungeon.player.orbs.get(i) instanceof MetalOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[7], ElementMix.EXTENDED_DESCRIPTION[8], () -> {
                        mixAction.addOrb(new MetalOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
                if (AbstractDungeon.player.orbs.get(i) instanceof SunOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[9], ElementMix.EXTENDED_DESCRIPTION[10], () -> {
                        mixAction.addOrb(new SunOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
                if (AbstractDungeon.player.orbs.get(i) instanceof WaterOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[11], ElementMix.EXTENDED_DESCRIPTION[12], () -> {
                        mixAction.addOrb(new WaterOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
                if (AbstractDungeon.player.orbs.get(i) instanceof WoodOrb) {
                    choice.add(ElementMix.EXTENDED_DESCRIPTION[13], ElementMix.EXTENDED_DESCRIPTION[14], () -> {
                        mixAction.addOrb(new WoodOrb());
                        AbstractDungeon.actionManager.addToBottom(mixAction);
                    });
                }
            }
            AbstractDungeon.actionManager.addToBottom(choice);
        }
    }

    public AbstractCard makeCopy() {
        return new ElementMix();
    }

    public void upgrade() {
        if (!(this.upgraded)) {
            this.upgradeName();
            this.exhaust = false;
            this.rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
        }
    }

//    public boolean canUse(AbstractPlayer p, AbstractMonster m){
//        super.canUse(p,m);
//        int emptyNum = 0;
//        for(int i = 0;i < p.orbs.size();i ++){
//            if(p.orbs.get(i) instanceof EmptyOrbSlot)
//                emptyNum += 1;
//        }
//        if((p.orbs.size() - emptyNum) < 2){
//            this.cantUseMessage = "我没有足够的元素球";
//            return false;
//        }
//        return true;
//    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("ElementMix");
        NAME = ElementMix.cardStrings.NAME;
        DESCRIPTION = ElementMix.cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = ElementMix.cardStrings.UPGRADE_DESCRIPTION;
        EXTENDED_DESCRIPTION = ElementMix.cardStrings.EXTENDED_DESCRIPTION;
    }
}
