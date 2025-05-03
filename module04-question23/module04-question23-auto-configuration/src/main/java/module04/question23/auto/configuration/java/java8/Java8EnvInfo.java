package module04.question23.auto.configuration.java.java8;

import module04.question23.auto.configuration.java.JavaEnvInfo;

class Java8EnvInfo implements JavaEnvInfo {

    @Override
    public void printJvmEnvInfo() {
        System.out.println("> Running from Java <= 8");
    }
}
