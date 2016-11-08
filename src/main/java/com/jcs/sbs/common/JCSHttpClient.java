package com.jcs.sbs.common;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.jcs.sbs.auth.Authorization;
import com.jcs.sbs.auth.JCSCredentials;

/**
 * Contains method used for making API calls and related utility
 * methods.
 *
 */
@ThreadSafe
public abstract class JCSHttpClient {

    protected volatile String endpoint;
    private static final Log log = LogFactory.getLog(JCSHttpClient.class);

    /**
     * Default constructor for JCSHttpClient object.
     */
    public JCSHttpClient() {
        super();
    }

    /**
     * Sets the base URL of the APIs to be called.
     * 
     * @param endpoint
     *            Base URL of the APIs
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    /**
     * 
     * @param headers
     *            Headers in the form of map, that are to be present in the URL
     *            of the API calls
     */
    private void addCustomHeaders(Map<String, String> headers) {
        headers.put("Content-Type", "application/json");
        headers.put("Accept-Encoding", "identity");
    }

    /**
     * It generates final API URL, calls it and returns the HTTP response object
     * containing the response returned by backend API.
     * 
     * @param credentials
     *            Object of type JCSCredentials, contains ACCESS_KEY and
     *            SECRET_KEY
     * @param params
     *            Query Params in the API call
     * @param headers
     *            Headers to be present in the API call
     * @return CloseableHttpResponse object containing the details of response
     *         of the called API.
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     * @throws IllegalStateException
     * @throws ClientProtocolException
     * @throws IOException
     * 
     *             This method creates the request URL, populates required
     *             headers and then executes the request.
     */
    protected CloseableHttpResponse makeRequest(JCSCredentials credentials, Map<String, String> params,
            Map<String, String> headers) throws InvalidKeyException, NoSuchAlgorithmException, IllegalStateException,
            ClientProtocolException, IOException {
        addCustomHeaders(headers);
        Authorization authorization = new Authorization(endpoint.toString(), "GET", credentials.getJCSAccessKey(),
                credentials.getJCSSecretKey(), headers);
        authorization.addAuthorization(params);
        String url = getUrl(params);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpRequestBase httpGet = new HttpGet(url);

        for (String header : headers.keySet()) {
            httpGet.addHeader(header, headers.get(header));
        }

        log.info("Getting response from URL: " + url);
        CloseableHttpResponse closeableHttpResponse = httpclient.execute(httpGet);

        return closeableHttpResponse;
    }

    /**
     * Returns the URL after adding query parameters.
     * 
     * @param params
     *            Query parameters in the form of map that are to be present in
     *            the API being called.
     * @return Query parameters in the form of string in URL format.
     */
    private String getUrl(Map<String, String> params) {
        StringBuilder url = new StringBuilder(this.endpoint);
        url.append("/?");
        for (String key : params.keySet()) {
            url.append(key).append("=").append(params.get(key)).append("&");
        }
        url.deleteCharAt(url.length() - 1);
        return url.toString();
    }

}
