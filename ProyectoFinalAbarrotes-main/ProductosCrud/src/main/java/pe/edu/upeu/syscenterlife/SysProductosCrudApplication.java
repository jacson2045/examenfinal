package pe.edu.upeu.syscenterlife;

import java.awt.EventQueue;
import java.util.prefs.Preferences;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import pe.edu.upeu.syscenterlife.gui.FrmGestProducto;
import pe.edu.upeu.syscenterlife.gui.MainProducto;

@SpringBootApplication
public class SysProductosCrudApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SysAlmacenVcApplication.class, args);
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SysProductosCrudApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
        EventQueue.invokeLater(() -> {
            FrmGestProducto ex = ctx.getBean(FrmGestProducto.class);
            ex.setContexto(ctx);
            ex.setVisible(true);
        });
    }

}
