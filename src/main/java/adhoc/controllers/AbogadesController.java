package adhoc.controllers;

import adhoc.models.Abogade;
import adhoc.services.AbogadesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbogadesController {
    private final AbogadesService service;

    public AbogadesController(AbogadesService service){
        this.service = service;
    }

    @RequestMapping("/abogades/show")
    public @ResponseBody
    Abogade show(long id) {
        return service.getAbogade(id);
    }

    @RequestMapping("/abogades/save")
    public void save(String nombre, String apellido) {
        service.saveAbodage(nombre, apellido);
    }

    @RequestMapping("/abogades/update")
    public void update(Long id, String nombre, String apellido)    {
        service.updateAbogade(id, nombre, apellido);
    }

}
