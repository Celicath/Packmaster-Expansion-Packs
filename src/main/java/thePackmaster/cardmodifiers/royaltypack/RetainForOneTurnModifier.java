package thePackmaster.cardmodifiers.royaltypack;

import basemod.abstracts.AbstractCardModifier;
import basemod.cardmods.RetainMod;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cardmodifiers.magnetizepack.MagnetizedModifier;

public class RetainForOneTurnModifier extends AbstractCardModifier {

    public static String ID = SpireAnniversary5Mod.makeID(RetainForOneTurnModifier.class.getSimpleName());
    private static final UIStrings uiStrings;

    private Color startingGlowColor;

    public RetainForOneTurnModifier() {
    }

    public String modifyDescription(String rawDescription, AbstractCard card) {
        return  String.format(uiStrings.TEXT[0], rawDescription) + rawDescription;
    }

    public void onInitialApplication(AbstractCard card)
    {
        card.retain = true;
        startingGlowColor = card.glowColor.cpy();
        card.glowColor = Color.WHITE.cpy();
    }

    public boolean removeAtEndOfTurn(AbstractCard card) {
        return true;
    }

    public void onRemove(AbstractCard card) {
        card.glowColor = startingGlowColor;
    }

    public AbstractCardModifier makeCopy() {
        return new RetainForOneTurnModifier();
    }

    public String identifier(AbstractCard card) {
        return ID;
    }

    static {
        uiStrings = CardCrawlGame.languagePack.getUIString(ID);
    }

}
