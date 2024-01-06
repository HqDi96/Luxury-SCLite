package xyz.luxury;

import net.md_5.bungee.api.plugin.Plugin;

public class SCPlugin extends Plugin {
    @Override
    public void onEnable(){
        SC.INSTANCE.start(this);

    }
}
