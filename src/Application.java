import logger.Logger;

public class Application {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
       // logger.infoLog(" this is info");
        logger.errorLog(" this is error");

    }
}
