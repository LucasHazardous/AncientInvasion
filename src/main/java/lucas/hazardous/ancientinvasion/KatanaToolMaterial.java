package lucas.hazardous.ancientinvasion;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class KatanaToolMaterial implements ToolMaterial {
    public static final KatanaToolMaterial INSTANCE = new KatanaToolMaterial();

    @Override
    public int getDurability() {
        return 2000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10f;
    }

    @Override
    public float getAttackDamage() {
        return 20f;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.NETHERITE_INGOT);
    }
}
