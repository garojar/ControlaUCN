package cl.ucn.disc.dam.controlaucn;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import cl.ucn.disc.dam.controlaucn.model.Persona;
import cl.ucn.disc.dam.controlaucn.model.Vehiculo;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Germán Rojo on 27-12-2017.
 */

@Slf4j
@RunWith(RobolectricTestRunner.class)
public class TestDBFlow {



    /**
     * Testing the db creation
     */
    @Test
    public void testCreateDatabase() {

        // Timer
        final StopWatch stopWatch = StopWatch.createStarted();

        log.d("Saving tests ..");
        {

            final ModelAdapter<Persona> personaDAO = FlowManager.getModelAdapter(Persona.class);
            log.debug("isCachingEnabled? {}", personaDAO.cachingEnabled());
            log.debug("Creation query: {}", personaDAO.getCreationQuery());

            log.debug("Building persona ..");
            final Persona persona = Persona.builder()
                    .nombre("Diego")
                    .numCelular("962044443")
                    .correo("dst005@alumnos.ucn.cl")
                    .rut("18.741.730-9")
                    .build();

            log.debug("Persona: {}", persona);
            personaDAO.insert(persona);

            log.debug("Persona saved: {}", persona);

            final ModelAdapter<Vehiculo> vehiculoDAO = FlowManager.getModelAdapter(Vehiculo.class);
            log.debug("isCachingEnabled? {}", vehiculoDAO.cachingEnabled());
            log.debug("Creation query: {}", vehiculoDAO.getCreationQuery());

            // Saving
            {

                log.debug("Building vehiculo ..");
                final Vehiculo vehiculo = Vehiculo.builder()
                        .patente("pk0021")
                        .year("2016")
                        .marca("Suzuki")
                        .modelo("Grand Nomade")
                        .owner(persona)
                        .nota("Estacionamiento en Y1")
                        .build();

                log.debug("Vehiculo: {}", vehiculo);

                log.debug("Saving vehiculo ..");
                vehiculoDAO.insert(vehiculo);

                log.debug("Vehicle saved: {}", vehiculo);
            }

        }

        // Getting
        {
        }

        // Timming
        log.debug("Done in: {}", stopWatch);

    }
}
