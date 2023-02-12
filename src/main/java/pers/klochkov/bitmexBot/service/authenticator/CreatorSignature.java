package pers.klochkov.bitmexBot.service.authenticator;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacUtils;
import pers.klochkov.bitmexBot.constants.TypeRequest;

import java.awt.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CreatorSignature {
    private String apiKey;
    private String apiSecret;
    private String path;
    private TypeRequest typeRequest;
    private Long expires;

    public CreatorSignature(String path, String apiKey, String apiSecret, TypeRequest typeRequest) {
        this.path = path;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.typeRequest = typeRequest;
    }

    public String getHMAC() {
        //verb + path + str(expires)
        /////
        typeRequest = TypeRequest.GET;
        apiSecret = "chNOOS4KvNXR_Xq4k4c9qsfoKWvnDecLATCRlcBwyKDYnWgO";
        path = "/api/v1/instrument";
        expires = 1518064236L;


        ////
        String data = typeRequest + path + expires;
        String algorithm = "HmacSHA256";
        String hmac = new HmacUtils(algorithm, apiSecret).hmacHex(data);
        String result = hmac;



        System.out.println(result.equals("c7682d435d0cfe87c16098df34ef2eb5a549d4c5a3c2b1f0f77b8af73423bf00"));
        System.out.println(result);
        return result;
    }

    public String signatureToStringMy(byte[] signature) {
//        String signatureStr = "";
//        signatureStr = String.format("%032x", new BigInteger(1, signature));
//        return signatureStr;


        return Hex.encodeHexString(signature);
    }

    public String signatureToStringIlya(byte[] signature) {
        String signatureStr = "";
        signatureStr = String.format("%032x", new BigInteger(1, signature));
        return signatureStr;


//        String hex = Hex.encodeHexString(signature);
    }


    public static void main(String[] args) {
        CreatorSignature creatorSignature = new CreatorSignature("kkk", "", "", TypeRequest.GET);
        String hmac = creatorSignature.getHMAC();
        System.out.println(creatorSignature.signatureToStringMy(hmac.getBytes(StandardCharsets.UTF_8)).equals(creatorSignature.signatureToStringIlya(hmac.getBytes(StandardCharsets.UTF_8))));
    }


}
