package org.llschall.jtrafficlight;

/**
 * Extract the required Arduino files to a folder aside of the Jar
 */
public class DeployIno {

    /**
     * @param args No args supported
     */
    public static void main(String[] args) {
        new DeployIno().process();
    }

    void process() {
        System.out.println("The jtraffiloght_ino files should be manually deployed on your Adruino board");

    }

}
