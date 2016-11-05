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
 * Contains methods for adding required authorization parameters before sending
 * the actual request.
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
     *            Request URL to which authorization parameters are to be added
     * @param verb
     *            Request method of the API
     * @param accessKey
     *            Access Key of the JCS account
     * @param secretKey
     *            Secret Key of the JCS account
     * @param headers
     *            Common headers that are to be added to any API request.
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
     * Sets required common parameters, such as JCSAccessKeyId,
     * SignatureVersion, SignatureMethod and so on, in 'params' map that is used
     * to create request URL.
     * 
     * @param params
     *            Query parameters that are to be added to API request
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
     * Converts query parameters as java map to sorted query parameters as in
     * format of request URLs. In other words, it serializes the query
     * parameters
     * 
     * @param params
     *            Query parameters as map
     * @return Query parameters converted to UTF-8 string format used in request
     *         URLs
     * @throws UnsupportedEncodingException
     */
    public String serializeParams(Map<String, String> params) throws UnsupportedEncodingException {
        List<String> sortedKeys = new ArrayList<String>(params.keySet());
        Collections.sort(sortedKeys);
        String value;
        StringBuilder qs = new StringBuilder();
        for (String key : sortedKeys) {
            value = params.get(key);
            value = URLEncoder.encode(value, "UTF-8");
            qs.append(key).append("=").append(value).append("&");
        }
        qs.deleteCharAt(qs.length()-1);
        return qs.toString();
    }

    /**
     * Generates the request string that needs to be signed
     * 
     * @param params
     *            Request query parameters as a map
     * @return Request String that needs to be signed
     * @throws UnsupportedEncodingException
     */
    public String stringToSign(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder ss = new StringBuilder(this.verb).append("\n").append(this.host);
        if (this.port != "") {
            ss.append("\n").append(this.port);
        }
        ss.append("\n").append(this.path).append("\n");
        this.addParams(params);
        String qs = this.serializeParams(params);
        ss.append(qs);
        return ss.toString();
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
