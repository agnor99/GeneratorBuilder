package com.agnor99.crazygenerators.client.gui;

import com.agnor99.crazygenerators.CrazyGenerators;
import com.agnor99.crazygenerators.client.gui.util.GeneratorScreen;
import com.agnor99.crazygenerators.network.NetworkUtil;
import com.agnor99.crazygenerators.objects.container.XyzGeneratorContainer;
import com.agnor99.crazygenerators.objects.tile.XyzGeneratorTileEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;


@OnlyIn(Dist.CLIENT)
public class XyzGeneratorScreen extends GeneratorScreen<XyzGeneratorContainer> {

    public XyzGeneratorScreen(XyzGeneratorContainer screenContainer, PlayerInventory playerInventory, ITextComponent title) {
        super(screenContainer, playerInventory, title, "information.xyz_generator");
        setBackgroundTexture(new ResourceLocation(CrazyGenerators.MOD_ID, "textures/gui/xyz_generator.png"));

    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        final int WHITE = 16777215;
        final int DEFAULT_COLOR = 4210752;


        Point relativeMousePosition = new Point(mouseX, mouseY);
        relativeMousePosition.translate(-RELATIVE_SCREEN_POSITION.x, -RELATIVE_SCREEN_POSITION.y);

        drawHoverMessages(relativeMousePosition);
    }

    @Override
    protected void drawHoverMessages(Point mousePosition) {
        super.drawHoverMessages(mousePosition);
    }
}
