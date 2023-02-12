package pers.klochkov.bitmexBot.service.authenticator;

import org.apache.commons.codec.digest.HmacUtils;
import pers.klochkov.bitmexBot.constants.AlgorithmHMAC;
import pers.klochkov.bitmexBot.constants.TypeRequest;

public class Hmac {
    
    public String createHMAC(AlgorithmHMAC algorithmHMAC, String apiSecret, String data) {
        return new HmacUtils(algorithmHMAC.toString(), apiSecret).hmacHex(data);
    }
    
    public String createHMAC256(String apiSecret, TypeRequest typeRequest, String path, String expires, String data) {
        data = typeRequest + path + expires + data;
        return new HmacUtils(AlgorithmHMAC.SHA256.toString(), apiSecret).hmacHex(data);
    }
}
