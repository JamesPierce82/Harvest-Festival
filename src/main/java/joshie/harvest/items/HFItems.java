package joshie.harvest.items;

import joshie.harvest.api.crops.ICrop;
import joshie.harvest.core.config.General;
import joshie.harvest.core.lib.SizeableMeta;
import joshie.harvest.crops.Crop;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.text.WordUtils;

import java.util.EnumMap;

public class HFItems {
    //Sized Map
    private static final EnumMap<SizeableMeta, Item> SIZED = new EnumMap<SizeableMeta, Item>(SizeableMeta.class);

    //Sizeables
    public static final Item EGG = getSizedItem(SizeableMeta.EGG);
    public static final Item MILK = getSizedItem(SizeableMeta.MILK);
    public static final Item MAYONNAISE = getSizedItem(SizeableMeta.MAYONNAISE);
    public static final Item WOOL = getSizedItem(SizeableMeta.WOOL);

    //Tools
    public static final Item HOE = new ItemHoe().setUnlocalizedName("hoe");
    public static final Item SICKLE = new ItemSickle().setUnlocalizedName("sickle");
    public static final Item WATERING_CAN = new ItemWateringCan().setUnlocalizedName("wateringcan");
    public static final Item HAMMER = new ItemHammer().setUnlocalizedName("hammer");

    //Misc
    public static final Item GENERAL = new ItemGeneral().setUnlocalizedName("general.item");
    public static final Item MEAL = new ItemMeal().setUnlocalizedName("meal");
    public static final Item ANIMAL = new ItemAnimal().setUnlocalizedName("animal");
    public static final ItemTreat TREATS = (ItemTreat) new ItemTreat().setUnlocalizedName("treat");
    public static final Item SEEDS = new ItemHFSeeds().setUnlocalizedName("crops.seeds");

    //Misc
    public static final Item STRUCTURES = new ItemBuilding().setUnlocalizedName("structures");
    public static final Item SPAWNER_NPC = new ItemNPCSpawner().setUnlocalizedName("spawner.npc");

    public static void preInit() {
        //Add a new crop item for things that do not have an item yet :D
        for (ICrop crop : Crop.CROPS) {
            if (!crop.hasItemAssigned()) {
                crop.setItem(new ItemStack(new ItemCrop(crop).setUnlocalizedName("crop." + crop.getUnlocalizedName()), 1, 0));
                ItemStack clone = crop.getCropStack().copy();
                clone.setItemDamage(OreDictionary.WILDCARD_VALUE);
                OreDictionary.registerOre("crop" + WordUtils.capitalizeFully(crop.getUnlocalizedName().replace("_", "")), clone);
            }
        }

        //Add the debug item
        if (General.DEBUG_MODE) {
            new ItemCheat().setUnlocalizedName("cheat");
        }
    }

    public static Item getSizedItem(SizeableMeta size) {
        if (SIZED.containsKey(size)) return SIZED.get(size);
        else {
            Item item = size.getOrCreateStack();
            SIZED.put(size, item);
            return item;
        }
    }
}