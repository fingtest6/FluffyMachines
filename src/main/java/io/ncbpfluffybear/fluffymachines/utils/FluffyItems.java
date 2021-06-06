package io.ncbpfluffybear.fluffymachines.utils;

import dev.j3fftw.extrautils.utils.LoreBuilderDynamic;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import io.github.thebusybiscuit.slimefun4.utils.itemstack.ColoredFireworkStar;
import io.ncbpfluffybear.fluffymachines.FluffyMachines;
import io.ncbpfluffybear.fluffymachines.items.Barrel;
import io.ncbpfluffybear.fluffymachines.items.FireproofRune;
import io.ncbpfluffybear.fluffymachines.items.tools.FluffyWrench;
import io.ncbpfluffybear.fluffymachines.items.tools.PortableCharger;
import io.ncbpfluffybear.fluffymachines.machines.AdvancedAutoDisenchanter;
import io.ncbpfluffybear.fluffymachines.machines.AdvancedChargingBench;
import io.ncbpfluffybear.fluffymachines.machines.AutoAncientAltar;
import io.ncbpfluffybear.fluffymachines.objects.AutoCrafter;
import io.ncbpfluffybear.fluffymachines.machines.AutoCraftingTable;
import io.ncbpfluffybear.fluffymachines.machines.AutoTableSaw;
import io.ncbpfluffybear.fluffymachines.machines.BackpackLoader;
import io.ncbpfluffybear.fluffymachines.machines.BackpackUnloader;
import io.ncbpfluffybear.fluffymachines.machines.ElectricDustFabricator;
import io.ncbpfluffybear.fluffymachines.machines.ElectricDustRecycler;
import io.ncbpfluffybear.fluffymachines.machines.WaterSprinkler;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;


public class FluffyItems {

    private FluffyItems() {
    }

    // ItemGroup
    public static final ItemGroup fluffymachines = new ItemGroup(new NamespacedKey(FluffyMachines.getInstance(),
        "fluffymachines"),
        new CustomItemStack(Material.SMOKER, "&6Fluffy Machines(蓬松机器)")
    );

    public static final ItemGroup fluffybarrels = new ItemGroup(new NamespacedKey(FluffyMachines.getInstance(),
        "fluffybarrels"),
        new CustomItemStack(Material.BARREL, "&6Fluffy Barrels(物品储存)")
    );

    public static final SlimefunItemStack FLUFFYMACHINES_INFO = new SlimefunItemStack("FLUFFYMACHINES_INFO",
        Material.ORANGE_WOOL,
        "&6&lFluffyMachines信息",
        "",
        "&e" + FluffyMachines.getInstance().getName() + " " + FluffyMachines.getInstance().getPluginVersion(),
        "",
        "&e左键单击&7wiki",
        "&e右键单击&7反馈bugk"
    );

    // Barrels
    public static final SlimefunItemStack SMALL_FLUFFY_BARREL = new SlimefunItemStack("SMALL_FLUFFY_BARREL",
        Material.BEEHIVE,
        "&e一阶蓬松箱子",
        "",
        "&7可以储存大量物品",
        "&c请不要用爆炸工具打破...",
        "&c不然将会丢失所有物品",
        "",
        "&b可储: &e" + Barrel.SMALL_BARREL_SIZE + "个物品"
    );

    public static final SlimefunItemStack MEDIUM_FLUFFY_BARREL = new SlimefunItemStack("MEDIUM_FLUFFY_BARREL",
        Material.BARREL,
        "&6二阶蓬松箱子",
        "",
        "&7可以储存大量物品",
        "&c请不要用爆炸工具打破...",
        "&c不然将会丢失所有物品",
        "",
        "&b可储存: &e" + Barrel.MEDIUM_BARREL_SIZE + "可物品"
    );

    public static final SlimefunItemStack BIG_FLUFFY_BARREL = new SlimefunItemStack("BIG_FLUFFY_BARREL",
        Material.SMOKER,
        "&b三阶蓬松箱子",
        "",
        "&7可以储存大量物品",
        "&c请不要用爆炸工具打破...",
        "&c不然将会丢失所有物品",
        "",
        "&b可储存: &e" + Barrel.BIG_BARREL_SIZE + "个物品"
    );

    public static final SlimefunItemStack LARGE_FLUFFY_BARREL = new SlimefunItemStack("LARGE_FLUFFY_BARREL",
        Material.LODESTONE,
        "&a四阶蓬松箱子l",
        "",
        "&7可以储存大量物品",
        "&c请不要用爆炸工具打破...",
        "&c不然将会丢失所有物品",
        "",
        "&b可储存: &e" + Barrel.LARGE_BARREL_SIZE + "个物品"
    );

    public static final SlimefunItemStack MASSIVE_FLUFFY_BARREL = new SlimefunItemStack("MASSIVE_FLUFFY_BARREL",
        Material.CRYING_OBSIDIAN,
        "&5五阶蓬松箱子",
        "",
        "&7可以储存大量物品",
        "&c请不要用爆炸工具打破...",
        "&c不然将会丢失所有物品",
        "",
        "&b可储存: &e" + Barrel.MASSIVE_BARREL_SIZE + "个物品"
    );

    public static final SlimefunItemStack BOTTOMLESS_FLUFFY_BARREL = new SlimefunItemStack("BOTTOMLESS_FLUFFY_BARREL",
        Material.RESPAWN_ANCHOR,
        "&c六阶蓬松箱子",
        "",
        "&7可以储存大量物品",
        "&c请不要用爆炸工具打破...",
        "&c不然将会丢失所有物品",
        "",
        "&b可储存: &e" + Barrel.BOTTOMLESS_BARREL_SIZE + "个物品"
    );

    // Portable Chargers
    public static final SlimefunItemStack SMALL_PORTABLE_CHARGER = new SlimefunItemStack("SMALL_PORTABLE_CHARGER",
        Material.BRICK,
        "&e一阶便携充电器",
        "",
        "&7可以给手中物品/装备充电",
        "",
        "&e充电速度: &7" + PortableCharger.Type.SMALL.chargeSpeed + " J/s",
        LoreBuilder.powerCharged(0, PortableCharger.Type.SMALL.chargeCapacity)
    );

    public static final SlimefunItemStack MEDIUM_PORTABLE_CHARGER = new SlimefunItemStack("MEDIUM_PORTABLE_CHARGER",
        Material.IRON_INGOT,
        "&6二阶便携充电器",
        "",
        "&7可以给手中物品/装备充电",
        "",
        "&e充电速度: &7" + PortableCharger.Type.MEDIUM.chargeSpeed + " J/s",
        LoreBuilder.powerCharged(0, PortableCharger.Type.MEDIUM.chargeCapacity)
    );

    public static final SlimefunItemStack BIG_PORTABLE_CHARGER = new SlimefunItemStack("BIG_PORTABLE_CHARGER",
        Material.GOLD_INGOT,
        "&a三阶便携充电器",
        "",
        "&7可以给手中物品/装备充电",
        "",
        "&e充电速度: &7" + PortableCharger.Type.BIG.chargeSpeed + " J/s",
        LoreBuilder.powerCharged(0, PortableCharger.Type.BIG.chargeCapacity)
    );

    public static final SlimefunItemStack LARGE_PORTABLE_CHARGER = new SlimefunItemStack("LARGE_PORTABLE_CHARGER",
        Material.NETHER_BRICK,
        "&2四阶便携充电器",
        "",
        "&7可以给手中物品/装备充电",
        "",
        "&e充电速度: &7" + PortableCharger.Type.LARGE.chargeSpeed + " J/s",
        LoreBuilder.powerCharged(0, PortableCharger.Type.LARGE.chargeCapacity)
    );

    public static final SlimefunItemStack CARBONADO_PORTABLE_CHARGER = new SlimefunItemStack(
        "CARBONADO_PORTABLE_CHARGER",
        Material.NETHERITE_INGOT,
        "&4五阶便携充电器",
        "",
        "&7可以给手中物品/装备充电",
        "",
        "&e充电速度: &7" + PortableCharger.Type.CARBONADO.chargeSpeed + " J/s",
        LoreBuilder.powerCharged(0, PortableCharger.Type.CARBONADO.chargeCapacity)
    );

    // Items
    public static final SlimefunItemStack ANCIENT_BOOK = new SlimefunItemStack("ANCIENT_BOOK",
        Material.BOOK,
        "&6远古之书",
        "",
        "&7在&c高级全自动驱魔机&7中应用",
        "",
        "&6&o凝聚千年精华"
    );
    public static final SlimefunItemStack HELICOPTER_HAT = new SlimefunItemStack("HELICOPTER_HAT",
        Material.LEATHER_HELMET, Color.AQUA,
        "&1直升机帽",
        "",
        "&7brrrrrrrrRRRRRRRR",
        "",
        "&e蹲下&7使用"
    );
    public static final SlimefunItemStack WATERING_CAN = new SlimefunItemStack("WATERING_CAN",
        "6484da45301625dee79ae29ff513efa583f1ed838033f20db80963cedf8aeb0e",
        "&b喷壶",
        "",
        "&f给植物浇水",
        "",
        "&7> &e右键单击&7灌满喷壶",
        "&7> &e右键单击&7加速植物生长.",
        "&7> &e右键单击&7生长慢些",
        "",
        "&a水值: &e0"
    );
    public static final SlimefunItemStack ENDER_CHEST_EXTRACTION_NODE = new SlimefunItemStack(
        "ENDER_CHEST_EXTRACTION_NODE",
        "e707c7f6c3a056a377d4120028405fdd09acfcd5ae804bfde0f653be866afe39",
        "&6末影货运节点(输出)",
        "",
        "&7请把这个机器放在&5末影箱&7的一侧",
        "",
        "&7会从&5末影箱&7输入物品",
        "&7从相邻的&6箱子&7放入物品"
    );
    public static final SlimefunItemStack ENDER_CHEST_INSERTION_NODE = new SlimefunItemStack(
        "ENDER_CHEST_INSERTION_NODE",
        "7e5dc50c0186d53381d9430a2eff4c38f816b8791890c7471ffdb65ba202bc5",
        "&b末影货运节点(输入)",
        "",
        "&7请把这个机器放在&5末影箱&7的一侧",
        "",
        "&7会从&5末影箱&7输出物品",
        "&7从相邻的&6箱子&7吸取物品"
    );
    // Machines
    public static final SlimefunItemStack AUTO_CRAFTING_TABLE = new SlimefunItemStack("AUTO_CRAFTING_TABLE",
        Material.CRAFTING_TABLE,
        "&6全自动工作台(原版)",
        "",
        "&7全自动制造&f原版&7物品",
        "",
        LoreBuilderDynamic.powerBuffer(AutoCraftingTable.CAPACITY),
        LoreBuilderDynamic.powerPerTick(AutoCraftingTable.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack AUTO_ANCIENT_ALTAR = new SlimefunItemStack("AUTO_ANCIENT_ALTAR",
        Material.ENCHANTING_TABLE,
        "&5全自动远古祭坛",
        "",
        "&7全自动制造&5远古祭坛&7物品",
        "",
        LoreBuilderDynamic.powerBuffer(AutoAncientAltar.CAPACITY),
        LoreBuilderDynamic.powerPerTick(AutoAncientAltar.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack AUTO_TABLE_SAW = new SlimefunItemStack("AUTO_TABLE_SAW",
        Material.STONECUTTER,
        "&6全自动切石机",
        "",
        "&7全自动制造&6切石机&7物品",
        "",
        LoreBuilderDynamic.powerBuffer(AutoTableSaw.CAPACITY),
        LoreBuilderDynamic.powerPerTick(AutoTableSaw.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack WATER_SPRINKER = new SlimefunItemStack("WATER_SPRINKLER",
        "d6b13d69d1929dcf8edf99f3901415217c6a567d3a6ead12f75a4de3ed835e85",
        "&b浇水壶",
        "",
        "&7biu~",
        "",
        LoreBuilderDynamic.powerBuffer(WaterSprinkler.CAPACITY),
        LoreBuilderDynamic.powerPerTick(WaterSprinkler.ENERGY_CONSUMPTION) + " per crop"
    );
    public static final SlimefunItemStack ITEM_OVERSTACKER = new SlimefunItemStack("ITEM_OVERSTACKER",
        Material.PISTON,
        "&e物品堆叠机",
        "",
        "&7堆叠不可堆叠的物品"
    );
    public static final SlimefunItemStack GENERATOR_CORE = new SlimefunItemStack("GENERATOR_CORE",
        Material.BLAST_FURNACE,
        "&7发电机芯",
        "",
        "&7发电机的必要物"
    );
    public static final SlimefunItemStack CRANK_GENERATOR = new SlimefunItemStack("CRANK_GENERATOR",
        Material.BLAST_FURNACE,
        "&7手摇发电机",
        "",
        "&e右键单击&7拉杆发电",
        "",
        Utils.multiBlockWarning()
    );

    public static final SlimefunItemStack FOUNDRY = new SlimefunItemStack("FOUNDRY",
        Material.BLAST_FURNACE,
        "&c铸造厂",
        "",
        "&e储存粉尘和锭",
        "&7可储存138,240个粉尘",
        "",
        Utils.multiBlockWarning()
    );

    public static final SlimefunItemStack BACKPACK_UNLOADER = new SlimefunItemStack("BACKPACK_UNLOADER",
        Material.BROWN_STAINED_GLASS,
        "&e背包卸载机",
        "",
        "&7从背包里卸载物品",
        "",
        LoreBuilderDynamic.powerBuffer(BackpackUnloader.CAPACITY),
        LoreBuilderDynamic.powerPerTick(BackpackUnloader.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack BACKPACK_LOADER = new SlimefunItemStack("BACKPACK_LOADER",
        Material.ORANGE_STAINED_GLASS,
        "&e背包装载机",
        "",
        "&7从背包里装载物品",
        "",
        LoreBuilderDynamic.powerBuffer(BackpackLoader.CAPACITY),
        LoreBuilderDynamic.powerPerTick(BackpackLoader.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack UPGRADED_EXPLOSIVE_PICKAXE = new SlimefunItemStack(
        "UPGRADED_EXPLOSIVE_PICKAXE",
        Material.DIAMOND_PICKAXE,
        "&e&l改进爆破镐",
        "",
        "&7挖掘5x5范围"
    );
    public static final SlimefunItemStack UPGRADED_EXPLOSIVE_SHOVEL = new SlimefunItemStack("UPGRADED_EXPLOSIVE_SHOVEL",
        Material.DIAMOND_SHOVEL,
        "&e&l改进爆破铲",
        "",
        "&7挖掘5x5范围"
    );
    public static final SlimefunItemStack FIREPROOF_RUNE = new SlimefunItemStack(
        "FIREPROOF_RUNE",
        new ColoredFireworkStar(Color.fromRGB(255, 165, 0),
            "&7古代符文&8&l[&c&l防火&8&l]",
            "",
            "&e此物品与其他物品丢在地上",
            "&e物品将会&c防火",
            ""
        ));
    public static final SlimefunItemStack SUPERHEATED_FURNACE = new SlimefunItemStack("SUPERHEATED_FURNACE",
        Material.BLAST_FURNACE,
        "&c超热炉",
        "",
        "&7铸造厂多块部件",
        "&c必须在铸造厂使用",
        "&c请不要用爆炸工具打破!"
    );
    public static final SlimefunItemStack AUTO_MAGIC_WORKBENCH = new SlimefunItemStack("AUTO_MAGIC_WORKBENCH",
        Material.BOOKSHELF,
        "&6自动魔法工作台",
        "",
        "&7全自动制造&6魔法工作台&7物品",
        "",
        LoreBuilderDynamic.powerBuffer(AutoCrafter.CAPACITY),
        LoreBuilderDynamic.powerPerTick(AutoCrafter.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack AUTO_ARMOR_FORGE = new SlimefunItemStack("AUTO_ARMOR_FORGE",
        Material.SMITHING_TABLE,
        "&7全自动盔甲锻造机",
        "",
        "&7全自动制造&6盔甲锻造机&7物品",
        "",
        LoreBuilderDynamic.powerBuffer(AutoCrafter.CAPACITY),
        LoreBuilderDynamic.powerPerTick(AutoCrafter.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack ADVANCED_AUTO_DISENCHANTER = new SlimefunItemStack(
        "ADVANCED_AUTO_DISENCHANTER",
        Material.ENCHANTING_TABLE,
        "&c高级全自动驱魔机",
        "",
        "&7从一个物品中移除第一个附魔",
        "&7需要一本&6远古之书&7来操作",
        "",
        LoreBuilderDynamic.powerBuffer(AdvancedAutoDisenchanter.CAPACITY),
        LoreBuilderDynamic.powerPerTick(AdvancedAutoDisenchanter.ENERGY_CONSUMPTION)
    );
    public static final SlimefunItemStack SCYTHE = new SlimefunItemStack("SCYTHE",
        Material.IRON_HOE,
        "&e镰刀",
        "",
        "&7一次性打破5个农作物"
    );
    public static final SlimefunItemStack UPGRADED_LUMBER_AXE = new SlimefunItemStack("UPGRADED_LUMBER_AXE",
        Material.DIAMOND_AXE,
        "&6&l改进斧头",
        "",
        "&7一次砍下整棵树",
        "&7右键给树削皮"
    );
    public static final SlimefunItemStack DOLLY = new SlimefunItemStack("DOLLY",
        Material.MINECART,
        "&b箱子搬运车",
        "",
        "&7右键拾起箱子",
        "",
        "&7ID: <ID>"
    );

    public static final SlimefunItemStack WARP_PAD = new SlimefunItemStack("WARP_PAD",
        Material.SMOKER,
        "&6传送装置",
        "",
        "&7用此物品传送到另一个传送装置",
        "&7需要传送装置配置器来配置",
        "",
        "&7在传送装置上蹲下来进行传送"
    );

    public static final SlimefunItemStack WARP_PAD_CONFIGURATOR = new SlimefunItemStack("WARP_PAD_CONFIGURATOR",
        Material.BLAZE_ROD,
        "&6传送装置配置器",
        "",
        "&e蹲下右键&7来设置终点",
        "&e右键&7来设置起点",
        "",
        "&e传送坐标:&7无"
    );

    public static final SlimefunItemStack ELECTRIC_DUST_FABRICATOR = new SlimefunItemStack("ELECTRIC_DUST_FABRICATOR",
        Material.BLAST_FURNACE,
        "&6粉尘制造机",
        "",
        "&7一台磨石,筛粉和洗矿三合一的机器",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(10),
        LoreBuilderDynamic.powerBuffer(ElectricDustFabricator.CAPACITY),
        LoreBuilderDynamic.powerPerTick(ElectricDustFabricator.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack ELECTRIC_DUST_RECYCLER = new SlimefunItemStack("ELECTRIC_DUST_RECYCLER",
        Material.IRON_BLOCK,
        "&f粉尘回收机",
        "",
        "&7将粉尘回收到筛矿",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilderDynamic.powerBuffer(ElectricDustRecycler.CAPACITY),
        LoreBuilderDynamic.powerPerTick(ElectricDustRecycler.ENERGY_CONSUMPTION)
    );

    public static final SlimefunItemStack ALTERNATE_ELEVATOR_PLATE = new SlimefunItemStack("ALTERNATE_ELEVATOR_PLATE",
        Material.POLISHED_BLACKSTONE_PRESSURE_PLATE,
        "&3电梯板",
        "",
        "&f每成需要放置一个",
        "&f电梯都要在同一条垂直线.",
        "",
        "&e右键单击&7来命名",
        ""
    );

    public static final SlimefunItemStack FLUFFY_WRENCH = new SlimefunItemStack("FLUFFY_WRENCH",
        FluffyWrench.Wrench.DEFAULT.getMaterial(),
        "&6扳手",
        "",
        "&7快速拆除Slimefun",
        "的机器",
        "",
        "&e左&7/&e右键 > &7来拆除机器"
    );

    public static final SlimefunItemStack REINFORCED_FLUFFY_WRENCH =
        new SlimefunItemStack("REINFORCED_FLUFFY_WRENCH",
        FluffyWrench.Wrench.REINFORCED.getMaterial(),
        "&b改进扳手",
        "",
        "&7用于快速移除Slimefun货物节点",
        "&7和机器",
        "",
        "&e左&7/&e右键 > &7来拆除机器"
    );

    public static final SlimefunItemStack CARBONADO_FLUFFY_WRENCH =
        new SlimefunItemStack("CARBONADO_FLUFFY_WRENCH",
        FluffyWrench.Wrench.CARBONADO.getMaterial(),
        "&7精制扳手",
        "",
        "&7用于快速删除Slimefun货物节点",
        "&7与各种物品",
        "",
        "&e左&7/&e右键 > &7来拆除机器",
        "",
        LoreBuilder.powerCharged(0, FluffyWrench.Wrench.CARBONADO.getMaxCharge())
    );

    public static final SlimefunItemStack PAXEL = new SlimefunItemStack("PAXEL",
        Material.DIAMOND_PICKAXE,
        "&b多功能工具",
        "",
        "&7镐子,斧头,剑随意切换!"
    );

    public static final SlimefunItemStack ADVANCED_CHARGING_BENCH = new SlimefunItemStack(
        "ADVANCED_CHARGING_BENCH",
        Material.SMITHING_TABLE,
        "&c高级充电台",
        "",
        "&7给物品充电",
        "&7可以使用&6ACB升级器升级"
    );

    public static final SlimefunItemStack ACB_UPGRADE_CARD = new SlimefunItemStack(
        "ACB_UPGRADE_CARD",
        Material.PAPER,
        "&6ACB升级器",
        "",
        "&e右键单击&7到&c高级充电台",
        "",
        "&6充电速度&a+" + AdvancedChargingBench.CHARGE + "J",
        "&6容量&a+" + AdvancedChargingBench.CAPACITY +"J",
        "&6能源消耗&c+" + AdvancedChargingBench.ENERGY_CONSUMPTION + "J"
    );

    private static final Enchantment glowEnchant = Enchantment.getByKey(Constants.GLOW_ENCHANT);

    static {
        FireproofRune.setFireproof(FIREPROOF_RUNE);
        SMALL_PORTABLE_CHARGER.addEnchantment(glowEnchant, 1);
        MEDIUM_PORTABLE_CHARGER.addEnchantment(glowEnchant, 1);
        BIG_PORTABLE_CHARGER.addEnchantment(glowEnchant, 1);
        LARGE_PORTABLE_CHARGER.addEnchantment(glowEnchant, 1);
        CARBONADO_PORTABLE_CHARGER.addEnchantment(glowEnchant, 1);
    }
}
