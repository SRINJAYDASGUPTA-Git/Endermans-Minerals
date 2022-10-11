package net.endermans.minerals.world.gen;

public class ModWorldGen {

    public static void generateWorld(){
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();
    }
}
