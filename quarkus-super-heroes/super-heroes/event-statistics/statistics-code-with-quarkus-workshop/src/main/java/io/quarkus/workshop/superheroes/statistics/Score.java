package io.quarkus.workshop.superheroes.statistics;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Score {

    public String name;
    public int score;

    public int getScore() {
        return score;
    }

    public Score() {
        this.score = 0 ;
    }
}
