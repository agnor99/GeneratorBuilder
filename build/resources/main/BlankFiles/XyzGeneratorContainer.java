package com.agnor99.crazygenerators.objects.container;

import com.agnor99.crazygenerators.init.BlockInit;
import com.agnor99.crazygenerators.init.ContainerInit;
import com.agnor99.crazygenerators.objects.tile.GeneratorTileEntity;
import com.agnor99.crazygenerators.objects.tile.XyzGeneratorTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IntReferenceHolder;


public class XyzGeneratorContainer extends GeneratorContainer {

    public XyzGeneratorContainer(final int windowID, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowID, playerInventory, getTileEntity(playerInventory, data));
    }

    public XyzGeneratorContainer(final int windowID, final PlayerInventory playerInventory, final GeneratorTileEntity tileEntity) {
        super(ContainerInit.XYZ_GENERATOR.get(), windowID, playerInventory, tileEntity);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.xyz_generator);
    }

    @Override
    protected void tracking() {
        super.tracking();
        XyzGeneratorTileEntity gte = (XyzGeneratorTileEntity) tileEntity;
    }
}
