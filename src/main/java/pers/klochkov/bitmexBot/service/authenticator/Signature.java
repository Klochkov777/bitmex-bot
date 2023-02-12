package pers.klochkov.bitmexBot.service.authenticator;

import org.apache.commons.codec.binary.Hex;
import pers.klochkov.bitmexBot.constants.AlgorithmHMAC;
import pers.klochkov.bitmexBot.constants.TypeRequest;

import java.nio.charset.StandardCharsets;

public class Signature {
//    private byte[] createSignature(String verb, String path, String data, String expires, String apiSecret) {
//        CreatorHMAC hmac = new CreatorHMAC();
//        return hmac.calcHmacSha256(apiSecret.getBytes(StandardCharsets.UTF_8),
//                (verb + path + expires + data).getBytes(StandardCharsets.UTF_8));
//    }

    public byte[] createSignature(String apiSecret, TypeRequest typeRequest, String path, String expires, String data) {
        Hmac hmac = new Hmac();
        return hmac.createHMAC256(apiSecret, typeRequest, path, expires, data).getBytes(StandardCharsets.UTF_8);
    }

    public String signatureToHEXString(byte[] signature) {
        return Hex.encodeHexString(signature);
    }
}
