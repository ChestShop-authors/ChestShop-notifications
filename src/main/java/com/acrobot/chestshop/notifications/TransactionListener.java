package com.acrobot.chestshop.notifications;

import com.Acrobot.Breeze.Utils.InventoryUtil;
import com.Acrobot.Breeze.Utils.MaterialUtil;
import com.Acrobot.ChestShop.Economy.Economy;
import com.Acrobot.ChestShop.Events.TransactionEvent;
import com.google.common.base.Joiner;
import me.muizers.Notifications.Notification;
import me.muizers.Notifications.Notifications;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import static com.Acrobot.ChestShop.Events.TransactionEvent.TransactionType.BUY;
import static com.Acrobot.ChestShop.Events.TransactionEvent.TransactionType.SELL;

/**
 * @author Acrobot
 */
public class TransactionListener implements Listener {

    private Notifications notifications;

    public TransactionListener() {
        notifications = (Notifications) Bukkit.getPluginManager().getPlugin("Notifications");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onBuyTransaction(TransactionEvent event) {
        if (event.getTransactionType() != BUY) {
            return;
        }

        String firstLine = event.getClient().getName() + " bought " + parseItemInformation(event.getStock());
        String secondLine = "from " + event.getOwner().getName() + " for " + Economy.formatBalance(event.getPrice());

        Notification notification = new Notification("ChestShop", firstLine, secondLine);
        notifications.showNotification(notification);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onSellTransaction(TransactionEvent event) {
        if (event.getTransactionType() != SELL) {
            return;
        }

        String firstLine = event.getClient().getName() + " sold " + parseItemInformation(event.getStock());
        String secondLine = "to " + event.getOwner().getName() + " for " + Economy.formatBalance(event.getPrice());

        Notification notification = new Notification("ChestShop", firstLine, secondLine);
        notifications.showNotification(notification);
    }

    private static String parseItemInformation(ItemStack[] items) {
        ItemStack[] stock = InventoryUtil.mergeSimilarStacks(items);

        StringBuilder message = new StringBuilder(15);
        Joiner joiner = Joiner.on(' ');

        for (ItemStack item : stock) {
            joiner.appendTo(message, item.getAmount(), MaterialUtil.getName(item));
        }

        return message.toString();
    }
}
