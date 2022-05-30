package logcategory;

public enum LogCategoryEnum {

    INFO(1),
    ERROR(2),
    DEBUG(3);

    public int level;

    LogCategoryEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
