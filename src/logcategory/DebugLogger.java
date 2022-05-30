package logcategory;

import sink.LogSubject;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        this.level = level;
    }


    @Override
    protected void display(String msg, LogSubject logSubject) {
        String message = "Debug : " + msg;
        logSubject.notifyAllObserver(LogCategoryEnum.DEBUG.getLevel(), message);
    }
}
