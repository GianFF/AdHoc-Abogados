package adhoc.services;

import adhoc.AdHocApplication;
import adhoc.controllers.AbogadesController;
import adhoc.models.Abogade;
import adhoc.repositories.AbogadesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AbogadesService {
    private AbogadesRepository repository;
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(AdHocApplication.class);

    public AbogadesService(AbogadesRepository repository){
        this.repository = repository;
    }

    public Abogade getAbogade(long id) {
        long logId = this.counter.incrementAndGet();
        Abogade abogade = null;
        try{
            abogade = this.repository.findById(id).get();
        }catch (NoSuchElementException ex){
            log.info(formatLogId(logId)+ "Abogade not found with id:" + id);
        }
        finally {
            if(abogade == null){
                abogade = new Abogade("", "");
            }
        }
        return abogade;
    }

    public void saveAbodage(String nombre, String apellido) {
        long logId = counter.incrementAndGet();
        try{
            log.info(formatLogId(logId) + "saving abogade with nombre: "+nombre+", and apellido "+ apellido);
            repository.save(new Abogade(nombre, apellido));
        }catch(Exception ex){
            log.info(formatLogId(logId) + "error: "+ ex.getMessage());
            throw ex;
        }
    }

    public void updateAbogade(Long id, String nombre, String apellido) {
        long logId = counter.incrementAndGet();
        try{
            log.info(formatLogId(logId) + "saving abogade with nombre: "+nombre+", and apellido "+ apellido);

            repository.save(new Abogade(nombre, apellido));
        }catch(Exception ex){
            log.info(formatLogId(logId) + "error: "+ ex.getMessage());
            throw ex;
        }finally {
            log.info(formatLogId(logId) + "finally");
        }
    }


    private String formatLogId(long logId) {
        return "[" + logId + "] - ";
    }
}
