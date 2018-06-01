package com.andreyplis.springplugin;

import com.tibbo.aggregate.common.context.*;
import com.tibbo.aggregate.common.plugin.*;
import org.java.plugin.*;
import org.springframework.context.annotation.*;

public class SpringPlugin extends AbstractContextPlugin {


    @Override
    public void globalInit(Context rootContext) throws PluginException {
        super.globalInit(rootContext);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        PluginManager pm = getPluginDirector().getPluginManager();
        ClassLoader cl = pm.getPluginClassLoader(pm.getRegistry().getPluginDescriptor("com.andreyplis.spring-plugin"));
        ctx.setClassLoader(cl);
        ctx.register(SpringConfiguration.class);
        ctx.refresh();

        Greet gt = ctx.getBean(Greet.class);
        gt.welcome();
    }
}