package logcategory;

import sink.LogSubject;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }


    @Override
    protected void display(String msg, LogSubject logSubject) {
        String message = "Info : " + msg;
        logSubject.notifyAllObserver(LogCategoryEnum.INFO.getLevel(), message);

    }
}
