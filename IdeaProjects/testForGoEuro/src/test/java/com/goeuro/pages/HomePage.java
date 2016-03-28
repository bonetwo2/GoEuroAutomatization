package com.goeuro.pages;

import com.goeuro.Bindings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by aviv on 18/03/16.
 */

@Component
public class HomePage extends Bindings {

    @Override
    @Value("${url.homepage}")
    public void setUrl(String url) {
        this.url = url;
    }
}
