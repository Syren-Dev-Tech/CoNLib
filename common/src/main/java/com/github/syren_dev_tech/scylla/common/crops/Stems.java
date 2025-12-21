package com.github.syren_dev_tech.scylla.common.crops;

import java.util.function.Supplier;

import com.github.syren_dev_tech.scylla.common.collections.Tuple;
import com.github.syren_dev_tech.scylla.common.registry.ModRegister;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class Stems {

    private Stems() {
    }

    public static class AttachedStems {

        private AttachedStems() {
        }

        public static final Supplier<AttachedStemBlock> create(ModRegister register, String name, StemGrownBlock fruit, Item seeds) {
            return register.blockRegistry.register(name, () -> new AttachedStemBlock(fruit, () -> seeds, Properties.copy(Blocks.ATTACHED_PUMPKIN_STEM)));
        }

        public static final Supplier<AttachedStemBlock> create(ModRegister register, String name, Properties properties, StemGrownBlock fruit, Item seeds) {
            return register.blockRegistry.register(name, () -> new AttachedStemBlock(fruit, () -> seeds, properties));
        }
    }

    public static class GrowingStems {

        private GrowingStems() {
        }

        public static final Supplier<StemBlock> create(ModRegister register, String name, StemGrownBlock fruit, Item seeds) {
            return register.blockRegistry.register(name, () -> new StemBlock(fruit, () -> seeds, Properties.copy(Blocks.PUMPKIN_STEM)));
        }

        public static final Supplier<StemBlock> create(ModRegister register, String name, Properties properties, StemGrownBlock fruit, Item seeds) {
            return register.blockRegistry.register(name, () -> new StemBlock(fruit, () -> seeds, properties));
        }
    }

    public static final Tuple<Supplier<StemBlock>, Supplier<AttachedStemBlock>> create(ModRegister register, String name, Properties properties, StemGrownBlock fruit, Item seeds) {
        var stem = GrowingStems.create(register, name, properties, fruit, seeds);
        var attachedStem = AttachedStems.create(register, "attached_" + name, properties, fruit, seeds);

        return new Tuple<>(stem, attachedStem);
    }

    public static final Tuple<Supplier<StemBlock>, Supplier<AttachedStemBlock>> create(ModRegister register, String name, StemGrownBlock fruit, Item seeds) {
        var stem = GrowingStems.create(register, name, fruit, seeds);
        var attachedStem = AttachedStems.create(register, "attached_" + name, fruit, seeds);

        return new Tuple<>(stem, attachedStem);
    }
}
