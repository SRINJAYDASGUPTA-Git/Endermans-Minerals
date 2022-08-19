package net.endermans.minerals.sound;

import net.endermans.minerals.EndermansMinerals;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;

public class ModSounds {

    public static SoundEvent DANDELIONS =
            registerSoundEvent("dandelions");
    public static SoundEvent ONE_DANCE =
            registerSoundEvent("one_dance");

    public static SoundEvent WATERMELON_SUGAR =
            registerSoundEvent("watermelon_sugar");



    public static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(EndermansMinerals.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }
}
