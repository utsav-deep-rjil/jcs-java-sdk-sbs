package com.jcs.sbs.auth;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.jcs.sbs.common.Utils;
import com.jcs.sbs.model.ProtocolAndHost;

/**
 * This class contains methods for adding required authorization parameters
 * before sending the actual request.
 */
public class Authorization {

    private String verb;
    private String accessKey;
    private String secretKey;
    private Map<String, String> headers;
    private String path;
    private String protocol;
    private String host;
    private String port;

    /**
     * Constructor for initializing data members of this class.
     * 
     * @param url
     *            Request URL on which authorization parameters are to be added
     * @param verb
     *            Request method of the API being called
     * @param accessKey
     *            Unique Access Key of the JCS account
     * @param secretKey
     *            Secret Key of the JCS account
     * @param headers
     *            Common headers that is to be added to any API request.
     */
    public Authorization(String url, String verb, String accessKey, String secretKey, Map<String, String> headers) {
        this.verb = verb;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.headers = headers;
        this.path = "/";
        ProtocolAndHost protocolAndHost = Utils.getProtocolAndHost(url);
        if (!Arrays.asList(new String[] { "http", "https" }).contains(protocolAndHost.getProtocol())) {
            throw new RuntimeException("Unsupported protocol present in given url :" + url);
        }
        this.protocol = protocolAndHost.getProtocol();
        this.host = protocolAndHost.getHost();
        this.port = "";
        if (host.indexOf(':') > 0) {
            String[] parts = host.split(":");
            this.host = parts[0];
            this.port = parts[1];
        }

    }

    /**
     * method to set some required common parameters like: JCSAccessKeyId,
     * SignatureVersion, SignatureMethod etc. in 'params' map that will be used
     * to create request url.
     * 
     * @param params
     *            Query parameters that is to be added to API request
     */
    public void addParams(Map<String, String> params) {
        params.put("JCSAccessKeyId", this.accessKey);
        params.put("SignatureVersion", "2");
        params.put("SignatureMethod", "HmacSHA256");
        params.put("Version", "2016-03-01");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        params.put("Timestamp", sdf.format(Calendar.getInstance().getTime()));
    }

    /**
     * Method to convert query params as java map to sorted query params as in
     * format of request URLs
     * 
     * @param params
     *            Query parameters as map
     * @return Query parameters converted to UTF-8 string in format used in
     *         request URLs
     * @throws UnsupportedEncodingException
     */
    public String sortParams(Map<String, String> params) throws UnsupportedEncodingException {
        List<String> sortedKeys = new ArrayList<String>(params.keySet());
        Collections.sort(sortedKeys);
        String value;
        String qs = "";
        for (String key : sortedKeys) {
            value = params.get(key);
            value = URLEncoder.encode(value, "UTF-8");
            qs = qs + key + "=" + value + "&";
        }
        qs = qs.substring(0, qs.length() - 1);
        return qs;
    }

    /**
     * This method generates the request string that is to be signed
     * 
     * @param params
     *            Request query parameters as a map
     * @return Request String that is to be signed
     * @throws UnsupportedEncodingException
     */
    public String stringToSign(Map<String, String> params) throws UnsupportedEncodingException {
        String ss = this.verb + "\n" + this.host;
        if (this.port != "") {
            ss += "\n" + this.port;
        }
        ss += "\n" + this.path + "\n";
        this.addParams(params);
        String qs = this.sortParams(params);
        ss += qs;
        return ss;
    }

    /**
     * Adds authorization parameters to the passed argument 'params'
     * 
     * @param params
     *            Initial map of request query parameters in which additional
     *            authorization parameters are to be added.
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IllegalStateException
     * @throws UnsupportedEncodingException
     */
    public void addAuthorization(Map<String, String> params)
            throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        String canonicalString = this.stringToSign(params);
        SecretKeySpec secret_key = new SecretKeySpec(this.secretKey.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(canonicalString.getBytes("UTF-8")));
        hash = new String(hash.getBytes(), "UTF-8");
        hash = URLEncoder.encode(hash, "UTF-8");
        hash = hash.replaceAll("%2F", "/");
        params.put("Signature", hash);
    }

}
