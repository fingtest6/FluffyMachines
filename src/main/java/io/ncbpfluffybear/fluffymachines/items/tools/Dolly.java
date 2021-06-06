package io.ncbpfluffybear.fluffymachines.items.tools;

import io.github.thebusybiscuit.slimefun4.api.player.PlayerBackpack;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import io.ncbpfluffybear.fluffymachines.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.concurrent.atomic.AtomicBoolean;

public class Dolly extends SimpleSlimefunItem<ItemUseHandler> {

    private static final ItemStack lockItem = Utils.buildNonInteractable(Material.DIRT, "&4&l错误", "&c你要搬到哪里?");

    public Dolly(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return e -> {
            e.cancel();

            Player p = e.getPlayer();
            ItemStack dolly = e.getItem();

            if (!e.getClickedBlock().isPresent()) {
                return;
            }

            Block b = e.getClickedBlock().get();

            if (!Slimefun.getProtectionManager().hasPermission(e.getPlayer(), b.getLocation(),
                Interaction.BREAK_BLOCK)) {
                return;
            }

            Block relative = b.getRelative(e.getClickedFace());

            if (b.getType() == Material.CHEST && !BlockStorage.hasBlockInfo(b)) {

                ItemMeta dollyMeta = dolly.getItemMeta();
                for (String line : dollyMeta.getLore()) {
                    if (line.contains("ID: <ID>")) {
                        PlayerProfile.get(p, profile -> {
                            int backpackId = profile.createBackpack(27).getId();
                            Slimefun.getBackpackListener().setBackpackId(p, dolly, 3, backpackId);
                            PlayerProfile.getBackpack(dolly, backpack -> backpack.getInventory().setItem(0, lockItem));
                        });
                    }
                }

                Inventory chest = ((InventoryHolder) b.getState()).getInventory();

                if (chest.getSize() > 27) {
                    Utils.send(p, "&c单次只能搬运一个箱子!");
                    return;
                }

                ItemStack[] contents = chest.getContents();

                AtomicBoolean exists = new AtomicBoolean(false);
                PlayerProfile.getBackpack(dolly, backpack -> {
                    if (backpack != null && backpack.getInventory().getItem(0) != null
                        && Utils.checkNonInteractable(backpack.getInventory().getItem(0))) {
                        backpack.getInventory().setStorageContents(contents);
                        chest.clear();
                        PlayerProfile.getBackpack(dolly, PlayerBackpack::markDirty);
                        exists.set(true);
                        dolly.setType(Material.CHEST_MINECART);
                    } else {
                        Utils.send(p, "&c上面已经有箱子了!");
                    }
                });

                // Deals with async problems
                if (exists.get()) {
                    b.setType(Material.AIR);
                    Utils.send(p, "&a你拾起了箱子");
                }


            } else if (relative.getType() == Material.AIR) {

                PlayerProfile.getBackpack(dolly, backpack -> {
                    if (backpack != null && (backpack.getInventory().getItem(0) == null || !Utils.checkNonInteractable(backpack.getInventory().getItem(0)))) {
                        ItemStack[] bpcontents = backpack.getInventory().getContents();
                        backpack.getInventory().clear();
                        backpack.getInventory().setItem(0, lockItem);
                        relative.setType(Material.CHEST);
                        ((InventoryHolder) relative.getState()).getInventory().setStorageContents(bpcontents);
                        dolly.setType(Material.MINECART);
                        Utils.send(p, "&a箱子已放置");
                    } else {
                        Utils.send(p, "&c你必须先拾起一个箱子!");
                    }
                });
            }
        };
    }


}
