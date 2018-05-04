package com.tuxdev.kontaweb.services.constants;

/**
 * Created by j.sanchez.chaves on 4/27/2018.
 *
 * KONTA-pom
 */
public class Constants {
    public static enum typeAccounts{
        ALL("all"),SUBTOPIC("subtopic"),QA("QA");
        /**
         * Instantiates a new results.
         *
         * @param value the value
         */
        private typeAccounts(String value){
            this.value = value;
        }

        String value;

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }
    }
}
