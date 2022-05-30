package logcategory;

import sink.LogSubject;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }


    @Override
    protected void display(String msg, LogSubject logSubject) {
        String message = "Error : " + msg;
        logSubject.notifyAllObserver(LogCategoryEnum.ERROR.getLevel(), message);

    }
}
