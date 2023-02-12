package pers.klochkov.bitmexBot.constants;

public enum AlgorithmHMAC {

    SHA256("HmacSHA256"),
    MD5("HmacMD5"),
    SHA1("HmacSHA1"),
    SHA224("HmacSHA224"),
    SHA384("HmacSHA384"),
    SHA512("HmacSHA512");

    private String algorithm;

    AlgorithmHMAC(String algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public String toString() {
        return algorithm;
    }
}
