package lucas.hazardous.ancientinvasion;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.util.Identifier;

public class AncientZombieRenderer extends MobEntityRenderer<AncientZombieEntity, ZombieEntityModel<AncientZombieEntity>> {

    public AncientZombieRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new ZombieEntityModel(ctx.getPart(AncientInvasion.ANCIENT_ZOMBIE_MODEL_LAYER)), 1f);
    }

    @Override
    public Identifier getTexture(AncientZombieEntity entity) {
        return new Identifier("ancient_invasion:textures/entity/ancient_zombie/ancient_zombie.png");
    }
}
