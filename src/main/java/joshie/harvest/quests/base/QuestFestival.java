package joshie.harvest.quests.base;

import joshie.harvest.api.quests.Quest;
import net.minecraftforge.fml.common.eventhandler.EventPriority;

import java.util.Set;

public abstract class QuestFestival extends QuestTown {
    @Override
    public EventPriority getPriority() {
        return EventPriority.HIGHEST;
    }

    @Override
    public boolean canStartQuest(Set<Quest> active, Set<Quest> finished) {
        return false;
    }

    @Override
    public boolean isRepeatable() {
        return true;
    }
}
