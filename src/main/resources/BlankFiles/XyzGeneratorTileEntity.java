package com.agnor99.crazygenerators.objects.tile;

import com.agnor99.crazygenerators.objects.container.XyzGeneratorContainer;
import com.agnor99.crazygenerators.init.TileInit;
import com.agnor99.crazygenerators.network.packets.sync.PacketAbstractSyncResponse;
import com.agnor99.crazygenerators.network.packets.sync.PacketXyzSyncResponse;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.tileentity.TileEntityType;

import java.awt.*;
import java.util.Random;

public class XyzGeneratorTileEntity extends GeneratorTileEntity{

    public XyzGeneratorTileEntity(final TileEntityType<?> tileEntityType) {
        super(tileEntityType);

    }
    public XyzGeneratorTileEntity() {
        this(TileInit.XYZ_GENERATOR.get());
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.xyz_generator");
    }

    @Override
    public void tick() {
        super.tick();
        if(!shouldTickIntern()) return;
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new XyzGeneratorContainer(id, player, this);
    }


    @Override
    public PacketAbstractSyncResponse generateSyncPacket() {
        return new PacketXyzSyncResponse(getEnergy());
    }
}
