package org.intermine.app.net.request;

/*
 * Copyright (C) 2015 InterMine
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  See the LICENSE file for more
 * information or http://www.gnu.org/copyleft/lesser.html.
 *
 */

import android.content.Context;

import org.intermine.app.util.Uris;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.springframework.http.HttpMethod.POST;

public abstract class PostRequest<T> extends BaseRequest<T> {
    private MultiValueMap<String, String> mPost;

    public PostRequest(Class<T> clazz, Context ctx, String url, Map<String, ?> params,
                       MultiValueMap<String, String> post) {
        super(clazz, ctx, url, params);

        mPost = post;
    }

    @Override
    public HttpHeaders getHeaders() {
        HttpHeaders headers = super.getHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        return headers;
    }

    public MultiValueMap<String, String> getPost() {
        return mPost;
    }

    public void setPost(MultiValueMap<String, String> post) {
        mPost = post;
    }

    protected String post() {
        RestTemplate rtp = getRestTemplate();
        HttpHeaders headers = getHeaders();
        String uriString = getUrl();
        Map<String, ?> params = getUrlParams();
        MultiValueMap<String, String> post = getPost();

        HttpEntity<?> req;
        if (null != post) {
            req = new HttpEntity<Object>(post, headers);
        } else {
            req = new HttpEntity<String>(headers);
        }

        ResponseEntity<String> res;

        String uri = Uris.expandQuery(uriString, params);

        res = rtp.exchange(uri, POST, req, String.class);
        return res.getBody();
    }
}
