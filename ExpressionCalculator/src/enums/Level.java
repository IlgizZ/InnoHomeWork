package enums;

import java.util.List;

/**
 * Created by Ilgiz on 11.09.2016.
 */
public enum Level {
    LOGICAL(0), RELATION(1), TERM(2), FACTOR(3), INTEGER(4);

    private int id;

    Level(int id) {
        this.id = id;
    }

    public List<Operator> getOperators() {
        switch (this.id) {
            case 0:
                return Operator.getLogical();
            case 1:
                return Operator.getRelation();
            case 2:
                return Operator.getTerm();
            case 3:
                return Operator.getFactor();
        }
        return Operator.getNone();
    }

    public Level nextLevel() {
        if (this.equals(INTEGER))
            return null;
        return Level.values()[this.id + 1];
    }
}
