package teamroots.goetia.spellcasting.demon;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import teamroots.goetia.lib.LibMain;
import teamroots.goetia.spellcasting.CastSpell;
import teamroots.goetia.spellcasting.AlignmentType;

public class SpellChainedStrikes extends CastSpell{

	public SpellChainedStrikes() {
		super("chainedStrikes", 171, new int[]{1,6,3,4,5,2,1}, new ItemStack(Items.STRING), AlignmentType.DEMON);
	}
	
	@Override
	public void doEffect(EntityPlayer caster){
		for (float i = 0; i < 360; i += 7.5){
			float offX = 0.75f*(float)Math.sin(Math.toRadians(i));
			float offZ = 0.75f*(float)Math.cos(Math.toRadians(i));
			if (random.nextInt(2) == 0){
				caster.getEntityWorld().spawnParticle(EnumParticleTypes.FLAME, caster.posX+offX, caster.posY+caster.getEyeHeight()/2.0, caster.posZ+offZ, 0, 0, 0, 0);
			}
			if (random.nextInt(2) == 0){
				caster.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_LARGE, caster.posX+offX, caster.posY+caster.getEyeHeight()/2.0, caster.posZ+offZ, 0, 0.015*random.nextFloat(), 0, 0);
			}
			caster.getEntityWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, caster.posX+offX, caster.posY+caster.getEyeHeight()/2.0, caster.posZ+offZ, 0, 0.015*random.nextFloat(), 0, 0);
		}
		caster.getEntityData().setInteger(LibMain.LibNBT.chained_strikes_tag, 600);
	}
}
