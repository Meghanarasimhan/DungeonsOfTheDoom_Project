package com.se459.model;

public class CombatModel {
    private PlayerModel playerModel;
    private MonsterModel monsterModel;

    public CombatModel(PlayerModel playerModel, MonsterModel monsterModel) {
        this.playerModel = playerModel;
        this.monsterModel = monsterModel;
    }

    public MonsterModel getMonsterModel() {
        return monsterModel;
    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public void setMonsterModel(MonsterModel monsterModel) {
        this.monsterModel = monsterModel;
    }

    public void setPlayerModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public boolean isBattleOver() {
        return monsterModel.getHpt() <= 0 || playerModel.getCurrHits() <= 0;
    }
}
