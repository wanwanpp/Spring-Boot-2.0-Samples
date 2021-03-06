package com.bee.sample.ch4.conf;

import com.bee.sample.ch4.util.SimpleFunction;
import com.bee.sample.ch4.util.SimpleTag;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeetlExtConfig {

    @Autowired
    GroupTemplate groupTemplate;

    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void config() {
        Map<String, Object> shared = new HashMap<String, Object>();
        shared.put("jsVersion", System.currentTimeMillis());
        groupTemplate.registerFunction("hi", applicationContext.getBean(SimpleFunction.class));
        groupTemplate.registerTagFactory("myTag", new TagFactory() {
            @Override
            public Tag createTag() {
                return applicationContext.getBean(SimpleTag.class);
            }
        });
        URL url = BeetlExtConfig.class.getResource("/templates/functions");
        System.out.print("==================" + url);
    }

    //		@Bean /*另外一种配置方法，实现BeetlTemplateCustomize*/
    //	  public BeetlTemplateCustomize beetlTemplateCustomize(){
    //	    return new BeetlTemplateCustomize(){
    //	      public void customize(GroupTemplate groupTemplate){
    //
    //	      }
    //	    };
    //	  }

}
