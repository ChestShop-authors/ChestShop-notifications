package com.acrobot.chestshop.notifications.properties;

import com.Acrobot.Breeze.Configuration.Annotations.PrecededBySpace;

/**
 * @author Acrobot
 */
public class Messages {
    public static String BUY_TRANSACTION_FIRST_LINE = "%client bought %stock";
    public static String BUY_TRANSACTION_SECOND_LINE = "from %owner for %price";

    @PrecededBySpace
    public static String SELL_TRANSACTION_FIRST_LINE = "%client sold %stock";
    public static String SELL_TRANSACTION_SECOND_LINE = "to %owner for %price";

    @PrecededBySpace
    public static String SHOP_CREATION_FIRST_LINE = "%player created a shop selling %item";
    public static String SHOP_CREATION_SECOND_LINE = "at %location";
}
