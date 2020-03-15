package game;

import avatar.*;

/**
 * FightRound
 */
public class FightRound {
    private AvatarType currentTurn;

    private Monster[] teamOfMonsters;

    private Hero[] teamOfHeros;

    FightRound() {

    }

    public int numberOfAliveAvatar(AvatarType team) {
        if (team == AvatarType.Hero) {
            return teamOfHeros.length;
        }

        if (team == AvatarType.Monster) {
            return teamOfMonsters.length;
        }

        return -1;
    }

    private void changeTurn() {
        if (currentTurn == AvatarType.Hero) {
            currentTurn = AvatarType.Monster;
        }

        if (currentTurn == AvatarType.Monster) {
            currentTurn = AvatarType.Hero;
        }
    }

    private void takeAction(Avatar executor, Avatar target, ActionType action) {

    }

    private boolean areAllDead(Avatar[] team) {
        for (Avatar avatar : team) {
            if (!avatar.getIsDead()) {
                return false;
            }
        }
        return true;
    }

    private void recoverHP(Hero[] heros) {
        for (Hero hero : heros) {
            hero.recover();
        }
    }
}