package com.andreyplis.springplugin;

import com.tibbo.aggregate.common.context.*;
import com.tibbo.aggregate.common.plugin.*;
import org.java.plugin.*;
import org.springframework.context.annotation.*;

public class SpringPlugin extends AbstractContextPlugin {


    @Override
    public void globalInit(Context rootContext) throws PluginException {
        super.globalInit(rootContext);

        PluginManager pm = getPluginDirector().getPluginManager();
        ClassLoader cl = pm.getPluginClassLoader(pm.getRegistry().getPluginDescriptor("com.andreyplis.spring-plugin"));
        launchSpring(cl);
    }


    public static void launchSpring(ClassLoader classLoader) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        if (classLoader != null)
            ctx.setClassLoader(classLoader);
        ctx.register(SpringConfiguration.class);
        ctx.refresh();

        Greet gt = ctx.getBean(Greet.class);
        gt.welcome();
    }
}