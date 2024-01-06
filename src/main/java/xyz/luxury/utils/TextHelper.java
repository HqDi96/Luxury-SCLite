package xyz.luxury.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import net.md_5.bungee.api.ChatColor;

public class TextHelper {

    public static String[] format(String... strings){
        return Arrays.stream(strings).map(TextHelper::format).toArray(String[]::new);
    }
    public static String format(String string){
        return ChatColor.translateAlternateColorCodes('&', string);
    }
    public static List<String> format(List<String> strings){
        return strings.stream().map(TextHelper::format).collect(Collectors.toList());
    }
}