
package pe.edu.upeu.syscenterlife.service;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComprobanteService {

    @Autowired
    private DataSource dataSource;

    public byte[] generarComprobante(String idVenta) throws Exception {
        InputStream jrxmlInput = new ClassPathResource("jasper/comprobante.jrxml").getInputStream();
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlInput);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idventa", idVenta);
        parameters.put("imagenurl", "ruta/a/la/imagen.png");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource.getConnection());
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
