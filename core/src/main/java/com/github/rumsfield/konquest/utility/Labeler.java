package com.github.rumsfield.konquest.utility;

import com.github.rumsfield.konquest.api.model.KonquestDiplomacyType;
import com.github.rumsfield.konquest.api.model.KonquestTerritoryType;

/**
 * Provides static methods for looking up MessagePath labels from API enums
 */
public class Labeler {

    public static String lookup(KonquestDiplomacyType type) {
        switch(type) {
            case ENEMY:
                return MessagePath.RELATIONSHIP_ENEMY.getMessage();
            case PEACE:
                return MessagePath.RELATIONSHIP_PEACE.getMessage();
            case ALLIED:
                return MessagePath.RELATIONSHIP_ALLIED.getMessage();
            case SANCTIONED:
                return MessagePath.RELATIONSHIP_SANCTIONED.getMessage();
            default:
                break;
        }
        return "";
    }

    public static String lookup(KonquestTerritoryType type) {
        switch(type) {
            case WILD:
                return MessagePath.TERRITORY_WILD.getMessage();
            case CAPITAL:
                return MessagePath.TERRITORY_CAPITAL.getMessage();
            case TOWN:
                return MessagePath.TERRITORY_TOWN.getMessage();
            case CAMP:
                return MessagePath.TERRITORY_CAMP.getMessage();
            case RUIN:
                return MessagePath.TERRITORY_RUIN.getMessage();
            case SANCTUARY:
                return MessagePath.TERRITORY_SANCTUARY.getMessage();
            default:
                break;
        }
        return "";
    }

}
