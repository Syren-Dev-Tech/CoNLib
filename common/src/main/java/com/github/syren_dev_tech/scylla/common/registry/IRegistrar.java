package com.github.syren_dev_tech.scylla.common.registry;

import java.util.function.Supplier;

public interface IRegistrar<T> {
    <X extends T> Supplier<X> register(String modId, String name, Supplier<X> supplier);

    <X> void finish(X bus);
}
