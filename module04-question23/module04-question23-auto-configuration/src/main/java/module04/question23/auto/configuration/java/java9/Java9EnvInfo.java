package module04.question23.auto.configuration.java.java9;

import module04.question23.auto.configuration.java.JavaEnvInfo;

class Java9EnvInfo implements JavaEnvInfo {

    @Override
    public void printJvmEnvInfo() {
        System.out.println("> Running from Java >= 9");
    }
}
