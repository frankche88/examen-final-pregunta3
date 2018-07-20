package universidad;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import universidad.alumnos.api.controller.AlumnosController;
import universidad.alumnos.application.dto.AlumnoToAlumnoDtoMapper;
import universidad.alumnos.domain.repository.AlumnosRepository;
import universidad.alumnos.infrastructure.fake.repository.FakeAlumnosRepository;
import universidad.common.api.controller.ResponseHandler;

public class UniversidadApplication extends Application<UniversidadConfiguration> {

	public static void main(String[] args) throws Exception {
		new UniversidadApplication().run(args);
	}


	@Override
	public String getName() {
		return "java-api";
	}

	@Override
	public void initialize(Bootstrap<UniversidadConfiguration> bootstrap) {

		bootstrap.addBundle(new CorsBundle());

	}

	@Override
	public void run(UniversidadConfiguration configuration, Environment environment) throws Exception {

		environment.jersey().register(AlumnosController.class);
		environment.jersey().register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				bind(ResponseHandler.class).to(ResponseHandler.class).in(Singleton.class );
				
				bind(FakeAlumnosRepository.class).to(AlumnosRepository.class).in(Singleton.class );
				
				bind(AlumnoToAlumnoDtoMapper.class).to(AlumnoToAlumnoDtoMapper.class).in(Singleton.class );
				
				
			}
		});

	}
}
