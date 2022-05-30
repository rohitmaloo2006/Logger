package logcategory;

import sink.LogSubject;

public abstract class AbstractLogger {
    int level;
    AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger loggingLevel) {
        this.nextLoggingLevel = loggingLevel;
    }

    public void logMessage(int level, String msg, LogSubject logSubject) {
        if (this.level == level) {
            display(msg, logSubject);
        }
        if (nextLoggingLevel != null) {
            nextLoggingLevel.logMessage(level, msg, logSubject);
        }
    }

    protected abstract void display(String msg, LogSubject logSubject);

}
