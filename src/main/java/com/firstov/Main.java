package com.firstov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import static com.firstov.Main.WarningType.*;

public class Main {

    private final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Have not arguments!");
        } else if (args.length > 1) {
            System.out.println("Found more than one argument!");
        } else if (Arrays.stream(WarningType.values()).anyMatch(s -> s.getCode().equals(args[0].toUpperCase()))) {
            String warn = args[0].toUpperCase();
            if (ERROR.getCode().equals(warn)) {
                log.error("info message");
            } else if (WARN.getCode().equals(warn)) {
                log.warn("info message");
            } else if (INFO.getCode().equals(warn)) {
                log.info("info message");
            }
        } else {
            System.out.println("Not expected argument!");
        }
    }

    enum WarningType {
        ERROR("ERROR"),
        WARN("WARN"),
        INFO("INFO");

        private String code;

        WarningType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
