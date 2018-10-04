package shu.cases2.server.rest.api;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

import shu.cases2.server.rest.TextForm;

public class ApplicationConfig extends Application {
		private final Set<Class<?>> classes;
		
		public ApplicationConfig() {
			HashSet<Class<?>> c = new HashSet<>();
			c.add(TextForm.class);
			c.add(MultiPartFeature.class);
			classes = Collections.unmodifiableSet(c);
		}
		
		@Override
		public Set<Class<?>> getClasses() {
			return classes;
		}
}

