package lucas.hazardous.ancientinvasion;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class AncientInvasion implements ModInitializer {
    public static final String MOD_ID = "ancient_invasion";

    public static final ItemGroup ANCIENT_GROUP = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "ancient_group")).build();

    public static final KatanaItem KATANA_ITEM = new KatanaItem(KatanaToolMaterial.INSTANCE, 40, 10f, new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC).group(ANCIENT_GROUP));

    public static final EntityType<AncientZombieEntity> ANCIENT_ZOMBIE_ENTITY = FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AncientZombieEntity::new).dimensions(EntityDimensions.fixed(1, 2)).build();

    public static final EntityModelLayer ANCIENT_ZOMBIE_MODEL_LAYER = new EntityModelLayer(new Identifier(MOD_ID, "ancient_zombie"), "main");

    @Override
    public void onInitialize() {

        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "ancient_katana"), KATANA_ITEM);

        FabricDefaultAttributeRegistry.register(ANCIENT_ZOMBIE_ENTITY, ZombieEntity.createZombieAttributes());

        EntityModelLayerRegistry.registerModelLayer(ANCIENT_ZOMBIE_MODEL_LAYER, () -> TexturedModelData.of(ZombieEntityModel.getModelData(Dilation.NONE, 0f), 64, 64));

        EntityRendererRegistry.register(ANCIENT_ZOMBIE_ENTITY, (context) -> new AncientZombieRenderer(context));

        Registry.register(Registry.ENTITY_TYPE, new Identifier(MOD_ID, "ancient_zombie"), ANCIENT_ZOMBIE_ENTITY);
    }
}
