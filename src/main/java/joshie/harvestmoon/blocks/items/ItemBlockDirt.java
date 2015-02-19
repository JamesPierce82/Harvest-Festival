package joshie.harvestmoon.blocks.items;

import java.util.List;

import joshie.harvestmoon.base.ItemBlockBase;
import joshie.harvestmoon.blocks.BlockDirt.FloorType;
import joshie.harvestmoon.config.General;
import joshie.harvestmoon.util.generic.Text;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockDirt extends ItemBlockBase {
    public ItemBlockDirt(Block block) {
        super(block);
    }

    @Override
    public String getName(ItemStack stack) {
        return "mine_floor";
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean debug) {
        if (General.DEBUG_MODE) {
            if (stack.getItemDamage() < FloorType.values().length) {
                list.add(Text.INDIGO + Text.ITALIC + WordUtils.capitalizeFully(FloorType.values()[stack.getItemDamage()].name().replace("_", " ")));
            }
        }
    }
}
