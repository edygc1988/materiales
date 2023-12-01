package com.integra.materiales.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integra.materiales.dto.EgresoMovimientoDto;
import com.integra.materiales.model.EgresoMovimiento;
import com.integra.materiales.services.EgresoMovimientoService;

@RestController
@RequestMapping("/api/v1/egresomovimiento")
public class EgresoMovimientoController {
    private final EgresoMovimientoService egresoMovimientoService;

    // The `@Autowired` annotation is used to automatically wire the
    // `EgresoMovimientoService` bean into
    // the `EgresoMovimientoController` class.
    public EgresoMovimientoController(EgresoMovimientoService egresoMovimientoService) {
        this.egresoMovimientoService = egresoMovimientoService;
    }

    @GetMapping
    // The method `getAllEgresoMov()` is a GET request handler that returns a
    // `ResponseEntity`
    // containing a list of `EgresoMovimiento` objects. This method is used to
    // retrieve all the
    // `EgresoMovimiento` objects from the database and return them as a response.
    public ResponseEntity<EgresoMovimientoDto> getAllEgresoMov() {

        List<EgresoMovimiento> listaEgresos = egresoMovimientoService.getAllEgresoMov();

        EgresoMovimientoDto customResponse = new EgresoMovimientoDto();
        customResponse.setStatus("Ok"); // Replace with your actual status
        customResponse.setTotalResults(listaEgresos.size());
        customResponse.setItems(listaEgresos);

        return ResponseEntity.ok(customResponse);
    }

    @GetMapping("/{id}")
    // The method `getEgresoMovimientoById` is a GET request handler that retrieves
    // an
    // `EgresoMovimiento` object from the database based on the provided `id`.
    public ResponseEntity<EgresoMovimientoDto> getEgresoMovimientoById(@PathVariable Long id) {
        return egresoMovimientoService.getEgresoMovimientoById(id)
                .map(egresoMovimiento -> {
                    EgresoMovimientoDto customResponse = new EgresoMovimientoDto();
                    customResponse.setStatus("Ok"); // Reemplaza con tu estado real
                    customResponse.setTotalResults(Collections.singletonList(egresoMovimiento).size()); // En este caso,
                                                                                                        // es un solo
                                                                                                        // elemento, no
                                                                                                        // una lista
                    customResponse.setItems(Collections.singletonList(egresoMovimiento));
                    return ResponseEntity.ok(customResponse);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/egreso/{nroFisico}")
    public ResponseEntity<EgresoMovimientoDto> getEgresoMovimientoByNroFisico(@PathVariable Long nroFisico) {
        List<EgresoMovimiento> listEgreso = egresoMovimientoService.getEgresoMovimientoByNroFisico(nroFisico);
        EgresoMovimientoDto egresoDto = new EgresoMovimientoDto();
        egresoDto.setStatus("Ok");
        egresoDto.setTotalResults(listEgreso.size());
        egresoDto.setItems(listEgreso);

        return ResponseEntity.ok(egresoDto);
    }

    @PostMapping
    // The method `createEgresoMovimiento` is a POST request handler that creates a
    // new
    // `EgresoMovimiento` object in the database. It takes in an `EgresoMovimiento`
    // object as a request
    // body and returns a `ResponseEntity` containing a `Map` object with the result
    // code and status.
    public ResponseEntity<Map<String, Object>> createEgresoMovimiento(@RequestBody EgresoMovimiento egresoMovimiento) {

        egresoMovimientoService.saveEgresoMovimiento(egresoMovimiento);
        // The line `Map<String, Object> response = new HashMap<>();` is creating a new
        // instance of the
        // `HashMap` class and assigning it to the variable `response`.
        Map<String, Object> response = new HashMap<>();
        response.put("resultCode", HttpStatus.CREATED);
        response.put("status", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    // The method `updateListaCorte` is a PUT request handler that updates an
    // existing
    // `EgresoMovimiento` object in the database. It takes in two parameters: `id`
    // and
    // `egresoMovimiento`.
    public ResponseEntity<EgresoMovimiento> updateListaCorte(@PathVariable Long id,
            @RequestBody EgresoMovimiento egresoMovimiento) {
        return ResponseEntity.ok(egresoMovimientoService.saveEgresoMovimiento(egresoMovimiento));
    }

    @DeleteMapping("/{id}")
    // The method `deleteEgresoMovimiento` is a DELETE request handler that deletes
    // an
    // `EgresoMovimiento` object from the database based on the provided `id`. It
    // takes in the `id` as
    // a path variable and returns a `ResponseEntity` with a `Void` response body.
    // The `ResponseEntity`
    // is used to indicate the success or failure of the delete operation. In this
    // case, it returns a
    // `204 No Content` status code to indicate that the delete operation was
    // successful and there is
    // no content to return in the response body.
    public ResponseEntity<Void> deleteEgresoMovimiento(@PathVariable Long id) {
        egresoMovimientoService.deleteEgreso(id);
        return ResponseEntity.noContent().build();
    }

}
