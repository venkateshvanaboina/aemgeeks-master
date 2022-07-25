package com.aem.geeks.core.page;

import com.day.cq.wcm.api.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import java.util.Optional;



    @Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
    public class HeaderAndFooterPageModel {

        private static final String FALLBACK_PATH = "/content/global-content/en";

        private static final String HEADER_PATH = "/header-and-footer/jcr:content/header";
        private static final String FOOTER_PATH = "/header-and-footer/jcr:content/footer";

        @Self
        @Via("resource")
        private Resource resource;


        private Page homepage;

        @SlingObject
        private ResourceResolver resourceResolver;

        public String getHeaderPath() {
            return getBasePage()
                    .map(page -> resourceResolver.resolve(page.getPath() + HEADER_PATH))
                    .map(Resource::getPath)
                    .orElse(null);
        }

        public String getFooterPath() {
            return getBasePage()
                    .map(page -> resourceResolver.resolve(page.getPath() + FOOTER_PATH))
                    .map(Resource::getPath)
                    .orElse(null);
        }

        private Optional<Page> getBasePage() {
            if (homepage == null && StringUtils.startsWith(resource.getPath(), "/conf/puratos")) {
                return Optional.ofNullable(resourceResolver.getResource(FALLBACK_PATH))
                        .map(resource -> resource.adaptTo(Page.class));
            }

            return Optional.ofNullable(homepage);
        }

    }


