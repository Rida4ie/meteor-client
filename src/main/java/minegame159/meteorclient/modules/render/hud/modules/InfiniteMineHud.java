/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2021 Meteor Development.
 */

package minegame159.meteorclient.modules.render.hud.modules;

import minegame159.meteorclient.modules.ModuleManager;
import minegame159.meteorclient.modules.player.InfinityMiner;
import minegame159.meteorclient.modules.render.hud.HUD;

public class InfiniteMineHud extends DoubleTextHudModule {
    public InfiniteMineHud(HUD hud) {
        super(hud, "infmine", "Displays details regarding Infinity Mine.", "Infinity Mine: ");
    }

    @Override
    protected String getRight() {
        InfinityMiner infinityMiner = ModuleManager.INSTANCE.get(InfinityMiner.class);
        if (!infinityMiner.isActive()) return "Disabled";

        switch (infinityMiner.getMode()) {
            case Home:
                int[] coords = infinityMiner.getHomeCoords();
                return "Heading Home: " + coords[0] + " " + coords[1] + " " + coords[2];
            case Target:
                return "Mining: " + infinityMiner.getCurrentTarget().getName().getString();
            case Repair:
                return "Repair-Mining: " + infinityMiner.getCurrentTarget().getName().getString();
            case Still:
                return "Resting";
            default:
                return "";
        }
    }
}
